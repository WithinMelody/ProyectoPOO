/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanasPiezas;

import javax.swing.JFrame;

/**
 *
 * @author Erick
 */
public class EliminarVentana extends JFrame{
    EliminarPanel pnlEliminar = new EliminarPanel(this);
    
    public EliminarVentana(){
        super ("Dar de baja Piezas");
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlEliminar);
    }
}
