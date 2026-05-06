/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvapalmira.fpoe.modelo;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Sala Sistemas
 */
public class Asignatura {
    private String codigo;
    private String nombre;
    private byte creditos;
    private byte intensidad;
    
    
    public Asignatura(){ 
    }

    public Asignatura(String codigo, String nombre, byte creditos, byte intensidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.intensidad = intensidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public byte getCreditos() {
        return creditos;
    }

    public byte getIntensidad() {
        return intensidad;
    }
    
   
    
}
