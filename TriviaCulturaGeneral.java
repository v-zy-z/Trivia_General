import java.util.Scanner;

public class TriviaCulturaGeneral {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== TRIVIA DE CULTURA GENERAL ===");
            System.out.println("1. Nivel Facil");
            System.out.println("2. Nivel Intermedio");
            System.out.println("3. Nivel Dificil");
            System.out.println("4. Salir");
            System.out.print("Seleccione el nivel que desea jugar: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    nivelFacil(sc);
                    break;
                case 2:
                    nivelIntermedio(sc);
                    break;
                case 3:
                    nivelDificil(sc);
                    break;
                case 4:
                    System.out.println("Gracias por jugar. Hasta pronto.");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
            }

        } while (opcion != 4);

        sc.close();
    }

    // --- NIVEL FACIL ---
    private static void nivelFacil(Scanner sc) {
        System.out.println("\n--- Nivel Facil ---");

        System.out.println("Pregunta 1: Cual es la capital de Francia");
        System.out.println("a) Londres\nb) Paris\nc) Roma");
        String respuesta = sc.next().toLowerCase();

        if (respuesta.equals("b")) {
            System.out.println("¡Correcto! La respuesta es Paris.\n");
        } else {
            System.out.println("Incorrecto. La respuesta correcta es 'b) Paris'.\n");
        }
    }

    // --- NIVEL INTERMEDIO ---
    private static void nivelIntermedio(Scanner sc) {
        System.out.println("\n--- Nivel Intermedio ---");

        System.out.println("Pregunta 1: En que año comenzo la Segunda Guerra Mundial");
        System.out.println("a) 1935\nb) 1939\nc) 1941");
        String respuesta = sc.next().toLowerCase();

        if (respuesta.equals("b")) {
            System.out.println("Correcto, Comenzo en 1939.\n");
        } else {
            System.out.println("Incorrecto. La respuesta correcta es 'b') 1939'.\n");
        }
    }

    // --- NIVEL DIFICIL ---
    private static void nivelDificil(Scanner sc) {
        System.out.println("\n--- Nivel Dificil ---");

        System.out.println("Pregunta 1: Quien escribio 'La Odisea'");
        System.out.println("a) Platon\nb) Socrates\nc) Homero");
        String respuesta = sc.next().toLowerCase();

        if (respuesta.equals("c")) {
            System.out.println("Correcto, Fue escrita por Homero.\n");
        } else {
            System.out.println("Incorrecto. La respuesta correcta es 'c) Homero'.\n");
        }
    }
}