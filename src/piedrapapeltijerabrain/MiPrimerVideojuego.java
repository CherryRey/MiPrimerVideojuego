/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


package piedrapapeltijerabrain;

import java.util.Scanner;

/**
 * Esta clase replica el tradicional juego "Piedra, papel o tijeras"  
 * por medio de 5 rondas mientras registra el tiempo y penaliza los fallos.
 * Se acumulan puntos en función de las victorias del jugador sobre el ordenador.
 * @author cherry

 * */
public class MiPrimerVideojuego {
        /**
        * El método main contiene TODA la logica del juego.
        * Comprende una serie de 5 rondas, entre el jugador y el ordenador.
        *Los fallos se contabilizan y se restan a los puntos finales.
        *Se contabiliza el tiempo y se muestra en pantalla.
        */
    public static void main(String[] args) {

        //Marcador de puntos: La variable chiquipuntos acumula los puntos totales de cada ronda
        int chiquipuntos = 0;
        
        //Variables que definen jugador y bot.
        Scanner sc = new Scanner(System.in);
        String opcionJugador = "";
        String opcionBot = "";
        
        //Variable que determina si el jugador tuvo éxito o no
        int exitoEnProposito = 1;
        
        //Inicio del contador del tiempo
        long inicio = System.currentTimeMillis();
        
        /*
        Rondas del juego por medio de un bucle for. 
        * La variable "propósito" es aleatoria y determina si el ordenador intenta ganar o perder.        
        */
        for (int i = 0; i < 5; i++) {
            
            int proposito = (int) Math.floor(Math.random() * 2 + 1);            
            if (proposito == 1) {
                System.out.println("\n\tIntenta ganar");
            }
            if (proposito == 2) {
                System.out.println("\n\tIntenta perder");
            }
            
            //De forma aleatoria, el ordenador establece si juega con tijera, papel o piedra a través de un condicional.
            int j = (int) Math.floor(Math.random() * 3 + 1);
            if (j == 1) {
                opcionBot = "tijera";
                System.out.println(opcionBot);
                tijera();
            }
            if (j == 2) {
                opcionBot = "papel";
                System.out.println(opcionBot);
                papel();
            }
            if (j == 3) {
                opcionBot = "piedra";
                System.out.println(opcionBot);
                piedra();
            }
            
            // El jugador introduce su jugada.
            do {
            System.out.println("Introduce tu jugada");
            opcionJugador = sc.nextLine();
            if (opcionBot.equals(opcionJugador)) {
            System.out.println("No tiene sentido que intentes empatar");
            }
            
            /* Compara las jugadas del jugador y del ordenador. 
            Establece si ganó o perdió la partida el jugador añadiendo el punto en la variable “chiquipuntos”
            */
            
            } while (opcionBot == opcionJugador);
            if (opcionJugador.equals("tijera") && (opcionBot.equals("papel"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("tijera") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("papel"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = 1;
            }
            // si el proposito era perder, multiplica con -1 para cambiar el signo
            if (proposito == 2) {
                exitoEnProposito *= -1;
            }
            //Si es ganar simplemente añade los puntos a “chiquipuntos” 
            if (exitoEnProposito == 1) {
                chiquipuntos++;
            }
        }
        
        //finaliza el contador de tiempo
        long fin = System.currentTimeMillis();
        
        //calcula el tiempo de la partida
        double tiempo = (double) ((fin - inicio) / 1000);
        System.out.println("Has realizado el ejercicio en " + tiempo + " segundos");
        
        //calcula los fallos y penalización
        int nFallos = 5 - chiquipuntos;
        System.out.println("Penalización: " + nFallos + " x 5s = " + nFallos * 5);
        
        //calcula el tiempo final en razón de los fallos.
        double tiempoFinal = tiempo + nFallos * 5;
        System.out.println("Tu tiempo final es de " + tiempoFinal + " segundos");
    }

    public static void tijera() {
        /**Imprime un código ASCII representandio la opción "tijera".
         */

        System.out.println("'''\n"
                + "    _______\n"
                + "---' ____)____\n"
                + "        ______)\n"
                + "     __________)\n"
                + "      (____)\n"
                + "---.__(___)\n"
                + "'''");
    }

    public static void papel() {
        /**Imprime un código ASCII representando la opción "papel".
         */
        System.out.println("'''\n"
                + "    _______\n"
                + "---' ____)____\n"
                + "        ______)\n"
                + "        _______)\n"
                + "       _______)\n"
                + "---.__________)");
    }

    public static void piedra() {
        /**Imprime un código ASCII representando la opción "piedra".
         */
        System.out.println("'''\n"
                + "    _______\n"
                + "---'   ____)\n"
                + "     (_____)\n"
                + "      (_____)\n"
                + "      (____)\n"
                + "---.__(___)\n"
                + "'''");
    }
}
