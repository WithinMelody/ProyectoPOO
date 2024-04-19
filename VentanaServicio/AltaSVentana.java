/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaServicio;

import javax.swing.JFrame;

/**
 *
 * @author mari2
 */
public class AltaSVentana extends JFrame {

    AltaSPanel pnlAlta = new AltaSPanel(this);

    public AltaSVentana() {
        super("Administrador");
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlAlta);
    }

}
