/**
 * @author Juliana Pääkkönen juliana.paakkonen@tuni.fi
 * @version 2021.0310
 * @since 15.0.2
 */

 /**
 * Creates exception for invalid game board size selection.
 */
class IllegalSizeException extends Exception {

    /**
     * Exception for invalid game board size selection.
     *
     * @param errorMessage custom error message
     */
    public IllegalSizeException(String errorMessage) {
        super(errorMessage);
    }
}
