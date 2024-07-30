package gestiongimnasio.Vistas;

import gestiongimnasio.DAO.MembresiaData;
import gestiongimnasio.Entidades.Membresia;
import gestiongimnasio.DAO.SocioDAO;
import gestiongimnasio.Entidades.Socio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.Date;


import java.util.List;
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
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre y Apellido del socio");

        jTextField2.setBackground(new java.awt.Color(102, 102, 102));
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField2.setSelectedTextColor(new java.awt.Color(0, 0, 204));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setForeground(new java.awt.Color(153, 153, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Membresía", "ID Socio", "Cantidad de Pases", "Fecha de Inicio", "Fecha de Fin", "Costo"
            }
        ){
            Class[] types = new Class [] {
                Integer.class, Integer.class, Integer.class, java.sql.Date.class, java.sql.Date.class, BigDecimal.class, Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
    jLabel3.setText("Nueva Fecha de finalizacion");

    jButton1.setBackground(new java.awt.Color(51, 51, 51));
    jButton1.setForeground(new java.awt.Color(255, 255, 255));
    jButton1.setText("Actualizar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(112, 112, 112)
                            .addComponent(jLabel1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3)
                            .addGap(8, 8, 8)))
                    .addGap(33, 33, 33)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addGap(37, 37, 37)
                            .addComponent(jButton4)
                            .addGap(52, 52, 52)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(222, 222, 222)
                    .addComponent(jLabel2)))
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2)
            .addGap(8, 8, 8)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(12, 12, 12)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2)
                .addComponent(jButton3)
                .addComponent(jButton4))
            .addGap(17, 17, 17))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

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
                    
                    // Actualizar la tabla
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setValueAt(false, selectedRow, 6); // Suponiendo que la columna de estado es la 7 (índice 6)
                    
                    JOptionPane.showMessageDialog(this, "Membresía cancelada exitosamente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la membresía.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una membresía de la tabla.");
        }
    } catch (Exception e) {
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        buscarMembresias();

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            int idMembresia = (int) jTable1.getValueAt(selectedRow, 0);
            Date nuevaFechaFin = jDateChooser1.getDate();
            if (nuevaFechaFin != null) {
                Membresia membresia = membresiaData.obtenerMembresiaPorId(idMembresia);
                if (membresia != null) {
                    membresia.setFechaFin(new java.sql.Date(nuevaFechaFin.getTime()));
                    membresiaData.actualizarMembresia(membresia);

                    // Actualizar la tabla
                    jTable1.setValueAt(new java.sql.Date(nuevaFechaFin.getTime()), selectedRow, 4);
                    JOptionPane.showMessageDialog(this, "Fecha de finalización actualizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró la membresía.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una nueva fecha de finalización.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una membresía de la tabla.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar la fecha de finalización: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     try {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            int idMembresia = (int) jTable1.getValueAt(selectedRow, 0);
            Date nuevaFechaFin = jDateChooser1.getDate();
            if (nuevaFechaFin != null) {
                Membresia membresia = membresiaData.obtenerMembresiaPorId(idMembresia);
                if (membresia != null) {
                    // Verificar si la membresía está inactiva
                    if (membresia.getFechaFin().before(new java.util.Date())) {
                        // Establecer la nueva fecha de fin
                        membresia.setFechaFin(new java.sql.Date(nuevaFechaFin.getTime()));
                        // Establecer la fecha de inicio como la fecha actual
                        membresia.setFechaInicio(new java.sql.Date(System.currentTimeMillis()));
                        membresiaData.actualizarMembresia(membresia);
                        // Actualizar la tabla
                        jTable1.setValueAt(membresia.getFechaInicio(), selectedRow, 3); // Suponiendo que la columna 3 es la fecha de inicio
                        jTable1.setValueAt(membresia.getFechaFin(), selectedRow, 4); // Suponiendo que la columna 4 es la fecha de fin
                        JOptionPane.showMessageDialog(this, "Membresía reactivada exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Esta membresía aún está activa.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró la membresía.");
                }
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

     private void buscarMembresias() {
        try {
            String nombreCompleto = jTextField2.getText().trim();
            String[] partesNombre = nombreCompleto.split(" ");

            if (partesNombre.length < 2) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese tanto el nombre como el apellido del socio.");
                return;
            }

            String nombreSocio = partesNombre[0];
            String apellidoSocio = partesNombre[1];

            Socio socio = socioData.buscarSocioPorNombreApellido(nombreSocio, apellidoSocio);

            if (socio == null) {
                JOptionPane.showMessageDialog(this, "El nombre y apellido del socio no existen. Por favor, ingrese un nombre y apellido válidos.");
                return;
            }

            List<Membresia> membresias = membresiaData.obtenerMembresiasPorSocio(socio.getId_Socio());
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            for (Membresia membresia : membresias) {
                model.addRow(new Object[]{
                    membresia.getId_membresia(),
                    membresia.getSocio().getId_Socio(),
                    membresia.getCantidadPases(),
                    membresia.getFechaInicio(),
                    membresia.getFechaFin(),
                    membresia.getCosto(),
                    membresia.isEstado()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar las membresías: " + e.getMessage());
        }
    }
    private void cargarDatos() {
        try {
            List<Membresia> membresias = membresiaData.obtenerMembresias();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            for (Membresia membresia : membresias) {
                model.addRow(new Object[]{
                    membresia.getId_membresia(),
                    membresia.getSocio().getId_Socio(),
                    membresia.getCantidadPases(),
                    membresia.getFechaInicio(),
                    membresia.getFechaFin(),
                    membresia.getCosto(),
                    membresia.isEstado()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage());
        }
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
