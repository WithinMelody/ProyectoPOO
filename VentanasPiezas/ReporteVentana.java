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
public class ReporteVentana extends JFrame{
    ReportePanel pnlReporte = new ReportePanel(this);
    public ReporteVentana(){
        super ("Reporte de Piezas");
        setSize(700, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlReporte);
    }
}
