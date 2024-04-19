package MenuUsuarios;

import VentanasKits.AltaVentanaK;
import VentanasPiezas.EliminarVentana;
import VentanasPiezas.InformeVentana;
import VentanasPiezas.ConsultaVentana;
import VentanasPiezas.ServiciosVentana;
import VentanasPiezas.AltaPiezaVentana;
import VentanasPiezas.ModificacionesVentana;
import VentanasPiezas.ReporteVentana;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Mariana
 */
public class PanelMenuServicio extends JPanel implements ActionListener {

    //Variables globales de trabajo
    JFrame ventanaMenu;
    JButton btnAlta;
    JButton btnConsulta;
    JButton btnReporte;
    JButton btnModificacion;
    JButton btnBaja;
    JButton btnServicios;
    JButton btnInforme;
    JButton btnSalir;
    JButton btnPieza;
    JButton btnKit;
    JLabel lblEspacio = new JLabel("          ");
    GridBagConstraints gbc = new GridBagConstraints();
    JComboBox combo1;
    

    public PanelMenuServicio(JFrame ventanaMenu) {
        //Inicializando datos
        this.ventanaMenu = ventanaMenu;
        

        //Aplicando un formato de LayOut
        setLayout(new GridBagLayout());
        //setLayout(new GridLayout(4, 2));
        //Creando botones para que escuchen y actuen
        btnAlta = new JButton("Registrar");
        btnAlta.setFont(new Font("Bell MT",Font.BOLD,16));
        btnAlta.setActionCommand("Alta");
        btnAlta.addActionListener(this);
        btnAlta.setBackground(Color.white);

        btnConsulta = new JButton("Consultar información");
        btnConsulta.setFont(new Font("Bell MT",Font.BOLD,16));
        btnConsulta.setActionCommand("Consultar");
        btnConsulta.addActionListener(this);
        btnConsulta.setBackground(Color.white);

        btnReporte = new JButton("Reporte");
        btnReporte.setFont(new Font("Bell MT",Font.BOLD,16));
        btnReporte.setActionCommand("Reporte");
        btnReporte.addActionListener(this);
        btnReporte.setBackground(Color.white);

        btnModificacion = new JButton("Modificar información");
        btnModificacion.setFont(new Font("Bell MT",Font.BOLD,16));
        btnModificacion.setActionCommand("Modificacion");
        btnModificacion.addActionListener(this);
        btnModificacion.setBackground(Color.white);

        btnBaja = new JButton("Dar de baja");
        btnBaja.setFont(new Font("Bell MT",Font.BOLD,16));
        btnBaja.setActionCommand("Baja");
        btnBaja.addActionListener(this);
        btnBaja.setBackground(Color.white);

        btnServicios = new JButton("Servicios");
        btnServicios.setFont(new Font("Bell MT",Font.BOLD,16));
        btnServicios.setActionCommand("Servicios");
        btnServicios.addActionListener(this);
        btnServicios.setBackground(Color.white);

        btnInforme = new JButton("Piezas por agotarse");
        btnInforme.setFont(new Font("Bell MT",Font.BOLD,16));
        btnInforme.setActionCommand("Informe");
        btnInforme.addActionListener(this);
        btnInforme.setBackground(Color.white);

        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Bell MT",Font.BOLD,16));
        btnSalir.setActionCommand("Salir");
        btnSalir.addActionListener(this);
        btnSalir.setBackground(Color.white);

        //Al panel principal se le agrega etiquetas, campos de entrada y el boton de accceso.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnAlta, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(lblEspacio, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnConsulta, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnReporte, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnModificacion, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnBaja, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnServicios, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnInforme, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnSalir, gbc);
        gbc.weighty = 0.0;
        /*add(btnAlta);
        add(btnConsulta);
        add(btnReporte);
        add(btnModificacion);
        add(btnBaja);
        add(btnServicios);
        add(btnInforme);
        add(btnSalir);*/
        //Al panel se le agrega un borde con titulo
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Menu principal");
        setBorder(bordejpanel);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        JComboBox<String> TipoAlta;
        
        switch (accion) {
            case "Alta":
               AltaPiezaVentana vtnAlta = new AltaPiezaVentana();
               ventanaMenu.dispose();
               

                break;
            case "Consultar":
                ConsultaVentana vtnConsulta = new ConsultaVentana();
                ventanaMenu.dispose();
                break;
            case "Reporte":
                ReporteVentana vtnReporte = new ReporteVentana();
                ventanaMenu.dispose();
                break;
            case "Modificacion":
                ModificacionesVentana vtnModificacion = new ModificacionesVentana();
                ventanaMenu.dispose();
                break;
            case "Baja":
                EliminarVentana vtnEliminar = new EliminarVentana();
                ventanaMenu.dispose();
                break;
            case "Servicios":
                ServiciosVentana vtnServicios = new ServiciosVentana();
                ventanaMenu.dispose();
                break;
            case "Informe":
                InformeVentana vtnInforme = new InformeVentana();
                ventanaMenu.dispose();
                break;

            case "Salir":
                System.exit(0);
                break;
        }
    }
    
      public void paint(Graphics g){
        Dimension tam = getSize();
        int width = this.getSize().width;
        int height = this.getSize().height;
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Fondos/v10.jpg"));
        g.drawImage(fondo.getImage(), 0, 0,width,height,null);
        setOpaque(false);
        super.paint(g);
        
        
    }
    

}
