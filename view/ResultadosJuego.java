/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControladorJuego;
import java.awt.Color;
import javax.swing.JOptionPane;

public class ResultadosJuego extends javax.swing.JFrame {

    private ControladorJuego controlador;
    private String nivelDificultad;
    private String nombreJugador;

    public ResultadosJuego() {
        initComponents();
        btnSalir.setBackground(new Color(220, 220, 220));
        btnSalir.setForeground(Color.BLACK);
        btnSalir.setFocusPainted(false);
        btnJugarDeNuevo.setBackground(new Color(144, 238, 144));
        btnJugarDeNuevo.setForeground(Color.BLACK);
        btnJugarDeNuevo.setFocusPainted(false);
        btnVolverMenu.setBackground(new Color(127, 255, 212));
        btnVolverMenu.setForeground(Color.BLACK);
        btnVolverMenu.setFocusPainted(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        result_label.setIcon(new javax.swing.ImageIcon("images/resultados.jpg"));

    }

    public void configurarResultados(ControladorJuego controlador, String jugador,
        String nivel, int puntajeFinal, int recordAnterior,
        boolean esNuevoRecord) {
        this.controlador = controlador;
        this.nombreJugador = jugador;
        this.nivelDificultad = nivel;

        // Configurar información del jugador y nivel
        lblJugador.setText("Jugador: " + jugador);
        lblNivel.setText("Nivel: " + nivel);

        // Configurar puntaje final
        lblPuntajeFinal.setText("Puntaje Final: " + puntajeFinal + " / 100");

        // Configurar record anterior
        lblRecordAnterior.setText("Récord anterior: " + recordAnterior);

        String mensajeFinal;
        java.awt.Color colorMensaje;

        if (esNuevoRecord && puntajeFinal > recordAnterior) {
            mensajeFinal = "¡NUEVO RÉCORD!";
            colorMensaje = new java.awt.Color(76, 175, 80); // Verde
        } else if (puntajeFinal == recordAnterior && puntajeFinal > 0) {
            mensajeFinal = "¡Igualaste tu récord!";
            colorMensaje = new java.awt.Color(33, 150, 243); // Azul
        } else {
            // Usar mensaje motivacional basado en porcentaje
            mensajeFinal = obtenerMensajeMotivacional(puntajeFinal);
            colorMensaje = new java.awt.Color(96, 125, 139); // Gris azulado
        }

        // Aplicar el mensaje final
        lblMensajeMotivacional.setText(mensajeFinal);
        lblMensajeMotivacional.setForeground(colorMensaje);
    }

    private String obtenerMensajeMotivacional(double porcentaje) {
        if (porcentaje >= 90) {
            return "¡Excelente! Eres un maestro de la trivia";
        } else if (porcentaje >= 80) {
            return "¡Muy bien! Tienes un gran conocimiento";
        } else if (porcentaje >= 70) {
            return "¡Buen trabajo! Vas por buen camino";
        } else if (porcentaje >= 60) {
            return "¡No está mal! Sigue practicando";
        } else if (porcentaje >= 50) {
            return "¡Puedes mejorar! La práctica hace al maestro";
        } else {
            return "¡No te rindas! Cada intento te hace mejor";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblJugador = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        lblPuntajeFinal = new javax.swing.JLabel();
        lblRecordAnterior = new javax.swing.JLabel();
        lblMensajeMotivacional = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnVolverMenu = new javax.swing.JButton();
        btnJugarDeNuevo = new javax.swing.JButton();
        result_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("RESULTADOS DEL JUEGO");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 600, -1));

        lblJugador.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblJugador.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJugador.setText("Jugador: ");
        getContentPane().add(lblJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 600, -1));

