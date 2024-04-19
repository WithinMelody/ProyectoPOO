package MenuUsuarios;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mariana
 */
public class VentanaMenuServicio extends JFrame{
    PanelMenuServicio pnlMenu = new PanelMenuServicio(this);
    
    public VentanaMenuServicio(){
        super ("Servicio Social");
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlMenu);
        
    }
}
