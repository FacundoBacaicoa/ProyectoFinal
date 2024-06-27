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
    private String horarioSeleccionado;

    public AñadirClase() {
        initComponents();
       cargarEntrenadores(null);
        cargarHorarios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void cargarEntrenadores(String horario) {
    // Crear una instancia de EntrenadorData y ClaseData
    EntrenadorData entrenadorData = new EntrenadorData();
    ClaseData claseData = new ClaseData();
    
    // Obtener la lista de entrenadores ocupados en el horario seleccionado
    List<Clase> clasesConMismoHorario = claseData.buscarClases(null, null, horario);
    List<Integer> entrenadoresOcupados = new ArrayList<>();
    for (Clase clase : clasesConMismoHorario) {
        entrenadoresOcupados.add(clase.getIdEntrenador().getId_entrenadores());
    }

    // Mensajes de depuración
    System.out.println("Clases encontradas para el horario " + horario + ": " + clasesConMismoHorario.size());
    for (Clase clase : clasesConMismoHorario) {
        System.out.println("Clase ID: " + clase.getId_clase() + ", Entrenador ID: " + clase.getIdEntrenador().getId_entrenadores());
    }
    System.out.println("Entrenadores ocupados en el horario " + horario + ": " + entrenadoresOcupados);

    // Obtener el modelo de la tabla de entrenadores
    DefaultTableModel modelo = entrenadorData.mostrarEntrenadores();

    // Limpiar el JComboBox antes de llenarlo
    jComboBox2.removeAllItems();
    jComboBox2.addItem("Seleccione un entrenador");

    for (int i = 0; i < modelo.getRowCount(); i++) {
        // Asegurarse de que el ID es un Integer
        Integer idEntrenador = (Integer) modelo.getValueAt(i, 0);
        // Mensaje de depuración
        System.out.println("Evaluando entrenador ID: " + idEntrenador);
        if (!entrenadoresOcupados.contains(idEntrenador)) {
            String nombre = modelo.getValueAt(i, 1).toString(); // Columna "Nombre"
            jComboBox2.addItem(nombre);
        } else {
            // Mensaje de depuración
            System.out.println("Entrenador " + idEntrenador + " está ocupado y no se añadirá.");
        }
    }
}

    private void cargarHorarios() {
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Seleccione un horario");
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
       horarioSeleccionado = (String) jComboBox1.getSelectedItem();

       // Verificar que se ha seleccionado un horario
    if (horarioSeleccionado != null && !horarioSeleccionado.isEmpty() && !horarioSeleccionado.equals("Seleccione un horario")) {
        cargarEntrenadores(horarioSeleccionado);
    } 
    

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        String nombreClase = jTextField1.getText();
        String entrenadorNombre = (String) jComboBox2.getSelectedItem();
        String horario = (String) jComboBox1.getSelectedItem();

   
        if (nombreClase == null || nombreClase.isEmpty() || entrenadorNombre == null || entrenadorNombre.isEmpty() || horario == null || horario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

      
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
        nuevaClase.setCapacidad(20); 
        nuevaClase.setEstado(true); 

       
        ClaseData claseData = new ClaseData();

        claseData.guardarClase(nuevaClase);

       
   
      
        limpiarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void limpiarCampos() {
        jTextField1.setText("");
        jComboBox2.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
