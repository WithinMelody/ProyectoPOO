/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author mari2
 */
public class Equipo implements Serializable {

    private byte numequipo;
    private byte numintegrantes; 
    private String profesor;
    private String materia;
    private String nombreE;
  

    public Equipo(byte numequipo,byte numintegrantes,String profesor, String materia, String nombreE) {
       this.materia=materia;
       this.numequipo = numequipo;
       this.numintegrantes = numintegrantes;
       this.profesor = profesor;
       this.nombreE = nombreE;
    }

    public void modificarEquipo(String materia,byte numintegrantes,String profesor,String nombreE) {
        this.materia=materia;
        this.numintegrantes=numintegrantes;
        this.profesor=profesor;
        this.nombreE = nombreE;
 
    }

   

    public byte getNumequipo() {
        return numequipo;
    }

    public void setNumequipo(byte numequipo) {
        this.numequipo = numequipo;
    }

    public byte getNumintegrantes() {
        return numintegrantes;
    }

    public void setNumintegrantes(byte numintegrantes) {
        this.numintegrantes = numintegrantes;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

 

}
