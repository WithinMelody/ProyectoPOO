/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaIntegrante;

import Archivos.ArInt;
import MenuUsuarios.VentanaMenuAdm;
import Objetos.Integrante;
import Validaciones.VIntegrante;
import VentanaEquipo.MoVentana;
import VentanaServicio.MoSVentana;
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
public class MoIntPanel extends JPanel implements ActionListener {

    //Variables globales de trabajo
    private JComboBox<String> TipoMod;
    JFrame ventanaModificaciones;
    JLabel lblEquipo;
    JTextField txtEquipo;
    JLabel lblMateria;
    JTextField txtMateria;
    JLabel lblProfesor;
    JTextField txtProfesor;
    JLabel lblNombre;
    JTextField txtNombre;
    JLabel lblCuenta;
    JTextField txtCuenta;
    JLabel lblCorreo;
    JTextField txtCorreo;
    JButton btnBuscar;
    JButton btnRegresar;
    JButton btnCancelar;
    JButton btnModificar;
    GridBagConstraints gbc = new GridBagConstraints();
    VIntegrante validacion = new VIntegrante();

    public MoIntPanel(JFrame ventanaModificaciones) {
        //Inicializando datos
        this.ventanaModificaciones = ventanaModificaciones;
        String[] tipoMod = {"Modificar Equipos", "Modificar Alumnos", "Modificar Servicios"};
        TipoMod = new JComboBox<String>(tipoMod);
        TipoMod.setBackground(Color.WHITE);
        TipoMod.setFont(new Font("Bell MT",Font.BOLD,14));
        String opcion = TipoMod.getSelectedItem().toString();

        //Aplicando un formato de LayOut
        setLayout(new GridBagLayout());

        //Creando etiquetas
        lblEquipo = new JLabel("Numero de equipo:");
        lblEquipo.setFont(new Font("Bell MT",Font.BOLD,16));
        lblMateria = new JLabel("Materia:");
        lblMateria.setFont(new Font("Bell MT",Font.BOLD,16));
        lblProfesor = new JLabel("Profesor:");
        lblProfesor.setFont(new Font("Bell MT",Font.BOLD,16));
        lblNombre = new JLabel("Nombre del alumno:");
        lblNombre.setFont(new Font("Bell MT",Font.BOLD,16));
        lblCuenta = new JLabel("Numero de cuenta:");
        lblCuenta.setFont(new Font("Bell MT",Font.BOLD,16));
        lblCorreo = new JLabel("Correo electronico:");
        lblCorreo.setFont(new Font("Bell MT",Font.BOLD,16));

        //Creando campos de texto
        txtEquipo = new JTextField(20);
        txtMateria = new JTextField(50);
        txtProfesor = new JTextField(100);
        txtNombre = new JTextField(100);
        txtCuenta = new JTextField(20);
        txtCorreo = new JTextField(100);

        //Creando botones para que escuchen y actuen
        btnBuscar = new JButton("Buscar");
        btnBuscar.setActionCommand("Buscar");
        btnBuscar.addActionListener(this);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnRegresar = new JButton("Regresar");
        btnRegresar.setActionCommand("Regresar");
        btnRegresar.addActionListener(this);
        btnRegresar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnRegresar.setBackground(Color.WHITE);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnCancelar.setBackground(Color.WHITE);
        btnModificar = new JButton("Modificar");
        btnModificar.setActionCommand("Modificar");
        btnModificar.addActionListener(this);
        btnModificar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnModificar.setBackground(Color.WHITE);
        TipoMod.addActionListener(this);
        //Asignando propiedad de no modificacion a los campos
        txtNombre.setEditable(false);
        txtMateria.setEditable(false);
        txtProfesor.setEditable(false);
        txtEquipo.setEditable(false);
        txtCorreo.setEditable(false);

        //Configurando el LayOut a ocupar en el programa y Agregando elementos al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 15, 15, 1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.CENTER;
        this.add(TipoMod, gbc);

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
        add(lblEquipo, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtEquipo, gbc);

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
        gbc.weighty = 1.0;
        add(lblCorreo, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtCorreo, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblMateria, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtMateria, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblProfesor, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtProfesor, gbc);
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
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnModificar, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnCancelar, gbc);
        gbc.weighty = 0.0;
        btnModificar.setVisible(false);
        btnCancelar.setVisible(false);
        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Modificar Alumnos");
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
                    if (validacion.existeIntegrante(Integer.parseInt(dato))) {
                        txtMateria.setText(validacion.getIntegrante().getMateria());
                        txtProfesor.setText(validacion.getIntegrante().getProfesor() + "");
                        txtNombre.setText(validacion.getIntegrante().getNombre() + "");
                        txtEquipo.setText(validacion.getIntegrante().getEquipo() + "");
                        txtCorreo.setText(validacion.getIntegrante().getCorreo() + "");
                        btnModificar.setVisible(true);
                        btnCancelar.setVisible(true);
                        habilitarCampos();
                    } else {
                        inicializar();
                        btnModificar.setVisible(false);
                        btnCancelar.setVisible(false);
                        deshabilitarCampos();
                    }
                }
                break;
            case "Modificar":
                if (validacion.isExisteIntegrante()) {
                    Modificar(validacion.getIntegrante());
                }
                break;
            case "Cancelar":
                inicializar();
                btnModificar.setVisible(false);
                btnCancelar.setVisible(false);
                deshabilitarCampos();
                break;
            case "Regresar":
                VentanaMenuAdm vtnMenu = new VentanaMenuAdm();
                ventanaModificaciones.dispose();
                break;
            case "comboBoxChanged":
                String seleccionCmbox = (String) TipoMod.getSelectedItem();
                switch (seleccionCmbox) {
                    case "Modificar Equipos":
                        MoVentana vtnKits = new MoVentana();
                        ventanaModificaciones.dispose();
                        break;
                    case "Modificar Alumnos":
                        MoIntVentana v = new MoIntVentana();
                        ventanaModificaciones.dispose();
                        break;
                    case "Modificar Servicios":
                        MoSVentana n = new MoSVentana();
                        ventanaModificaciones.dispose();
                        break;
                }
                break;
        }
    }

    private void inicializar() {
        txtEquipo.setText("");
        txtNombre.setText("");
        txtMateria.setText("");
        txtProfesor.setText("");
        txtCorreo.setText("");
        txtCuenta.setText("");
    }

    private void habilitarCampos() {
        txtCuenta.setEditable(false);
        txtNombre.setEditable(true);
        txtProfesor.setEditable(true);
        txtEquipo.setEditable(true);
        txtCorreo.setEditable(true);
        txtMateria.setEditable(true);
    }

    private void deshabilitarCampos() {
        txtCuenta.setEditable(true);
        txtNombre.setEditable(false);
        txtProfesor.setEditable(false);
        txtMateria.setEditable(false);
        txtCorreo.setEditable(false);
        txtEquipo.setEditable(false);
    }
    //Variables globales de trabajo

    public void Modificar(Integrante eq) {
        if (validacion.altaEsCorrecta(txtCuenta.getText(), txtEquipo.getText(), txtNombre.getText(), txtCorreo.getText(), txtMateria.getText(), txtProfesor.getText())) {
            byte op1 = (byte) JOptionPane.showConfirmDialog(null, "Los datos ingresados son correctos?\n" + "No. de cuenta: " + validacion.getIntegrante().getCuenta() + "\nEquipo: " + validacion.getIntegrante().getEquipo() + "\nNombre del alumno: " + validacion.getIntegrante().getNombre() + "\nCorreo: " + validacion.getIntegrante().getCorreo() + "\nMateria: " + validacion.getIntegrante().getMateria() + "\nProfesor: " + validacion.getIntegrante().getProfesor());
            if (op1 == 0) {
                //JOptionPane.showMessageDialog(null,"Pieza agregada correctamente:\n" + "Clave: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nPrecio: " + validacion.getPieza().getPrecio()+ "\nUnidades: " + validacion.getPieza().getUnidades() + "\nEscasez: " + validacion.getPieza().getAlerta());
                ArInt archivo = new ArInt();
                ArrayList<Integrante> piezas = archivo.leerArchivo();
                piezas.set((int) validacion.getPosicionDeIntegrante(), validacion.getIntegrante());
                archivo.guardarArchivo(piezas);
                JOptionPane.showMessageDialog(null, "Informacion modificada correctamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
                byte op2 = (byte) JOptionPane.showConfirmDialog(null, "Desea modificar la informacion de otro alumno?\n");
                if (op2 == 0) {
                    inicializar();
                    btnModificar.setVisible(false);
                    btnCancelar.setVisible(false);
                    deshabilitarCampos();
                } else {
                    VentanaMenuAdm vtnMenu = new VentanaMenuAdm();
                    ventanaModificaciones.dispose();
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
