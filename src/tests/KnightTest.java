package tests;

import static org.junit.jupiter.api.Assertions.*;

import Game.*;
import Pieces.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class KnightTest {

	@Test
	void testKnightMoves() {
		
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set up the board
	    Knight knight = (Knight) board.getBoard()[7][1];  // White Knight starts at 7,1
	    
	    // Calculate legal moves for the Knight
	    moves = knight.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the Knight: " + moves.size());
	    
	    // The knight should have 2 legal moves from its starting position in a standard setup
	    assertTrue(moves.size() == 2);

	    // Ensure the correct moves (Knight can move to (5,0) and (5,2))
	    boolean hasMoveTo50 = false;
	    boolean hasMoveTo52 = false;
	    
	    for (int[] move : moves) {
	        if (move[0] == 5 && move[1] == 0) {
	            hasMoveTo50 = true;
	        }
	        if (move[0] == 5 && move[1] == 2) {
	            hasMoveTo52 = true;
	        }
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	    
	    assertTrue(hasMoveTo50 && hasMoveTo52);
	}

	@Test
	void testKnightMovesInMiddle() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set up the Knight in the middle of the board (4, 4)
	    Knight knight = (Knight) board.getBoard()[7][1];  // White Knight starts at 7,1
	    knight.setPosition(new int[] {4, 4});
	    board.getBoard()[7][1] = null;
	    board.getBoard()[4][4] = knight;
	    
	    // Calculate legal moves for the Knight
	    moves = knight.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the Knight in the middle: " + moves.size());
	    
	    // The knight should have 8 legal moves from the center of the board
	    assertTrue(moves.size() == 6);

	    // Ensure the correct moves (Knight can move to 8 valid positions)
	    int[][] expectedMoves = {
	        {5, 2}, {5, 6},  // Two moves sideways
	        {2, 3}, {2, 5},  // Two moves backward
	        {3, 2}, {3, 6}   // Two more moves sideways
	    };

	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }

	    // Check that all expected moves are present
	    for (int[] expectedMove : expectedMoves) {
	        boolean found = false;
	        for (int[] move : moves) {
	            if (move[0] == expectedMove[0] && move[1] == expectedMove[1]) {
	                found = true;
	                break;
	            }
	        }
	        assertTrue(found, "Expected move " + expectedMove[0] + "," + expectedMove[1] + " was not found.");
	    }
	}
	
	@Test
	void testKnightPinnedToKing() {
		
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set up the Knight and King
	    Knight knight = (Knight) board.getBoard()[7][1];  // White Knight starts at 7,1
	    King king = (King) board.getBoard()[7][4];        // White King starts at 7,4
	    Rook blackRook = new Rook(new int[] {7, 0}, 'R', 'B');  // Black rook to pin the knight
	    
	    // Move Knight to (7,2) and keep King at (7,4)
	    knight.setPosition(new int[] {7, 2});
	    board.getBoard()[7][1] = null;
	    board.getBoard()[7][2] = knight;

	    // Place Black Rook on the same row to pin the Knight
	    board.getBoard()[7][0] = blackRook;
	    board.getBoard()[7][3] = null;
	    
	    // Calculate legal moves for the Knight
	    moves = knight.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the pinned Knight: " + moves.size());
	    
	    // The Knight should have 0 legal moves as it's pinned by the rook
	    assertTrue(moves.size() == 0);
	}
	
	@Test
	void testKnightCapturesKnightInCheck() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set up the Knight and King
	    Knight whiteKnight = (Knight) board.getBoard()[7][1];  // White Knight starts at 7,1
	    King whiteKing = (King) board.getBoard()[7][4];        // White King starts at 7,4
	    Knight blackKnight = new Knight(new int[] {5, 3}, 'N', 'B');  // Black Knight puts King in check
	    
	    // Place the Black Knight on the board
	    board.getBoard()[5][3] = blackKnight;

	    // Move White Knight to (7,2) and keep King at (7,4)
	    whiteKnight.setPosition(new int[] {7, 2});
	    board.getBoard()[7][1] = null;
	    board.getBoard()[7][2] = whiteKnight;

	    // Calculate legal moves for the Knight
	    moves = whiteKnight.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the Knight under check: " + moves.size());
	    
	    // The Knight should have 1 legal move to capture the black Knight
	    assertTrue(moves.size() == 1);
	    assertArrayEquals(new int[] {5, 3}, moves.get(0)); // The only move is to capture the black Knight

	    // Print the legal moves for the Knight
	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	}



}
