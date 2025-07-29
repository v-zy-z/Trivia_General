/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControladorJuego;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import model.Pregunta;


public class JuegoTrivia extends javax.swing.JFrame {

    private ControladorJuego controlador;
    private ButtonGroup grupoOpciones;
    private Pregunta preguntaActual;
    private int numeroPregunta;
    private int puntajeActual;
    private String nivelDificultad;
    private String nombreJugador;

    public JuegoTrivia() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Configurar grupo de botones de radio
        grupoOpciones = new ButtonGroup();
        grupoOpciones.add(rbOpcion1);
        grupoOpciones.add(rbOpcion2);
        grupoOpciones.add(rbOpcion3);
//        grupoOpciones.add(rbOpcion4);
    }

    public void configurarJuego(ControladorJuego controlador, String nivel, String jugador) {
        this.controlador = controlador;
        this.nivelDificultad = nivel;
        this.nombreJugador = jugador;
        this.numeroPregunta = 1;
        this.puntajeActual = 0;
        banner.setIcon(new javax.swing.ImageIcon("images/banner1.png"));
                label_c_base.setIcon(new javax.swing.ImageIcon("images/c_label.png"));


        actualizarInformacionJuego();
        cargarSiguientePregunta();
    }

    private void actualizarInformacionJuego() {
        lblPuntaje.setText("Puntaje: " + puntajeActual);
        lblProgreso.setText("Pregunta " + numeroPregunta + " de 100");
        lblNivel.setText("Nivel: " + nivelDificultad);
        lblJugador.setText("Jugador: " + nombreJugador);
    }

    public void cargarPregunta(Pregunta pregunta) {
        this.preguntaActual = pregunta;

        // Limpiar selección anterior
        grupoOpciones.clearSelection();

        // Cargar la pregunta y opciones
        lblPregunta.setText(pregunta.getTextoPregunta());

        String[] opciones = pregunta.getOpciones();
        rbOpcion1.setText(opciones[0]);
//        text_A.setText(opciones[0]);
        rbOpcion2.setText(opciones[1]);
        rbOpcion3.setText(opciones[2]);
//        rbOpcion4.setText(opciones[3]);

        // Habilitar botón de respuesta
        btnResponder.setEnabled(true);
    }

    private void cargarSiguientePregunta() {
        controlador.cargarSiguientePregunta();
    }

    public void actualizarPuntaje(int nuevoPuntaje) {
        this.puntajeActual = nuevoPuntaje;
        actualizarInformacionJuego();
    }

    public void avanzarPregunta() {
        this.numeroPregunta++;
        actualizarInformacionJuego();
    }

    public void finalizarJuego() {
        controlador.terminarJuego(puntajeActual);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbOpcion2 = new javax.swing.JRadioButton();
        label_B = new javax.swing.JLabel();
        rbOpcion1 = new javax.swing.JRadioButton();
        label_A = new javax.swing.JLabel();
        lblPuntaje = new javax.swing.JLabel();
        lblJugador = new javax.swing.JLabel();
        lblProgreso = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        lblPregunta = new javax.swing.JLabel();
        rbOpcion3 = new javax.swing.JRadioButton();
        label_C = new javax.swing.JLabel();
        label_c_base = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnResponder = new javax.swing.JButton();
        label_dark = new javax.swing.JLabel();
        label_dark1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        banner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbOpcion2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbOpcion2.setForeground(new java.awt.Color(255, 255, 255));
        rbOpcion2.setText("Opción 2");
        rbOpcion2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                rbOpcion2MouseMoved(evt);
            }
        });
        rbOpcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOpcion2ActionPerformed(evt);
            }
        });
        getContentPane().add(rbOpcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 280, 60));

        label_B.setForeground(new java.awt.Color(255, 255, 255));
        label_B.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_B.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                label_BMouseMoved(evt);
            }
        });
        label_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_BMouseExited(evt);
            }
        });
        getContentPane().add(label_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 302, 360, 75));

        rbOpcion1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbOpcion1.setForeground(new java.awt.Color(255, 255, 255));
        rbOpcion1.setText("Opción 1");
        rbOpcion1.setToolTipText("");
        rbOpcion1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                rbOpcion1MouseMoved(evt);
            }
        });
        rbOpcion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rbOpcion1MouseExited(evt);
            }
        });
        rbOpcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOpcion1ActionPerformed(evt);
            }
        });
        getContentPane().add(rbOpcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 280, 60));

        label_A.setForeground(new java.awt.Color(255, 255, 255));
        label_A.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_A.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                label_AMouseMoved(evt);
            }
        });
        label_A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_AMouseExited(evt);
            }
        });
        getContentPane().add(label_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 302, 360, 75));

        lblPuntaje.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPuntaje.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntaje.setText("Puntaje: 0");
        getContentPane().add(lblPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 108, -1));

        lblJugador.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblJugador.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador.setText("Jugador: ");
        getContentPane().add(lblJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 164, -1));

        lblProgreso.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblProgreso.setForeground(new java.awt.Color(255, 255, 255));
        lblProgreso.setText("Pregunta 1 de 100");
        getContentPane().add(lblProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 164, -1));

        lblNivel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(255, 255, 255));
        lblNivel.setText("Nivel: ");
        getContentPane().add(lblNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 164, -1));

        lblPregunta.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPregunta.setForeground(new java.awt.Color(255, 255, 255));
        lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPregunta.setText("Aquí aparecerá la pregunta");
        getContentPane().add(lblPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 650, 120));

        rbOpcion3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbOpcion3.setForeground(new java.awt.Color(255, 255, 255));
        rbOpcion3.setText("Opción 3");
        rbOpcion3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                rbOpcion3MouseMoved(evt);
            }
        });
        rbOpcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOpcion3ActionPerformed(evt);
            }
        });
        getContentPane().add(rbOpcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 270, 60));

        label_C.setForeground(new java.awt.Color(255, 255, 255));
        label_C.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_C.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                label_CMouseMoved(evt);
            }
        });
        label_C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_CMouseExited(evt);
            }
        });
        getContentPane().add(label_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 400, 360, 75));

        label_c_base.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/c_label.png"))); // NOI18N
        getContentPane().add(label_c_base, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 357, 75));

        btnSalir.setBackground(new java.awt.Color(255, 102, 102));
        btnSalir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, 240, -1));

        btnResponder.setBackground(new java.awt.Color(76, 175, 80));
        btnResponder.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnResponder.setForeground(new java.awt.Color(255, 255, 255));
        btnResponder.setText("Responder");
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });
        getContentPane().add(btnResponder, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 240, -1));

        label_dark.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_dark.setForeground(new java.awt.Color(255, 255, 255));
        label_dark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_dark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/night.jpg"))); // NOI18N
        getContentPane().add(label_dark, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 370, 80));

        label_dark1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_dark1.setForeground(new java.awt.Color(255, 255, 255));
        label_dark1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_dark1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/night.jpg"))); // NOI18N
        getContentPane().add(label_dark1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 370, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/banner1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 560));
        getContentPane().add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbOpcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOpcion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbOpcion1ActionPerformed

    private void rbOpcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOpcion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbOpcion2ActionPerformed

    private void rbOpcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOpcion3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbOpcion3ActionPerformed

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        // Verificar que se haya seleccionado una opción
        if (!rbOpcion1.isSelected() && !rbOpcion2.isSelected()
                && !rbOpcion3.isSelected()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor selecciona una respuesta",
                    "Respuesta requerida",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener la respuesta seleccionada
        int respuestaSeleccionada = -1;
        if (rbOpcion1.isSelected()) {
            respuestaSeleccionada = 0;
        } else if (rbOpcion2.isSelected()) {
            respuestaSeleccionada = 1;
        } else if (rbOpcion3.isSelected()) {
            respuestaSeleccionada = 2;
        }
//        else if (rbOpcion4.isSelected()) respuestaSeleccionada = 3;

        // Deshabilitar botón para evitar múltiples clics
        btnResponder.setEnabled(false);

        // Procesar la respuesta
        controlador.procesarRespuesta(respuestaSeleccionada);
    }//GEN-LAST:event_btnResponderActionPerformed

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

    private void label_AMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_AMouseMoved
        label_A.setIcon(new javax.swing.ImageIcon("images/a1b.png"));
