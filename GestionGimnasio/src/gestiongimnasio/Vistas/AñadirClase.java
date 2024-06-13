package gestiongimnasio.Vistas;

import gestiongimnasio.DAO.ClaseData;
import gestiongimnasio.DAO.EntrenadorData;
import gestiongimnasio.Entidades.Clase;
import gestiongimnasio.Entidades.Entrenador;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cinti
 */
public class AñadirClase extends javax.swing.JInternalFrame {

    private String nombreClase;
    private String entrenadorSeleccionado;

    public AñadirClase() {
        initComponents();
         cargarEntrenadores();
         cargarHorarios();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("nombre de la clase");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("entrenador asignado");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"09:00 am", "10:00 am", "11:00 am", "12:00 pm", "01:00 pm", "02:00 pm", "03:00 pm", "04:00 pm", "05:00 pm", "06:00 pm", "07:00 pm", "08:00 pm", "09:00 pm", "10:00 pm"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setText("HORARIO");

        jButton1.setText("AGREGAR CLASE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField1)
                        .addComponent(jComboBox2, 0, 155, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void cargarEntrenadores() {
        // Crear una instancia de EntrenadorData
        EntrenadorData entrenadorData = new EntrenadorData();

        // Obtener el modelo de la tabla de entrenadores
        DefaultTableModel modelo = entrenadorData.mostrarEntrenadores();

        // Limpiar el JComboBox antes de llenarlo
        jComboBox2.removeAllItems();

        // Recorrer el modelo y agregar los nombres de los entrenadores al JComboBox
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nombre = modelo.getValueAt(i, 1).toString(); // Columna "Nombre"
            jComboBox2.addItem(nombre);
        }
    }
     private void cargarHorarios() {
        jComboBox1.removeAllItems();
        for (int hour = 9; hour <= 22; hour++) {
            String time = String.format("%02d:00 %s", hour % 12 == 0 ? 12 : hour % 12, hour < 12 ? "AM" : "PM");
            jComboBox1.addItem(time);
        }
    }
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // Capturar el nombre del entrenador seleccionado
        entrenadorSeleccionado = (String) jComboBox2.getSelectedItem();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

        // Capturar el nombre de la clase
        nombreClase = jTextField1.getText();
    }

    private int getEntrenadorIdPorNombre(String nombre) {
         
        if (nombre.equals("Entrenador 1")) {
            return 1;
        }
        if (nombre.equals("Entrenador 2")) {
            return 2;
        }
        if (nombre.equals("Entrenador 3")) {
            return 3;
        }
        if (nombre.equals("Entrenador 4")) {
            return 4;
        }
        return -1; // Devuelve -1 si no se encuentra el entrenador
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       // Obtener la selección del horario del JComboBox
        String horarioSeleccionado = (String) jComboBox1.getSelectedItem();

        // Verificar que se ha seleccionado un horario
        if (horarioSeleccionado != null && !horarioSeleccionado.isEmpty()) {
            // Crear una instancia de ClaseData
            ClaseData claseData = new ClaseData();

            // Buscar las clases con el horario seleccionado
            List<Clase> clases = claseData.buscarClases(null, null, horarioSeleccionado);

            // Verificar si el horario está ocupado
            if (!clases.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El horario seleccionado ya está ocupado por otra clase.", "Horario Ocupado", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "El horario seleccionado está disponible.", "Horario Disponible", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un horario.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Obtener los datos de los campos
    String nombreClase = jTextField1.getText();
    String entrenadorNombre = (String) jComboBox2.getSelectedItem();
    String horario = (String) jComboBox1.getSelectedItem();

    // Verificar que los campos no estén vacíos
    if (nombreClase == null || nombreClase.isEmpty() || entrenadorNombre == null || entrenadorNombre.isEmpty() || horario == null || horario.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    // Verificar disponibilidad del horario
    ClaseData claseData = new ClaseData();
    List<Clase> clasesConMismoHorario = claseData.buscarClases(null, null, horario);
    if (!clasesConMismoHorario.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El horario seleccionado ya está ocupado por otra clase.", "Horario Ocupado", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Obtener el Entrenador usando EntrenadorData
    EntrenadorData entrenadorData = new EntrenadorData();
    Entrenador entrenador = entrenadorData.buscarEntrenadorPorNombre(entrenadorNombre);

    if (entrenador == null) {
        JOptionPane.showMessageDialog(this, "Entrenador no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear objeto Clase
    Clase nuevaClase = new Clase();
    nuevaClase.setNombre(nombreClase);
    nuevaClase.setIdEntrenador(entrenador);
    nuevaClase.setHorario(horario);
    nuevaClase.setCapacidad(20); // Asume una capacidad por defecto, puedes cambiar esto
    nuevaClase.setEstado(true); // Asume que la clase está activa por defecto

    // Guardar la clase en la base de datos
    
    claseData.guardarClase(nuevaClase);

    // Mostrar un mensaje de confirmación
    JOptionPane.showMessageDialog(this, "Clase agregada exitosamente.");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
