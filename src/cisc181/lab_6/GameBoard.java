package cisc181.lab_6;

/**
 * a class to describe board in game
 */
public class GameBoard {
    private GamePiece[][] board;    // a 2D array that can hold GamePiece objects

    /**
     * a constructor that accepts one parameter
     * @param board a 2D array of GamePiece objects
     */
    public GameBoard(GamePiece[][] board) {
        this.board = board;
    }

    /**
     * an accessor to get board
     * @return a 2D array -- board
     */
    public GamePiece[][] getBoard() {
        return board;
    }

    /**
     * returns the GamePiece that is in that location of the GameBoard.
     *
     * @param row    row num in 2D array
     * @param column column num in 2D array
     * @return a GamePiece in the location
     */
    public GamePiece getPiece(int row, int column) {
        try {

            return board[row][column];
        } catch (Exception e) {
            System.out.println("Not a right index");
            return null;
        }
    }

    /**
     * place gamePiece in specified location on the board
     * @param row row num to place
     * @param column column num to place
     * @param gamePiece a gamePiece to be placed
     */
    public void setPiece(int row, int column, GamePiece gamePiece) {
        try {
            board[row][column] = gamePiece;
        } catch (Exception e) {
            System.out.println("Not a right index");
        }
    }

    /**
     * whether  there is an empty space on the board
     * @return true that there has empty
     *          false that there do not have
     */
    public boolean hasEmptySpace() {
        for (GamePiece[] gamePieces :
                board) {
            for (GamePiece gamePiece :
                    gamePieces) {
                if (gamePiece.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * if the position within the boundaries of the board
     * @param row row num
     * @param column column num
     * @return true if within
     *          false if not in
     */
    public boolean isInBounds(int row, int column) {
        return (row < board.length  && row >= 0 && column < board[0].length && column >= 0);

    }

    /**
     * prints a visual representation of the symbol
     */
    public void printBoard() {

        for (GamePiece[] gamePieces :
                board) {
            boolean flag = false;       //to print space between symbol
            for (GamePiece gamePiece :
                    gamePieces) {
                if (flag) {
                    System.out.print(" ");

                } else {
                    flag = true;
                }
                System.out.print(gamePiece);
            }
            System.out.println();
        }
    }

    /**
     * count the specific range number of symbol
     * @param startRow start row position
     * @param startCol start column position
     * @param deltaRow step of row each move
     * @param deltaCol step of col each move
     * @param symbol char to match
     * @return number of symbol
     */
    public int getNumConsec(int startRow, int startCol, int deltaRow, int deltaCol, char symbol) {
        int cnt = 0;

        int tempRow = startRow-deltaRow;
        int tempCol = startCol-deltaCol;
        while (isInBounds(startRow, startCol)) {
            if (board[startRow][startCol].getSymbol() == symbol) {
                cnt++;
            }
            startRow += deltaRow;
            startCol += deltaCol;
        }
        while (isInBounds(tempRow, tempCol)) {
            if (board[tempRow][tempCol].getSymbol() == symbol) {
                cnt++;
            }
            tempRow -= deltaRow;
            tempCol -= deltaCol;
        }
        return cnt;

    }

    public int getMaxConsec(char symbol) {
        int maxV = 0,temp;
        for (int i = 0; i < board.length; i++) {
            temp = getNumConsec(i, i, 0, 1, symbol);
            if (temp > maxV) maxV = temp;
            temp = getNumConsec(i, 0, 0, 1, symbol);
            if (temp > maxV) maxV = temp;
            temp = getNumConsec(0, i, 0, 1, symbol);
            if (temp > maxV) maxV = temp;
            temp = getNumConsec(i, i, 1, 0, symbol);
            if (temp > maxV) maxV = temp;
            temp = getNumConsec(0, i, 1, 0, symbol);
            if (temp > maxV) maxV = temp;
            temp = getNumConsec(i, 0, 1, 0, symbol);
            if (temp > maxV) maxV = temp;
            temp = getNumConsec(i, i, 1, 1, symbol);
            if (temp > maxV) maxV = temp;
            temp = getNumConsec(0, i, 1, 1, symbol);
            if (temp > maxV) maxV = temp;
            temp = getNumConsec(i, 0, 1, 1, symbol);
            if (temp > maxV) maxV = temp;
            temp = getNumConsec(i, i, 1, -1, symbol);
            if (temp > maxV) maxV = temp;
            temp = getNumConsec(0, i, 1, -1, symbol);
            if (temp > maxV) maxV = temp;
            temp = getNumConsec(i, 0, 1, -1, symbol);
            if (temp > maxV) maxV = temp;

        }
        return maxV;
    }
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                buffer.append(board[i][j] + " ");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

}
