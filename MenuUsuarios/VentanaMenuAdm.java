/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUsuarios;

import javax.swing.JFrame;

/**
 *
 * @author mari2
 */
public class VentanaMenuAdm extends JFrame{
    PanelMenuAdm menu = new PanelMenuAdm(this);
   
       public VentanaMenuAdm(){
        super ("Administrador");
        setSize(400, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(menu);
        
    }
}
