import java.util.*;

/**
 * @author Juliana Pääkkönen juliana.paakkonen@tuni.fi
 * @version 2021.0310
 * @since 15.0.2
 */

/**
 * Creates game board.
 */
class Board {
    /**
     * The amount of cards created (also used to number the cards)
     */
    int cards = 0;
    /**
     * The length of one side of the game board
     */
    int boardSize;
    /**
     * The first chosen card
     */
    String currCardOne;
    /**
     * The second chosen card
     */
    String currCardTwo;
    /**
     * The actual game board that holds all the cards
     */
    Card[][] gameBoard;
    /**
     * One version of the board that shows currently chosen cards' picture
     * sides (also used when printing the board)
     */
    String[][] tempBoard;
    /**
     * Stores the current board before new cards are chosen
     */
    String[][] currBoard;
    /**
     * Holds a list with all possible card pictures
     */
    List<String> list;
    /**
     * Used to create new list of card pictures
     */
    CardList cardList = new CardList();

    /**
     * Constructor of Board.
     *
     * @param boardSize length of one side the board
     */
    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.gameBoard = new Card[boardSize][boardSize];
        this.list = cardList.createCardList(boardSize);
        this.createBoard();
        this.tempBoard = new String[boardSize][boardSize];
        this.createTempBoard();
        this.currBoard = new String[boardSize][boardSize];
        this.copyArray(tempBoard, currBoard);
    }

    /**
     * Reveals chosen card on the board.
     *
     * @param chosenCard card that the player has chosen
     */
    void turnCard(Card chosenCard) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (gameBoard[i][j].cardNum == chosenCard.cardNum) {
                    tempBoard[i][j] = gameBoard[i][j].cardPic;
                    chosenCard.cardPic = gameBoard[i][j].cardPic;
                    System.out.println("It's " + gameBoard[i][j].cardPic);
                }
            }
        }
    }

    /**
     * Checks if two chosen cards are a pair.
     *
     * @param chosenCardOne first chosen card
     * @param chosenCardTwo second chosen card
     * @param character character that chose the cards
     * @param stats statistics of current game
     */
    void checkIfPair(int chosenCardOne, int chosenCardTwo, Character character,
            Stats stats) {
        System.out.print(chosenCardOne + " and " + chosenCardTwo);
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (gameBoard[i][j].cardNum == chosenCardOne) {
                    currCardOne = gameBoard[i][j].cardPic;
                }
            }
        }
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (gameBoard[i][j].cardNum == chosenCardTwo) {
                    currCardTwo = gameBoard[i][j].cardPic;
                }
            }
        }
        if(currCardOne.equals(currCardTwo)){
            pairFound(character, stats);
        } else {
            pairNotFound();
        }
    }

    /**
     * Updates statistics and game board if a pair is found.
     *
     * @param character character that chose the cards
     * @param stats statistics of the current game
     */
    void pairFound(Character character, Stats stats) {
        System.out.println(" are a pair!");
        copyArray(tempBoard, currBoard);
        character.stats.setStats();
        stats.setStats();
    }

    /**
     * Updates game board if a pair is not found.
     */
    void pairNotFound() {
        System.out.println(" are not a pair...");
        copyArray(currBoard, tempBoard);
    }

    /**
     * Creates game board when a new game starts.
     */
    void createBoard() {
        for (int m = 0; m < this.boardSize; m++) {
            for (int n = 0; n < this.boardSize; n++) {
                this.cards++;
                Card card = new Card(this.cards, list.get(cards - 1));
                this.gameBoard[m][n] = card;
            }
        }
    }

    /**
     * Creates temporary board that shows cards that are chosen at the moment.
     */
    void createTempBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int cardNumTemp = gameBoard[i][j].cardNum;
                String cardNumStr = "" + cardNumTemp;
                tempBoard[i][j] = cardNumStr;
            }
        }
    }

    /**
     * Copies one array to another.
     *
     * @param copyFrom array that is being copied from
     * @param copyTo array that is being copied to
     */
    void copyArray(String[][] copyFrom, String[][] copyTo) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                copyTo[i][j] = copyFrom[i][j];
            }
        }
    }

    /**
     * Prints board.
     *
     * @param select determines which version of the board is being printed
     * 1 = the board that shows card numbers (should not be used unless
     * program does not operate like it should)
     * 2 = the board that shows card pictures (should not be used unless
     * program does not operate like it should)
     * 3 = temporary board with chosen card(s) shown (recommended option)
     * 4 = current board with found pairs shown (should not be used unless
     * program does not operate like it should)
     */
    void printBoard(int select) {
        for (int m = 0; m < boardSize; m++) {
            System.out.printf("%1s%5s", " ", "-----");
        }
        System.out.print("\n");
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                if (select == 1) {
                    System.out.printf("%2s%2d%2s", "|", gameBoard[i][j].cardNum,
                                    "|");
                } else if (select == 2) {
                    System.out.printf("%2s%2s%2s", "|", gameBoard[i][j].cardPic,
                                    "|");
                } else if (select == 3) {
                    System.out.printf("%2s%2s%2s", "|", tempBoard[i][j], "|");
                } else if (select == 4) {
                    System.out.printf("%2s%2s%2s", "|", currBoard[i][j], "|");
                }
            }
            System.out.print("\n");
            for (int m = 0; m < boardSize; m++) {
                System.out.printf("%1s%5s", " ", "-----");
            }
            System.out.print("\n");
        }
    }
}
