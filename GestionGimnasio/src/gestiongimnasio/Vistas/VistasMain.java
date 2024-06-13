
package gestiongimnasio.Vistas;
import com.vistasJorge.HistoriadeMembresiasForm;
import com.vistasJorge.RegistrarMembresiaForm;
import com.vistasJorge.GestionarMembresiaForm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Facu
 */
public class VistasMain extends javax.swing.JFrame {

    /**
     * Creates new form VistasMain
     */
    public VistasMain() {
        initComponents();
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
        ImageIcon icono = new ImageIcon (getClass().getResource("/gestiongimnasio/Recursos/Fondo.png"));
        Image fondo=icono.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent (Graphics graf){
                graf.drawImage(fondo, 0, 0, getWidth(), getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jmEntrenador = new javax.swing.JMenu();
        jmAnadirEntrenador = new javax.swing.JMenuItem();
        jmListaEntrenadores = new javax.swing.JMenuItem();
        jmClases = new javax.swing.JMenu();
        jmClaseAnadir = new javax.swing.JMenuItem();
        jmClaseLista = new javax.swing.JMenuItem();
        jmClaseBuscar = new javax.swing.JMenuItem();
        jmClaseInscribir = new javax.swing.JMenuItem();
        jmGestionMem = new javax.swing.JMenu();
        jmRegMembresias = new javax.swing.JMenuItem();
        jmHistorialMem = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jmSocios = new javax.swing.JMenu();
        jmAnadirSocios = new javax.swing.JMenuItem();
        jmListaSocios = new javax.swing.JMenuItem();
        jmBuscarSocios = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

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

        jmClaseLista.setText("Lista de Clases");
        jmClaseLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClaseListaActionPerformed(evt);
            }
        });
        jmClases.add(jmClaseLista);

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

        jmAnadirSocios.setText("Añadir Socios");
        jmAnadirSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAnadirSociosActionPerformed(evt);
            }
        });
        jmSocios.add(jmAnadirSocios);

        jmListaSocios.setText("Lista de Socios");
        jmListaSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListaSociosActionPerformed(evt);
            }
        });
        jmSocios.add(jmListaSocios);

        jmBuscarSocios.setText("Buscar Socios");
        jmSocios.add(jmBuscarSocios);

        jMenuBar1.add(jmSocios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jmClaseAnadirActionPerformed

    private void jmClaseBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClaseBuscarActionPerformed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jmClaseInscribirActionPerformed

    private void jmClaseListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClaseListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmClaseListaActionPerformed

    private void jmListaSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListaSociosActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ListaSocios listar=new ListaSocios();
        listar.setVisible(true);
        listar.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(listar);        
    }//GEN-LAST:event_jmListaSociosActionPerformed

    private void jmAnadirSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAnadirSociosActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
       AñadirSocio añadirS=new AñadirSocio();
        añadirS.setVisible(true);
        añadirS.getContentPane().setBackground(new Color(56, 56, 56));
        escritorio.add(añadirS);        
    }//GEN-LAST:event_jmAnadirSociosActionPerformed

    private void jmHistorialMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmHistorialMemActionPerformed
         escritorio.removeAll();
        escritorio.repaint();
        HistoriadeMembresiasForm historiadeMembresiasForm = new HistoriadeMembresiasForm();
        historiadeMembresiasForm.setVisible(true);
        escritorio.add(historiadeMembresiasForm);
        try {
            historiadeMembresiasForm.setMaximum(true); // Para que se maximice dentro del JDesktopPane
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jmHistorialMemActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        escritorio.removeAll();
    escritorio.repaint();
    GestionarMembresiaForm gestionarMembresiaForm = new GestionarMembresiaForm();
    gestionarMembresiaForm.setVisible(true);
    escritorio.add(gestionarMembresiaForm);
    try {
        gestionarMembresiaForm.setMaximum(true); // Para que se maximice dentro del JDesktopPane
    } catch (java.beans.PropertyVetoException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jmRegMembresiasActionPerformed(java.awt.event.ActionEvent evt) {
     escritorio.removeAll();
    escritorio.repaint();
    RegistrarMembresiaForm registrarMembresiaForm = new RegistrarMembresiaForm();
    registrarMembresiaForm.setVisible(true);
    escritorio.add(registrarMembresiaForm);
    try {
        registrarMembresiaForm.setMaximum(true); // Para que se maximice dentro del JDesktopPane
    } catch (java.beans.PropertyVetoException e) {
        e.printStackTrace();
    }
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
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jmAnadirEntrenador;
    private javax.swing.JMenuItem jmAnadirSocios;
    private javax.swing.JMenuItem jmBuscarSocios;
    private javax.swing.JMenuItem jmClaseAnadir;
    private javax.swing.JMenuItem jmClaseBuscar;
    private javax.swing.JMenuItem jmClaseInscribir;
    private javax.swing.JMenuItem jmClaseLista;
    private javax.swing.JMenu jmClases;
    private javax.swing.JMenu jmEntrenador;
    private javax.swing.JMenu jmGestionMem;
    private javax.swing.JMenuItem jmHistorialMem;
    private javax.swing.JMenuItem jmListaEntrenadores;
    private javax.swing.JMenuItem jmListaSocios;
    private javax.swing.JMenuItem jmRegMembresias;
    private javax.swing.JMenu jmSocios;
    // End of variables declaration//GEN-END:variables
}
