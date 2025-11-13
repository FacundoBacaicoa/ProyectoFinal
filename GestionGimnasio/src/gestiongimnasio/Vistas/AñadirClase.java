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
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de la Clase");

        jTextField1.setBackground(new java.awt.Color(102, 102, 102));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"09:00 AM", "10:00 AM", "11:00 AM", "12:00 pm", "01:00 pm", "02:00 pm", "03:00 pm", "04:00 pm", "05:00 pm", "06:00 pm", "07:00 pm", "08:00 pm", "09:00 pm", "10:00 pm"}));
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

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Añadir Clase");
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

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AÑADIR CLASE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void cargarEntrenadores(String horario) {
    System.out.println("=== CARGANDO ENTRENADORES ===");
    System.out.println("Horario filtro: " + horario);
    
    EntrenadorData entrenadorData = new EntrenadorData();
    ClaseData claseData = new ClaseData();
    
    // Obtener la lista de entrenadores ocupados en el horario seleccionado
    List<Clase> clasesConMismoHorario = new ArrayList<>();
    List<Integer> entrenadoresOcupados = new ArrayList<>();
    
    if (horario != null && !horario.equals("-Seleccionar Horario-")) {
        // Convertir horario a formato 24h para la búsqueda
        try {
            String horarioParaBusqueda = horario.replaceAll("[^\\x20-\\x7E]", "").trim().toUpperCase();
            java.text.SimpleDateFormat formatoEntrada = new java.text.SimpleDateFormat("hh:mm a", java.util.Locale.ENGLISH);
            java.text.SimpleDateFormat formatoSQL = new java.text.SimpleDateFormat("HH:mm:ss");
            formatoEntrada.setLenient(false);
            
            java.util.Date horaAMPM = formatoEntrada.parse(horarioParaBusqueda);
            String hora24 = formatoSQL.format(horaAMPM);
            
            System.out.println("Buscando clases con horario: " + hora24);
            clasesConMismoHorario = claseData.buscarClases(null, null, hora24);
            
            for (Clase clase : clasesConMismoHorario) {
                entrenadoresOcupados.add(clase.getIdEntrenador().getId_entrenadores());
            }
        } catch (Exception e) {
            System.err.println("Error convirtiendo horario para filtro: " + e.getMessage());
        }
    }

    System.out.println("Entrenadores ocupados: " + entrenadoresOcupados);

    // Obtener todos los entrenadores
    DefaultTableModel modelo = entrenadorData.mostrarEntrenadores();
    System.out.println("Total entrenadores en BD: " + modelo.getRowCount());

    // Limpiar el JComboBox antes de llenarlo
    jComboBox2.removeAllItems();
    jComboBox2.addItem("-Seleccionar Entrenador-");

    for (int i = 0; i < modelo.getRowCount(); i++) {
        Integer idEntrenador = (Integer) modelo.getValueAt(i, 0);
        String nombre = modelo.getValueAt(i, 1).toString();
        
        System.out.println("Evaluando entrenador: ID=" + idEntrenador + " Nombre=" + nombre);
        
        if (!entrenadoresOcupados.contains(idEntrenador)) {
            jComboBox2.addItem(nombre);
            System.out.println("Entrenador añadido: " + nombre);
        } else {
            System.out.println("Entrenador ocupado, no añadido: " + nombre);
        }
    }
    
    System.out.println("Total items en combo: " + jComboBox2.getItemCount());
}

private void cargarHorarios() {
    jComboBox1.removeAllItems();
    jComboBox1.addItem("-Seleccionar Horario-");
    
    // Generar horarios con formato consistente
    for (int hour = 9; hour <= 22; hour++) {
        String ampm = hour < 12 ? "AM" : "PM";
        int displayHour = hour;
        if (hour > 12) {
            displayHour = hour - 12;
        } else if (hour == 0) {
            displayHour = 12;
        }
        
        String time = String.format("%02d:00 %s", displayHour, ampm);
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

    // DEBUG: Imprimir valores capturados
    System.out.println("=== DEBUG GUARDADO ===");
    System.out.println("Nombre clase: '" + nombreClase + "'");
    System.out.println("Entrenador seleccionado: '" + entrenadorNombre + "'");
    System.out.println("Horario seleccionado: '" + horario + "'");

    if (nombreClase == null || nombreClase.isEmpty() ||
        entrenadorNombre == null || entrenadorNombre.isEmpty() ||
        horario == null || horario.isEmpty() ||
        entrenadorNombre.equals("-Seleccionar Entrenador-") ||
        horario.equals("-Seleccionar Horario-")) {
        
        System.out.println("ERROR: Campos incompletos");
        System.out.println("nombreClase vacío: " + (nombreClase == null || nombreClase.isEmpty()));
        System.out.println("entrenadorNombre vacío: " + (entrenadorNombre == null || entrenadorNombre.isEmpty()));
        System.out.println("horario vacío: " + (horario == null || horario.isEmpty()));
        
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Convertir el horario al formato "HH:mm:ss" compatible con la base de datos
    String hora24;
    try {
        horario = horario.replaceAll("[^\\x20-\\x7E]", "").trim().toUpperCase();
        System.out.println("Horario normalizado: '" + horario + "'");

        java.text.SimpleDateFormat formatoEntrada = new java.text.SimpleDateFormat("hh:mm a", java.util.Locale.ENGLISH);
        java.text.SimpleDateFormat formatoSQL = new java.text.SimpleDateFormat("HH:mm:ss");
        formatoEntrada.setLenient(false);

        java.util.Date horaAMPM = formatoEntrada.parse(horario);
        hora24 = formatoSQL.format(horaAMPM);
        System.out.println("Hora convertida a 24h: '" + hora24 + "'");
    } catch (Exception e) {
        System.err.println("Error parseando hora: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Formato de hora inválido: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Buscar al entrenador
    EntrenadorData entrenadorData = new EntrenadorData();
    System.out.println("Buscando entrenador: '" + entrenadorNombre + "'");
    
    Entrenador entrenador = entrenadorData.buscarEntrenadorPorNombre(entrenadorNombre);
    System.out.println("Entrenador encontrado: " + (entrenador != null ? entrenador.getId_entrenadores() : "NULL"));

    if (entrenador == null) {
        System.out.println("ERROR: Entrenador no encontrado");
        JOptionPane.showMessageDialog(this, "Entrenador no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear objeto Clase
    Clase nuevaClase = new Clase();
    nuevaClase.setNombre(nombreClase);
    nuevaClase.setIdEntrenador(entrenador);
    nuevaClase.setHorario(hora24);
    nuevaClase.setCapacidad(20);
    nuevaClase.setEstado(true);

    System.out.println("Clase a guardar:");
    System.out.println("- Nombre: " + nuevaClase.getNombre());
    System.out.println("- Entrenador ID: " + nuevaClase.getIdEntrenador().getId_entrenadores());
    System.out.println("- Horario: " + nuevaClase.getHorario());
    System.out.println("- Capacidad: " + nuevaClase.getCapacidad());
    System.out.println("- Estado: " + nuevaClase.isEstado());

    // Guardar la clase
    ClaseData claseData = new ClaseData();
    claseData.guardarClase(nuevaClase);

    limpiarCampos();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void limpiarCampos() {
        jTextField1.setText("");
        jComboBox2.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
