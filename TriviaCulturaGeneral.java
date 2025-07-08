package Controller;

//import java.util.Scanner;

public class ControllerMenu {

    private static Metodo.Menu Menu;
    public static void main(String[] args) {
        System.out.println("Bienvenido a la Trivia de Cultura General");
        Menu = new Metodo.Menu();
        // Mostrar menú de dificultad
        
       Menu.mostrarMenuDificultad();

        //Scanner scanner = new Scanner(System.in);
        //int nivel = scanner.nextInt();
        
    }
}
