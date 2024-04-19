/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanasPiezas;

import MenuUsuarios.VentanaMenuServicio;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Erick
 */
public class ServiciosPanel extends JPanel implements ActionListener{
    JFrame ventanaServicios;
    JButton btnPrestamo;
    JButton btnDevolucion;
    JButton btnRegresar;
    //JLabel lblEspacio = new JLabel("          ");
    GridBagConstraints gbc = new GridBagConstraints();
    
    public ServiciosPanel(JFrame ventanaServicios) {
        //Inicializando datos
        this.ventanaServicios = ventanaServicios;
        
        //Aplicando un formato de LayOut
        setLayout(new GridBagLayout());
        //setLayout(new GridLayout(4, 2));
        //Creando botones para que escuchen y actuen
        btnPrestamo = new JButton("Prestamo");
        btnPrestamo.setActionCommand("Prestamo");
        btnPrestamo.setPreferredSize(new Dimension(120,120));
        btnPrestamo.addActionListener(this);
        btnPrestamo.setFont(new Font("Bell MT",Font.BOLD,16));
        btnPrestamo.setBackground(Color.white);
        
        btnDevolucion = new JButton("Devolucion");
        btnDevolucion.setActionCommand("Devolucion");
        btnDevolucion.setPreferredSize(new Dimension(120,120));
        btnDevolucion.addActionListener(this);
        btnDevolucion.setFont(new Font("Bell MT",Font.BOLD,16));
        btnDevolucion.setBackground(Color.white);
        
        btnRegresar = new JButton("Regresar");
        btnRegresar.setActionCommand("Regresar");
        btnRegresar.setPreferredSize(new Dimension(120,30));
        btnRegresar.addActionListener(this);
        btnRegresar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnRegresar.setBackground(Color.white);
        
        //Al panel principal se le agrega etiquetas, campos de entrada y el boton de accceso.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnPrestamo,gbc);
        
        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnDevolucion,gbc);
        
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnRegresar,gbc);
        
        /*add(btnAlta);
        add(btnConsulta);
        add(btnReporte);
        add(btnModificacion);
        add(btnBaja);
        add(btnServicios);
        add(btnInforme);
        add(btnSalir);*/
        //Al panel se le agrega un borde con titulo
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Servicios de Prestamo y Devolucion");
        setBorder(bordejpanel);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String accion = e.getActionCommand();
        switch(accion){
            case "Prestamo":
                ServicioVentana vtnPrestamo = new ServicioVentana("Prestar piezas", "Prestamo de piezas", true);
                ventanaServicios.dispose();
                break;
            case "Devolucion":
                ServicioVentana vtnDevolucion = new ServicioVentana("Devolver piezas", "Devolucion de piezas", false);
                ventanaServicios.dispose();
                break;
                
            case "Regresar":
                    VentanaMenuServicio vtnMenu = new VentanaMenuServicio();
                    ventanaServicios.dispose();
                break;
        }
    }
    
      public void paint(Graphics g) {
        Dimension tam = getSize();
        int width = this.getSize().width;
        int height = this.getSize().height;
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Fondos/v10.jpg"));
        g.drawImage(fondo.getImage(), 0, 0, width, height, null);
        setOpaque(false);
        super.paint(g);

    }
}
