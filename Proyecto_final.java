/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;

import java.util.Scanner;

/**
 *
 * @author le282
 */
public class Proyecto_final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        String[] preguntas = {
            "1. ¿Cuál es el país con más volcanes activos?\na) Japón\nb) Indonesia\nc) México",
            "2. ¿Quién fue el primer presidente de Estados Unidos?\na) Abraham Lincoln\nb) Thomas Jefferson\nc) George Washington",
            "3. ¿Qué animal pone los huevos más grandes del mundo?\na) Tortuga\nb) Avestruz\nc) Pingüino emperador",
            "4. ¿En qué continente está el desierto del Sahara?\na) Asia\nb) África\nc) América",
            "5. ¿Qué órgano del cuerpo humano produce la insulina?\na) Páncreas\nb) Hígado\nc) Riñón",
            "6. ¿Qué científico propuso la ley de la gravedad?\na) Galileo Galilei\nb) Isaac Newton\nc) Stephen Hawking",
            "7. ¿Qué país ganó el Mundial de Fútbol en 2010?\na) Alemania\nb) Argentina\nc) España",
            "8. ¿Cuál es el río más largo del mundo?\na) Amazonas\nb) Nilo\nc) Yangtsé",
            "9. ¿Cuál es la capital de Canadá?\na) Toronto\nb) Ottawa\nc) Montreal",
            "10. ¿Cuál es el símbolo químico del sodio?\na) S\nb) So\nc) Na",
            "11. ¿Qué país inventó el papel?\na) China\nb) Egipto\nc) Grecia",
            "12. ¿Qué día se celebra el Día de la Tierra?\na) 21 de marzo\nb) 22 de abril\nc) 5 de junio",
            "13. ¿Cuál es el planeta más cercano al Sol?\na) Venus\nb) Mercurio\nc) Marte",
            "14. ¿Qué compositor creó la Novena Sinfonía?\na) Mozart\nb) Beethoven\nc) Chopin",
            "15. ¿Cuántos corazones tiene un pulpo?\na) Uno\nb) Dos\nc) Tres"
        };

        char[] respuestasCorrectas = {'b', 'c', 'b', 'b', 'a', 'b', 'c', 'a', 'b', 'c', 'a', 'b', 'b', 'b', 'c'};

        int puntaje = 0;

        for (int i = 0; i < preguntas.length; i++) {
            System.out.println(preguntas[i]);
            System.out.print("Tu respuesta: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                System.out.println("Respuesta vacía. Se contará como incorrecta.\n");
                continue;
            }

            char respuesta = input.charAt(0);

            if (respuesta == respuestasCorrectas[i]) {
                puntaje++;
                System.out.println("¡Correcto!\n");
            } else {
                System.out.println("Incorrecto. La respuesta correcta era: " + respuestasCorrectas[i] + "\n");
            }
        }

        System.out.println("Tu puntaje final es: " + puntaje + " de " + preguntas.length);
        scanner.close();
    }
}

      
    

