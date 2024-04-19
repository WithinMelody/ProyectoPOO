/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaServicio;

import MenuUsuarios.VentanaMenuAdm;
import Objetos.Servicio;
import Validaciones.VServ;
import VentanaEquipo.RVentana;
import VentanaIntegrante.ReIntVentana;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mari2
 */
public class ReSPanel extends JPanel implements ActionListener {

    JFrame ventanaReporte;
    JTable tblPiezas;
    DefaultTableModel tabla;
    JButton btnRegresar;
    JLabel lblCantidadPiezas = new JLabel("");
    GridBagConstraints gbc = new GridBagConstraints();
    private JComboBox<String> TipoR;

    public ReSPanel(JFrame ventanaReporte) {
        this.ventanaReporte = ventanaReporte;
        String[] tipoR = {"Reporte de Equipos", "Reporte de Alumnos", "Reporte de Servicios"};
        TipoR = new JComboBox<String>(tipoR);
        TipoR.setBackground(Color.WHITE);
        TipoR.setFont(new Font("Bell MT",Font.BOLD,14));
        String opcion = TipoR.getSelectedItem().toString();

        //Aplicando un formato de LayOut
        setLayout(new GridBagLayout());

        //Creando botones para que escuchen y actuen
        btnRegresar = new JButton("Regresar");
        btnRegresar.setActionCommand("Regresar");
        btnRegresar.addActionListener(this);
        btnRegresar.setFont(new Font("Bell MT",Font.BOLD,16));
        btnRegresar.setBackground(Color.white);

        TipoR.addActionListener(this);

        //Creando tabla para mostrar piezas
        tblPiezas = new JTable();
        tblPiezas.setBackground(Color.white);
        tblPiezas.setFont(new Font("Bell MT",Font.BOLD,16));
        tblPiezas.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "No. de cuenta", "Nombre", "Correo", "Telefono", "Carrera", "F. Inicio", "F. Fin"
                }
        ));
        tblPiezas.setPreferredScrollableViewportSize(new Dimension(650, 150));
        JScrollPane scrollPane = new JScrollPane(tblPiezas);

        //Configurando el LayOut a ocupar en el programa y Agregando elementos al panel
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 15, 15, 1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.CENTER;
        this.add(TipoR, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(btnRegresar, gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblCantidadPiezas, gbc);
        gbc.weighty = 0.0;
        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Reporte de Servicios");
        setBorder(bordejpanel);

        //Agregando datos a la tabla
        VServ validacion = new VServ();
        long contador = 0;
        if (validacion.hayServicios()) {
            for (Servicio eq : validacion.getServicios()) {
                tabla = (DefaultTableModel) tblPiezas.getModel();
                Object[] fila = new Object[tabla.getColumnCount()];
                fila[0] = eq.getCuenta();
                fila[1] = eq.getNombre();
                fila[2] = eq.getCorreo();
                fila[3] = eq.getTelefono();
                fila[4] = eq.getCarrera();
                fila[5] = eq.getInicio();
                fila[6] = eq.getFin();
                tabla.addRow(fila);
                contador++;
            }
            lblCantidadPiezas.setText(" Numero de servicios: " + contador);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //VentanaMenuServicio vtnMenu = new VentanaMenuServicio();
        //ventanaReporte.dispose();
        String accion = e.getActionCommand();
        switch (accion) {
            case "Regresar":
                VentanaMenuAdm vtnMenu = new VentanaMenuAdm();
                ventanaReporte.dispose();
                break;
            case "comboBoxChanged":
                String seleccionCmbox = (String) TipoR.getSelectedItem();
                switch (seleccionCmbox) {
                    case "Reporte de Equipos":
                        RVentana vtnKits = new RVentana();
                        ventanaReporte.dispose();
                        break;
                    case "Reporte de Alumnos":
                        ReIntVentana n = new ReIntVentana();
                        ventanaReporte.dispose();
                        break;
                    case "Reporte de Servicios":
                        ReSVentana vSer = new ReSVentana();
                        ventanaReporte.dispose();
                        break;
                }
                break;
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
