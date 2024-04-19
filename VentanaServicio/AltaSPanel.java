/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaServicio;

import Archivos.ArServ;
import MenuUsuarios.VentanaMenuAdm;
import Objetos.Servicio;
import Quicksort.QuickServ;
import Validaciones.VServ;
import VentanaEquipo.AltaVentana;
import VentanaIntegrante.RegIntVentana;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author mari2
 */
public class AltaSPanel extends JPanel implements ActionListener {

    private JComboBox<String> TipoAlta;
    JFrame ventanaAlta;
    JLabel lblTel;
    JTextField txtTel;
    JLabel lblNombre;
    JTextField txtNombre;
    JLabel lblCuenta;
    JTextField txtCuenta;
    JLabel lblCorreo;
    JTextField txtCorreo;
    JLabel lblCarrera;
    JTextField txtCarrera;
    JLabel lblInicio;
    JTextField txtInicio;
    JLabel lblFin;
    JTextField txtFin;
    JButton btnRegresar;
    JButton btnAgregar;
    JButton bRegistrar;
    JPanel panel;

    public AltaSPanel(JFrame ventanaAlta) {
        //Inicializando datos
        this.ventanaAlta = ventanaAlta;

        String[] tipoUsuario = {"Registrar Equipos", "Registrar Servicio Social", "Registrar Alumnos"};
        TipoAlta = new JComboBox<String>(tipoUsuario);
        TipoAlta.setBackground(Color.white);
        TipoAlta.setFont(new Font("Bell MT",Font.BOLD,14));
        String opcion = TipoAlta.getSelectedItem().toString();

        //Aplicando un formato de LayOut
        //setLayout(new GridLayout(7,2,15,15));
        //Creando etiquetas
        lblTel = new JLabel("Telefono:");
        lblTel.setFont(new Font("Bell MT",Font.BOLD,16));
        lblNombre = new JLabel("Nombre del servicio:");
        lblNombre.setFont(new Font("Bell MT",Font.BOLD,16));
        lblCuenta = new JLabel("Numero de cuenta:");
        lblCuenta.setFont(new Font("Bell MT",Font.BOLD,16));
        lblCorreo = new JLabel("Correo electronico:");
        lblCorreo.setFont(new Font("Bell MT",Font.BOLD,16));
        lblCarrera = new JLabel("Carrera:");
        lblCarrera.setFont(new Font("Bell MT",Font.BOLD,16));
        lblInicio = new JLabel("Fecha de inicio:");
        lblInicio.setFont(new Font("Bell MT",Font.BOLD,16));
        lblFin = new JLabel("Fecha de termino:");
        lblFin.setFont(new Font("Bell MT",Font.BOLD,16));

        //Creando campos de texto
        txtTel = new JTextField("");
        txtNombre = new JTextField("");
        txtCuenta = new JTextField("");
        txtCorreo = new JTextField("");
        txtCarrera = new JTextField("");
        txtInicio = new JTextField("");
        txtFin = new JTextField("");

        //Creando botones para que escuchen y actuen
        btnRegresar = new JButton("Regresar");
        btnRegresar.setActionCommand("Regresar");
        btnRegresar.addActionListener(this);
        btnRegresar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnRegresar.setBackground(Color.white);
        btnAgregar = new JButton("Registrar");
        btnAgregar.setActionCommand("Registrar");
        btnAgregar.addActionListener(this);
        btnAgregar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnAgregar.setBackground(Color.white);

        TipoAlta.addActionListener(this);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 15, 15, 1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.CENTER;
        this.add(TipoAlta, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 15, 4, 1);
        this.add(lblCuenta, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 10, 1);
        this.add(txtCuenta, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5, 15, 5, 1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(this.lblNombre, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 4, 1);
        this.add(this.txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5, 15, 5, 1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(this.lblCorreo, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 4, 1);
        this.add(this.txtCorreo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 15, 4, 1);
        this.add(lblTel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 10, 1);
        this.add(txtTel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 15, 4, 1);
        this.add(lblCarrera, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 10, 1);
        this.add(txtCarrera, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 15, 4, 1);
        this.add(lblInicio, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 10, 1);
        this.add(txtInicio, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 15, 4, 1);
        this.add(lblFin, gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 10, 1);
        this.add(txtFin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(15, 4, 4, 10);
        this.add(btnAgregar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(15, 4, 4, 10);
        this.add(btnRegresar, gbc);

        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Registro de Servicios");
        setBorder(bordejpanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Registrar":
                VServ validacion = new VServ();

                if (validacion.altaEsCorrecta(txtCuenta.getText(), txtNombre.getText(), txtCorreo.getText(), txtTel.getText(), txtCarrera.getText(), txtInicio.getText(), txtFin.getText())) {
                    if (validacion.esCuentaUnica(validacion.getServicio().getCuenta())) {
                        byte op1 = (byte) JOptionPane.showConfirmDialog(null, "Los datos ingresados son correctos?\n" + "Numero de cuenta: " + validacion.getServicio().getCuenta() + "\nNombre del servicio: " + validacion.getServicio().getNombre() + "\nCorreo electronico: " + validacion.getServicio().getCorreo() + "\nTelefono: " + validacion.getServicio().getTelefono() + "\nCarrera: " + validacion.getServicio().getCarrera() + "\nFecha de inicio: " + validacion.getServicio().getInicio() + "\n Fecha de termino:" + validacion.getServicio().getFin());
                        if (op1 == 0) {
                            //JOptionPane.showMessageDialog(null,"Pieza agregada correctamente:\n" + "Clave: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nPrecio: " + validacion.getPieza().getPrecio()+ "\nUnidades: " + validacion.getPieza().getUnidades() + "\nEscasez: " + validacion.getPieza().getAlerta());
                            ArServ archivo = new ArServ();
                            ArrayList<Servicio> servicios = archivo.leerArchivo();
                            servicios.add(validacion.getServicio());
                            QuickServ quicksort = new QuickServ(servicios);//ordenando vector
                            archivo.guardarArchivo(servicios);
                            byte op2 = (byte) JOptionPane.showConfirmDialog(null, "Desea agregar a otro servicio?\n");
                            if (op2 == 0) {
                                inicializar();
                            } else {
                                VentanaMenuAdm vtnMenu = new VentanaMenuAdm();
                                ventanaAlta.dispose();
                            }
                        }
                    }

                }
                break;
            case "Regresar":
                VentanaMenuAdm vtnMenu = new VentanaMenuAdm();
                ventanaAlta.dispose();
                break;

            case "comboBoxChanged":
                String seleccionCmbox = (String) TipoAlta.getSelectedItem();
                switch (seleccionCmbox) {
                    case "Registrar Equipos":
                        AltaVentana vtnKits = new AltaVentana();
                        ventanaAlta.dispose();
                        break;
                    case "Registrar Servicio Social":
                        AltaSVentana v = new AltaSVentana();
                        ventanaAlta.dispose();
                        break;
                    case "Registrar Alumnos":
                        RegIntVentana inte = new RegIntVentana();
                        ventanaAlta.dispose();
                        break;
                }
                break;

        }
    }

    private void inicializar() {
        txtNombre.setText("");
        txtCuenta.setText("");
        txtCorreo.setText("");
        txtTel.setText("");
        txtCarrera.setText("");
        txtInicio.setText("");
        txtFin.setText("");

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
