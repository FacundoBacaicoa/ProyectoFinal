
package gestiongimnasio.Vistas;
import gestiongimnasio.DAO.MembresiaData;
import gestiongimnasio.Entidades.Membresia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

/**
 *
 * @author Jorge
 */
public class GestionarMembresiaForm extends javax.swing.JInternalFrame {
    private MembresiaData membresiaData;

    /**
     * Creates new form GestionarMembresiaForm
     */
    public GestionarMembresiaForm() {
         membresiaData = new MembresiaData();
        initComponents();
        cargarDatos();
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

        jLabel1.setText("ID de la membresía");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

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
    jScrollPane1.setViewportView(jTable1);

    jButton2.setText("Cancelar Membresía");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    jLabel3.setText("Nueva Fecha de finalizacion");

    jButton1.setText("actualizar");
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
            .addGap(57, 57, 57)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(jLabel1))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(187, 187, 187)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 49, Short.MAX_VALUE)))
            .addContainerGap())
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(137, 137, 137))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jButton1)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addGap(49, 49, 49))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jButton2)
                    .addGap(33, 33, 33))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(15, 15, 15))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
        int membresiaId = Integer.parseInt(jTextField2.getText());
        
        // Verifica si la membresía existe antes de intentar cancelarla
        Membresia membresia = membresiaData.obtenerMembresiaPorId(membresiaId);
        
        if (membresia != null) {
            membresiaData.cancelarMembresia(membresia);
            JOptionPane.showMessageDialog(this, "Membresía cancelada exitosamente.");
            cargarDatos();
        } else {
            JOptionPane.showMessageDialog(this, "Membresía no encontrada.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de membresía válido.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cancelar la membresía: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
try {
        int membresiaId = Integer.parseInt(jTextField2.getText());
        
        // Obtener la membresía desde la base de datos
        Membresia membresia = membresiaData.obtenerMembresiaPorId(membresiaId);
        
        if (membresia != null) {
            // Limpiar la tabla antes de agregar nuevos datos
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            // Agregar los detalles de la membresía a la tabla
            model.addRow(new Object[]{
                membresia.getId_membresia(),
                membresia.getSocio().getId_Socio(),
                membresia.getCantidadPases(),
                membresia.getFechaInicio(),
                membresia.getFechaFin(),
                membresia.getCosto(),
                membresia.isEstado()
            });

            // Mostrar los detalles de la membresía en los campos correspondientes
            jTextField2.setText(String.valueOf(membresia.getSocio().getId_Socio()));
            jDateChooser1.setDate(membresia.getFechaFin());
        } else {
            JOptionPane.showMessageDialog(this, "Membresía no encontrada.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de membresía válido.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar la membresía: " + e.getMessage());
    }
     
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        // Obtén el ID de la membresía desde el campo de texto
        int membresiaId = Integer.parseInt(jTextField2.getText());

        // Verifica que se haya seleccionado una nueva fecha de finalización
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una nueva fecha de finalización.");
            return;
        }

        // Convierte la fecha seleccionada a java.sql.Date
        Date nuevaFechaFin = new Date(jDateChooser1.getDate().getTime());

        // Obtén la membresía desde la base de datos usando el ID
        Membresia membresia = membresiaData.obtenerMembresiaPorId(membresiaId);

        if (membresia != null) {
            // Actualiza la fecha de finalización de la membresía
            membresia.setFechaFin(nuevaFechaFin);
            
            // Llama al método de actualizar membresía en la base de datos
            membresiaData.actualizarMembresia(membresia);

            // Muestra un mensaje de éxito
            JOptionPane.showMessageDialog(this, "Membresía actualizada exitosamente.");
            
            // Recarga los datos en la tabla
            cargarDatos();
        } else {
            // Muestra un mensaje si la membresía no se encuentra
            JOptionPane.showMessageDialog(this, "Membresía no encontrada.");
        }
    } catch (NumberFormatException e) {
        // Maneja el error si el ID de la membresía no es válido
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de membresía válido.");
    } catch (Exception e) {
        // Maneja cualquier otro error que ocurra
        JOptionPane.showMessageDialog(this, "Error al actualizar la membresía: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
