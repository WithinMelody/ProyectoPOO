/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Objetos.Servicio;
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
public class ArServ {
    public void guardarArchivo(ArrayList<Servicio> servicios){
        try{
            FileOutputStream fo = new FileOutputStream("servicios.dat");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(servicios);
            oo.flush();
            oo.close();
        }catch(IOException exception){
            JOptionPane.showMessageDialog(null,"Archivo iniciado correctamente.");
        }
    }
    public ArrayList<Servicio> leerArchivo(){
        ArrayList<Servicio> serv = new ArrayList();
        try{
            FileInputStream fi = new FileInputStream("servicios.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            serv = (ArrayList) oi.readObject();
            oi.close();
        }catch(Exception exception){
            //JOptionPane.showMessageDialog(null, "No existe el archivo");
        }
        return serv;
    }
}
