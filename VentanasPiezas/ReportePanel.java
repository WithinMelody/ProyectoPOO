/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanasPiezas;

import MenuUsuarios.VentanaMenuServicio;
import Objetos.Pieza;
import Validaciones.Validaciones;
import VentanasKits.ReporteVentanaK;
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
 * @author Mariana
 */
public class ReportePanel extends JPanel implements ActionListener {
    //Variables globales de trabajo
    JFrame ventanaReporte;
    JTable tblPiezas;
    DefaultTableModel tabla;
    JButton btnRegresar;
    JLabel lblCantidadPiezas = new JLabel("");
    GridBagConstraints gbc = new GridBagConstraints();
    private JComboBox<String> TipoR;
    
    public ReportePanel(JFrame ventanaReporte) {
        this.ventanaReporte = ventanaReporte;
        String[] tipoR = {"Reporte de Piezas", "Reporte de Kits"};
        TipoR = new JComboBox<String>(tipoR);
        TipoR.setBackground(Color.white);
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
        tblPiezas.setFont(new Font("Bell MT",Font.BOLD,16));
        tblPiezas.setBackground(Color.white);
        tblPiezas.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo", "Nombre", "Precio", "Piezas disponibles", "Minimo de piezas"
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
        add(scrollPane,gbc);
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
        add(btnRegresar,gbc);
        gbc.weighty = 0.0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        add(lblCantidadPiezas,gbc);
        gbc.weighty = 0.0;
        //Al panel se le agrega un titulo y un borde
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Reporte de Piezas");
        setBorder(bordejpanel);
     
        //Agregando datos a la tabla
        Validaciones validacion = new Validaciones();
        long contador = 0;
        if (validacion.hayPiezas()) {
            for (Pieza pieza : validacion.getPiezas()) {
                tabla = (DefaultTableModel) tblPiezas.getModel();
                Object[] fila = new Object[tabla.getColumnCount()];
                fila[0] = pieza.getCodigo();
                fila[1] = pieza.getNombre();
                fila[2] = pieza.getPrecio();
                fila[3] = pieza.getUnidades();
                fila[4] = pieza.getAlerta();
                tabla.addRow(fila);
                contador++;
            }
            lblCantidadPiezas.setText(" Numero de piezas: " + contador);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //VentanaMenuServicio vtnMenu = new VentanaMenuServicio();
        //ventanaReporte.dispose();
        String accion = e.getActionCommand();
        switch(accion){
            case "Regresar":
                    VentanaMenuServicio vtnMenu = new VentanaMenuServicio();
                    ventanaReporte.dispose();
                break;
            case "comboBoxChanged":
                String seleccionCmbox = (String)TipoR.getSelectedItem();
                switch(seleccionCmbox){
                    case "Reporte de Kits":
                        ReporteVentanaK vtnKits = new ReporteVentanaK();
                        ventanaReporte.dispose();
                        break;
                    case "Reporte de Piezas":
                        ReporteVentana vtnPiezas = new ReporteVentana();
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
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Fondos/v10.jpg"));
        g.drawImage(fondo.getImage(), 0, 0, width, height, null);
        setOpaque(false);
        super.paint(g);

    }

}
