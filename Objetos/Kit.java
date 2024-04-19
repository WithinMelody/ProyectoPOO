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
public class Kit implements Serializable {

    private int codigo;
    private String nombre;
    private int unidades;
      

    public Kit(int codigo, String nombre,int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidades = unidades;
    }

    public void modificarPieza(int codigo, String nombre, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidades = unidades;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
 

}
