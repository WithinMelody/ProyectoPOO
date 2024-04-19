/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Objetos.Pieza;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Archivos {
    public void guardarArchivo(ArrayList<Pieza> piezas){
        try{
            FileOutputStream fo = new FileOutputStream("piezas.dat");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(piezas);
            oo.flush();
            oo.close();
        }catch(IOException exception){
            JOptionPane.showMessageDialog(null,"Archivo iniciado correctamente.");
        }
    }
    public ArrayList<Pieza> leerArchivo(){
        ArrayList<Pieza> piezas = new ArrayList();
        try{
            FileInputStream fi = new FileInputStream("piezas.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            piezas = (ArrayList) oi.readObject();
            oi.close();
        }catch(Exception exception){
            //JOptionPane.showMessageDialog(null, "No existe el archivo");
        }
        return piezas;
    }

}
