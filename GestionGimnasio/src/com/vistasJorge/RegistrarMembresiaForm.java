package com.vistasJorge;

import gestiongimnasio.DAO.MembresiaData;
import gestiongimnasio.Entidades.Membresia;
import gestiongimnasio.Entidades.Socio;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Jorge
 */
public class RegistrarMembresiaForm extends JInternalFrame {

    private MembresiaData membresiaData;

    /**
     * Creates new form NewJInternalFrame
     */
    public RegistrarMembresiaForm() {
        membresiaData = new MembresiaData();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonOK = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        contentPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cantidad De Pases");
        contentPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 40));
        contentPane.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 47, 40));

        jLabel2.setText("Duracion del mes");
        contentPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 40));
        contentPane.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 47, 40));

        jLabel3.setText("Fecha fin");
        contentPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 84, 40));

        buttonOK.setText("Registrar membresia");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });
        contentPane.add(buttonOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        jLabel4.setText("SocioId");
        contentPane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 60, 40));
        contentPane.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 47, 40));

        jLabel5.setText("Costo");
        contentPane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 84, 40));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        contentPane.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 80, 40));

        jLabel6.setText("Fecha de inicio");
        contentPane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 84, 40));

        jLabel7.setText("MembresiaId");
        contentPane.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 84, 40));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        contentPane.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 80, 40));

        jCheckBox1.setText("Estado");
        contentPane.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));
        contentPane.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));
        contentPane.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        jButton1.setText("salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        contentPane.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        try {
            int socioId = Integer.parseInt(jTextField4.getText());
            // Verificar si el socioId existe en la base de datos
        if (!membresiaData.socioExists(socioId)) {
            JOptionPane.showMessageDialog(this, "El SocioId no existe. Por favor, ingrese un SocioId válido.");
            return;
        }
            int cantidadDePases = Integer.parseInt(jTextField1.getText());
            int duracionDelMes = Integer.parseInt(jTextField2.getText());
            Date selectedDateInicio = jDateChooser1.getDate();

            if (selectedDateInicio == null) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione la fecha de inicio");
                return;
            }

            // Calcula la fecha de fin basándose en la duración en meses
            LocalDate localFechaInicio = selectedDateInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localFechaFin = localFechaInicio.plusMonths(duracionDelMes);
            Date fechaFin = java.sql.Date.valueOf(localFechaFin);

            // Conversión de java.util.Date a java.sql.Date
            java.sql.Date fechaInicio = new java.sql.Date(selectedDateInicio.getTime());
            BigDecimal costo = new BigDecimal(jTextField5.getText());
            boolean estado = jCheckBox1.isSelected();

            Socio socio = new Socio();
            socio.setId_Socio(socioId);

            Membresia membresia = new Membresia();
            membresia.setSocio(socio);
            membresia.setCantidadPases(cantidadDePases);
            membresia.setFechaInicio(fechaInicio);
            membresia.setFechaFin(fechaFin);
            membresia.setCosto(costo);
            membresia.setEstado(estado);

            membresiaData.registrarMembresia(membresia);

            JOptionPane.showMessageDialog(this, "Membresía registrada exitosamente");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los campos correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar la membresía: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarMembresiaForm().setVisible(true);
            }
        });
    
    }//GEN-LAST:event_buttonOKActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Cerrar el formulario
    dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
 
        
 

    

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonOK;
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
