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
public class CVentana extends JFrame{
     CPanel pnlConsulta = new CPanel(this);
    
    public CVentana(){
        super ("Administrador");
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlConsulta);
    }
}
