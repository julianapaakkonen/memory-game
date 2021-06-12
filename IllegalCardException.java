/**
 * @author Juliana Pääkkönen juliana.paakkonen@tuni.fi
 * @version 2021.0310
 * @since 15.0.2
 */

 /**
 * Creates exception for invalid card selection.
 */
class IllegalCardException extends Exception {

    /**
     * Exception for invalid card selection.
     *
     * @param errorMessage custom error message
     */
    public IllegalCardException(String errorMessage) {
        super(errorMessage);
    }
}
