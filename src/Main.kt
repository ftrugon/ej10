/**
 * Clase que representa el tablero de juego del Tres en Línea.
 */
class Tablero {
    // La propia array crea el tablero
    private val tablero = Array(3) { Array(3) { ' ' } }

    /**
     * imprime por pantalla el tablero
     */
    fun imptabl() {
        for (i in 0..2) {
            for (j in 0..2) {
                print("${tablero[i][j]} ")
            }
            println()
        }
    }

    /**
     * El jugador pone una ficha en el tablero
     * @param fila el numero de fila
     * @param columna el numero de la columna
     * @param jugador el jugador al que le toca, X o O
     */
    fun mov(fila: Int, columna: Int, jugador: Char): Boolean {
        if (fila in 0..2 && columna in 0..2 && tablero[fila][columna] == ' ') {
            tablero[fila][columna] = jugador
            return true
        }
        return false
    }

    /**
     * Comprueba si alguien gana
     * @return true o false si alguien a ganado o no
     */
    fun gana(): Boolean {
        // Verificar filas y columnas
        for (i in 0..2) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != ' ') {
                return true
            }
            if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != ' ') {
                return true
            }
        }

        // Verificar diagonales
        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != ' ') {
            return true
        }
        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != ' ') {
            return true
        }

        return false
    }
}

/**
 * La funcion principal donde se ejecuta todo el juego
 */
fun main() {
    val tablero = Tablero()
    var jugadorActual = 'X'
    var turno = 0
    do {


        println("Turno del jugador $jugadorActual")
        tablero.imptabl()

        var fila: Int
        var columna: Int

        do {
            println("Ingrese fila (0-2): ")
            fila = readln().toIntOrNull() ?: -1

            println("Ingrese columna (0-2): ")
            columna = readln().toIntOrNull() ?: -1

        } while (!tablero.mov(fila, columna, jugadorActual))

        val ganador = tablero.gana()
        if (ganador) {
            println("¡El jugador $jugadorActual ha ganado!")
            break
        }
        if (turno == 8){
            println("Empate, se acaba la partida")
            break
        }
        turno += 1
        jugadorActual = if (jugadorActual == 'X') 'O' else 'X'

    }while (true)

    println("Fin del juego.")
}
