package cisc181.lab_6;

/**
 * a class to set pieces server for game
 */
public class GamePiece {
    public static final char EMPTY = 'E';   //a public constant
    private char symbol = 'X';

    /**
     * a constructor that accepts one parameter and sets the symbol
     * @param symbol a char to set 'symbol'
     */
    public GamePiece(char symbol) {
        this.symbol = symbol;
    }

    /**
     * an accessor to  get symbol
     * @return char symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * an accessor to get if symbol is empty
     * @return boolean that whether symbol= E
     */
    public boolean isEmpty() {
        return symbol == EMPTY;
    }

    /**
     * Override the toString method to represent this object as the value of symbol
     * @return reserve 'symbol' to String
     */
    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    /**
     * Override the equals method to return true if the symbol’s match
     * @param obj another GamePiece object
     * @return if these two are equal
     */
    @Override
    public boolean equals(Object obj) {
        GamePiece gamePiece = (GamePiece) obj;
        return this.symbol == gamePiece.symbol;
    }

}
