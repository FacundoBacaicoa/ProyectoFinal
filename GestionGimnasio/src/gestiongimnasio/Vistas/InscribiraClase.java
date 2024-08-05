package gestiongimnasio.Vistas;

import gestiongimnasio.DAO.ClaseData;
import gestiongimnasio.DAO.MembresiaData;
import gestiongimnasio.DAO.SocioDAO;
import gestiongimnasio.Entidades.Clase;
import gestiongimnasio.Entidades.Membresia;
import gestiongimnasio.Entidades.Socio;

import javax.swing.*;
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
        jLabel1 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar Clase-"}));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar Socio-"}));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Inscribir a Clase");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INSCRIBIR A CLASE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(23, 23, 23))
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
      if ((s.getNombre() + " " + s.getApellido()).equals(socioSeleccionado)) {
                socio = s;
                break;
            
        }
    }

    if (clase == null || socio == null) {
        JOptionPane.showMessageDialog(this, "Clase o socio no encontrados.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
     // Verificar si el socio tiene una membresía activa
    MembresiaData membresiaData = new MembresiaData();
    boolean tieneActiva = membresiaData.tieneMembresiaActiva(socio.getId_Socio());

    if (!tieneActiva) {
        JOptionPane.showMessageDialog(this, "La membresía del socio está cancelada o no existe. No se puede inscribir en la clase.", "Error", JOptionPane.ERROR_MESSAGE);
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
    jComboBox1.addItem("-Seleccionar Clase-");
    for (Clase clase : clases) {
        jComboBox1.addItem(clase.getNombre());
    }

    // Llenar JComboBox de socios
    jComboBox2.removeAllItems();
    jComboBox2.addItem("-Seleccionar Socio-");
for (Socio socio : socios) {
    jComboBox2.addItem(socio.getNombre() + " " + socio.getApellido());
}
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
