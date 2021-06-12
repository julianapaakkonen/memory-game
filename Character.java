/**
 * @author Juliana Pääkkönen juliana.paakkonen@tuni.fi
 * @version 2021.0310
 * @since 15.0.2
 */

 /**
 * Creates character.
 */
abstract class Character {
    /**
     * The name of the character
     */
    String name;
    /**
     * An object with statistics for the character
     */
    CharStats stats;

    /**
     * Constructor of Character.
     *
     * @param name name for character
     */
    public Character(String name) {
        this.name = name;
        this.stats = new CharStats(name);
    }
}
