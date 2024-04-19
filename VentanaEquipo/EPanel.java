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
import Validaciones.Validaciones;
import VentanaIntegrante.ElIntVentana;
import VentanaServicio.ElSVentana;
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
public class EPanel extends JPanel implements ActionListener {
    //Variables globales de trabajo

    JFrame ventanaEliminar;
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
    JButton btnModificar;
    GridBagConstraints gbc = new GridBagConstraints();
    ValEquipo validacion = new ValEquipo();
    private JComboBox<String> TipoEliminar;

    public EPanel(JFrame ventanaModificaciones) {
        //Inicializando datos
        this.ventanaEliminar = ventanaModificaciones;
        String[] tipoEliminar = {"Dar de Baja Equipos", "Dar de Baja Alumnos", "Dar de Baja Servicios"};
        TipoEliminar = new JComboBox<String>(tipoEliminar);
        TipoEliminar.setFont(new Font("Bell MT",Font.BOLD,14));
        TipoEliminar.setBackground(Color.WHITE);
        String opcion = TipoEliminar.getSelectedItem().toString();

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
        txtMateria = new JTextField(100);
        txtProfesor = new JTextField(100);
        txtNombre = new JTextField(100);
        txtIntegrantes = new JTextField(20);

        //Creando botones para que escuchen y actuen
        btnBuscar = new JButton("Buscar");
        btnBuscar.setActionCommand("Buscar");
        btnBuscar.addActionListener(this);
        btnBuscar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnBuscar.setBackground(Color.WHITE);
        btnRegresar = new JButton("Regresar");
        btnRegresar.setActionCommand("Regresar");
        btnRegresar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnRegresar.addActionListener(this);
        btnRegresar.setBackground(Color.WHITE);
        btnModificar = new JButton("Eliminar");
        btnModificar.setActionCommand("Eliminar");
        btnModificar.addActionListener(this);
        btnModificar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnModificar.setBackground(Color.WHITE);
        TipoEliminar.addActionListener(this);
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
        this.add(TipoEliminar, gbc);

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
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnRegresar, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnModificar, gbc);

        btnModificar.setVisible(false);
        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Dar de Baja Equipos");
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
                        txtNombre.setText(validacion.getEquipo().getNombreE());
                        txtMateria.setText(validacion.getEquipo().getMateria() + "");
                        txtProfesor.setText(validacion.getEquipo().getProfesor() + "");
                        txtIntegrantes.setText(validacion.getEquipo().getNumintegrantes() + "");
                        btnModificar.setVisible(true);
                    } else {
                        inicializar();
                        btnModificar.setVisible(false);
                    }
                }
                break;
            case "Eliminar":
                if (validacion.isExisteEquipo()) {
                    Eliminar(validacion.getEquipo());
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
        txtEquipo.setText("");
        txtNombre.setText("");
        txtMateria.setText("");
        txtProfesor.setText("");
        txtIntegrantes.setText("");
    }

    //Variables globales de trabajo
    public void Eliminar(Equipo eq) {
        if (validacion.altaEsCorrecta(txtEquipo.getText(), txtIntegrantes.getText(), txtProfesor.getText(), txtMateria.getText(), txtNombre.getText())) {
            byte op1 = (byte) JOptionPane.showConfirmDialog(null, "Desea eliminar al equipo?\n" + "Numero de equipo: " + validacion.getEquipo().getNumequipo() + "\nMateria: " + validacion.getEquipo().getMateria() + "\nProfesor: " + validacion.getEquipo().getProfesor() + "\nNombre del equipo: " + validacion.getEquipo().getNombreE() + "\nNumero de integrantes: " + validacion.getEquipo().getNumintegrantes());
            if (op1 == 0) {
                //JOptionPane.showMessageDialog(null,"Pieza agregada correctamente:\n" + "Clave: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nPrecio: " + validacion.getPieza().getPrecio()+ "\nUnidades: " + validacion.getPieza().getUnidades() + "\nEscasez: " + validacion.getPieza().getAlerta());
                ArEquipo archivo = new ArEquipo();
                ArrayList<Equipo> equipos = archivo.leerArchivo();
                equipos.remove((int) validacion.getPosicionDeEquipo());
                archivo.guardarArchivo(equipos);
                JOptionPane.showMessageDialog(null, "Equipo eliminado correctamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
                byte op2 = (byte) JOptionPane.showConfirmDialog(null, "Desea eliminar otro equipo?\n");
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
    
    public void paint(Graphics g){
        Dimension tam = getSize();
        int width = this.getSize().width;
        int height = this.getSize().height;
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Fondos/v5.jpg"));
        g.drawImage(fondo.getImage(), 0, 0,width,height,null);
        setOpaque(false);
        super.paint(g);
        
        
    }
}
