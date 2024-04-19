/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Archivos.ArEquipo;
import Objetos.Equipo;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mari2
 */
public class ValEquipo {
    private ArrayList<Equipo> equipos;
    private Equipo equipo;
    private double numero;
    private boolean existeEquipo;
    private long posicionDeEquipo;
    
    public boolean validarCadena(String dato, String campo) {
        if (dato.equals("")) {
            JOptionPane.showMessageDialog(null, "El campo " + campo + " no puede quedar vacio", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/error.png"));
            return false;
        }
        return true;
    }
    
    public boolean validarNumero(String dato, double max, double min, String campo) {
        try {
            numero = Double.parseDouble(dato);
            if (numero <= max && numero >= min) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El numero ingresado en el campo " + campo + " no es un valor soportado.", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es un numero el campo " + campo, "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/error.png"));
        }
        return false;
    }
    public boolean altaEsCorrecta(String clave,String integrantes,String profesor,String materia, String nombreE) {
        if (validarNumero(clave, Byte.MAX_VALUE, Byte.MIN_VALUE, "Numero de equipo")) {
            if (!profesor.equals("") | !materia.equals("") | !nombreE.equals("")) {
                            if (validarNumero(integrantes, Byte.MAX_VALUE, Byte.MIN_VALUE, "Numero de integrantes")) {
                            Equipo eq = new Equipo(Byte.parseByte(clave),Byte.parseByte(integrantes),profesor,materia,nombreE);
                            equipo = eq;
                            return true;

                    }
                
            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/error.png"));
            }
        }
        return false;
    }
    
    public boolean esClaveUnica(int clave) {
        ArEquipo archivo = new ArEquipo();
        ArrayList<Equipo> piezas = archivo.leerArchivo();
        for (Equipo validacion : piezas) {
            if (validacion.getNumequipo() == clave) {
                JOptionPane.showMessageDialog(null, "El equipo " + clave + " ya existe.", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
                return false;
            }
            
        }
        return true;
    }

    public boolean existeClave(int clave) {
        ArEquipo archivo = new ArEquipo();
        ArrayList<Equipo> piezas = archivo.leerArchivo();
        existeEquipo = false;
        posicionDeEquipo = 0;
        for (Equipo validacion : piezas) {
            if (validacion.getNumequipo() == clave) {
                equipo= validacion;
                existeEquipo = true;
                JOptionPane.showMessageDialog(null, "Equipo encontrado.", "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
                return true;
            }
            posicionDeEquipo++;
        }
        JOptionPane.showMessageDialog(null, "el equipo " + clave + " no existe.", "Aviso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/aviso.png"));
        return false;
    }
    
    public boolean hayEquipo(){
        ArEquipo archivo = new ArEquipo();
        ArrayList<Equipo> equipos = archivo.leerArchivo();
        this.equipos = equipos;
        if (equipos == null) {
            JOptionPane.showMessageDialog(null, "No hay registros de equipos.", "Alerta", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
            return false;
        } else {
            //JOptionPane.showMessageDialog(null, "Piezas Encontradas: " + piezas.size(), "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
            return true;
        }
    }


    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public boolean isExisteEquipo() {
        return existeEquipo;
    }

    public long getPosicionDeEquipo() {
        return posicionDeEquipo;
    }

    public double getNumero() {
        return numero;
    }
    
}