//        String[] opciones = this.preguntaActual.getOpciones();
//        rbOpcion1.setText(opciones[0]);
//        text_A.setText(opciones[0]);
    }//GEN-LAST:event_label_AMouseMoved

    private void label_AMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_AMouseExited
        label_A.setIcon(null); // O puedes poner otra imagen
    }//GEN-LAST:event_label_AMouseExited

    private void rbOpcion1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbOpcion1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_rbOpcion1MouseExited

    private void rbOpcion1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbOpcion1MouseMoved
        // TODO add your handling code here:
        label_A.setIcon(new javax.swing.ImageIcon("images/a1b.png"));

    }//GEN-LAST:event_rbOpcion1MouseMoved

    private void label_BMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_BMouseMoved
        label_B.setIcon(new javax.swing.ImageIcon("images/b1b.png"));
    }//GEN-LAST:event_label_BMouseMoved

    private void label_BMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_BMouseExited
        label_B.setIcon(null); // O puedes poner otra imagen
    }//GEN-LAST:event_label_BMouseExited

    private void label_CMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_CMouseMoved
        label_C.setIcon(new javax.swing.ImageIcon("images/c1b.png"));
    }//GEN-LAST:event_label_CMouseMoved

    private void label_CMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_CMouseExited
        label_C.setIcon(null); // O puedes poner otra imagen
    }//GEN-LAST:event_label_CMouseExited

    private void rbOpcion2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbOpcion2MouseMoved
        label_B.setIcon(new javax.swing.ImageIcon("images/b1b.png"));
    }//GEN-LAST:event_rbOpcion2MouseMoved

    private void rbOpcion3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbOpcion3MouseMoved
        label_C.setIcon(new javax.swing.ImageIcon("images/c1b.png"));
    }//GEN-LAST:event_rbOpcion3MouseMoved

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
            java.util.logging.Logger.getLogger(JuegoTrivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoTrivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoTrivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoTrivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoTrivia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banner;
    private javax.swing.JButton btnResponder;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_A;
    private javax.swing.JLabel label_B;
    private javax.swing.JLabel label_C;
    private javax.swing.JLabel label_c_base;
    private javax.swing.JLabel label_dark;
    private javax.swing.JLabel label_dark1;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JLabel lblProgreso;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JRadioButton rbOpcion1;
    private javax.swing.JRadioButton rbOpcion2;
    private javax.swing.JRadioButton rbOpcion3;
    // End of variables declaration//GEN-END:variables
}
