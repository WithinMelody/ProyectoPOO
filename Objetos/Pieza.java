package Objetos;

import java.io.Serializable;

/**
 *
 * @author Mariana
 */
public class Pieza implements Serializable{
    private int codigo;
    private String nombre;
    private float precio;
    private int unidades;
    private int alerta;

    public Pieza(int codigo, String nombre, float precio, int unidades, int alerta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.alerta = alerta;
    }
    
    public void modificarPieza(int codigo, String nombre, float precio, int unidades, int alerta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.alerta = alerta;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getAlerta() {
        return alerta;
    }

    public void setAlerta(int alerta) {
        this.alerta = alerta;
    }
    
}
