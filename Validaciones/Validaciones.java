/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Archivos.Archivos;
import Objetos.Pieza;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mari2
 */
public class Validaciones {
    
    private ArrayList<Pieza> piezas;
    private Pieza pieza;
    private double numero;
    private boolean existePieza;
    private long posicionDePieza;
    
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
    
    public boolean altaEsCorrecta(String clave, String nombre, String precio, String unidades, String escasez) {
        if (validarNumero(clave, Integer.MAX_VALUE, Integer.MIN_VALUE, "código")) {
            if (!nombre.equals("")) {
                if (validarNumero(precio, Float.MAX_VALUE, Float.MIN_VALUE, "precio")) {
                    if (validarNumero(unidades, Integer.MAX_VALUE, Integer.MIN_VALUE, "unidades")) {
                        if (validarNumero(escasez, Integer.MAX_VALUE, Integer.MIN_VALUE, "escasez")) {
                            Pieza pz = new Pieza(Integer.parseInt(clave), nombre, Float.parseFloat(precio), Integer.parseInt(unidades), Integer.parseInt(escasez));
                            pieza = pz;
                            return true;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nombre no puede quedar vacio", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/error.png"));
            }
        }
        return false;
    }
    
    public boolean esClaveUnica(int clave) {
        Archivos archivo = new Archivos();
        ArrayList<Pieza> piezas = archivo.leerArchivo();
        for (Pieza validacion : piezas) {
            if (validacion.getCodigo() == clave) {
                JOptionPane.showMessageDialog(null, "El código " + clave + " ya existe.", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
                return false;
            }
            
        }
        return true;
    }

    public boolean existeClave(int clave) {
        Archivos archivo = new Archivos();
        ArrayList<Pieza> piezas = archivo.leerArchivo();
        existePieza = false;
        posicionDePieza = 0;
        for (Pieza validacion : piezas) {
            if (validacion.getCodigo() == clave) {
                pieza = validacion;
                existePieza = true;
                JOptionPane.showMessageDialog(null, "Pieza encontrada.", "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
                return true;
            }
            posicionDePieza++;
        }
        JOptionPane.showMessageDialog(null, "La pieza " + clave + " no existe.", "Aviso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/aviso.png"));
        return false;
    }
    
    public boolean hayPiezas(){
        Archivos archivo = new Archivos();
        ArrayList<Pieza> piezas = archivo.leerArchivo();
        this.piezas = piezas;
        if (piezas == null) {
            JOptionPane.showMessageDialog(null, "No hay registros de piezas.", "Alerta", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
            return false;
        } else {
            //JOptionPane.showMessageDialog(null, "Piezas Encontradas: " + piezas.size(), "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
            return true;
        }
    }
    public boolean prestamoAdecuado(boolean servicio) {
        if (servicio) {
            if (numero > pieza.getUnidades()) {
                JOptionPane.showMessageDialog(null, "El numero de piezas a prestar supera al numero disponible.", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
                return false;
            }
        }
        if (numero <= 0) {
            JOptionPane.showMessageDialog(null, "El valor no puede ser menor o igual a 0.", "Alerta", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
            return false;
        }
        return true;
    }

    public ArrayList<Pieza> getPiezas() {
        return piezas;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public boolean isExistePieza() {
        return existePieza;
    }

    public long getPosicionDePieza() {
        return posicionDePieza;
    }

    public double getNumero() {
        return numero;
    }
    
}
