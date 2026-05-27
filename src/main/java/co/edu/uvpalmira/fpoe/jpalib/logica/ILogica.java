/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.uvpalmira.fpoe.jpalib.logica;

import co.edu.uvapalmira.fpoe.modelo.Asignatura;
import co.edu.uvpalmira.fpoe.jpalib.NonexistentEntityException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 * @author Sala Sistemas
 */
public interface ILogica {
    public void crearAsignatura(Asignatura asigantura) throws SQLIntegrityConstraintViolationException, Exception;
    public void ModificarAsignatura(Asignatura asigantura) throws NonexistentEntityException, Exception;
    public Asignatura buscarAsignatura(String codigo);
    public List<Asignatura>  buscarAsignaturas();
    
}
