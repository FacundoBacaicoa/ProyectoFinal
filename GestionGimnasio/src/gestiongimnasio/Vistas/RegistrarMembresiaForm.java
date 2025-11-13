package gestiongimnasio.Vistas;

import gestiongimnasio.DAO.SocioDAO;
import gestiongimnasio.DAO.MembresiaData;
import gestiongimnasio.Entidades.Membresia;
import gestiongimnasio.Entidades.Socio;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class RegistrarMembresiaForm extends JInternalFrame {

    private MembresiaData membresiaData;
    private SocioDAO socioData;

    public RegistrarMembresiaForm() {
        membresiaData = new MembresiaData();
        socioData = new SocioDAO();
        initComponents();
        configurarFormulario();
    }

    private void configurarFormulario() {
        jDateChooser2.setEnabled(false);
        jComboBox1.addActionListener(e -> calcularFechaFinYCosto());
        jDateChooser1.addPropertyChangeListener("date", e -> calcularFechaFinYCosto());
    }
   
    private void calcularFechaFinYCosto() {
        String planSeleccionado = (String) jComboBox1.getSelectedItem();
        Date fechaInicio = jDateChooser1.getDate();
        if (planSeleccionado == null || planSeleccionado.equals("-Seleccionar-") || fechaInicio == null) {
            jDateChooser2.setDate(null);
            return;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaInicio);

        BigDecimal costo = BigDecimal.ZERO;
        int cantidadPases = 0;

        switch (planSeleccionado) {
            case "Pase Individual":
                cantidadPases = 1;
                costo = new BigDecimal("1000");
                cal.add(Calendar.MONTH,1);
                break;
            case "Plan 5 Pases":
                cantidadPases = 5;
                costo = new BigDecimal("3000");
                cal.add(Calendar.MONTH, 1);
                break;
            case "Plan 10 Pases":
                cantidadPases = 10;
                costo = new BigDecimal("6000");
                cal.add(Calendar.MONTH, 1);
                break;
            case "Plan 15 Pases":
                cantidadPases = 15;
                costo = new BigDecimal("9000");
                cal.add(Calendar.MONTH, 1);
                break;
            case "Plan Pase Libre":
                cantidadPases = -1;
                costo = new BigDecimal("20000");
                cal.add(Calendar.MONTH, 1);
                break;
        }

        jDateChooser2.setDate(cal.getTime());

        String pasesTexto = cantidadPases == -1 ? "Ilimitado" : String.valueOf(cantidadPases);
        jLabel5.setText("Clases: " + pasesTexto + " | Costo: $" + costo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        buttonOK = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ingresodeNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        contentPane.setBackground(new java.awt.Color(56, 56, 56));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de Finalización");

        buttonOK.setBackground(new java.awt.Color(51, 51, 51));
        buttonOK.setForeground(new java.awt.Color(255, 255, 255));
        buttonOK.setText("Registrar Membresia");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre y apellido del socio");

        ingresodeNombre.setBackground(new java.awt.Color(102, 102, 102));
        ingresodeNombre.setSelectedTextColor(new java.awt.Color(204, 204, 204));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha de inicio");

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Activo");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("REGISTRAR MEMBRESIA");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Plan");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar-", "Pase Individual", "Plan 5 Pases", "Plan 10 Pases", "Plan 15 Pases", "Plan Pase Libre" }));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Estado de Membresia");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setText(" ");

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(44, 44, 44)))
                                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8)
                                        .addComponent(ingresodeNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox1)))))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(buttonOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 137, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(39, 39, 39)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingresodeNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(50, 50, 50)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBox1))
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOK)
                    .addComponent(jButton1))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooser1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDateChooser1ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1ComponentHidden

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed

        try {
            String nombreCompleto = ingresodeNombre.getText().trim();
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
            
            if (membresiaData.tieneMembresiaActiva(socio.getId_Socio())) {
                JOptionPane.showMessageDialog(this, "El socio ya tiene una membresía activa.");
                return;
            }

            String planSeleccionado = (String) jComboBox1.getSelectedItem();
            if (planSeleccionado == null || planSeleccionado.equals("-Seleccionar-")) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un plan.");
                return;
            }

            Date selectedDateInicio = jDateChooser1.getDate();
            Date selectedDateFin = jDateChooser2.getDate();

            if (selectedDateInicio == null) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione la fecha de inicio");
                return;
            }
            if (selectedDateFin == null) {
                JOptionPane.showMessageDialog(this, "Error: La fecha de fin no se calculó correctamente");
                return;
            }

            Date currentDate = new Date();
            if (selectedDateInicio.before(currentDate)) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                Date startOfCurrentDay = calendar.getTime();

                if (selectedDateInicio.before(startOfCurrentDay)) {
                    JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser anterior a la fecha actual");
                    return;
                }
            }

            int cantidadDePases = 0;
            BigDecimal costo = BigDecimal.ZERO;
            
            switch (planSeleccionado) {
                case "Pase Individual":
                    cantidadDePases = 1;
                    costo = new BigDecimal("1000");
                    break;
                case "Plan 5 Pases":
                    cantidadDePases = 5;
                    costo = new BigDecimal("3000");
                    break;
                case "Plan 10 Pases":
                    cantidadDePases = 10;
                    costo = new BigDecimal("6000");
                    break;
                case "Plan 15 Pases":
                    cantidadDePases = 15;
                    costo = new BigDecimal("9000");
                    break;
                case "Plan Pase Libre":
                    cantidadDePases = -1;
                    costo = new BigDecimal("20000");
                    break;
            }

            java.sql.Date fechaInicio = new java.sql.Date(selectedDateInicio.getTime());
            java.sql.Date fechaFin = new java.sql.Date(selectedDateFin.getTime());
            boolean estado = jCheckBox1.isSelected();

            Membresia membresia = new Membresia();
            membresia.setSocio(socio);
            membresia.setCantidadPases(cantidadDePases);
            membresia.setFechaInicio(fechaInicio);
            membresia.setFechaFin(fechaFin);
            membresia.setCosto(costo);
            membresia.setEstado(estado);

            membresiaData.registrarMembresia(membresia);

            JOptionPane.showMessageDialog(this, "Membresía registrada exitosamente\n" +
                "Plan: " + planSeleccionado + "\n" +
                "Clases: " + (cantidadDePases == -1 ? "Ilimitadas" : cantidadDePases) + "\n" +
                "Costo: $" + costo);
            
            limpiarCampos();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los campos correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar la membresía: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        ingresodeNombre.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jCheckBox1.setSelected(false);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarMembresiaForm().setVisible(true);
            }
        });
    }//GEN-LAST:event_buttonOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonOK;
    private javax.swing.JPanel contentPane;
    private javax.swing.JTextField ingresodeNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
