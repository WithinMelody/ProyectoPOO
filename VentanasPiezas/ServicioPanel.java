/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanasPiezas;

import Archivos.Archivos;
import MenuUsuarios.VentanaMenuServicio;
import Objetos.Pieza;
import Validaciones.Validaciones;
import VentanasKits.ServicioVentanaK;
import VentanasKits.ServiciosVentanaK;
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
 * @author Erick
 */
public class ServicioPanel extends JPanel implements ActionListener {

    JFrame ventanaServicio;
    JLabel lblClave;
    JTextField txtClave;
    JLabel lblNombre;
    JTextField txtNombre;
    JLabel lblPrecio;
    JTextField txtPrecio;
    JLabel lblUnidades;
    JTextField txtUnidades;
    JLabel lblEscasez;
    JTextField txtEscasez;
    JLabel lblCantidad;
    JTextField txtCantidad;
    JLabel serv;
    JTextField txtServ;
    JLabel fecha;
    JTextField txtFecha;
    JLabel lblEquipo;
    JTextField txtEquipo;
    JButton btnBuscar;
    JButton btnRegresar;
    JButton btnCancelar;
    JButton btnServicio;
    GridBagConstraints gbc = new GridBagConstraints();
    Validaciones validacion = new Validaciones();
    String accion;
    String mensaje;
    boolean servicio;
    private JComboBox<String> TipoS;

