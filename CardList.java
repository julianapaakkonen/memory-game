import java.util.*;

/**
 * @author Juliana Pääkkönen juliana.paakkonen@tuni.fi
 * @version 2021.0310
 * @since 15.0.2
 */

/**
 * Creates new list of card pictures
 */
class CardList {
    /**
     * Creates list of card pictures according to the size of game board.
     *
     * @param boardSize the length of one side of the game board
     */
    List<String> createCardList (int boardSize) {
        List<String> list = new ArrayList<String>(boardSize*boardSize);
        Collections.addAll(list,"%","%","&","&","!","!","$","$","#","#","@",
                            "@","+","+","?","?");
        if(boardSize == 6) {
            Collections.addAll(list,"-","-","=","=","/","/","^","^","_","_",
                            ".",".","*","*","~","~",";",";","<","<");
        }
        Collections.shuffle(list);
        return list;
    }
}
