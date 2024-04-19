/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Objetos.Kit;
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
public class ArchivoKit {
     public void guardarArchivo(ArrayList<Kit> kits){
        try{
            FileOutputStream fo = new FileOutputStream("kit.dat");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(kits);
            oo.flush();
            oo.close();
        }catch(IOException exception){
            JOptionPane.showMessageDialog(null,"Archivo iniciado correctamente.");
        }
    }
    public ArrayList<Kit> leerArchivo(){
        ArrayList<Kit> kits = new ArrayList();
        try{
            FileInputStream fi = new FileInputStream("kit.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            kits = (ArrayList) oi.readObject();
            oi.close();
        }catch(Exception exception){
            //JOptionPane.showMessageDialog(null, "No existe el archivo");
        }
        return kits;
    }
    
    
}
