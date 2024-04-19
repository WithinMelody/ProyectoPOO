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
public class ServiciosVentana extends JFrame{
    ServiciosPanel pnlServicios = new ServiciosPanel(this);
    
    public ServiciosVentana(){
        super ("Servicios para Piezas");
        setSize(400,400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlServicios);
    }
}
