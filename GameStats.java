/**
 * @author Juliana Pääkkönen juliana.paakkonen@tuni.fi
 * @version 2021.0310
 * @since 15.0.2
 */

 /**
 * Creates statistics for the game.
 */
class GameStats implements Stats {
    /**
     * Tracks how many pairs are left
     */
    int pairs;

    /**
     * Constructor of GameStats.
     *
     * @param boardSize length of one side of the board
     */
    public GameStats (int boardSize) {
        this.pairs = boardSize*boardSize/2;
    }

    /**
     * Sets statistics for the game.
     */
    public void setStats() {
        this.pairs--;
    }

    /**
     * Prints statistics.
     */
    public void printStats() {
        System.out.println("There are " + pairs + " pairs left.");
    }
}
