package gestiongimnasio.Vistas;

import gestiongimnasio.DAO.AsistenciaData;
import gestiongimnasio.DAO.MembresiaData;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class HistorialAsistencias extends javax.swing.JInternalFrame {

    private int selectedRow = -1;
    private Map<Integer, String> cambiosAsistencia = new HashMap<>();

 
    public HistorialAsistencias() {
        initComponents();
        configurarFiltradoAutomatico();

        buscarAsistencias("");
    }

    private void configurarFiltradoAutomatico() {
        jTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarEnTiempoReal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarEnTiempoReal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarEnTiempoReal();
            }
        });
    }

    private void filtrarEnTiempoReal() {
        String textoBusqueda = jTxt.getText().trim();
        buscarAsistencias(textoBusqueda);
        selectedRow = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnpresente = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asistencias");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese el Dni del Socio:");

        jTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnpresente.setBackground(new java.awt.Color(51, 51, 51));
        btnpresente.setForeground(new java.awt.Color(255, 255, 255));
        btnpresente.setText("Presente");
        btnpresente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpresenteActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(51, 51, 51));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(51, 51, 51));
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btnpresente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnpresente)
                    .addComponent(btnguardar)
                    .addComponent(jbSalir))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtActionPerformed
       buscarAsistencias(jTxt.getText());
    }//GEN-LAST:event_jTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarAsistencias(jTxt.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
