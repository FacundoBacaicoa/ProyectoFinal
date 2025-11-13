package gestiongimnasio.Vistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;

public class VistasMain extends javax.swing.JFrame {


    public VistasMain() {
        initComponents();
        diaSemana();
        fechaActual();
        this.setExtendedState(6);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        ImageIcon icono = new ImageIcon (getClass().getResource("/gestiongimnasio/Recursos/Fondo3.jpg"));
        Image fondo=icono.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent (Graphics graf){
                graf.drawImage(fondo, 0, 0, getWidth(), getHeight(),this);
            }
        };
        lblFecha = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmEntrenador = new javax.swing.JMenu();
        jmAnadirEntrenador = new javax.swing.JMenuItem();
        jmListaEntrenadores = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jmClases = new javax.swing.JMenu();
        jmClaseAnadir = new javax.swing.JMenuItem();
        jmClaseBuscar = new javax.swing.JMenuItem();
        jmClaseInscribir = new javax.swing.JMenuItem();
        jmGestionMem = new javax.swing.JMenu();
        jmRegMembresias = new javax.swing.JMenuItem();
        jmHistorialMem = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jmSocios = new javax.swing.JMenu();
        jmAnadirSocios = new javax.swing.JMenuItem();
        jmListaSocios = new javax.swing.JMenuItem();
        JmAsistencias = new javax.swing.JMenu();
        JmAsist = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFecha.setBackground(new java.awt.Color(204, 204, 204));
        lblFecha.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));

        escritorio.setLayer(lblFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(669, 669, 669))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 612, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));

        jmEntrenador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestiongimnasio/Recursos/Entrenador.png"))); // NOI18N
        jmEntrenador.setText("Entrenadores");

        jmAnadirEntrenador.setText("Añadir Entrenador");
        jmAnadirEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAnadirEntrenadorActionPerformed(evt);
            }
        });
        jmEntrenador.add(jmAnadirEntrenador);

        jmListaEntrenadores.setText("Lista y Busqueda de Entrenadores");
        jmListaEntrenadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListaEntrenadoresActionPerformed(evt);
            }
        });
        jmEntrenador.add(jmListaEntrenadores);

        jMenuItem6.setText("Modificar Datos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jmEntrenador.add(jMenuItem6);

        jMenuBar1.add(jmEntrenador);

        jmClases.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestiongimnasio/Recursos/Clase 2.png"))); // NOI18N
        jmClases.setText("Clases");

        jmClaseAnadir.setText("Añadir Clase");
        jmClaseAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClaseAnadirActionPerformed(evt);
            }
        });
        jmClases.add(jmClaseAnadir);

        jmClaseBuscar.setText("Buscar Clases");
        jmClaseBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClaseBuscarActionPerformed(evt);
            }
        });
        jmClases.add(jmClaseBuscar);

        jmClaseInscribir.setText("Inscribir a Clase");
        jmClaseInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClaseInscribirActionPerformed(evt);
            }
        });
        jmClases.add(jmClaseInscribir);

        jMenuBar1.add(jmClases);

        jmGestionMem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestiongimnasio/Recursos/Membresia.png"))); // NOI18N
        jmGestionMem.setText("Membresias");

        jmRegMembresias.setText("Registrar Membresia");
        jmRegMembresias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRegMembresiasActionPerformed(evt);
            }
        });
        jmRegMembresias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRegMembresiasActionPerformed(evt);
            }
        });
        jmGestionMem.add(jmRegMembresias);

        jmHistorialMem.setText("Historial de Membresias");
        jmHistorialMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmHistorialMemActionPerformed(evt);
            }
        });
        jmGestionMem.add(jmHistorialMem);

        jMenuItem7.setText("Gestionar Membresias");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmGestionMem.add(jMenuItem7);

        jMenuBar1.add(jmGestionMem);

        jmSocios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestiongimnasio/Recursos/Socios.png"))); // NOI18N
        jmSocios.setText("Socios");

        jmAnadirSocios.setText("Añadir o modificar Socios");
        jmAnadirSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAnadirSociosActionPerformed(evt);
            }
        });
        jmSocios.add(jmAnadirSocios);

        jmListaSocios.setText("Listado de Socios");
        jmListaSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListaSociosActionPerformed(evt);
            }
        });
        jmSocios.add(jmListaSocios);

        jMenuBar1.add(jmSocios);

        JmAsistencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestiongimnasio/Recursos/icons8-asistencia-30.png"))); // NOI18N
        JmAsistencias.setText("Asistencias");

        JmAsist.setText("Historial");
        JmAsist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAsistActionPerformed(evt);
            }
        });
        JmAsistencias.add(JmAsist);

        jMenuBar1.add(JmAsistencias);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmAnadirEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAnadirEntrenadorActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        AgregarEntrenador agEntrenador = new AgregarEntrenador();
        agEntrenador.setVisible(true);
        agEntrenador.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(agEntrenador);
    }//GEN-LAST:event_jmAnadirEntrenadorActionPerformed

    private void jmClaseAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClaseAnadirActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        AñadirClase anadirClase = new AñadirClase();
        anadirClase.setVisible(true);
        anadirClase.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(anadirClase);
    }//GEN-LAST:event_jmClaseAnadirActionPerformed

    private void jmClaseBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClaseBuscarActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        BuscarClase buscarClase = new BuscarClase();
        buscarClase.setVisible(true);
        buscarClase.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(buscarClase);
    }//GEN-LAST:event_jmClaseBuscarActionPerformed

    private void jmListaEntrenadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListaEntrenadoresActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ListaEntrenadores listEntrenador = new ListaEntrenadores();
        listEntrenador.setVisible(true);
        listEntrenador.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(listEntrenador);
    }//GEN-LAST:event_jmListaEntrenadoresActionPerformed

    private void jmClaseInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClaseInscribirActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        InscribiraClase inscribiraClase = new InscribiraClase();
        inscribiraClase.setVisible(true);
        inscribiraClase.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(inscribiraClase);
    }//GEN-LAST:event_jmClaseInscribirActionPerformed

    private void jmListaSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListaSociosActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ListaSocios listar = new ListaSocios();
        listar.setVisible(true);
        listar.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(listar);
    }//GEN-LAST:event_jmListaSociosActionPerformed

    private void jmAnadirSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAnadirSociosActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        AñadirSocio añadirS = new AñadirSocio();
        añadirS.setVisible(true);
        añadirS.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(añadirS);
    }//GEN-LAST:event_jmAnadirSociosActionPerformed

    private void jmHistorialMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmHistorialMemActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        HistoriadeMembresiasForm historiadeMembresiasForm = new HistoriadeMembresiasForm();
        historiadeMembresiasForm.setVisible(true);
        historiadeMembresiasForm.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(historiadeMembresiasForm);
    }//GEN-LAST:event_jmHistorialMemActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        GestionarMembresiaForm gestionarMembresiaForm = new GestionarMembresiaForm();
        gestionarMembresiaForm.setVisible(true);
        gestionarMembresiaForm.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(gestionarMembresiaForm);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void JmAsistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAsistActionPerformed
          escritorio.removeAll();
    escritorio.repaint();
    HistorialAsistencias historialAsistenciasForm = new HistorialAsistencias();
    historialAsistenciasForm.setVisible(true);
    historialAsistenciasForm.getContentPane().setBackground(new Color(56, 56, 56));
    escritorio.add(historialAsistenciasForm);
 
    }//GEN-LAST:event_JmAsistActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
         escritorio.removeAll();
         escritorio.repaint();
         ModificarDatosEntrenador modificarDatos = new ModificarDatosEntrenador();
         modificarDatos.setVisible(true);
         modificarDatos.getContentPane().setBackground(new Color(56,56,56));
         escritorio.add(modificarDatos);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jmRegMembresiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRegMembresiasActionPerformed
               escritorio.removeAll();
        escritorio.repaint();
        RegistrarMembresiaForm registrarMembresiaForm = new RegistrarMembresiaForm();
        registrarMembresiaForm.setVisible(true);
        registrarMembresiaForm.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(registrarMembresiaForm);
    }//GEN-LAST:event_jmRegMembresiasActionPerformed
 
    public void diaSemana(){
        Calendar calendar = Calendar.getInstance();
        String diaSemana = " ";
        switch (calendar.get(Calendar.DAY_OF_WEEK)){
        case 1:
             diaSemana = "Domingo";
             break;
                     case 2:
             diaSemana = "Lunes";
             break;
                     case 3:
             diaSemana = "Martes";
             break;
                     case 4:
             diaSemana = "Miercoles";
             break;
                     case 5:
             diaSemana = "Jueves";
             break;
                     case 6:
             diaSemana = "Viernes";
             break;
                     case 7:
             diaSemana = "Sabado";
             break;
        }
        lblFecha.setText(diaSemana);
    }
    
    private void fechaActual(){
        Date fecha_actual = new Date();
        DateFormat formato_fecha = new SimpleDateFormat ("dd/MM/YYYY");
        String fecha = formato_fecha.format(fecha_actual);
        String diaSemana = lblFecha.getText();
        lblFecha.setText(diaSemana + " " + fecha);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistasMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JmAsist;
    private javax.swing.JMenu JmAsistencias;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jmAnadirEntrenador;
    private javax.swing.JMenuItem jmAnadirSocios;
    private javax.swing.JMenuItem jmClaseAnadir;
    private javax.swing.JMenuItem jmClaseBuscar;
    private javax.swing.JMenuItem jmClaseInscribir;
    private javax.swing.JMenu jmClases;
    private javax.swing.JMenu jmEntrenador;
    private javax.swing.JMenu jmGestionMem;
    private javax.swing.JMenuItem jmHistorialMem;
    private javax.swing.JMenuItem jmListaEntrenadores;
    private javax.swing.JMenuItem jmListaSocios;
    private javax.swing.JMenuItem jmRegMembresias;
    private javax.swing.JMenu jmSocios;
    private javax.swing.JLabel lblFecha;
    // End of variables declaration//GEN-END:variables
}
