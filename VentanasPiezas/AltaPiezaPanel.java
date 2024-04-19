package VentanasPiezas;

import Archivos.Archivos;
import MenuUsuarios.VentanaMenuServicio;
import Quicksort.Quicksort;
import Objetos.Pieza;
import Validaciones.Validaciones;
import VentanasKits.AltaVentanaK;
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
public class AltaPiezaPanel extends JPanel implements ActionListener{
    //Variables globales de trabajo
    private JComboBox<String> TipoAlta;
    JFrame ventanaAlta;
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
    JButton btnRegresar;
    JButton btnAgregar;
    JPanel panel;
   
    
    
    
    public AltaPiezaPanel(JFrame ventanaAlta){
        //Inicializando datos
        this.ventanaAlta = ventanaAlta;
      
      
        String[] tipoUsuario = {"Registro Piezas", "Registro Kits"};
        TipoAlta = new JComboBox<String>(tipoUsuario);
        TipoAlta.setBackground(Color.white);
        TipoAlta.setFont(new Font("Bell MT",Font.BOLD,14));
        String opcion = TipoAlta.getSelectedItem().toString();
  

        //Aplicando un formato de LayOut
        //setLayout(new GridLayout(7,2,15,15));
        
        //Creando etiquetas
        
        lblClave = new JLabel("Codigo:");
        lblClave.setFont(new Font("Bell MT",Font.BOLD,16));
        lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Bell MT",Font.BOLD,16));
        lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Bell MT",Font.BOLD,16));
        lblUnidades = new JLabel("Piezas disponibles:");
        lblUnidades.setFont(new Font("Bell MT",Font.BOLD,16));
        lblEscasez = new JLabel("Minimo de piezas:");
        lblEscasez.setFont(new Font("Bell MT",Font.BOLD,16));
        
        //Creando campos de texto
        txtClave = new JTextField("");
        txtNombre = new JTextField("");
        txtPrecio = new JTextField("");
        txtUnidades = new JTextField("");
        txtEscasez = new JTextField("");
        
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
        this.add(lblPrecio, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 10, 1);
        this.add(txtPrecio, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 15, 4, 1);
        this.add(lblUnidades, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 10, 1);
        this.add(txtUnidades, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 15, 4, 1);
        this.add(lblEscasez, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 15, 10, 1);
        this.add(txtEscasez, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weighty =1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(15, 4, 4, 10);
        this.add(btnAgregar, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(15, 4, 4, 10);
        this.add(btnRegresar, gbc);
        
        
   
    
        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Registro de Piezas");
        setBorder(bordejpanel);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Agregar":
                Validaciones validacion = new Validaciones();
                if (validacion.altaEsCorrecta(txtClave.getText(), txtNombre.getText(), txtPrecio.getText(), txtUnidades.getText(), txtEscasez.getText())) {
                    if (validacion.esClaveUnica(validacion.getPieza().getCodigo())) {
                        byte op1 = (byte) JOptionPane.showConfirmDialog(null, "Los datos ingresados son correctos?\n" + "Codigo: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nPrecio: " + validacion.getPieza().getPrecio() + "\nPiezas disponibles: " + validacion.getPieza().getUnidades() + "\nMinimo de piezas: " + validacion.getPieza().getAlerta());
                        if (op1 == 0) {
                            //JOptionPane.showMessageDialog(null,"Pieza agregada correctamente:\n" + "Clave: " + validacion.getPieza().getCodigo() + "\nNombre: " + validacion.getPieza().getNombre() + "\nPrecio: " + validacion.getPieza().getPrecio()+ "\nUnidades: " + validacion.getPieza().getUnidades() + "\nEscasez: " + validacion.getPieza().getAlerta());
                            Archivos archivo = new Archivos();
                            ArrayList<Pieza> piezas = archivo.leerArchivo();
                            piezas.add(validacion.getPieza());
                            Quicksort quicksort = new Quicksort(piezas);//ordenando vector
                            archivo.guardarArchivo(piezas);
                            byte op2 = (byte) JOptionPane.showConfirmDialog(null, "Desea agregar otra pieza?\n");
                            if (op2 == 0) {
                                inicializar();
                            }else{
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
                String seleccionCmbox = (String)TipoAlta.getSelectedItem();
                switch(seleccionCmbox){
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
    
    private void inicializar(){
        txtClave.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtUnidades.setText("");
        txtEscasez.setText("");
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