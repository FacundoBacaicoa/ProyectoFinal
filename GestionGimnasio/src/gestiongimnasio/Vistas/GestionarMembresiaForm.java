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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(470, 340));

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
                "ID Membresía", "ID Socio", "Cantidad de Pases", "Fecha de Inicio", "Fecha de Fin", "Costo", "Estado"
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

    jDateChooser1.setBackground(new java.awt.Color(102, 102, 102));
    jDateChooser1.setForeground(new java.awt.Color(153, 153, 153));

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

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jButton2)
                    .addGap(45, 45, 45)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, Short.MAX_VALUE))
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, 0)))
            .addContainerGap())
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jLabel2)
            .addGap(124, 124, 124))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton3)
                .addComponent(jButton1)
                .addComponent(jButton2))
            .addGap(0, 0, 0))
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
                membresiaData.cancelarMembresia(membresia);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Membresía cancelada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la membresía.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una membresía de la tabla.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cancelar la membresía: " + e.getMessage());
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
