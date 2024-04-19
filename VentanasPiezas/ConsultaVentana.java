package VentanasPiezas;

import javax.swing.JFrame;

/**
 *
 * @author Mariana
 */
public class ConsultaVentana extends JFrame{
    ConsultaPanel pnlConsulta = new ConsultaPanel(this);
    
    public ConsultaVentana(){
        super ("Consultar Piezas");
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(pnlConsulta);
    }
    
}
