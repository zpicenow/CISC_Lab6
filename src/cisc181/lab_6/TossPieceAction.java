package cisc181.lab_6;

/**
 *  a class called TossPieceAction server for game
 *  This action is different from the PlacePieceAction in that when a player tosses a piece –
 *  that spot on the board will be updated with the new piece even if its not an empty spot.
 */
public class TossPieceAction implements Action<TicTacToeTypeGame>{
    private int row;
    private int column;
    private char player;


    /**
     * a constructor that accepts the player, the row and the column in this order and sets these properties.
     * @param player player
     * @param row row number
     * @param column column number
     */
    public TossPieceAction(char player, int row, int column) {
        this.player = player;
        this.row = row;
        this.column = column;
    }

    /**
     * getter for player
     * @return player
     */
    public char getPlayer() {
        return player;
    }

    /**
     * getter for row number
     * @return row number
     */
    public int getRow() {
        return row;
    }

    /**
     * getter for column number
     * @return column number
     */
    public int getColumn() {
        return column;
    }

    /**
     * accepts TicTacToeTypeGame and returns true if given the current game:
     * @param game a TicTacToeTypeGame object
     * @return it is this player’s turn;the PlacePieceAction’s row and column are in bounds
     */
    @Override
    public boolean isValid(TicTacToeTypeGame game) {
        return game.getTurnSymbol() == player && game.getGameBoard().isInBounds(row, column);
    }
    /**
     * accepts TicTacToeTypeGame and sets the GamePiece on the board for this PlacePieceAction and sets the turn to the next player.
     * @param game a TicTacToeTypeGame object
     */
    @Override
    public void update(TicTacToeTypeGame game) {
        GamePiece gamePiece = new GamePiece(player);
        game.setPiece(row, column, gamePiece);


        game.changeTurn();

    }

    /**
     * Override the toString method to a String that includes the action of placing this symbol at this row and column
     * @return placing this symbol at this row and column
     */
    @Override
    public String toString() {
        return "place " + player + " at row " + row + " col " + column;
    }
}
