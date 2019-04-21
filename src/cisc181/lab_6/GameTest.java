package cisc181.lab_6;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void test_PlacePieceAction() {
        System.out.println("Testing PlacePieceAction");

        PlacePieceAction action1 = new PlacePieceAction('X', 0, 1);
        PlacePieceAction action2 = new PlacePieceAction('X', 2, 2);
        PlacePieceAction action3 = new PlacePieceAction('O', 3, 0);
        PlacePieceAction action4 = new PlacePieceAction('O', 0, 0);
        PlacePieceAction action5 = new PlacePieceAction('X', 0, 0);

        TicTacToeTypeGame game = new TicTacToeTypeGame('X', 'O',3,3,3);
        System.out.println(game);
        assertTrue(action1.isValid(game)); // it is x's turn
        System.out.println(action1 + "\n");
        action1.update(game);
        System.out.println(game);

        // compare the current game board to this board
        GamePiece E = new GamePiece(GamePiece.EMPTY);
        GamePiece X = new GamePiece('X');
        GamePiece O = new GamePiece('O');
        GameBoard expectedBoard1 = new GameBoard(new GamePiece[][]{
                {E,X,E},
                {E,E,E},
                {E,E,E} });

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertTrue(game.getGameBoard().getPiece(row, col).equals(expectedBoard1.getPiece(row, col)));
            }
        }

        assertFalse(action2.isValid(game)); // it is o's turn
        assertFalse(action3.isValid(game)); // it is not within bounds
        assertTrue(action4.isValid(game)); // it is o's turn
        System.out.println(action4 + "\n");
        action4.update(game);
        System.out.println(game);

        expectedBoard1.setPiece(0,0,O);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertTrue(game.getGameBoard().getPiece(row, col).equals(expectedBoard1.getPiece(row, col)));
            }
        }
        assertFalse(action5.isValid(game)); // it is x's turn but space in not empty
    }

    @Test
    public void test_TossPieceAction() {
        System.out.println("Testing PlacePieceAction");

        TossPieceAction action1 = new TossPieceAction('X', 0, 1);
        TossPieceAction action2 = new TossPieceAction('X', 2, 2);
        TossPieceAction action3 = new TossPieceAction('O', 3, 0);
        TossPieceAction action4 = new TossPieceAction('O', 0, 0);
        TossPieceAction action5 = new TossPieceAction('X', 0, 0);

        TicTacToeTypeGame game = new TicTacToeTypeGame('X', 'O',3,3,3);
        System.out.println(game);
        assertTrue(action1.isValid(game)); // it is x's turn
        System.out.println(action1 + "\n");
        action1.update(game);
        System.out.println(game);

        // compare the current game board to this board
        GamePiece E = new GamePiece(GamePiece.EMPTY);
        GamePiece X = new GamePiece('X');
        GamePiece O = new GamePiece('O');
        GameBoard expectedBoard1 = new GameBoard(new GamePiece[][]{
                {E,X,E},
                {E,E,E},
                {E,E,E} });

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertTrue(game.getGameBoard().getPiece(row, col).equals(expectedBoard1.getPiece(row, col)));
            }
        }

        assertFalse(action2.isValid(game)); // it is o's turn
        assertFalse(action3.isValid(game)); // it is not within bounds
        assertTrue(action4.isValid(game)); // it is o's turn
        System.out.println(action4 + "\n");
        action4.update(game);
        System.out.println(game);

        expectedBoard1.setPiece(0,0,O);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertTrue(game.getGameBoard().getPiece(row, col).equals(expectedBoard1.getPiece(row, col)));
            }
        }
        assertTrue(action5.isValid(game)); // it is x's turn doesn't matter is spot is full
        System.out.println(action5 + "\n");
        action5.update(game);
        System.out.println(game);
    }
}