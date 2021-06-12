/**
 * @author Juliana Pääkkönen juliana.paakkonen@tuni.fi
 * @version 2021.0310
 * @since 15.0.2
 */

 /**
 * Creates statistics for character.
 */
class CharStats implements Stats {
    /**
     * Tracks how many pairs character has found
     */
    int pairs;
    /**
     * The name of the character
     */
    String name;

    /**
     * Constructor of CharStats.
     * @param name name of character
     */
    public CharStats (String name) {
        this.pairs = 0;
        this.name = name;
    }

    /**
     * Sets statistics for the character.
     */
    public void setStats() {
        this.pairs++;
    }

    /**
     * Prints statistics.
     */
    public void printStats() {
        System.out.println(name + " has found " + pairs + " pairs.");
    }
}
