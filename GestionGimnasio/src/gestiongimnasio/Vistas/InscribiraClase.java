package gestiongimnasio.Vistas;

import gestiongimnasio.DAO.ClaseData;
import gestiongimnasio.DAO.SocioDAO;
import gestiongimnasio.Entidades.Clase;
import gestiongimnasio.Entidades.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author cinti
 */
public class InscribiraClase extends javax.swing.JInternalFrame {
    private List<Socio> socios;
    private List<Clase> clases;

    public InscribiraClase() {
        
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione clase"}));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione socio"}));

        jButton1.setText("inscribir a clase");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(105, 105, 105)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(108, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(113, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // Obtener los datos seleccionados del JComboBox
    String claseSeleccionada = (String) jComboBox1.getSelectedItem();
    String socioSeleccionado = (String) jComboBox2.getSelectedItem();

    if (claseSeleccionada == null || claseSeleccionada.isEmpty() || socioSeleccionado == null || socioSeleccionado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una clase y un socio.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener el objeto Clase y Socio
    Clase clase = null;
    Socio socio = null;

    for (Clase c : clases) {
        if (c.getNombre().equals(claseSeleccionada)) {
            clase = c;
            break;
        }
    }

    for (Socio s : socios) {
        if (s.getNombre().equals(socioSeleccionado)) {
            socio = s;
            break;
        }
    }

    if (clase == null || socio == null) {
        JOptionPane.showMessageDialog(this, "Clase o socio no encontrados.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Inscribir al socio en la clase
    ClaseData claseData = new ClaseData();
    claseData.inscribirSocioEnClase(socio, clase);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Cerrar el formulario actual
    dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
 private void cargarDatos() {
    ClaseData claseData = new ClaseData();
    SocioDAO socioDAO = new SocioDAO();

    // Obtener listas de clases y socios
    clases = claseData.listarTodasLasClases();
    socios = socioDAO.obtenerTodosLosSocios();

    // Llenar JComboBox de clases
    jComboBox1.removeAllItems();
    jComboBox1.addItem("seleccione clase");
    for (Clase clase : clases) {
        jComboBox1.addItem(clase.getNombre());
    }

    // Llenar JComboBox de socios
    jComboBox2.removeAllItems();
    jComboBox2.addItem("seleccione socio");
    for (Socio socio : socios) {
        jComboBox2.addItem(socio.getNombre());
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    // End of variables declaration//GEN-END:variables
}
