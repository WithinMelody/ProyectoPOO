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
public class ElSVentana extends JFrame {

    ElSPanel pnlEliminar = new ElSPanel(this);

    public ElSVentana() {
        super("Admnistrador");
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlEliminar);
    }

}
