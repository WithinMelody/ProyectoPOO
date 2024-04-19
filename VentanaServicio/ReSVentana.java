/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaServicio;

import VentanaIntegrante.ReIntPanel;
import javax.swing.JFrame;

/**
 *
 * @author mari2
 */
public class ReSVentana extends JFrame{
       ReSPanel Reporte = new ReSPanel(this);

    public ReSVentana() {
        super("Admnistrador");
        setSize(700, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(Reporte);
    }
    
}
