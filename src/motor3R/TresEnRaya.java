package motor3R;

import java.util.Random;

public class TresEnRaya {
   private char humano = 'o';
   private char maquina = 'x';

    private char[][] tablero = {
            {'_', '_','_'},
            {'_', '_','_'},
            {'_', '_','_'},
    };

    public char[][] getTablero(){
        return tablero;
    }

    public boolean jugar(int fila, int columna, char caracterJugador){
        fila = fila-1;
        columna = columna-1;

        char caracterMaquina;
        if (caracterJugador == 'x'){
            caracterMaquina = 'o';
        }
        else {caracterMaquina = 'x';}

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
        // itera sobre la matriz tablero
        int celdasLlenas = 0;
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                // si encuentra un caracter diferente a '_' retorna false
                if (getTablero()[i][j] != '_'){
                    celdasLlenas++;
                }
            }
        }
        if (celdasLlenas == 9){
            return false;
        }else {
            return true;
        }
    }

    public boolean hay3EnRaya(){
        return false;
    }
}
