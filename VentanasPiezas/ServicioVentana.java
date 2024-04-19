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
public class ServicioVentana extends JFrame{
 ServicioPanel pnlPrestamo;
    
    public ServicioVentana(String accion, String mensaje, boolean servicio){
        super ("Servicio para Piezas");
        setSize(700, 700);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pnlPrestamo = new ServicioPanel(this, accion, mensaje, servicio);
        this.getContentPane().add(pnlPrestamo);
    }
}
