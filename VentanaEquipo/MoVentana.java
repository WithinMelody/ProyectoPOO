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
public class MoVentana extends JFrame{
     MoPanel pnlModificaciones = new MoPanel(this);
    
    public MoVentana(){
        super ("Admnistrador");
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlModificaciones);
    }
}
