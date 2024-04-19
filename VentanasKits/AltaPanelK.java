/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanasKits;

import Archivos.ArchivoKit;
import MenuUsuarios.VentanaMenuServicio;
import Objetos.Kit;
import Quicksort.QuickKit;
import Validaciones.ValKit;
import VentanasPiezas.AltaPiezaVentana;
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
public class AltaPanelK extends JPanel implements ActionListener {
    //Variables globales de trabajo

    JFrame ventanaAlta;
    JLabel lblClave;
    JTextField txtClave;
    JLabel lblNombre;
    JTextField txtNombre;
    JLabel lblUnidades;
    JTextField txtUnidades;
    JButton btnRegresar;
    JButton btnAgregar;
    private JComboBox<String> TipoAlta;

    public AltaPanelK(JFrame ventanaAlta) {
        //Inicializando datos
        this.ventanaAlta = ventanaAlta;
        String[] tipoUsuario = {"Registro Piezas", "Registro Kits"};
        TipoAlta = new JComboBox<String>(tipoUsuario);
        TipoAlta.setBackground(Color.white);
        TipoAlta.setFont(new Font("Bell MT",Font.BOLD,14));
        String opcion = TipoAlta.getSelectedItem().toString();

        //Aplicando un formato de LayOut
        //setLayout(new GridLayout(6, 2));
        //Creando etiquetas
        lblClave = new JLabel("Código:");
        lblClave.setFont(new Font("Bell MT",Font.BOLD,16));
        lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Bell MT",Font.BOLD,16));
        lblUnidades = new JLabel("Kits disponibles:");
        lblUnidades.setFont(new Font("Bell MT",Font.BOLD,16));

        //Creando campos de texto
        txtClave = new JTextField("");
        txtNombre = new JTextField("");
        txtUnidades = new JTextField("");

        //Creando botones para que escuchen y actuen
        btnRegresar = new JButton("Regresar");
        btnRegresar.setActionCommand("Regresar");
        btnRegresar.addActionListener(this);
        btnRegresar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnRegresar.setBackground(Color.white);
        btnAgregar = new JButton("Agregar");
        btnAgregar.setActionCommand("Agregar");
        btnAgregar.addActionListener(this);
        btnAgregar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnAgregar.setBackground(Color.white);
        TipoAlta.addActionListener(this);

        //Agregando elementos al panel
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
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5, 15, 5, 1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(this.lblClave, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 4, 1);
        this.add(this.txtClave, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 15, 4, 1);
        this.add(lblNombre, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 10, 1);
        this.add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 15, 4, 1);
        this.add(lblUnidades, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 10, 1);
        this.add(txtUnidades, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(15, 4, 4, 10);
        this.add(btnAgregar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(15, 4, 4, 10);
        this.add(btnRegresar, gbc);

        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Registro de Kits");
        setBorder(bordejpanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Agregar":
                ValKit validacion = new ValKit();
                if (validacion.altaEsCorrecta(txtClave.getText(), txtNombre.getText(), txtUnidades.getText())) {
                    if (validacion.esClaveUnica(validacion.getKit().getCodigo())) {
                        byte op1 = (byte) JOptionPane.showConfirmDialog(null, "Los datos ingresados son correctos?\n" + "Código: " + validacion.getKit().getCodigo() + "\nNombre: " + validacion.getKit().getNombre() + "\nKits disponibles: " + validacion.getKit().getUnidades());
                        if (op1 == 0) {
                            //JOptionPane.showMessageDialog(null,"Pieza agregada correctamente:\n" + "Clave: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nPrecio: " + validacion.getPieza().getPrecio()+ "\nUnidades: " + validacion.getPieza().getUnidades() + "\nEscasez: " + validacion.getPieza().getAlerta());
                            ArchivoKit archivo = new ArchivoKit();
                            ArrayList<Kit> kits = archivo.leerArchivo();
                            kits.add(validacion.getKit());
                            QuickKit quicksort = new QuickKit(kits);//ordenando vector
                            archivo.guardarArchivo(kits);
                            byte op2 = (byte) JOptionPane.showConfirmDialog(null, "Desea agregar otro kit?\n");
                            if (op2 == 0) {
                                inicializar();
                            } else {
                                VentanaMenuServicio vtnMenu = new VentanaMenuServicio();
                                ventanaAlta.dispose();
                            }
                        }
                    }

                }
                break;
            case "Regresar":
                VentanaMenuServicio vtnMenu = new VentanaMenuServicio();
                ventanaAlta.dispose();
                break;
            case "comboBoxChanged":
                String seleccionCmbox = (String) TipoAlta.getSelectedItem();
                switch (seleccionCmbox) {
                    case "Registro Kits":
                        AltaVentanaK vtnKits = new AltaVentanaK();
                        ventanaAlta.dispose();
                        break;
                    case "Registro Piezas":
                        AltaPiezaVentana vtnAlta = new AltaPiezaVentana();
                        ventanaAlta.dispose();
                        break;
                }
                break;
        }
    }

    private void inicializar() {
        txtClave.setText("");
        txtNombre.setText("");
        txtUnidades.setText("");

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
