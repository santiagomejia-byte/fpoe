/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe;

import co.edu.uvapalmira.fpoe.modelo.Asignatura;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Sala Sistemas
 */
@Named(value="asignCtrl")
@SessionScoped
public class ControladorAsignatura implements Serializable{
 // joder 
     private Asignatura asignatura = new Asignatura ("750014C","FPOE", (byte)3, (byte)3);
        
        public Asignatura getAsignatura(){
            return asignatura;
        }
    }

