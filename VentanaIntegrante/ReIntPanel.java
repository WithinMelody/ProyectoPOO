/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaIntegrante;

import MenuUsuarios.VentanaMenuAdm;
import Objetos.Integrante;
import Validaciones.VIntegrante;
import VentanaEquipo.RVentana;
import VentanaServicio.ReSVentana;
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
public class ReIntPanel extends JPanel implements ActionListener {

    JFrame ventanaReporte;
    JTable tblPiezas;
    DefaultTableModel tabla;
    JButton btnRegresar;
    JLabel lblCantidadPiezas = new JLabel("");
    GridBagConstraints gbc = new GridBagConstraints();
    private JComboBox<String> TipoR;

    public ReIntPanel(JFrame ventanaReporte) {
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
        btnRegresar.setBackground(Color.WHITE);

        TipoR.addActionListener(this);

        //Creando tabla para mostrar piezas
        tblPiezas = new JTable();
        tblPiezas.setBackground(Color.WHITE);
        tblPiezas.setFont(new Font("Bell MT",Font.BOLD,16));
        tblPiezas.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Equipo", "Alumno", "No. de cuenta", "Correo", "Materia", "Profesor"
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
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Reporte de Alumnos");
        setBorder(bordejpanel);

        //Agregando datos a la tabla
        VIntegrante validacion = new VIntegrante();
        long contador = 0;
        if (validacion.hayIntegrantes()) {
            for (Integrante eq : validacion.getIntegrantes()) {
                tabla = (DefaultTableModel) tblPiezas.getModel();
                Object[] fila = new Object[tabla.getColumnCount()];
                fila[0] = eq.getEquipo();
                fila[1] = eq.getNombre();
                fila[2] = eq.getCuenta();
                fila[3] = eq.getCorreo();
                fila[4] = eq.getMateria();
                fila[5] = eq.getProfesor();
                tabla.addRow(fila);
                contador++;
            }
            lblCantidadPiezas.setText(" Numero de alumnos: " + contador);
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
                        ReSVentana vtnSer = new ReSVentana();
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
