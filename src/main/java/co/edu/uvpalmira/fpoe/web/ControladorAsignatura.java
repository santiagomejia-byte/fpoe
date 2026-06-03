/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.web;

import co.edu.uvapalmira.fpoe.modelo.Asignatura;
import co.edu.uvpalmira.fpoe.jpalib.logica.ILogica;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sala Sistemas
 */
@Named(value = "asignCtrl")
@SessionScoped
public class ControladorAsignatura implements Serializable {

    private Asignatura asignatura = new Asignatura();

    @Inject
    private ILogica logica;

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public List<Asignatura> getAsignaturas() {
        return this.logica.buscarAsignaturas();
    }

    public void guardar() {
        try {
            this.logica.crearAsignatura(this.asignatura);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La asignatura fue guardada"));
        } catch (SQLIntegrityConstraintViolationException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error de restricciones", ex.getLocalizedMessage()));
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "error no identificado. Contacte con el desarrollador", ex.getLocalizedMessage()));
            Logger.getLogger(ControladorAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cancelar() {
        this.asignatura = new Asignatura();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proceso canelado"));
    }
}