        lblNivel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(255, 255, 255));
        lblNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNivel.setText("Nivel: ");
        getContentPane().add(lblNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 600, -1));

        lblPuntajeFinal.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblPuntajeFinal.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntajeFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPuntajeFinal.setText("Puntaje Final: 0 / 100");
        getContentPane().add(lblPuntajeFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 600, -1));

        lblRecordAnterior.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblRecordAnterior.setForeground(new java.awt.Color(255, 255, 255));
        lblRecordAnterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRecordAnterior.setText("Récord anterior: 0");
        getContentPane().add(lblRecordAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 600, -1));

        lblMensajeMotivacional.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMensajeMotivacional.setForeground(new java.awt.Color(255, 255, 255));
        lblMensajeMotivacional.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensajeMotivacional.setText("Mensaje motivacional");
        getContentPane().add(lblMensajeMotivacional, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 600, -1));

        btnSalir.setBackground(new java.awt.Color(255, 102, 102));
        btnSalir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 430, 130, -1));

        btnVolverMenu.setBackground(new java.awt.Color(33, 150, 243));
        btnVolverMenu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnVolverMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverMenu.setText("Volver al Menú");
        btnVolverMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVolverMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVolverMenuMouseExited(evt);
            }
        });
        btnVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolverMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 176, -1));

        btnJugarDeNuevo.setBackground(new java.awt.Color(76, 175, 80));
        btnJugarDeNuevo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnJugarDeNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnJugarDeNuevo.setText("Jugar de Nuevo");
        btnJugarDeNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnJugarDeNuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnJugarDeNuevoMouseExited(evt);
            }
        });
        btnJugarDeNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarDeNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnJugarDeNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 170, -1));

        result_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/resultados2.jpg"))); // NOI18N
        result_label.setAlignmentY(0.0F);
        getContentPane().add(result_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que quieres salir del juego?\nSe perderá tu progreso actual.",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            controlador.volverAlMenu();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
        controlador.volverAlMenu();
        this.dispose();
    }//GEN-LAST:event_btnVolverMenuActionPerformed

    private void btnJugarDeNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarDeNuevoActionPerformed
        controlador.iniciarJuego(nivelDificultad, nombreJugador);
        this.dispose();
    }//GEN-LAST:event_btnJugarDeNuevoActionPerformed

    private void btnVolverMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMenuMouseEntered
        // TODO add your handling code here:
        btnVolverMenu.setBackground(new Color(30, 144, 255));// Color al pasar el mouse (verde claro)
        btnVolverMenu.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnVolverMenuMouseEntered

    private void btnVolverMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMenuMouseExited
        // TODO add your handling code here:
        btnVolverMenu.setBackground(new Color(127, 255, 212)); // Color original (azul claro)
        btnVolverMenu.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnVolverMenuMouseExited

    private void btnJugarDeNuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJugarDeNuevoMouseEntered
        // TODO add your handling code here:
        btnJugarDeNuevo.setBackground(new Color(34, 139, 34));// Color al pasar el mouse (verde claro)
        btnJugarDeNuevo.setForeground(Color.WHITE); 
    }//GEN-LAST:event_btnJugarDeNuevoMouseEntered

    private void btnJugarDeNuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJugarDeNuevoMouseExited
        // TODO add your handling code here:
        btnJugarDeNuevo.setBackground(new Color(144, 238, 144)); // Color original (azul claro)
        btnJugarDeNuevo.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnJugarDeNuevoMouseExited

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        // TODO add your handling code here:
        btnSalir.setBackground(new Color(128, 128, 128)); // Color original (naranja claro)
        btnSalir.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        // TODO add your handling code here:
        btnSalir.setBackground(new Color(220, 220, 220)); // Color original (naranja claro)
        btnSalir.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnSalirMouseExited

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
            java.util.logging.Logger.getLogger(ResultadosJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultadosJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultadosJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultadosJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultadosJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugarDeNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblMensajeMotivacional;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblPuntajeFinal;
    private javax.swing.JLabel lblRecordAnterior;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel result_label;
    // End of variables declaration//GEN-END:variables
}
