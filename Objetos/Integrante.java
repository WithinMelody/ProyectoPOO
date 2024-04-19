/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;

/**
 *
 * @author mari2
 */
public class Integrante implements Serializable {
    private byte equipo;
    private int cuenta;
    private String correo;
    private String nombre;
    private String materia;
    private String profesor;

    public Integrante(int cuenta, byte equipo, String nombre, String correo, String materia, String profesor) {
        this.equipo = equipo;
        this.cuenta = cuenta;
        this.correo = correo;
        this.nombre = nombre;
        this.materia = materia;
        this.profesor = profesor;
    }
    
     public void modificarInt(byte equipo, String nombre, String correo, String materia, String profesor) {
        this.equipo = equipo;
        this.correo = correo;
        this.nombre = nombre;
        this.materia = materia;
        this.profesor = profesor;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(byte equipo) {
        this.equipo = equipo;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    
    
}
