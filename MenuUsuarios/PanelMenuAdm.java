/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUsuarios;

import VentanaEquipo.AltaVentana;
import VentanaEquipo.CVentana;
import VentanaEquipo.EVentana;
import VentanaEquipo.MoVentana;
import VentanaEquipo.RVentana;
import VentanasPiezas.EliminarVentana;
import VentanasPiezas.InformeVentana;
import VentanasPiezas.ServiciosVentana;
import VentanasPiezas.ModificacionesVentana;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author mari2
 */
public class PanelMenuAdm extends JPanel implements ActionListener {
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
    private Image background;
    JLabel lblEspacio = new JLabel("          ");
    GridBagConstraints gbc = new GridBagConstraints();

    public PanelMenuAdm(JFrame ventanaMenu) {
        //Inicializando datos
        this.ventanaMenu = ventanaMenu;
        //initComponents();

        //Aplicando un formato de LayOut
        setLayout(new GridBagLayout());
        //setLayout(new GridLayout(4, 2));
        //Creando botones para que escuchen y actuen
        btnAlta = new JButton("Registrar");
        btnAlta.setFont(new Font("Bell MT",Font.BOLD,16));
        btnAlta.setActionCommand("Alta");
        btnAlta.addActionListener(this);
        btnAlta.setBackground(Color.WHITE);

        btnConsulta = new JButton("Consultar información");
        btnConsulta.setFont(new Font("Bell MT",Font.BOLD,16));
        btnConsulta.setActionCommand("Consultar");
        btnConsulta.addActionListener(this);
        btnConsulta.setBackground(Color.WHITE);

        btnReporte = new JButton("Reporte");
        btnReporte.setFont(new Font("Bell MT",Font.BOLD,16));
        btnReporte.setActionCommand("Reporte");
        btnReporte.addActionListener(this);
        btnReporte.setBackground(Color.WHITE);

        btnModificacion = new JButton("Modificar información");
        btnModificacion.setFont(new Font("Bell MT",Font.BOLD,16));
        btnModificacion.setActionCommand("Modificacion");
        btnModificacion.addActionListener(this);
        btnModificacion.setBackground(Color.WHITE);

        btnBaja = new JButton("Dar de baja");
        btnBaja.setFont(new Font("Bell MT",Font.BOLD,16));
        btnBaja.setActionCommand("Baja");
        btnBaja.addActionListener(this);
        btnBaja.setBackground(Color.WHITE);

        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Bell MT",Font.BOLD,16));
        btnSalir.setActionCommand("Salir");
        btnSalir.addActionListener(this);
        btnSalir.setBackground(Color.WHITE);

        //Al panel principal se le agrega etiquetas, campos de entrada y el boton de accceso.
        gbc.weighty = 0.0;
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
        add(btnSalir, gbc);
        gbc.weighty = 0.0;
      
        
        //Al panel se le agrega un borde con titulo
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Menu principal");
        
        setBorder(bordejpanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Alta":
                AltaVentana equipo = new AltaVentana();
                ventanaMenu.dispose();
                break;
            case "Consultar":
                CVentana vtnConsulta = new CVentana();
                ventanaMenu.dispose();
                break;
            case "Reporte":
                RVentana vtnReporte = new RVentana();
                ventanaMenu.dispose();
                break;
            case "Modificacion":
                MoVentana vtnModificacion = new MoVentana();
                ventanaMenu.dispose();
                break;
            case "Baja":
                EVentana vtnEliminar = new EVentana();
                ventanaMenu.dispose();
                break;
           

            case "Salir":
                System.exit(0);
                break;
        }
    }
    
    @Override
    public void paint(Graphics g){
        Dimension tam = getSize();
        int width = this.getSize().width;
        int height = this.getSize().height;
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Fondos/v5.jpg"));
        g.drawImage(fondo.getImage(), 0, 0,width,height,null);
        setOpaque(false);
        //initComponents();
        super.paint(g);
        
        
        
    }
}
    

