/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvapalmira.fpoe.persistencia;

import co.edu.uvapalmira.fpoe.modelo.Asignatura;
import co.edu.uvpalmira.fpoe.jpalib.AbstractDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

/**
 *
 * @author Sala Sistemas
 */
public class AsignaturaDAO extends AbstractDAO<Asignatura> {
    
    public AsignaturaDAO(EntityManagerFactory emf) {
        super(Asignatura.class, emf);
    }
 public Asignatura buscarPorCodigo (String codigo){
     EntityManager em = super.getEntityManager();
     return (Asignatura) em.createNamedQuery("Asignatura.buscarPorCodigo")
             .setParameter("codigo", codigo).getSingleResult();
        
 }
 public List<Asignatura> buscarPorEscuela (String codigoEscuela){
     EntityManager em = super.getEntityManager();
     return  em.createNamedQuery("Asignatura.buscarPorEscuela")
             .setParameter("prefijo", codigoEscuela)
             .getResultList();
        
 }
}
