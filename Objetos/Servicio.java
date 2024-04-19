/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mari2
 */
public class Servicio implements Serializable {

    private String nombre;
    private String correo;
    private long telefono;
    private String carrera;
    private String inicio;
    private String fin;

    public Servicio(int cuenta, String nombre, String correo, long telefono, String carrera, String inicio, String fin) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.carrera = carrera;
        this.inicio = inicio;
        this.fin = fin;

    }

    public void modificarServicio(String nombre, String correo, long telefono, String carrera) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.carrera = carrera;

    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }
    private int cuenta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

}
