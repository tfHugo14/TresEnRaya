package motor3R;

import java.util.Arrays;
import java.util.Random;

public class TresEnRaya {
    private char[][] tablero = {
            {'_', '_','_'},
            {'_', '_','_'},
            {'_', '_','_'},
    };

    public char[][] getTablero(){
        return tablero;
    }

    public boolean jugar(int fila, int columna, char caracterJugador){
        //try catch si fila o columna son mayores que 2
        fila = fila-1;
        columna = columna-1;

        if (fila > 3 || columna > 3){
            return false;
        }



        char caracterMaquina;
        if (caracterJugador == 'x')
            caracterMaquina = 'o';
        else
            caracterMaquina = 'x';

        if (getTablero()[fila][columna] == caracterJugador || getTablero()[fila][columna] == caracterMaquina){
            return false;
        }

        getTablero()[fila][columna] = caracterJugador;
        movimientoMaquina(caracterMaquina);

        return true;
    }

    public void movimientoMaquina(char caracterMaquina){
        Random random = new Random();

        if (!tableroVacio()){
            return;
        }

        while (true) {
            int fila = random.nextInt(3);
            int columna = random.nextInt(3);

            if (getTablero()[fila][columna] == '_') {
                getTablero()[fila][columna] = caracterMaquina;
                break;
            }
        }
    }

    public boolean tableroVacio(){
        int celdasLlenas = 0;
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                if (getTablero()[i][j] != '_'){
                    celdasLlenas++;
                }
            }
        }
        if (celdasLlenas == 9){ // la matriz está llena, se termina el juego
            return false;
        }else {
            return true;
        }
    }

    public String hay3EnRaya(char caracterJugador){
        char caracterMaquina;
        if (caracterJugador == 'x')
            caracterMaquina = 'o';
        else
            caracterMaquina = 'x';

        char[] rayaMaquina = {caracterMaquina, caracterMaquina, caracterMaquina};
        char[] rayaJugador = {caracterJugador, caracterJugador, caracterJugador};

        char[] diagonalPrincipal = {getTablero()[0][0], getTablero()[1][1], getTablero()[2][2]};
        char[] diagonalSecundaria = {getTablero()[0][2], getTablero()[1][1], getTablero()[2][0]};

        char[] fila1 = {getTablero()[0][0], getTablero()[0][1], getTablero()[0][2]};
        char[] fila2 = {getTablero()[1][0], getTablero()[1][1], getTablero()[1][2]};
        char[] fila3 = {getTablero()[2][0], getTablero()[2][1], getTablero()[2][2]};

        char[] columna1 = {getTablero()[0][0], getTablero()[1][0], getTablero()[2][0]};
        char[] columna2 = {getTablero()[0][1], getTablero()[1][1], getTablero()[2][1]};
        char[] columna3 = {getTablero()[0][2], getTablero()[1][2], getTablero()[2][2]};


        // comprueba si ganó el jugador
        if (Arrays.equals(diagonalPrincipal, rayaJugador) || Arrays.equals(diagonalSecundaria, rayaJugador)){
            return "Jugador";
        }
        if (Arrays.equals(fila1, rayaJugador)  || Arrays.equals(fila2, rayaJugador) || Arrays.equals(fila3, rayaJugador) ){
            return "Jugador";
        }
        if (Arrays.equals(columna1, rayaJugador) || Arrays.equals(columna2, rayaJugador)  || Arrays.equals(columna3, rayaJugador) ){
            return "Jugador";
        }

        // comprueba si ganó la maquina
        if (Arrays.equals(diagonalPrincipal, rayaMaquina) || Arrays.equals(diagonalSecundaria, rayaMaquina)){
            return "Maquina";
        }
        if (Arrays.equals(fila1, rayaMaquina)  || Arrays.equals(fila2, rayaMaquina) || Arrays.equals(fila3, rayaMaquina) ){
            return "Maquina";
        }
        if (Arrays.equals(columna1, rayaMaquina) || Arrays.equals(columna2, rayaMaquina)  || Arrays.equals(columna3, rayaMaquina) ){
            return "Maquina";
        }

        return "";
    }
}
