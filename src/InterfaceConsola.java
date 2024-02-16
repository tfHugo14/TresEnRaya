import motor3R.TresEnRaya;

import java.util.Scanner;

public class InterfaceConsola {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InterfaceConsola ic = new InterfaceConsola();
        TresEnRaya tresEnRaya = new TresEnRaya();

        System.out.println(
                "Hola, este es el juego del tres en raya! \n " +
                "para ganar debes conseguir que el caracter de tu elección : [o] o [x] \n" +
                "formen una raya de 3 bien horizontal, vertical o diagonal\n" +
                "este es el tablero en el que estarás jugando: "
        );

        ic.printTablero(tresEnRaya);

        System.out.println("escoje el caracter con el que quieres jugar [o] o [x]: ");
    }
    public void printTablero(TresEnRaya tresEnRaya){
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                System.out.print(' ');
                if (j == 1) {
                    System.out.print("| ");
                    System.out.print(tresEnRaya.getTablero()[i][j]);
                    System.out.print(" |");
                } else {
                    System.out.print(tresEnRaya.getTablero()[i][j]);
                }
            }
            System.out.println();
        }
    }
}
