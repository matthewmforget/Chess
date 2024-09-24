package tests;

import static org.junit.jupiter.api.Assertions.*;
import Game.*;
import Pieces.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class RookTest {

	@Test
	void testMoves() {
		Game game = new Game();
		Board board = game.getBoard();
		ArrayList<Piece> whitePieces = board.getWhitePieces();
		ArrayList<int[]> moves = new ArrayList<>();
		Pawn pawn = (Pawn) board.getBoard()[6][0];
		board.getBoard()[6][0] = null;
		board.getBoard()[4][0] = pawn;
		Rook rook = (Rook) board.getBoard()[7][0];
		//System.out.println(moves);
		moves = rook.calculateLegalMove(board);
		/*for (int[] move : moves) {
			System.out.println("move : " + move[0] + "" + move[1]);
		}*/
		assert(!moves.isEmpty());
	}
	
	@Test
    void testRookCapturesEnemy() {
        Game game = new Game();
        Board board = game.getBoard();

        // Move the white rook to an open position (4, 0)
        Rook rook = (Rook) board.getBoard()[7][0];
        board.getBoard()[6][0] = null;  // Remove the pawn
        board.getBoard()[4][0] = rook;  // Move rook to new position
        rook.setPosition(new int[] {4, 0});
        board.getBoard()[7][0] = null;  // Clear old rook position

        // Move a black pawn in front of the rook to (2, 0) (enemy piece)
        Pawn blackPawn = (Pawn) board.getBoard()[1][0];
        board.getBoard()[1][0] = null;
        board.getBoard()[2][0] = blackPawn;
        blackPawn.setPosition(new int[] {2, 0});
        
        //board.printBoard();

        // Calculate rook's possible moves
        ArrayList<int[]> moves = rook.calculateLegalMove(board);

        // Print the moves
        /*System.out.println(moves.size());
        for (int[] move : moves) {
            System.out.println("move : " + move[0] + ", " + move[1]);
        }*/

        // Check that the rook can move to (2, 0) where the black pawn is
        boolean canCapture = false;
        for (int[] move : moves) {
            if (move[0] == 2 && move[1] == 0) {
                canCapture = true;
            }
        }

        assertTrue(canCapture, "Rook should be able to capture the black pawn at (2, 0).");
    }
	
	@Test
    void testRookPinnedToKing() {
        Game game = new Game();
        Board board = game.getBoard();

        // Rearrange the pieces without clearing the board
        // Move the white King to g1 (row 7, column 6)
        King whiteKing = (King) board.getBoard()[7][4]; // Original e1 position
        board.getBoard()[7][4] = null;
        whiteKing.setPosition(new int[]{4, 7});
        board.getBoard()[4][7] = whiteKing; // Set new position to g1

        // Move the white Rook to g4 (row 4, column 6)
        Rook whiteRook = (Rook) board.getBoard()[7][7]; // Original h1 position
        board.getBoard()[7][7] = null;
        whiteRook.setPosition(new int[]{4, 6});
        board.getBoard()[4][6] = whiteRook; // Set new position to g4

        // Move the black Rook to g8 (row 0, column 6) to pin the white Rook
        Rook blackRook = (Rook) board.getBoard()[0][7]; // Original h8 position
        board.getBoard()[0][7] = null;
        blackRook.setPosition(new int[]{4, 1});
        board.getBoard()[4][1] = blackRook; // Set new position to g8

        // Calculate legal moves for the pinned white Rook
        ArrayList<int[]> moves = whiteRook.calculateLegalMove(board);

        // Print the board for visual confirmation
        board.printBoard();
        System.out.println(board.getBoard()[4][1].getTeam());
        System.out.println(board.getBoard()[4][6].getTeam());
        System.out.println(board.getBoard()[4][7].getTeam());
        
        // Print all possible moves for the white Rook
        System.out.println("Possible moves for white Rook:");
        for (int[] move : moves) {
            System.out.println("Move to: " + move[0] + ", " + move[1]);
        }

        // Expected moves for the white Rook: {3, 6}, {2, 6}, {1, 6}
        assertEquals(5, moves.size(), "The white Rook should have 5 legal moves.");
    }
	
	@Test
	void testRookCapturingEnemyPiece() {
	    Game game = new Game();
	    Board board = game.getBoard();

	    // Move white Rook to d4 (row 4, column 3)
	    Rook whiteRook = (Rook) board.getBoard()[7][0]; // Original a1 position
	    board.getBoard()[7][0] = null;
	    whiteRook.setPosition(new int[]{4, 3});
	    board.getBoard()[4][3] = whiteRook;

	    // Place a black Knight at d6 (row 2, column 3) in the Rook's path
	    Knight blackKnight = (Knight) board.getBoard()[0][1]; // Original b8 position
	    board.getBoard()[0][1] = null;
	    blackKnight.setPosition(new int[]{2, 3});
	    board.getBoard()[2][3] = blackKnight;

	    // Calculate legal moves for the white Rook
	    ArrayList<int[]> moves = whiteRook.calculateLegalMove(board);

	    // Print the board for visual confirmation
	    board.printBoard();

	    // Print all possible moves for the white Rook
	    System.out.println("Possible moves for white Rook:");
	    for (int[] move : moves) {
	        System.out.println("Move to: " + move[0] + ", " + move[1]);
	    }

	    // Assert that the Rook can move and capture the Knight
	    assertEquals(10, moves.size(), "The white Rook should have 9 legal moves.");
	    //assertArrayEquals(new int[]{2, 3}, moves.get(0), "Rook should be able to capture the Knight at (2, 3)");
	}

}
