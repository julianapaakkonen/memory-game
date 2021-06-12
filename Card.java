/**
 * @author Juliana Pääkkönen juliana.paakkonen@tuni.fi
 * @version 2021.0310
 * @since 15.0.2
 */

/**
 * Creates a card for game board.
 */
class Card {
    /**
     * The "side" that shows the number of the card
     */
    int cardNum;
    /**
     * The "side" that shows the picture of the card
     */
    String cardPic;

    /**
     * Constructor of Card without parameters.
    */
    public Card() {}

    /**
     * Constructor of Card with parameters.
     *
     * @param cards number for card
     * @param cardPic picture for card
     */
    public Card(int cards, String cardPic) {
        this.cardNum = cards;
        this.cardPic = cardPic;
    }
}
