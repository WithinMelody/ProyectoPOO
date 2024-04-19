/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaServicio;

import MenuUsuarios.VentanaMenuAdm;
import Validaciones.VServ;
import VentanaEquipo.CVentana;
import VentanaIntegrante.CoIntVentana;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author mari2
 */
public class CoSPanel extends JPanel implements ActionListener {
    //Variables globales de trabajo

    JFrame ventanaConsulta;
    JLabel lblCarrera;
    JTextField txtCarrera;
    JLabel lblTel;
    JTextField txtTel;
    JLabel lblInicio;
    JTextField txtInicio;
    JLabel lblNombre;
    JTextField txtNombre;
    JLabel lblCuenta;
    JTextField txtCuenta;
    JLabel lblCorreo;
    JTextField txtCorreo;
    JLabel lblFin;
    JTextField txtFin;

    private JComboBox<String> TipoC;

    JButton btnBuscar;
    JButton btnRegresar;
    GridBagConstraints gbc = new GridBagConstraints();

    public CoSPanel(JFrame ventanaConsulta) {
        //Inicializando datos
        this.ventanaConsulta = ventanaConsulta;
        String[] tipoUsuario = {"Consultar Equipo", "Consultar Alumnos", "Consultar Servicios"};
        TipoC = new JComboBox<String>(tipoUsuario);
        TipoC.setBackground(Color.white);
        TipoC.setFont(new Font("Bell MT",Font.BOLD,14));
        String opcion = TipoC.getSelectedItem().toString();

        //Aplicando un formato de LayOut
        setLayout(new GridBagLayout());

        //Creando etiquetas
        lblTel = new JLabel("Telefono:");
        lblTel.setFont(new Font("Bell MT",Font.BOLD,16));
        lblInicio = new JLabel("Fecha de inicio:");
        lblInicio.setFont(new Font("Bell MT",Font.BOLD,16));
        lblFin = new JLabel("Fecha de termino:");
        lblFin.setFont(new Font("Bell MT",Font.BOLD,16));
        lblCarrera = new JLabel("Carrera:");
        lblCarrera.setFont(new Font("Bell MT",Font.BOLD,16));
        lblNombre = new JLabel("Nombre del servicio:");
        lblNombre.setFont(new Font("Bell MT",Font.BOLD,16));
        lblCuenta = new JLabel("Numero de cuenta:");
        lblCuenta.setFont(new Font("Bell MT",Font.BOLD,16));
        lblCorreo = new JLabel("Correo electronico:");
        lblCorreo.setFont(new Font("Bell MT",Font.BOLD,16));

        //Creando campos de texto
        txtNombre = new JTextField(100);
        txtCarrera = new JTextField(50);
        txtInicio = new JTextField(20);
        txtTel = new JTextField(20);
        txtFin = new JTextField(20);
        txtCuenta = new JTextField(20);
        txtCorreo = new JTextField(100);

        //Creando botones para que escuchen y actuen
        btnBuscar = new JButton("Buscar");
        btnBuscar.setActionCommand("Buscar");
        btnBuscar.addActionListener(this);
        btnBuscar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnBuscar.setBackground(Color.white);
        btnRegresar = new JButton("Regresar");
        btnRegresar.setActionCommand("Regresar");
        btnRegresar.addActionListener(this);
        btnRegresar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnRegresar.setBackground(Color.white);
        TipoC.addActionListener(this);

        //Asignando propiedad de no modificacion a los campos
        txtNombre.setEditable(false);
        txtCorreo.setEditable(false);
        txtInicio.setEditable(false);
        txtFin.setEditable(false);
        txtCarrera.setEditable(false);
        txtTel.setEditable(false);

        //Configurando el LayOut a ocupar en el programa y Agregando elementos al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 15, 15, 1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.CENTER;
        this.add(TipoC, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(lblCuenta, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.0;
        add(txtCuenta, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.0;
        add(btnBuscar, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(lblNombre, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtNombre, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblCorreo, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtCorreo, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblTel, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtTel, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblCarrera, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtCarrera, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblInicio, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtInicio, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblFin, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtFin, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnRegresar, gbc);
        gbc.weighty = 0.0;

        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Consulta de Servicios");
        setBorder(bordejpanel);
        inicializar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Buscar":
                VServ validacion = new VServ();
                String dato = txtCuenta.getText();

                if (validacion.validarNumero(dato, Integer.MAX_VALUE, Integer.MIN_VALUE, "numero de cuenta")) {
                    if (validacion.existeServicio(Integer.parseInt(dato))) {
                        txtNombre.setText(validacion.getServicio().getNombre());
                        txtCarrera.setText(validacion.getServicio().getCarrera());
                        txtTel.setText(Long.toString(validacion.getServicio().getTelefono()));
                        txtCorreo.setText(validacion.getServicio().getCorreo());
                        txtInicio.setText(validacion.getServicio().getInicio());
                        txtFin.setText(validacion.getServicio().getFin());

                    } else {
                        inicializar();
                    }
                }
                break;
            case "Regresar":
                VentanaMenuAdm vtnMenu = new VentanaMenuAdm();
                ventanaConsulta.dispose();
                break;
            case "comboBoxChanged":
                String seleccionCmbox = (String) TipoC.getSelectedItem();
                switch (seleccionCmbox) {
                    case "Consultar Equipo":
                        CVentana vtnKits = new CVentana();
                        ventanaConsulta.dispose();
                        break;
                    case "Consultar Alumnos":
                        CoIntVentana co = new CoIntVentana();
                        ventanaConsulta.dispose();
                        break;
                    case "Consultar Servicios":
                        CoSVentana v = new CoSVentana();
                        ventanaConsulta.dispose();
                }
                break;
        }
    }

    private void inicializar() {
        txtCarrera.setText("");
        txtInicio.setText("");
        txtFin.setText("");
        txtNombre.setText("");
        txtCuenta.setText("");
        txtCorreo.setText("");
        txtTel.setText("");

    }

    public void paint(Graphics g) {
        Dimension tam = getSize();
    
        int width = this.getSize().width;
        int height = this.getSize().height;
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Fondos/v5.jpg"));
        g.drawImage(fondo.getImage(), 0, 0, width, height, null);
        setOpaque(false);
        super.paint(g);

    }

}
