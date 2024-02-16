import motor3R.TresEnRaya;

import java.util.Scanner;

public class InterfaceConsola {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InterfaceConsola ic = new InterfaceConsola();
        TresEnRaya tresEnRaya = new TresEnRaya();
        String verde = "\u001B[32m";
        String violeta = "\u001B[35m";
        String reset = "\u001B[0m";

        System.out.println(
                "Bienvendo, esto es el juego del tres en raya!\n" +
                "Para ganar debes conseguir que el caracter de tu elección: ["+verde+"o"+reset+"] o ["+violeta+"x"+reset+"] \n" +
                "Formen una raya de 3 bien horizontal, vertical o diagonalmente.\n" +
                "Este es el tablero en el que estarás jugando: "
        );

        ic.printTablero(tresEnRaya);

        System.out.println("Escoje el caracter con el que quieres jugar ["+verde+"o"+reset+"] o ["+violeta+"x"+reset+"]: ");
        char caracterJugador = input.next().charAt(0);
        if (caracterJugador == 'o' || caracterJugador == 'x'){
            System.out.println("Bien, estarás jugando contra la maquina buena suerte!");

            for (int i = 0; i<9; i++) {
                System.out.println("Esta es la apariencia actual del tablero:");
                System.out.println("Elige la fila en la que quieres poner tu marca [1-3]");
                int filaAMarcar = input.nextInt();
                System.out.println("Bien, ahora en que celda [1-3] (de izquierda a derecha) quieres poner tu marca?");
                int columnaAMarcar = input.nextInt();
                tresEnRaya.jugar(filaAMarcar, columnaAMarcar, caracterJugador);
                ic.printTablero(tresEnRaya);
            }
        }else {
            System.out.println("Introdujiste un caracter invalido, cerrando aplicación...");
        }
    }
    public void printTablero(TresEnRaya tresEnRaya){
        String verde = "\u001B[32m";
        String rojo = "\u001B[31m";
        String violeta = "\u001B[35m";
        String reset = "\u001B[0m";
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                System.out.print(' ');
                if (j == 1) {
                    System.out.print("| ");
                    if (tresEnRaya.getTablero()[i][j] == 'o')
                        System.out.print(verde+tresEnRaya.getTablero()[i][j]+reset);
                    else if (tresEnRaya.getTablero()[i][j] == 'x')
                        System.out.print(violeta+tresEnRaya.getTablero()[i][j]+reset);
                    else
                        System.out.print(rojo+tresEnRaya.getTablero()[i][j]+reset);
                    System.out.print(" |");
                } else {
                    if (tresEnRaya.getTablero()[i][j] == 'o')
                        System.out.print(verde+tresEnRaya.getTablero()[i][j]+reset);
                    else if (tresEnRaya.getTablero()[i][j] == 'x')
                        System.out.print(violeta+tresEnRaya.getTablero()[i][j]+reset);
                    else
                        System.out.print(rojo+tresEnRaya.getTablero()[i][j]+reset);
                }
            }
            System.out.println();
        }
    }
}
