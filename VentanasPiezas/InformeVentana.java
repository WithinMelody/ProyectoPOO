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
public class InformeVentana extends JFrame{
    InformePanel pnlInforme = new InformePanel(this);
    public InformeVentana(){
        super ("Piezas por agotarse");
        setSize(700, 300);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlInforme);
    }
}
