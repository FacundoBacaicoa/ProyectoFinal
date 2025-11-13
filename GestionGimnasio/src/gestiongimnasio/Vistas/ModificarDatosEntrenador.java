
package gestiongimnasio.Vistas;

import gestiongimnasio.DAO.EntrenadorData;
import gestiongimnasio.Entidades.Entrenador;
import javax.swing.JOptionPane;


public class ModificarDatosEntrenador extends javax.swing.JInternalFrame {

private EntrenadorData entrenadorData=new EntrenadorData();
private Entrenador entrenador=null;
    public ModificarDatosEntrenador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jrEstado = new javax.swing.JRadioButton();
        jtDni = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtEspecialidad = new javax.swing.JTextField();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DNI");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Especialidad");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado");

        jbModificar.setBackground(new java.awt.Color(51, 51, 51));
        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEliminar.setBackground(new java.awt.Color(51, 51, 51));
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(51, 51, 51));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jrEstado.setText("Activo");

        jtEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEspecialidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbModificar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jLabel1)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrEstado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtEspecialidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(jtApellido)
                                    .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtDni, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(43, 43, 43)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jbEliminar)
                                .addGap(90, 90, 90)
                                .addComponent(jbSalir)))
                        .addContainerGap(122, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jrEstado))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar)
                    .addComponent(jbEliminar)
                    .addComponent(jbSalir))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    try {
        String dniTexto = jtDni.getText().trim();
        if (dniTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer dni = Integer.parseInt(dniTexto);
        entrenador = entrenadorData.buscarEntrenadorPorDNI(dni);
        
        if (entrenador != null) {
            jtApellido.setText(entrenador.getApellido());
            jtNombre.setText(entrenador.getNombre());
            jrEstado.setSelected(entrenador.isEstado());
            jtEspecialidad.setText(entrenador.getEspecialidad());
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un entrenador con el DNI ingresado.", "DNI no válido", JOptionPane.WARNING_MESSAGE);
            limpiarCampos();
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un número válido para el DNI", "Error de formato", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
           if (entrenador != null) {
        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea eliminar este entrenador? Esto también eliminará todas las clases asociadas a él.",
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean eliminado = entrenadorData.eliminarEntrenador(entrenador.getId_entrenadores());
            if (eliminado) {
                entrenador = null;
                limpiarCampos();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "No hay un Entrenador seleccionado");
    }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
             try{
            Integer dni=Integer.parseInt(jtDni.getText());
            String nombre=jtNombre.getText();
            String apellido=jtApellido.getText();
            String especialidad=jtEspecialidad.getText();
            if (nombre.isEmpty() || apellido.isEmpty()||especialidad.isEmpty()||dni==null) {
                JOptionPane.showMessageDialog(this, "No puede haber campos vacios");
                return;
            }
            Boolean estado=jrEstado.isSelected();
            if(entrenador!=null){
                entrenador.setNombre(nombre);
                entrenador.setApellido(apellido);
                entrenador.setEspecialidad(especialidad);
                entrenador.setDni(dni);
                entrenador.setEstado(estado);
                entrenadorData.modificarEntrenador(entrenador);
                limpiarCampos();
            }
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(this,"Debe ingresar un DNI válido");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jtEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEspecialidadActionPerformed

private void limpiarCampos(){
    jtDni.setText("");
    jtApellido.setText("");
    jtNombre.setText("");
    jtEspecialidad.setText("");
    jrEstado.setSelected(false);
    
}  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrEstado;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtEspecialidad;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
