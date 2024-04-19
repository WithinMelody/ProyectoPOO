/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaServicio;

import Archivos.ArServ;
import MenuUsuarios.VentanaMenuAdm;
import Objetos.Servicio;
import Validaciones.VServ;
import VentanaEquipo.EVentana;
import VentanaIntegrante.ElIntVentana;
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
public class ElSPanel extends JPanel implements ActionListener {

    JFrame ventanaEliminar;
    JLabel lblCuenta;
    JTextField txtCuenta;
    JLabel lblCorreo;
    JTextField txtCorreo;
    JLabel lblTel;
    JTextField txtTel;
    JLabel lblCarrera;
    JTextField txtCarrera;
    JLabel lblNombre;
    JTextField txtNombre;
    JLabel lblInicio;
    JTextField txtInicio;
    JTextField txtFin;
    JLabel lblFin;

    JButton btnBuscar;
    JButton btnRegresar;
    JButton btnModificar;
    GridBagConstraints gbc = new GridBagConstraints();
    VServ validacion = new VServ();
    private JComboBox<String> TipoEliminar;

    public ElSPanel(JFrame ventanaModificaciones) {
        //Inicializando datos
        this.ventanaEliminar = ventanaModificaciones;
        String[] tipoEliminar = {"Dar de Baja Equipos", "Dar de Baja Alumnos", "Dar de Baja Servicios"};
        TipoEliminar = new JComboBox<String>(tipoEliminar);
        TipoEliminar.setBackground(Color.white);
        TipoEliminar.setFont(new Font("Bell MT",Font.BOLD,14));
        String opcion = TipoEliminar.getSelectedItem().toString();

        //Aplicando un formato de LayOut
        setLayout(new GridBagLayout());

        //Creando etiquetas
        lblTel = new JLabel("Telefono:");
        lblTel.setFont(new Font("Bell MT",Font.BOLD,16));
        lblCarrera = new JLabel("Carrera:");
        lblCarrera.setFont(new Font("Bell MT",Font.BOLD,16));
        lblInicio = new JLabel("Fecha de inicio:");
        lblInicio.setFont(new Font("Bell MT",Font.BOLD,16));
        lblFin = new JLabel("Fecha de termino:");
        lblFin.setFont(new Font("Bell MT",Font.BOLD,16));
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
        btnModificar = new JButton("Eliminar");
        btnModificar.setActionCommand("Eliminar");
        btnModificar.addActionListener(this);
        btnModificar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnModificar.setBackground(Color.white);
        TipoEliminar.addActionListener(this);
        //Asignando propiedad de no modificacion a los campos
        txtNombre.setEditable(false);
        txtCorreo.setEditable(false);
        txtTel.setEditable(false);
        txtCarrera.setEditable(false);
        txtInicio.setEditable(false);
        txtFin.setEditable(false);

        //Configurando el LayOut a ocupar en el programa y Agregando elementos al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 15, 15, 1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.CENTER;
        this.add(TipoEliminar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(lblCuenta, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(txtCuenta, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(btnBuscar, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(lblNombre, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtNombre, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(lblCorreo, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtCorreo, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblTel, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtTel, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblCarrera, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtCarrera, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblInicio, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtInicio, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblFin, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtFin, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnRegresar, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnModificar, gbc);

        btnModificar.setVisible(false);
        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Dar de Baja Servicios");
        setBorder(bordejpanel);
        inicializar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Buscar":
                String dato = txtCuenta.getText();
                if (validacion.validarNumero(dato, Integer.MAX_VALUE, Integer.MIN_VALUE, "numero de cuenta")) {
                    if (validacion.existeServicio(Integer.parseInt(dato))) {
                        txtNombre.setText(validacion.getServicio().getNombre());
                        txtCorreo.setText(validacion.getServicio().getCorreo() + "");
                        txtTel.setText(validacion.getServicio().getTelefono() + "");
                        txtCarrera.setText(validacion.getServicio().getCarrera() + "");
                        txtInicio.setText(validacion.getServicio().getInicio() + "");
                        txtFin.setText(validacion.getServicio().getFin() + "");
                        btnModificar.setVisible(true);
                    } else {
                        inicializar();
                        btnModificar.setVisible(false);
                    }
                }
                break;
            case "Eliminar":
                if (validacion.isExisteServicio()) {
                    Eliminar(validacion.getServicio());
                }
                break;
            case "Cancelar":
                inicializar();
                btnModificar.setVisible(false);
                break;
            case "Regresar":
                VentanaMenuAdm vtnMenu = new VentanaMenuAdm();
                ventanaEliminar.dispose();
                break;
            case "comboBoxChanged":
                String seleccionCmbox = (String) TipoEliminar.getSelectedItem();
                switch (seleccionCmbox) {
                    case "Dar de Baja Equipos":
                        EVentana vtnKits = new EVentana();
                        ventanaEliminar.dispose();
                        break;
                    case "Dar de Baja Alumnos":
                        ElIntVentana v = new ElIntVentana();
                        ventanaEliminar.dispose();
                        break;
                    case "Dar de Baja Servicios":
                        ElSVentana n = new ElSVentana();
                        ventanaEliminar.dispose();
                        break;
                }
                break;
        }
    }

    private void inicializar() {
        txtTel.setText("");
        txtNombre.setText("");
        txtCarrera.setText("");
        txtInicio.setText("");
        txtFin.setText("");
        txtCorreo.setText("");
        txtCuenta.setText("");
    }

    //Variables globales de trabajo
    public void Eliminar(Servicio eq) {
        if (validacion.altaEsCorrecta(txtCuenta.getText(), txtNombre.getText(), txtCorreo.getText(), txtTel.getText(), txtCarrera.getText(), txtInicio.getText(), txtFin.getText())) {
            byte op1 = (byte) JOptionPane.showConfirmDialog(null, "Desea eliminar al servicio?\n" + "Nombre: " + validacion.getServicio().getNombre() + "\nCorreo: " + validacion.getServicio().getCorreo() + "\nTelefono: " + validacion.getServicio().getTelefono() + "\nCarrera: " + validacion.getServicio().getCarrera() + "\nF. Inicio: " + validacion.getServicio().getInicio() + "\nF. Termino: " + validacion.getServicio().getFin());
            if (op1 == 0) {
                //JOptionPane.showMessageDialog(null,"Pieza agregada correctamente:\n" + "Clave: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nPrecio: " + validacion.getPieza().getPrecio()+ "\nUnidades: " + validacion.getPieza().getUnidades() + "\nEscasez: " + validacion.getPieza().getAlerta());
                ArServ archivo = new ArServ();
                ArrayList<Servicio> equipos = archivo.leerArchivo();
                equipos.remove((int) validacion.getPosicionDeServicio());
                archivo.guardarArchivo(equipos);
                JOptionPane.showMessageDialog(null, "Servicio eliminado correctamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
                byte op2 = (byte) JOptionPane.showConfirmDialog(null, "Desea eliminar a otro servicio?\n");
                if (op2 == 0) {
                    inicializar();
                    btnModificar.setVisible(false);
                } else {
                    VentanaMenuAdm vtnMenu = new VentanaMenuAdm();
                    ventanaEliminar.dispose();
                }
            }
        }
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
