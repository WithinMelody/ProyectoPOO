/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaEquipo;

import javax.swing.JFrame;

/**
 *
 * @author mari2
 */
public class RVentana extends JFrame{
     RPanel pnlReporte = new RPanel(this);
    public RVentana(){
        super ("Admnistrador");
        setSize(700, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlReporte);
    }
}
