package motor3R;
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

    public void jugar(int fila, int columa, char caracterJugador){
        fila = fila-1;
        columa = columa-1;
        getTablero()[fila][columa] = caracterJugador;
    }
}
