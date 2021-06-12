import java.io.Console;

/**
 * @author Juliana Pääkkönen juliana.paakkonen@tuni.fi
 * @version 2021.0310
 * @since 15.0.2
 */

 /**
 * Gets input from the player.
 */
class AskUser {
    /**
     * Receives input from user
     */
    Console input = System.console();

    /**
     * Gets (int) input from user.
     *
     * @param question string that is printed before getting the input
     * @return user input converted to integer
     * @throws NumberFormatException if input cannot be converted to integer
     */
    int getInputInt(String question) throws NumberFormatException {
        while(true) {
            System.out.print(question + ": ");
            try {
                int num = Integer.parseInt(input.readLine());
                if (num > 0 && num < 99) {
                    return num;
                }
            } catch (NumberFormatException nfe) {
                System.err.println("That's not a number");
            }
        }
    }

    /**
     * Gets (string) input from user.
     *
     * @param question string that is printed before getting the input
     * @return user input as string
     */
    String getInputStr(String question) {
        System.out.print(question + ": ");
        return input.readLine();
    }
}