JTable table = (JTable) evt.getSource();
    selectedRow = table.getSelectedRow();
    
    if (selectedRow != -1) {
        System.out.println("Fila seleccionada: " + selectedRow);
        
        try {
            int dniSocio = Integer.parseInt((String) table.getValueAt(selectedRow, 1));
            mostrarInformacionPases(dniSocio);
        } catch (Exception e) {
            System.out.println("Error al obtener información de pases: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_TablaMouseClicked

    private void btnpresenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpresenteActionPerformed
    if (selectedRow != -1) {
        int idAsistencia = (int) Tabla.getValueAt(selectedRow, 0);
        int dniSocio = Integer.parseInt((String) Tabla.getValueAt(selectedRow, 1));

        guardarCambioYActualizarPases(idAsistencia, dniSocio, "Presente");
    }
    }//GEN-LAST:event_btnpresenteActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (cambiosAsistencia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay cambios para guardar.");
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea guardar los cambios?",
                "Confirmar Guardar",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            guardarCambios();
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    public void listarAsistencias() {
        AsistenciaData asistenciaData = new AsistenciaData();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"ID Asistencia", "Fecha", "Clase", "Horario"});
        Tabla.setModel(modelo);
    }

    public void buscarAsistencias(String buscar) {
        AsistenciaData asistenciaData = new AsistenciaData();
        DefaultTableModel modelo = asistenciaData.buscarAsistencia(buscar);
        Tabla.setModel(modelo);
        cambiosAsistencia.clear();

    }

    private void guardarCambios() {
        AsistenciaData asistenciaData = new AsistenciaData();
        int cambiosGuardados = 0;

        for (Map.Entry<Integer, String> entry : cambiosAsistencia.entrySet()) {
            int row = entry.getKey();
            String estado = entry.getValue();

            if (row < Tabla.getRowCount()) {
                int idAsistencia = (int) Tabla.getValueAt(row, 0);
                asistenciaData.actualizarEstadoAsistencia(idAsistencia, estado);
                cambiosGuardados++;
            }
        }

        if (cambiosGuardados > 0) {
            JOptionPane.showMessageDialog(this,
                    "Se guardaron " + cambiosGuardados + " cambios exitosamente.");
            cambiosAsistencia.clear();
            buscarAsistencias(jTxt.getText());
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo guardar ningún cambio.");
        }
    }

    private void guardarCambioYActualizarPases(int idAsistencia, int dniSocio, String nuevoEstado) {
   AsistenciaData asistenciaData = new AsistenciaData();
    MembresiaData membresiaData = new MembresiaData(); 
    String estadoAnterior = obtenerEstadoAnterior(idAsistencia);

    if (estadoAnterior.equals(nuevoEstado)) {
        JOptionPane.showMessageDialog(this, "El estado ya es " + nuevoEstado);
        return;
    }
    
    if (!membresiaData.tieneMembresiaActiva(membresiaData.obtenerIdSocioPorDni(dniSocio))) {
        JOptionPane.showMessageDialog(this, 
            "El socio no tiene una membresía activa. No se puede procesar la asistencia.");
        return;
    }
   
    boolean procesoExitoso = false;
    
    if (estadoAnterior.equals("Ausente") && nuevoEstado.equals("Presente")) {
        int pasesDisponibles = membresiaData.obtenerPasesDisponibles(dniSocio);
        if (pasesDisponibles <= 0) {
            JOptionPane.showMessageDialog(this, 
                "El socio no tiene pases disponibles. No se puede marcar como presente.");
            return;
        }

        procesoExitoso = membresiaData.descontarPase(dniSocio);
        if (procesoExitoso) {
            asistenciaData.actualizarEstadoAsistencia(idAsistencia, "");
            JOptionPane.showMessageDialog(this, 
                "Asistencia marcada como presente. Pase descontado. Pases restantes: " + (pasesDisponibles - 1));
        } else {
            JOptionPane.showMessageDialog(this, "Error al descontar el pase.");
            return;
        }
        
    } else if (estadoAnterior.equals("Presente") && nuevoEstado.equals("Ausente")) {
        // Devolver un pase
        procesoExitoso = membresiaData.devolverPase(dniSocio);
        if (procesoExitoso) {
            asistenciaData.actualizarEstadoAsistencia(idAsistencia, "");
            int pasesActuales = membresiaData.obtenerPasesDisponibles(dniSocio);
            JOptionPane.showMessageDialog(this, 
                "Asistencia marcada como ausente. Pase devuelto. Pases actuales: " + pasesActuales);
        } else {
            JOptionPane.showMessageDialog(this, "Error al devolver el pase.");
            return;
        }
    } else {
        if (nuevoEstado.equals("Presente")) {
            int pasesDisponibles = membresiaData.obtenerPasesDisponibles(dniSocio);
            if (pasesDisponibles <= 0) {
                JOptionPane.showMessageDialog(this, 
                    "El socio no tiene pases disponibles. No se puede marcar como presente.");
                return;
            }
            procesoExitoso = membresiaData.descontarPase(dniSocio);
            if (procesoExitoso) {
                asistenciaData.actualizarEstadoAsistencia(idAsistencia, "");
                JOptionPane.showMessageDialog(this, 
                    "Asistencia marcada como presente. Pase descontado. Pases restantes: " + (pasesDisponibles - 1));
            }
        } else {
            asistenciaData.actualizarEstadoAsistencia(idAsistencia, "");
            JOptionPane.showMessageDialog(this, "Estado actualizado");
            procesoExitoso = true;
        }
    }
    if (procesoExitoso) {
        buscarAsistencias(jTxt.getText());
    }
}
    
    private String obtenerEstadoAnterior(int idAsistencia) {
    AsistenciaData asistenciaData = new AsistenciaData();
    return asistenciaData.obtenerEstadoAsistencia(idAsistencia);
}
    
    private void mostrarInformacionPases(int dniSocio) {
    MembresiaData membresiaData = new MembresiaData();
    int pasesDisponibles = membresiaData.obtenerPasesDisponibles(dniSocio);
    
    if (pasesDisponibles >= 0) {
        System.out.println("Socio DNI " + dniSocio + " tiene " + pasesDisponibles + " pases disponibles");
    } else {
        System.out.println("Socio DNI " + dniSocio + " no tiene membresía activa");
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnpresente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxt;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables
}
