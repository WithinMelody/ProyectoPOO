package VentanasPiezas;

import MenuUsuarios.VentanaMenuServicio;
import Validaciones.Validaciones;
import VentanasKits.ConsultaVentanaK;
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
 * @author Mariana
 */
public class ConsultaPanel extends JPanel implements ActionListener {

    //Variables globales de trabajo
    private JComboBox<String> TipoConsulta;
    JFrame ventanaConsulta;
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
    GridBagConstraints gbc = new GridBagConstraints();

    public ConsultaPanel(JFrame ventanaConsulta) {
        //Inicializando datos
        this.ventanaConsulta = ventanaConsulta;
        String[] tipoConsulta = {"Consultar Piezas", "Consultar Kits"};
        TipoConsulta = new JComboBox<String>(tipoConsulta);
        TipoConsulta.setBackground(Color.white);
        TipoConsulta.setFont(new Font("Bell MT",Font.BOLD,14));
        String opcion = TipoConsulta.getSelectedItem().toString();

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
        TipoConsulta.addActionListener(this);

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
        this.add(TipoConsulta, gbc);
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
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
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
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        add(btnRegresar, gbc);

        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Consulta de Piezas");
        setBorder(bordejpanel);
        inicializar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Buscar":
                Validaciones validacion = new Validaciones();
                String dato = txtClave.getText();

                if (validacion.validarNumero(dato, Integer.MAX_VALUE, Integer.MIN_VALUE, "código")) {
                    if (validacion.existeClave(Integer.parseInt(dato))) {
                        txtNombre.setText(validacion.getPieza().getNombre());
                        txtPrecio.setText(validacion.getPieza().getPrecio() + "");
                        txtUnidades.setText(validacion.getPieza().getUnidades() + "");
                        txtEscasez.setText(validacion.getPieza().getAlerta() + "");
                    } else {
                        inicializar();
                    }
                }
                break;
            case "Regresar":
                VentanaMenuServicio vtnMenu = new VentanaMenuServicio();
                ventanaConsulta.dispose();
                break;

            case "comboBoxChanged":
                String seleccionCmbox = (String) TipoConsulta.getSelectedItem();
                switch (seleccionCmbox) {
                    case "Consultar Kits":
                        ConsultaVentanaK vtnKits = new ConsultaVentanaK();
                        ventanaConsulta.dispose();
                        break;
                    case "Consultar Piezas":
                        ConsultaVentana vtnConsulta = new ConsultaVentana();
                        ventanaConsulta.dispose();
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

    /*public void buscar(){
        Archivos archivo = new Archivos();
        ArrayList<Pieza> piezas = archivo.leerArchivo();
        for(Pieza validacion: piezas){
            JOptionPane.showMessageDialog(null,"Pieza agregada correctamente:\n" + "Clave: " + validacion.getCodigo() + "\nNombre: " + validacion.getNombre() + "\nPrecio: " + validacion.getPrecio()+ "\nUnidades: " + validacion.getUnidades() + "\nEscasez: " + validacion.getAlerta());
        }
    }*/
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
