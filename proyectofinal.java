/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal;

import java.util.Scanner;

/**
 *
 * @author ASUS TUF GAMING
 */
public class proyectofinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String[] preguntas = {
           "1.  ¿cual es la capital de canada?\na)Ottawa\nb)Toronto\nc)Vancouver)",
           "2.	¿Quién escribió Cien años de soledad?\na)Mario Vargas Llosa\nb)Gabriel García Márquez\nc)Jorge Luis Borges",
           "3.	¿Qué país tiene el mayor número de habitantes en el mundo?\na)Estados Unidos\nb)India\nc)China",
           "4.  ¿Cuál es el río más largo del mundo?\na)Amazonas\nb)Nilo\nc)Yangtsé",
           "5.  ¿Quien pinto Germica ?\na)salvador dali\nd)Pablo Picaso\nc)Diego velazquez",
           "6.  ¿Cuál es el metal más ligero?\na)Aluminio\nb)Litio\nc)Mercurio",
           "7.  ¿Quién descubrió la penicilina?\na)Louis Pasteur\nb)Alexander Fleming\nc)Robert Koch",
           "8.  ¿En qué año comenzó la Segunda Guerra Mundial?\na)1935\nb)1939\nc)1941",
           "9.  ¿Cuál es la capital de Australia?\na)Sídney\nb)Melbourne\nc)Canberra",
           "10. ¿que sientifico formulo las leyes del movimiento?\na)Newton\nb)Galileo\nc)Einstin",
           "11. ¿Cual es el oceano mas grande del mundo?\na)Atlantico\nb)Indico\nc)Pacifico",
           "12. ¿Quien es el autor de Crimen y Castigo\na)Lev Tosloi\nb)Fiodor dostoyeveski\nc)Anton Chenjov",
        };

        char[] respuestasCorrectas = {'a','b','c','a','b','b','b','b','c','a','c','b'};

        int puntaje = 0;

        for (int i = 0; i < preguntas.length; i++) {
            System.out.println(preguntas[i]);
            System.out.print("Tu respuesta: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                System.out.println("Respuesta vacía. es incorrecta.\n");
                continue;
            }

            char respuesta = input.charAt(0);

            if (respuesta == respuestasCorrectas[i]) {
                puntaje++;
                System.out.println("¡Correcto!\n");
            } else {
                System.out.println("Incorrecto. La respuesta correcta es: " + respuestasCorrectas[i] + "\n");
            }
        }

        System.out.println("el puntaje final es: " + puntaje + " de " + preguntas.length);
        scanner.close();
    }
}


        
        
