package main;


import view.MenuPrincipal;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    
    public static void main(String[] args) {
        // Configurar Look and Feel del sistema
        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            // Si no se puede establecer, usar el por defecto
            System.out.println("No se pudo establecer el Look and Feel del sistema");
        }
        
        // Ejecutar la aplicación en el Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crear y mostrar el menú principal
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
                
                System.out.println("JUEGO DE TRIVIA INICIADO");
                System.out.println("Estructura MVC implementada correctamente:");
                System.out.println("Los puntajes se guardan en: datos_juego/jugadores.dat");
            }
        });
    }
}