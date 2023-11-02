package Ej9;

public class Tablero {
    private int dimension;
    private int[][] M;
    private boolean[][] X;

    public Tablero(int dimension)
    {
        this.dimension = dimension;
        this.M = new int[dimension][dimension];
        this.X = new boolean[dimension][dimension];
    }
    /**
     * @param i
     * @param j
     * @return
     * Método que recibe las coordenadas i y j del tablero y devuelve el valor almacenado en la matriz M en esas coordenadas. 
     * Es decir, obtiene el número o contenido de la casilla en la posición (i, j).
     */
    public int getPos(int i, int j)
    {
        return M[i][j];
    }
    /**
     * @param i
     * @param j
     * @return
     * Método que recibe las coordenadas i y j del tablero y verifica si la casilla en esas coordenadas ha sido "clickeada" o descubierta. 
     * Devuelve true si la casilla ha sido clickeada y false en caso contrario.
     */
    public boolean esClic(int i, int j)
    {
        return X[i][j];
    }
    /**
     * @param i
     * @param j
     * @return
     * Método que recibe las coordenadas i y j del tablero y cambia el estado de clic de la casilla en esas coordenadas. 
     * Si la casilla estaba "clickeada", se vuelve a "no clickeada", y viceversa.
     */
    public void clic(int i, int j)
    {
        X[i][j] = !X[i][j];
    }
    /**
     * @return
     * Método que devuelve el tamaño (dimension) del tablero, que se estableció en el constructor cuando se creó la instancia de la clase.
     */
    public int getDimension()
    {
        return dimension;
    }
    /**
     * @return
     * Método que verifica si todas las casillas del tablero han sido "clickeadas". Recorre todas las casillas en la matriz X y cuenta cuántas están clickeadas. 
     * Si el número de casillas clickeadas es igual al número total de casillas en el tablero, devuelve true, indicando que el tablero está completo; de lo contrario, devuelve false.
     */
    public boolean esCompleto()
    {
        int c = 0;
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                if(X[i][j])
                    c++;
            }
        }
        if(c == dimension * dimension)
            return true;
        return false;
    }
    /**
     * Este método se encarga de generar un tablero aleatorio 4x4 con números y posiciones aleatorias. 
     * Primero crea un arreglo numeros con los números del 1 al 8 (en un tablero 4x4, necesitas 8 pares de números). 
     * Luego, llena la matriz M con estos números en orden y realiza un intercambio aleatorio de los valores para desordenar el tablero. 
     * Finalmente, tendrás un tablero con números aleatorios dispuestos en parejas.
     */
    public void generarTableroAleatorio() {
        int maxNumber = (dimension * dimension) / 2;
        int[] numeros = new int[maxNumber * 2];
        for (int i = 1; i <= maxNumber * 2; i++) {
            numeros[i - 1] = i;
        }

        int g = 1;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                M[i][j] = g++;
                if (g > maxNumber)
                    g = 1;
            }
        }
        // Intercambia los valores de la matriz aleatoriamente
        int x, y;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                x = (int) (Math.random() * dimension);
                y = (int) (Math.random() * dimension);
                int aux = M[i][j];
                M[i][j] = M[x][y];
                M[x][y] = aux;
            }
        }
    }

}