    public ServicioPanel(JFrame ventanaServicio, String accion, String mensaje, boolean servicio) {
        //Inicializando datos
        this.ventanaServicio = ventanaServicio;
        this.accion = accion;
        this.mensaje = mensaje;
        this.servicio = servicio;
        String[] tipoUsuario = {"Servicios Piezas", "Servicios Kits"};
        TipoS = new JComboBox<String>(tipoUsuario);
        TipoS.setBackground(Color.white);
        TipoS.setFont(new Font("Bell MT",Font.BOLD,14));
        String opcion = TipoS.getSelectedItem().toString();
        //Aplicando un formato de LayOut

        setLayout(new GridBagLayout());

        //Creando etiquetas
        lblClave = new JLabel("Código:");
        lblClave.setFont(new Font("Bell MT",Font.BOLD,16));
        lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Bell MT",Font.BOLD,16));
        lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Bell MT",Font.BOLD,16));
        lblUnidades = new JLabel("Piezas disponibles:");
        lblUnidades.setFont(new Font("Bell MT",Font.BOLD,16));
        lblEscasez = new JLabel("Mínimo de piezas:");
        lblEscasez.setFont(new Font("Bell MT",Font.BOLD,16));
        lblCantidad = new JLabel("Piezas a " + accion + ":");
        lblCantidad.setFont(new Font("Bell MT",Font.BOLD,16));
        serv = new JLabel("Servicio que va a "+accion+":");
        serv.setFont(new Font("Bell MT",Font.BOLD,16));
        fecha = new JLabel ("Fecha en que se va a "+accion+":");
        fecha.setFont(new Font("Bell MT",Font.BOLD,16));
        lblEquipo = new JLabel("Equipo que pide/devuelve:");
        lblEquipo.setFont(new Font("Bell MT",Font.BOLD,16));

        //Creando campos de texto
        txtClave = new JTextField(20);
        txtNombre = new JTextField(20);
        txtPrecio = new JTextField(20);
        txtUnidades = new JTextField(20);
        txtEscasez = new JTextField(20);
        txtCantidad = new JTextField(20);
        txtServ = new JTextField(20);
        txtFecha = new JTextField(20);
        txtEquipo = new JTextField(20);

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
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnCancelar.setBackground(Color.white);
        btnServicio = new JButton(accion);
        btnServicio.setActionCommand("Servicio");
        btnServicio.addActionListener(this);
        btnServicio.setFont(new Font("Bell MT",Font.BOLD,16));
        btnServicio.setBackground(Color.white);
        TipoS.addActionListener(this);
        //Asignando propiedad de no modificacion a los campos
        deshabilitarCampos();
        //Configurando el LayOut a ocupar en el programa y Agregando elementos al panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 15, 15, 1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.CENTER;
        this.add(TipoS, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(lblClave, gbc);
        //gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtClave, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
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
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtNombre, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(lblPrecio, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtPrecio, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblUnidades, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtUnidades, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblEscasez, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtEscasez, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblCantidad, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtCantidad, gbc);
        
         gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(serv, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtServ, gbc);
         gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(fecha, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtFecha, gbc);
        
          gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblEquipo, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtEquipo, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnRegresar, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnServicio, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 13;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnCancelar, gbc);
        gbc.weighty = 0.0;
        btnServicio.setVisible(false);
        btnCancelar.setVisible(false);
        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Servicio para Piezas");
        setBorder(bordejpanel);
        inicializar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Buscar":
                String dato = txtClave.getText();
                if (validacion.validarNumero(dato, Integer.MAX_VALUE, Integer.MIN_VALUE, "código")) {
                    if (validacion.existeClave(Integer.parseInt(dato))) {
                        txtNombre.setText(validacion.getPieza().getNombre());
                        txtPrecio.setText(validacion.getPieza().getPrecio() + "");
                        txtUnidades.setText(validacion.getPieza().getUnidades() + "");
                        txtEscasez.setText(validacion.getPieza().getAlerta() + "");
                        txtCantidad.setText("");
                        txtServ.setText("");
                        txtFecha.setText("");
                        txtEquipo.setText("");
                        btnServicio.setVisible(true);
                        btnCancelar.setVisible(true);
                        habilitarCampos();
                    } else {
                        inicializar();
                        btnServicio.setVisible(false);
                        btnCancelar.setVisible(false);
                        deshabilitarCampos();
                    }
                }
                break;
            case "Servicio":
                if (validacion.isExistePieza()) {
                    Servicio(validacion.getPieza());
                }
                break;
            case "Cancelar":
                inicializar();
                btnServicio.setVisible(false);
                btnCancelar.setVisible(false);
                deshabilitarCampos();
                break;
            case "Regresar":
                ServiciosVentana vtnServicios = new ServiciosVentana();
                ventanaServicio.dispose();
                break;
            case "comboBoxChanged":
                String seleccionCmbox = (String) TipoS.getSelectedItem();
                switch (seleccionCmbox) {
                    case "Servicios Kits":
                        ServiciosVentanaK vtnKits = new ServiciosVentanaK();
                        ventanaServicio.dispose();
                        break;
                    case "Servicios Piezas":
                        ServiciosVentana vtnPiezas = new ServiciosVentana();
                        ventanaServicio.dispose();
                        break;
                }
                break;
        }
    }

    private void inicializar() {
        txtClave.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtUnidades.setText("");
        txtEscasez.setText("");
        txtCantidad.setText("");
        txtServ.setText("");
        txtFecha.setText("");
        txtEquipo.setText("");
    }

    private void habilitarCampos() {
        txtClave.setEditable(false);
        txtNombre.setEditable(false);
        txtPrecio.setEditable(false);
        txtUnidades.setEditable(false);
        txtEscasez.setEditable(false);
        txtServ.setEditable(true);
        txtFecha.setEditable(true);
        txtCantidad.setEditable(true);
        txtEquipo.setEditable(true);
    }

    private void deshabilitarCampos() {
        txtClave.setEditable(true);
        txtNombre.setEditable(false);
        txtPrecio.setEditable(false);
        txtUnidades.setEditable(false);
        txtEscasez.setEditable(false);
        txtCantidad.setEditable(false);
        txtFecha.setEditable(false);
        txtServ.setEditable(false);
        txtEquipo.setEditable(false);
    }
    //Variables globales de trabajo

    public void Servicio(Pieza pieza) {
        if (validacion.validarNumero(txtCantidad.getText(), Integer.MAX_VALUE, Integer.MIN_VALUE, "Piezas a " + accion + "")) {
            if (validacion.prestamoAdecuado(servicio)) {
                byte op1 = (byte) JOptionPane.showConfirmDialog(null, "La cantidad de piezas a " + accion + " es correcta?\n" + "Código: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nCantidad de piezas: " + validacion.getNumero()+"\nNombre del servicio: "+txtServ.getText()+"\nEquipo:"+txtEquipo.getText()+"\nFecha:"+txtFecha.getText());
                if (op1 == 0) {
                    //JOptionPane.showMessageDialog(null,"Pieza agregada correctamente:\n" + "Clave: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nPrecio: " + validacion.getPieza().getPrecio()+ "\nUnidades: " + validacion.getPieza().getUnidades() + "\nEscasez: " + validacion.getPieza().getAlerta());
                    Archivos archivo = new Archivos();
                    ArrayList<Pieza> piezas = archivo.leerArchivo();
                    if (servicio) {
                        validacion.getPieza().setUnidades((int) (validacion.getPieza().getUnidades() - validacion.getNumero()));
                    } else {
                        validacion.getPieza().setUnidades((int) (validacion.getPieza().getUnidades() + validacion.getNumero()));
                    }

                    piezas.set((int) validacion.getPosicionDePieza(), validacion.getPieza());
                    archivo.guardarArchivo(piezas);
                    JOptionPane.showMessageDialog(null, mensaje + " realizado correctamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
                    byte op2 = (byte) JOptionPane.showConfirmDialog(null, "Desea realizar otro " + mensaje + "?\n");
                    if (op2 == 0) {
                        inicializar();
                        btnServicio.setVisible(false);
                        btnCancelar.setVisible(false);
                        deshabilitarCampos();
                    } else {
                        VentanaMenuServicio vtnMenu = new VentanaMenuServicio();
                        ventanaServicio.dispose();
                    }
                }
            }
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
