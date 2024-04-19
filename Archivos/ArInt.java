/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Objetos.Integrante;
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
public class ArInt {
     public void guardarArchivo(ArrayList<Integrante> integrantes){
        try{
            FileOutputStream fo = new FileOutputStream("integrantes.dat");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(integrantes);
            oo.flush();
            oo.close();
        }catch(IOException exception){
            JOptionPane.showMessageDialog(null,"Archivo iniciado correctamente.");
        }
    }
    public ArrayList<Integrante> leerArchivo(){
        ArrayList<Integrante> integrantes = new ArrayList();
        try{
            FileInputStream fi = new FileInputStream("integrantes.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            integrantes = (ArrayList) oi.readObject();
            oi.close();
        }catch(Exception exception){
            //JOptionPane.showMessageDialog(null, "No existe el archivo");
        }
        return integrantes;
    }
    
}
