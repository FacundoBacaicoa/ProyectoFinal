package gestiongimnasio.Vistas;

import gestiongimnasio.DAO.MembresiaData;
import gestiongimnasio.Entidades.Membresia;
import gestiongimnasio.DAO.SocioDAO;
import gestiongimnasio.Entidades.Socio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import javax.swing.event.TableModelEvent;

/**
 *
 * @author Jorge
 */
public class GestionarMembresiaForm extends javax.swing.JInternalFrame {

    private MembresiaData membresiaData;
    private SocioDAO socioData;

    /**
     * Creates new form GestionarMembresiaForm
     */
    public GestionarMembresiaForm() {
        membresiaData = new MembresiaData();
        socioData = new SocioDAO();
        initComponents();
        cargarDatos();
        // Agregar listener para cambios en la tabla
        jTable1.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                if (column == 6) { // La columna de estado es la séptima (índice 6)
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    boolean nuevoEstado = (boolean) model.getValueAt(row, column);
                    int idMembresia = (int) model.getValueAt(row, 0);

                    // Actualizar el estado en la base de datos
                    actualizarEstadoMembresia(idMembresia, nuevoEstado);
                }
            }
        });

    }

    private void actualizarEstadoMembresia(int idMembresia, boolean nuevoEstado) {
        try {
            Membresia membresia = membresiaData.obtenerMembresiaPorId(idMembresia);
            if (membresia != null) {
                membresia.setEstado(nuevoEstado);
                membresiaData.actualizarMembresia(membresia);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el estado de la membresía: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 340));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setForeground(new java.awt.Color(153, 153, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Membresía", "Nombre", "Cant. de Pases", "Fecha de Inicio", "Fecha de Fin", "Costo"
            }
        ){
            Class[] types = new Class [] {
                Integer.class, Integer.class, Integer.class, java.sql.Date.class, java.sql.Date.class, BigDecimal.class, Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        }
    );
    jTable1.setGridColor(new java.awt.Color(153, 153, 153));
    jScrollPane1.setViewportView(jTable1);

    jButton2.setBackground(new java.awt.Color(51, 51, 51));
    jButton2.setForeground(new java.awt.Color(255, 255, 255));
    jButton2.setText("Cancelar Membresía");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Nueva Fecha de Finalizacion:");

    jButton3.setBackground(new java.awt.Color(51, 51, 51));
    jButton3.setForeground(new java.awt.Color(255, 255, 255));
    jButton3.setText("Salir");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("GESTIONAR MEMBRESIAS");

    jButton4.setBackground(new java.awt.Color(51, 51, 51));
    jButton4.setForeground(new java.awt.Color(255, 255, 255));
    jButton4.setText("Reactivar Membresìa");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(47, 47, 47)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(229, 229, 229))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(109, 109, 109)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(20, 20, 20)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel3)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(26, 26, 26)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3))
            .addGap(17, 17, 17))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarMembresia(int idMembresia) {
        try {
            Membresia membresia = membresiaData.obtenerMembresiaPorId(idMembresia);
            if (membresia != null) {
                membresia.setEstado(false);
                membresia.setFechaInicio(null);
                membresia.setFechaFin(null);
                membresiaData.actualizarMembresia(membresia);

                int selectedRow = jTable1.getSelectedRow();
                jTable1.setValueAt(null, selectedRow, 3);
                jTable1.setValueAt(false, selectedRow, 6);

                JOptionPane.showMessageDialog(this, "Membresía cancelada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la membresía.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cancelar la membresía: " + e.getMessage());
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow != -1) {
                int idMembresia = (int) jTable1.getValueAt(selectedRow, 0);
                Membresia membresia = membresiaData.obtenerMembresiaPorId(idMembresia);

                if (membresia != null) {
                    int confirm = JOptionPane.showConfirmDialog(this,
                            "¿Está seguro de que desea cancelar esta membresía?",
                            "Confirmar cancelación",
                            JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        membresiaData.cancelarMembresia(membresia);
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setValueAt(false, selectedRow, 6);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró la membresía.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una membresía de la tabla.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Membresía cancelada exitosamente.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void reactivarMembresia(int idMembresia, Date nuevaFechaFin) {
        try {
            Membresia membresia = membresiaData.obtenerMembresiaPorId(idMembresia);
            if (membresia != null) {
                // Verificar si el socio ya tiene una membresía activa
                List<Membresia> membresias = membresiaData.obtenerMembresiasPorSocio(membresia.getSocio().getId_Socio());
                for (Membresia m : membresias) {
                    if (m.isEstado() && m.getId_membresia() != idMembresia) {
                        JOptionPane.showMessageDialog(this, "El socio ya tiene una membresía activa. No se puede activar otra membresía.");
                        return;
                    }
                }
                if (!membresia.isEstado()) {
                    // Verificar que la nueva fecha de fin sea posterior a la fecha actual
                    Date fechaActual = new Date();
                    if (nuevaFechaFin.before(fechaActual)) {
                        JOptionPane.showMessageDialog(this, "La nueva fecha de finalización debe ser posterior a la fecha actual.");
                        return;
                    }
                    // Establecer nueva fecha de inicio y fin
                    membresia.setFechaInicio(new java.sql.Date(System.currentTimeMillis()));
                    membresia.setFechaFin(new java.sql.Date(nuevaFechaFin.getTime()));
                    membresia.setEstado(true);
                    membresiaData.actualizarMembresia(membresia);

                    // Actualizar la tabla
                    int selectedRow = jTable1.getSelectedRow();
                    jTable1.setValueAt(membresia.getFechaInicio(), selectedRow, 3); // Columna de fecha de inicio
                    jTable1.setValueAt(membresia.getFechaFin(), selectedRow, 4); // Columna de fecha de fin
                    jTable1.setValueAt(true, selectedRow, 6); // Columna de estado

                    JOptionPane.showMessageDialog(this, "Membresía reactivada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Esta membresía aún está activa.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la membresía.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Membresia reactivada exitosamente");
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow != -1) {
                int idMembresia = (int) jTable1.getValueAt(selectedRow, 0);
                Date nuevaFechaFin = jDateChooser1.getDate();
                if (nuevaFechaFin != null) {
                    reactivarMembresia(idMembresia, nuevaFechaFin);
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, seleccione una nueva fecha de finalización.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una membresía de la tabla.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al reactivar la membresía: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cargarDatos() {
        try {
            List<Membresia> membresias = membresiaData.obtenerMembresias();
            Map<Integer, Membresia> miembrosUnicos = new HashMap<>();

            for (Membresia membresia : membresias) {
                int idSocio = membresia.getSocio().getId_Socio();
                Membresia membresiaExistente = miembrosUnicos.get(idSocio);
                if (membresiaExistente == null || membresia.getFechaFin().after(membresiaExistente.getFechaFin())) {
                    // Guardar la membresía si es la primera encontrada o si tiene una fecha de fin más reciente
                    miembrosUnicos.put(idSocio, membresia);
                }
            }

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            for (Membresia membresia : miembrosUnicos.values()) {
                Socio socio = socioData.obtenerSocioPorId(membresia.getSocio().getId_Socio());
                String nombreCompleto = socio.getNombre() + " " + socio.getApellido();
                Boolean estado = membresia.isEstado();

                model.addRow(new Object[]{
                    membresia.getId_membresia(),
                    nombreCompleto,
                    membresia.getCantidadPases(),
                    membresia.getFechaInicio(),
                    membresia.getFechaFin(),
                    membresia.getCosto(),
                    estado
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
