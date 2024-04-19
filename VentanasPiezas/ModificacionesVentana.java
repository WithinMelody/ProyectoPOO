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
public class ModificacionesVentana extends JFrame{
    ModificacionesPanel pnlModificaciones = new ModificacionesPanel(this);
    
    public ModificacionesVentana(){
        super ("Modificar Piezas");
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlModificaciones);
    }
    
}
