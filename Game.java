/**
 * @author Juliana Pääkkönen juliana.paakkonen@tuni.fi
 * @version 2021.0310
 * @since 15.0.2
 */

 /**
 * Creates a new game.
 */
class Game {
    /**
     * Used to get input from player
     */
    AskUser input;
    /**
     * The length of one side of the game board
     */
    int boardSize;
    /**
     * The character playing the game
     */
    Character player;
    /**
     * Holds the statistics for the game
     */
    GameStats stats;
    /**
     * The game board
     */
    Board board;
    /**
     * Counts how many rounds it took to find all pairs
     */
    int tries;

    /**
     * Constructor of Game. Starts the game by calling method playGame.
     */
    public Game() {
        this.input = new AskUser();
        this.boardSize = setBoardSize();
        this.player = new Player(input.getInputStr("What's your name?"));
        this.board = new Board(boardSize);
        this.stats = new GameStats(boardSize);
        this.tries = 0;
        System.out.println();
        playGame();
        System.out.println("You found all the pairs!");
        System.out.println("It took you " + tries + " tries.");
    }

    /**
     * Sets the size of the game board.
     *
     * @return returns the size
     */
    int setBoardSize() {
        while(true) {
            String select = input.getInputStr("Choose board size S / L");
            try {
                if (!select.equals("S") && !select.equals("s")
                        && !select.equals("L") && !select.equals("l")) {
                    throw new IllegalSizeException("Invalid board size.");
                } else {
                    if(select.equals("S") || select.equals("s")) {
                        return 4;
                    } else if (select.equals("L") || select.equals("l")) {
                        return 6;
                    }
                }
            } catch (Exception m) {
                System.err.println("Invalid board size");
            }
        }
    }

    /**
     * Runs the game.
     */
    void playGame() {
        Card chosenCardOne = new Card();
        Card chosenCardTwo = new Card();
        while(stats.pairs > 0) {
            player.stats.printStats();
            stats.printStats();
            board.printBoard(3);
            chosenCardOne.cardNum = pickCard();
            board.turnCard(chosenCardOne);
            board.printBoard(3);

            chosenCardTwo.cardNum = pickCard();
            board.turnCard(chosenCardTwo);
            board.printBoard(3);

            board.checkIfPair(chosenCardOne.cardNum, chosenCardTwo.cardNum,
                            player, stats);
            tries++;
            input.getInputStr("Continue? (press enter)");
            System.out.println();
        }
    }

    /**
     * Asks user for a card and returns it.
     *
     * @return selected card number
     */
    int pickCard() {
        while(true) {
            int select = input.getInputInt("Pick a card 1-"
                                        + boardSize*boardSize);
            try {
                if(select < 1 || select > boardSize*boardSize) {
                    throw new IllegalCardException ("Invalid card");
                } else {
                    for (int i = 0; i < this.boardSize; i++) {
                        for (int j = 0; j < this.boardSize; j++) {
                            if(board.tempBoard[i][j].equals("" + select)) {
                                return select;
                            }
                        }
                    }
                    System.out.println("Pick a card that's not already picked");
                }
            } catch (Exception m) {
                System.err.println("Pick another one");
            }
        }
    }
}
