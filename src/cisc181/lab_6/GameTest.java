package cisc181.lab_6;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testGamePiece() {
        System.out.println("Testing GamePiece");
        GamePiece x = new GamePiece('X');
        GamePiece x2 = new GamePiece('X');
        GamePiece o = new GamePiece('O');
        GamePiece blank = new GamePiece('E');

        assertEquals(x.getSymbol() == 'X', true);
        assertEquals(o.getSymbol() == 'O', true);
        assertEquals(blank.getSymbol() == GamePiece.EMPTY, true);
        assertEquals(blank.isEmpty(), true);
        assertEquals(x.isEmpty(), false);
        assertEquals(x.toString().equals("X"), true);
        assertEquals(x.equals(o), false);
        assertEquals(x.equals(blank), false);
        assertEquals(x.equals(x2), true);
    }
    @Test
    public void testGameBoard() {
        System.out.println("Testing GameBoard");

        // create a 2D array that holds GamePiece objects
        GamePiece[][] array2D = new GamePiece[3][3];
        // iterate over the entire array and assign a new EMPTY gamepiece to each space
        for (int row =0; row < array2D.length; row++){
            for (int col = 0; col < array2D[row].length; col++){
                array2D[row][col] = new GamePiece(GamePiece.EMPTY);
            }
        }
        // create an instance of the GameBoard class and pass it this new 2D array
        GameBoard board = new GameBoard(array2D);

        GamePiece x = new GamePiece('X');
        GamePiece o = new GamePiece('O');

        board.setPiece(0, 0, new GamePiece('X'));
        board.setPiece(0, 1, new GamePiece('O'));
        board.setPiece(0, 2, new GamePiece('X'));
        board.setPiece(1, 0, new GamePiece('O'));
        board.setPiece(1, 1, new GamePiece('X'));
        board.setPiece(1, 2, new GamePiece('O'));
        board.setPiece(2, 0, new GamePiece('O'));
        board.setPiece(2, 1, new GamePiece('O'));

        System.out.println("Testing Empty Space on Board");
        assertEquals(board.hasEmptySpace(), true);
        board.setPiece(2, 2, new GamePiece('X'));
        System.out.println("Testing Empty Space on Board");
        assertEquals(board.hasEmptySpace(), false);

        System.out.println("Testing In Bounds");
        assertEquals(board.isInBounds(0, 2), true);
        assertEquals(board.isInBounds(3, 2), false);

        System.out.println("Testing equals");
        GamePiece[][] ticTacToe = board.getBoard();
        assertEquals(ticTacToe[0][0].equals(x), true);
        assertEquals(ticTacToe[0][1].equals(o), true);
        assertEquals(ticTacToe[0][2].equals(x), true);
        assertEquals(ticTacToe[1][0].equals(o), true);
        assertEquals(ticTacToe[1][1].equals(x), true);
        assertEquals(ticTacToe[1][2].equals(o), true);
        assertEquals(ticTacToe[2][0].equals(x), false);
        assertEquals(ticTacToe[2][1].equals(o), true);
        assertEquals(ticTacToe[2][2].equals(x), true);

        board.printBoard();
    }
    @Test
    public void testMaxConsec() {
        System.out.println("Testing MaxConsec");
        // create a 2D array that holds GamePiece objects
        GamePiece[][] array2D = new GamePiece[6][6];
        // iterate over the entire array and assign a new EMPTY gamepiece to each space
        for (int row =0; row < array2D.length; row++){
            for (int col = 0; col < array2D[row].length; col++){
                array2D[row][col] = new GamePiece(GamePiece.EMPTY);
            }
        }
        GameBoard board = new GameBoard(array2D);

        GamePiece x = new GamePiece('X');
        GamePiece o = new GamePiece('O');

        board.setPiece(0, 0, new GamePiece('X'));
        board.setPiece(0, 1, new GamePiece('X'));
        board.setPiece(0, 2, new GamePiece('O'));
        board.setPiece(0, 3, new GamePiece('X'));
        board.setPiece(0, 4, new GamePiece('X'));
        board.setPiece(0, 5, new GamePiece('O'));

        board.setPiece(1, 0, new GamePiece('O'));
        board.setPiece(1, 1, new GamePiece('X'));
        board.setPiece(1, 2, new GamePiece('X'));
        board.setPiece(1, 3, new GamePiece('X'));
        board.setPiece(1, 4, new GamePiece('X'));
        board.setPiece(1, 5, new GamePiece('X'));

        board.setPiece(2, 0, new GamePiece('X'));
        board.setPiece(2, 1, new GamePiece('X'));
        board.setPiece(2, 2, new GamePiece('X'));
        board.setPiece(2, 3, new GamePiece('X'));
        board.setPiece(2, 4, new GamePiece('X'));
        board.setPiece(2, 5, new GamePiece('O'));

        board.setPiece(3, 0, new GamePiece('O'));
        board.setPiece(3, 1, new GamePiece('O'));
        board.setPiece(3, 2, new GamePiece('O'));
        board.setPiece(3, 3, new GamePiece('X'));
        board.setPiece(3, 4, new GamePiece('O'));
        board.setPiece(3, 5, new GamePiece('X'));

        board.setPiece(4, 0, new GamePiece('O'));
        board.setPiece(4, 1, new GamePiece('O'));
        board.setPiece(4, 2, new GamePiece('O'));
        board.setPiece(4, 3, new GamePiece('X'));
        board.setPiece(4, 4, new GamePiece('O'));
        board.setPiece(4, 5, new GamePiece('O'));

        board.setPiece(5, 0, new GamePiece('X'));
        board.setPiece(5, 1, new GamePiece('X'));
        board.setPiece(5, 2, new GamePiece('X'));
        board.setPiece(5, 3, new GamePiece('X'));
        board.setPiece(5, 4, new GamePiece('X'));
        board.setPiece(5, 5, new GamePiece('X'));

        board.printBoard();
        System.out.println();
        assertEquals(board.getMaxConsec('X'),6);
        assertEquals(board.getNumConsec(1,0,0,1,'X'),5);
        assertEquals(board.getNumConsec(4,0,1,0,'O'),3);
        board.setPiece(5, 3, new GamePiece('O'));
        board.printBoard();
        System.out.println();
        assertEquals(board.getMaxConsec('X'),5);

        board.setPiece(1, 2, new GamePiece('O'));
        board.setPiece(2, 3, new GamePiece('O'));
        System.out.println();
        board.printBoard();
        assertEquals(board.getMaxConsec('X'),4);
    }
    @Test
    public void testTicTacToeTypeGame()throws Exception {

        System.out.println("Testing TicTacToeTypeGame");

        GamePiece [][] emptyPieces = TicTacToeTypeGame.setUpEmptyArray(4,4);
        GameBoard testBoard = new GameBoard(emptyPieces);
        assertEquals(testBoard.getMaxConsec('X'),0);
        assertEquals(testBoard.getMaxConsec('O'),0);

        TicTacToeTypeGame testGame = new TicTacToeTypeGame('G','B',4,4,3);
        GamePiece green = new GamePiece('G');
        GamePiece blue = new GamePiece('B');

        System.out.println();
        testGame.getGameBoard().printBoard();
        System.out.println(testGame.getStatus());
        testGame.setPiece(1,1,green);
        testGame.changeTurn();

        System.out.println();
        testGame.getGameBoard().printBoard();
        System.out.println(testGame.getStatus());
        testGame.setPiece(1,0,blue);
        testGame.changeTurn();
        assertEquals(testGame.isEnd(),false);

        System.out.println();
        testGame.getGameBoard().printBoard();
        System.out.println(testGame.getStatus());
        testGame.setPiece(2,2,green);
        testGame.changeTurn();

        System.out.println();
        testGame.getGameBoard().printBoard();
        System.out.println(testGame.getStatus());
        testGame.setPiece(2,0,blue);
        testGame.changeTurn();

        System.out.println();
        testGame.getGameBoard().printBoard();
        System.out.println(testGame.getStatus());
        testGame.setPiece(3,3,green);
        testGame.changeTurn();

        System.out.println();
        testGame.getGameBoard().printBoard();
        System.out.println(testGame.getStatus());

        assertEquals(testGame.isEnd(),true);
        assertEquals(testGame.isWinner('B'),false);
        assertEquals(testGame.isWinner('G'),true);
    }
}