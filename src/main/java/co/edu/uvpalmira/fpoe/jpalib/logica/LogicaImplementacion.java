/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.jpalib.logica;

import co.edu.uvapalmira.fpoe.modelo.Asignatura;
import co.edu.uvapalmira.fpoe.persistencia.AsignaturaDAO;
import co.edu.uvpalmira.fpoe.jpalib.NonexistentEntityException;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 * @author Sala Sistemas
 */
@ApplicationScoped
public class LogicaImplementacion implements ILogica {

    @PersistenceUnit(name = "ProyectPU")
    private EntityManagerFactory emf;

    private AsignaturaDAO asignaturaDaO;

    public LogicaImplementacion() {
    }

    @PostConstruct
    public void init() {
        this.asignaturaDaO = new AsignaturaDAO(this.emf);

    }

    @Override
    public void crearAsignatura(Asignatura asigantura) throws SQLIntegrityConstraintViolationException, Exception {
        this.asignaturaDaO.create(asigantura);
    }

    @Override
    public void ModificarAsignatura(Asignatura asigantura) throws NonexistentEntityException, Exception{
        this.asignaturaDaO.edit(asigantura);
    }

    @Override
    public Asignatura buscarAsignatura(String codigo) {
        return this.asignaturaDaO.buscarPorCodigo(codigo);
        
    }

    @Override
    public List<Asignatura> buscarAsignaturas() {
        return this.asignaturaDaO.findEntities();
    }

}
