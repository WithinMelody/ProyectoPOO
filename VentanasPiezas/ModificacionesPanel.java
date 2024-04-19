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
import VentanasKits.ModificacionesVentanaK;
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
public class ModificacionesPanel extends JPanel implements ActionListener {

    //Variables globales de trabajo
    private JComboBox<String> TipoMod;
    JFrame ventanaModificaciones;
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
    JButton btnBuscar;
    JButton btnRegresar;
    JButton btnCancelar;
    JButton btnModificar;
    GridBagConstraints gbc = new GridBagConstraints();
    Validaciones validacion = new Validaciones();

    public ModificacionesPanel(JFrame ventanaModificaciones) {
        //Inicializando datos
        this.ventanaModificaciones = ventanaModificaciones;
        String[] tipoMod = {"Modificar Piezas", "Modificar Kits"};
        TipoMod = new JComboBox<String>(tipoMod);
        TipoMod.setBackground(Color.white);
        TipoMod.setFont(new Font("Bell MT",Font.BOLD,14));
        String opcion = TipoMod.getSelectedItem().toString();

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

        //Creando campos de texto
        txtClave = new JTextField(20);
        txtNombre = new JTextField(20);
        txtPrecio = new JTextField(20);
        txtUnidades = new JTextField(20);
        txtEscasez = new JTextField(20);

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
        btnModificar = new JButton("Modificar");
        btnModificar.setActionCommand("Modificar");
        btnModificar.addActionListener(this);
        btnModificar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnModificar.setBackground(Color.white);
        TipoMod.addActionListener(this);
        //Asignando propiedad de no modificacion a los campos
        txtNombre.setEditable(false);
        txtPrecio.setEditable(false);
        txtUnidades.setEditable(false);
        txtEscasez.setEditable(false);

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
        add(lblClave, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(txtClave, gbc);

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
        add(lblPrecio, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtPrecio, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblUnidades, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtUnidades, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblEscasez, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(txtEscasez, gbc);
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
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Modificar Piezas");
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
                if (validacion.isExistePieza()) {
                    Modificar(validacion.getPieza());
                }
                break;
            case "Cancelar":
                inicializar();
                btnModificar.setVisible(false);
                btnCancelar.setVisible(false);
                deshabilitarCampos();
                break;
            case "Regresar":
                VentanaMenuServicio vtnMenu = new VentanaMenuServicio();
                ventanaModificaciones.dispose();
                break;
            case "comboBoxChanged":
                String seleccionCmbox = (String) TipoMod.getSelectedItem();
                switch (seleccionCmbox) {
                    case "Modificar Kits":
                        ModificacionesVentanaK vtnKits = new ModificacionesVentanaK();
                        ventanaModificaciones.dispose();
                        break;
                    case "Modificar Piezas":
                        ModificacionesVentana vtnPieza = new ModificacionesVentana();
                        ventanaModificaciones.dispose();
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
    }

    private void habilitarCampos() {
        txtClave.setEditable(false);
        txtNombre.setEditable(true);
        txtPrecio.setEditable(true);
        txtUnidades.setEditable(true);
        txtEscasez.setEditable(true);
    }

    private void deshabilitarCampos() {
        txtClave.setEditable(true);
        txtNombre.setEditable(false);
        txtPrecio.setEditable(false);
        txtUnidades.setEditable(false);
        txtEscasez.setEditable(false);
    }
    //Variables globales de trabajo

    public void Modificar(Pieza pieza) {
        if (validacion.altaEsCorrecta(txtClave.getText(), txtNombre.getText(), txtPrecio.getText(), txtUnidades.getText(), txtEscasez.getText())) {
            byte op1 = (byte) JOptionPane.showConfirmDialog(null, "Los datos ingresados son correctos?\n" + "Código: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nPrecio: " + validacion.getPieza().getPrecio() + "\nPiezas disponibles: " + validacion.getPieza().getUnidades() + "\nMinimo de piezas: " + validacion.getPieza().getAlerta());
            if (op1 == 0) {
                //JOptionPane.showMessageDialog(null,"Pieza agregada correctamente:\n" + "Clave: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nPrecio: " + validacion.getPieza().getPrecio()+ "\nUnidades: " + validacion.getPieza().getUnidades() + "\nEscasez: " + validacion.getPieza().getAlerta());
                Archivos archivo = new Archivos();
                ArrayList<Pieza> piezas = archivo.leerArchivo();
                piezas.set((int) validacion.getPosicionDePieza(), validacion.getPieza());
                archivo.guardarArchivo(piezas);
                JOptionPane.showMessageDialog(null, "Pieza modificada correctamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Img/correcto.png"));
                byte op2 = (byte) JOptionPane.showConfirmDialog(null, "Desea modificar otra pieza?\n");
                if (op2 == 0) {
                    inicializar();
                    btnModificar.setVisible(false);
                    btnCancelar.setVisible(false);
                    deshabilitarCampos();
                } else {
                    VentanaMenuServicio vtnMenu = new VentanaMenuServicio();
                    ventanaModificaciones.dispose();
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
