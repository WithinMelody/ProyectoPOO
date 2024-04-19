/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;
import Archivos.ArchivoKit;
import Objetos.Kit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mari2
 */
public class ValKit {
    private ArrayList<Kit> kits;
    private Kit kit;
    private double numero;
    private boolean existeKit;
    private long posicionDeKit;
    
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
    
    public boolean altaEsCorrecta(String clave, String nombre, String unidades) {
        if (validarNumero(clave, Integer.MAX_VALUE, Integer.MIN_VALUE, "código")) {
            if (!nombre.equals("")) {
                    if (validarNumero(unidades, Integer.MAX_VALUE, Integer.MIN_VALUE, "unidades")) {
                            Kit pz = new Kit(Integer.parseInt(clave), nombre, Integer.parseInt(unidades));
                            kit = pz;
                            return true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nombre no puede quedar vacio", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/error.png"));
            }
        }
        return false;
    }
    
    public boolean esClaveUnica(int clave) {
        ArchivoKit archivo = new ArchivoKit();
        ArrayList<Kit> kits = archivo.leerArchivo();
        for (Kit validacion : kits) {
            if (validacion.getCodigo() == clave) {
                JOptionPane.showMessageDialog(null, "El kit " + clave + " ya existe.", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
                return false;
            }
            
        }
        return true;
    }

    public boolean existeClave(int clave) {
        ArchivoKit archivo = new ArchivoKit();
        ArrayList<Kit> kits = archivo.leerArchivo();
        existeKit = false;
        posicionDeKit = 0;
        for (Kit validacion : kits) {
            if (validacion.getCodigo() == clave) {
                kit = validacion;
                existeKit= true;
                JOptionPane.showMessageDialog(null, "Kit encontrado.", "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
                return true;
            }
            posicionDeKit++;
        }
        JOptionPane.showMessageDialog(null, "el kit " + clave + " no existe.", "Aviso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/aviso.png"));
        return false;
    }
    
    public boolean hayKit(){
        ArchivoKit archivo = new ArchivoKit();
        ArrayList<Kit> kits = archivo.leerArchivo();
        this.kits = kits;
        if (archivo == null) {
            JOptionPane.showMessageDialog(null, "No hay registros de kits.", "Alerta", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
            return false;
        } else {
            //JOptionPane.showMessageDialog(null, "Piezas Encontradas: " + piezas.size(), "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
            return true;
        }
    }
    public boolean prestamoAdecuado(boolean servicio) {
        if (servicio) {
            if (numero > kit.getUnidades()) {
                JOptionPane.showMessageDialog(null, "El numero de kits a prestar supera al numero disponible.", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
                return false;
            }
        }
        if (numero <= 0) {
            JOptionPane.showMessageDialog(null, "El valor no puede ser menor o igual a 0.", "Alerta", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/alerta.png"));
            return false;
        }
        return true;
    }

    public ArrayList<Kit> getKits() {
        return kits;
    }

    public Kit getKit() {
        return kit;
    }

    public boolean isExisteKit() {
        return existeKit;
    }

    public long getPosicionDeKit() {
        return posicionDeKit;
    }

    public double getNumero() {
        return numero;
    }
    
}
