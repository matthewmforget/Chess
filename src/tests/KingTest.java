package tests;

import static org.junit.jupiter.api.Assertions.*;

import Game.*;
import Pieces.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class KingTest {

	@Test
	void testKingCapturesKnightInCheck() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set up the King and the Black Knight
	    King whiteKing = (King) board.getBoard()[7][4];        // White King starts at 7,4
	    Knight blackKnight = new Knight(new int[] {6, 5}, 'N', 'B');  // Black Knight puts King in check
	    
	    // Place the Black Knight on the board
	    board.getBoard()[6][5] = blackKnight;

	    // Calculate legal moves for the King
	    moves = whiteKing.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the King under check: " + moves.size());
	    
	    // The King should have 1 legal move to capture the black Knight
	    assertTrue(moves.size() == 1);
	    assertArrayEquals(new int[] {6, 5}, moves.get(0)); // The only move is to capture the black Knight

	    // Print the legal moves for the King
	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	}

	@Test
	void testKingInCenterHasEightMoves() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set up the King in the center of the board
	    King whiteKing = new King(new int[] {4, 4}, 'K', 'W');  // White King at (4,4)
	    board.getBoard()[4][4] = whiteKing;

	    // Calculate legal moves for the King
	    moves = whiteKing.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the King in center: " + moves.size());

	    // The King should have 8 legal moves from the center
	    assertTrue(moves.size() == 8);
	    
	    // Expected positions for the King's moves
	    int[][] expectedMoves = {
	        {3, 3}, {3, 4}, {3, 5},
	        {4, 3},  {4, 5},
	        {5, 3}, {5, 4}, {5, 5}
	    };
	    
	    // Check that all expected moves are present
	    int count = 0;
	    for (int[] expectedMove : expectedMoves) {
	        for (int[] move : moves) {
	        	if (move[0] == expectedMove[0] && move[1] == expectedMove[1]){
	        		count++;
	        	}
	        }
	    }
	    
	    assertTrue(count == 8);

	    // Print the legal moves for the King
	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	}

	@Test
	void testKingInCenterCheckmate() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set up the King in the center of the board
	    King whiteKing = (King) board.getBoard()[7][4];
	    whiteKing.setPosition(new int[] {4, 4});  // White King at (4,4)
	    board.getBoard()[4][4] = whiteKing;
	    board.getBoard()[7][4] = null;

	    // Set up pieces for checkmate
	    Rook blackRook1 = new Rook(new int[] {4, 5}, 'R', 'B');  // Block the right
	    Rook blackRook2 = new Rook(new int[] {5, 4}, 'R', 'B');  // Block below
	    Knight blackKnight = new Knight(new int[] {3, 5}, 'N', 'B');  // Check from the upper right

	    // Place the Black pieces on the board
	    board.getBoard()[4][5] = blackRook1;
	    board.getBoard()[5][4] = blackRook2;
	    board.getBoard()[3][5] = blackKnight;

	    // Calculate legal moves for the King
	    moves = whiteKing.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the King in checkmate: " + moves.size());

	    // The King should have 0 legal moves in checkmate
	    assertTrue(moves.size() == 2);

	    // Print the legal moves for the King
	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	}
	
	@Test
	void testKingInCheckmate() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set up the White King in the corner (0, 0)
	    King whiteKing = board.getKing('W', board.getBoard());
	    board.getBoard()[0][0] = whiteKing;

	    // Set up Black Queen and Rook to deliver checkmate
	    Queen blackQueen = new Queen(new int[] {1, 1}, 'Q', 'B');  // Black Queen at (1, 1)
	    Rook blackRook = new Rook(new int[] {0, 1}, 'R', 'B');     // Black Rook at (0, 1)

	    // Place the Black pieces on the board
	    board.getBoard()[1][1] = blackQueen;
	    board.getBoard()[0][1] = blackRook;

	    // Calculate legal moves for the White King
	    moves = whiteKing.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the King in checkmate: " + moves.size());

	    // The King should have 0 legal moves since it's in checkmate
	    assertTrue(moves.size() == 0);

	    // Print the legal moves for the King (should print none)
	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	}


}
