package VentanasPiezas;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AltaPiezaVentana extends JFrame{
    AltaPiezaPanel pnlAlta = new AltaPiezaPanel(this);
    
    public AltaPiezaVentana(){
        
        super ("Registro de Piezas");
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlAlta);
    
        
    }
}
