/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Objetos.Equipo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mari2
 */
public class ArEquipo {
    public void guardarArchivo(ArrayList<Equipo> equipos){
        try{
            FileOutputStream fo = new FileOutputStream("equipos.dat");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(equipos);
            oo.flush();
            oo.close();
        }catch(IOException exception){
            JOptionPane.showMessageDialog(null,"Archivo iniciado correctamente.");
        }
    }
    public ArrayList<Equipo> leerArchivo(){
        ArrayList<Equipo> equipos = new ArrayList();
        try{
            FileInputStream fi = new FileInputStream("equipos.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            equipos = (ArrayList) oi.readObject();
            oi.close();
        }catch(Exception exception){
            //JOptionPane.showMessageDialog(null, "No existe el archivo");
        }
        return equipos;
    }
    
}
