/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Archivos.ArServ;
import Objetos.Servicio;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mari2
 */
public class VServ {
    private ArrayList<Servicio> servicios;
    private Servicio servicio;
    private double numero;
    private boolean existeSer;
    private long posicionDeSer;

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

    public boolean altaEsCorrecta(String cuenta, String nombre, String correo, String tel, String carrera, String inicio, String fin) {
        if (validarNumero(cuenta, Integer.MAX_VALUE, Integer.MIN_VALUE, "numero de cuenta")) {
            if (!nombre.equals("") | !correo.equals("") | !carrera.equals("") | !inicio.equals("") | !fin.equals("")) {
                if (validarNumero(tel, Long.MAX_VALUE, Long.MIN_VALUE, "telefono")) {

                    Servicio pz = new Servicio(Integer.parseInt(cuenta),nombre, correo, Long.parseLong(tel),carrera, inicio, fin);
                    servicio = pz;
                    return true;

                }

            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/error.png"));
            }
        }
        return false;
    }

    public boolean esCuentaUnica(int cuenta) {
        ArServ archivo = new ArServ();
        ArrayList<Servicio> servicios = archivo.leerArchivo();
        for (Servicio validacion : servicios) {
            if (validacion.getCuenta() == cuenta) {
                JOptionPane.showMessageDialog(null, "El numero de cuenta " + cuenta + " ya existe.", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
                return false;
            }

        }
        return true;
    }

    public boolean existeServicio(int cuenta) {
        ArServ archivo = new ArServ();
        ArrayList<Servicio> piezas = archivo.leerArchivo();
        existeSer = false;
        posicionDeSer = 0;
        for (Servicio validacion : piezas) {
            if (validacion.getCuenta() == cuenta) {
                servicio = validacion;
                existeSer = true;
                JOptionPane.showMessageDialog(null, "Servicio encontrado.", "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
                return true;
            }
            posicionDeSer++;
        }
        JOptionPane.showMessageDialog(null, "El numero de " + cuenta + " no existe.", "Aviso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/aviso.png"));
        return false;
    }

    public boolean hayServicios() {
        ArServ archivo = new ArServ();
        ArrayList<Servicio> sr = archivo.leerArchivo();
        this.servicios = sr;
        if (sr == null) {
            JOptionPane.showMessageDialog(null, "No hay registros de servicios.", "Alerta", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
            return false;
        } else {
            //JOptionPane.showMessageDialog(null, "Piezas Encontradas: " + piezas.size(), "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
            return true;
        }
    }


    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public boolean isExisteServicio() {
        return existeSer;
    }

    public long getPosicionDeServicio() {
        return posicionDeSer;
    }

    public double getNumero() {
        return numero;
    }
    
}
