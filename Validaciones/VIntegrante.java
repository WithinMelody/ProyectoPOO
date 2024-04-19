/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Archivos.ArInt;
import Objetos.Integrante;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mari2
 */
public class VIntegrante {

    private ArrayList<Integrante> integrantes;
    private Integrante integrante;
    private double numero;
    private boolean existeInt;
    private long posicionDeInt;

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
                JOptionPane.showMessageDialog(null, "El numero ingresado en  " + campo + " no es un valor soportado.", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es un numero el campo " + campo, "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/error.png"));
        }
        return false;
    }

    public boolean altaEsCorrecta(String cuenta, String equipo, String nombre, String correo, String materia, String profesor) {
        if (validarNumero(cuenta, Integer.MAX_VALUE, Integer.MIN_VALUE, "numero de cuenta")) {
            if (!nombre.equals("") | !correo.equals("") | !materia.equals("") | !profesor.equals("")) {
                if (validarNumero(equipo, Integer.MAX_VALUE, Integer.MIN_VALUE, "codigo")) {

                    Integrante pz = new Integrante(Integer.parseInt(cuenta), Byte.parseByte(equipo),nombre, correo , materia,profesor);
                    integrante = pz;
                    return true;

                }

            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/error.png"));
            }
        }
        return false;
    }

    public boolean esCuentaUnica(int cuenta) {
        ArInt archivo = new ArInt();
        ArrayList<Integrante> integrantes = archivo.leerArchivo();
        for (Integrante validacion : integrantes) {
            if (validacion.getEquipo() == cuenta) {
                JOptionPane.showMessageDialog(null, "El numero de cuenta " + cuenta + " ya existe.", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
                return false;
            }

        }
        return true;
    }

    public boolean existeIntegrante(int cuenta) {
        ArInt archivo = new ArInt();
        ArrayList<Integrante> piezas = archivo.leerArchivo();
        existeInt = false;
        posicionDeInt = 0;
        for (Integrante validacion : piezas) {
            if (validacion.getCuenta() == cuenta) {
                integrante = validacion;
                existeInt = true;
                JOptionPane.showMessageDialog(null, "Alumno encontrado.", "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
                return true;
            }
            posicionDeInt++;
        }
        JOptionPane.showMessageDialog(null, "El numero de " + cuenta + " no existe.", "Aviso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/aviso.png"));
        return false;
    }

    public boolean hayIntegrantes() {
        ArInt archivo = new ArInt();
        ArrayList<Integrante> intg = archivo.leerArchivo();
        this.integrantes = intg;
        if (intg == null) {
            JOptionPane.showMessageDialog(null, "No hay registros de alumnos.", "Alerta", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
            return false;
        } else {
            //JOptionPane.showMessageDialog(null, "Piezas Encontradas: " + piezas.size(), "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
            return true;
        }
    }


    public ArrayList<Integrante> getIntegrantes() {
        return integrantes;
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public boolean isExisteIntegrante() {
        return existeInt;
    }

    public long getPosicionDeIntegrante() {
        return posicionDeInt;
    }

    public double getNumero() {
        return numero;
    }
}
