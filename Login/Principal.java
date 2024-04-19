/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.awt.Color;

/**
 *
 * @author mari2
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        
        setLocationRelativeTo(null);
        this.setTitle("Principal");
        this.setSize(900,600);
        this.Admin.setBackground(Color.white);
        this.Salir.setBackground(Color.white);
        this.Serv.setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Admin = new javax.swing.JButton();
        Serv = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        UAEM = new javax.swing.JLabel();
        Abejas = new javax.swing.JLabel();
        Laboratorio = new javax.swing.JLabel();
        Facultad = new javax.swing.JLabel();
        BLANCO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 0));
        setLocation(new java.awt.Point(500, 500));
        setResizable(false);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Admin.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        Admin.setText("Administrador");
        Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminActionPerformed(evt);
            }
        });
        getContentPane().add(Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 150, 30));

        Serv.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        Serv.setText("Servicio Social");
        Serv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServActionPerformed(evt);
            }
        });
        getContentPane().add(Serv, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 150, 30));

        Salir.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 150, 30));

        UAEM.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        UAEM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/logo.jpg"))); // NOI18N
        UAEM.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        UAEM.setMaximumSize(new java.awt.Dimension(200, 421));
        UAEM.setMinimumSize(new java.awt.Dimension(200, 421));
        UAEM.setPreferredSize(new java.awt.Dimension(200, 421));
        UAEM.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(UAEM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, 790, 190));

        Abejas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo.png"))); // NOI18N
        getContentPane().add(Abejas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 384, 450));

        Laboratorio.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        Laboratorio.setText("Laboratorio de Robótica");
        getContentPane().add(Laboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 360, 80));
        Laboratorio.getAccessibleContext().setAccessibleName("jLabel3");

        Facultad.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        Facultad.setText("Facultad de Ingeniería");
        getContentPane().add(Facultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 350, 60));

        BLANCO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BLANCO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/blanco.jpg"))); // NOI18N
        getContentPane().add(BLANCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -36, 900, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    private void AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminActionPerformed
        // TODO add your handling code here:
        IniciarSesion i = new IniciarSesion();
        i.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_AdminActionPerformed

    private void ServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServActionPerformed
        IniciarSesion2 in = new IniciarSesion2();
        in.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_ServActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
      
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
                
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Abejas;
    private javax.swing.JButton Admin;
    private javax.swing.JLabel BLANCO;
    private javax.swing.JLabel Facultad;
    private javax.swing.JLabel Laboratorio;
    private javax.swing.JButton Salir;
    private javax.swing.JButton Serv;
    private javax.swing.JLabel UAEM;
    // End of variables declaration//GEN-END:variables
}