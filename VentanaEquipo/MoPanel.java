/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaEquipo;

import Archivos.ArEquipo;
import MenuUsuarios.VentanaMenuAdm;
import Objetos.Equipo;
import Validaciones.ValEquipo;
import VentanaIntegrante.MoIntVentana;
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
public class MoPanel extends JPanel implements ActionListener {
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
    JLabel lblIntegrantes;
    JTextField txtIntegrantes;
    JButton btnBuscar;
    JButton btnRegresar;
    JButton btnCancelar;
    JButton btnModificar;
    GridBagConstraints gbc = new GridBagConstraints();
    ValEquipo validacion = new ValEquipo();

    public MoPanel(JFrame ventanaModificaciones) {
        //Inicializando datos
        this.ventanaModificaciones = ventanaModificaciones;
        String[] tipoMod = {"Modificar Equipos", "Modificar Alumnos", "Modificar Servicios"};
        TipoMod = new JComboBox<String>(tipoMod);
        TipoMod.setFont(new Font("Bell MT",Font.BOLD,14));
        TipoMod.setBackground(Color.WHITE);
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
        lblNombre = new JLabel("Nombre del equipo:");
        lblNombre.setFont(new Font("Bell MT",Font.BOLD,16));
        lblIntegrantes = new JLabel("Numero de integrantes:");
        lblIntegrantes.setFont(new Font("Bell MT",Font.BOLD,16));

        //Creando campos de texto
        txtEquipo = new JTextField(20);
        txtMateria = new JTextField(50);
        txtProfesor = new JTextField(100);
        txtNombre = new JTextField(20);
        txtIntegrantes = new JTextField(20);

        //Creando botones para que escuchen y actuen
        btnBuscar = new JButton("Buscar");
        btnBuscar.setActionCommand("Buscar");
        btnBuscar.addActionListener(this);
        btnBuscar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnBuscar.setBackground(Color.WHITE);
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
        txtIntegrantes.setEditable(false);

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
        add(lblEquipo, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(txtEquipo, gbc);

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
        add(lblMateria, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtMateria, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(lblProfesor, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtProfesor, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblNombre, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtNombre, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblIntegrantes, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtIntegrantes, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnRegresar, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnModificar, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnCancelar, gbc);
        gbc.weighty = 0.0;
        btnModificar.setVisible(false);
        btnCancelar.setVisible(false);
        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Modificar Equipos");
        setBorder(bordejpanel);
        inicializar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Buscar":
                String dato = txtEquipo.getText();
                if (validacion.validarNumero(dato, Integer.MAX_VALUE, Integer.MIN_VALUE, "código")) {
                    if (validacion.existeClave(Integer.parseInt(dato))) {
                        txtMateria.setText(validacion.getEquipo().getMateria());
                        txtProfesor.setText(validacion.getEquipo().getProfesor() + "");
                        txtNombre.setText(validacion.getEquipo().getNombreE() + "");
                        txtIntegrantes.setText(validacion.getEquipo().getNumintegrantes() + "");
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
                if (validacion.isExisteEquipo()) {
                    Modificar(validacion.getEquipo());
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
        txtIntegrantes.setText("");
    }

    private void habilitarCampos() {
        txtEquipo.setEditable(false);
        txtNombre.setEditable(true);
        txtProfesor.setEditable(true);
        txtIntegrantes.setEditable(true);
        txtMateria.setEditable(true);
    }

    private void deshabilitarCampos() {
        txtEquipo.setEditable(true);
        txtNombre.setEditable(false);
        txtProfesor.setEditable(false);
        txtMateria.setEditable(false);
        txtIntegrantes.setEditable(false);
    }
    //Variables globales de trabajo

    public void Modificar(Equipo eq) {
        if (validacion.altaEsCorrecta(txtEquipo.getText(), txtIntegrantes.getText(), txtProfesor.getText(), txtMateria.getText(), txtNombre.getText())) {
            byte op1 = (byte) JOptionPane.showConfirmDialog(null, "Los datos ingresados son correctos?\n" + "Numero de equipo: " + validacion.getEquipo().getNumequipo() + "\nMateria: " + validacion.getEquipo().getMateria() + "\nProfesor: " + validacion.getEquipo().getProfesor() + "\nNombre del equipo: " + validacion.getEquipo().getNombreE() + "\nNumero de integrantes: " + validacion.getEquipo().getNumintegrantes());
            if (op1 == 0) {
                //JOptionPane.showMessageDialog(null,"Pieza agregada correctamente:\n" + "Clave: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nPrecio: " + validacion.getPieza().getPrecio()+ "\nUnidades: " + validacion.getPieza().getUnidades() + "\nEscasez: " + validacion.getPieza().getAlerta());
                ArEquipo archivo = new ArEquipo();
                ArrayList<Equipo> piezas = archivo.leerArchivo();
                piezas.set((int) validacion.getPosicionDeEquipo(), validacion.getEquipo());
                archivo.guardarArchivo(piezas);
                JOptionPane.showMessageDialog(null, "Equipo modificado correctamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
                byte op2 = (byte) JOptionPane.showConfirmDialog(null, "Desea modificar otro equipo?\n");
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
