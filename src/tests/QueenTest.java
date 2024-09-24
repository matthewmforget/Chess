package tests;

import static org.junit.jupiter.api.Assertions.*;

import Game.*;
import Pieces.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class QueenTest {

	@Test
	void testQueenMoves() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<Piece> whitePieces = board.getWhitePieces();
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set Queen in the middle of the board
	    Queen queen = (Queen) board.getBoard()[7][3];  // Assuming initial setup with the queen at 7,3
	    queen.setPosition(new int[] {4, 4});
	    board.getBoard()[7][3] = null;
	    board.getBoard()[4][4] = queen;

	    // Calculate legal moves for the Queen
	    moves = queen.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the Queen: " + moves.size());
	    
	    // Assert that the queen has the expected number of legal moves
	    assertTrue(moves.size() == 19);  // Queen has 27 possible moves when placed in an empty middle of the board

	    // Print all the legal moves
	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	}
	
	@Test
	void testQueenPinnedByRook() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set up the board
	    Queen queen = (Queen) board.getBoard()[7][3];  // White Queen starts at 7,3
	    King king = (King) board.getBoard()[7][4];     // White King starts at 7,4
	    Rook blackRook = new Rook(new int[] {4, 4}, 'R', 'B');  // Black rook to pin the queen
	    
	    // Move Queen to (5,4) and King stays at (7,4)
	    queen.setPosition(new int[] {6, 4});
	    board.getBoard()[7][3] = null;
	    board.getBoard()[6][4] = queen;
	    
	    // Place Black Rook in the middle (4,4) to pin the queen
	    board.getBoard()[4][4] = blackRook;
	    
	    // Calculate legal moves for the Queen
	    moves = queen.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the pinned Queen: " + moves.size());
	    
	    // The Queen should only be able to move along the line between the King and the Rook
	    assertTrue(moves.size() == 2);  // Expecting only 1 move (the queen can only slide between the rook and king)

	    // Print all the legal moves
	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	}

	
	@Test
	void testQueenPinnedByBishop() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set up the board
	    Queen queen = (Queen) board.getBoard()[7][3];  // White Queen starts at 7,3
	    King king = (King) board.getBoard()[7][4];     // White King starts at 7,4
	    Bishop blackBishop = new Bishop(new int[] {3, 0}, 'B', 'B');  // Black bishop to pin the queen
	    
	    // Move Queen to (5,2) and King stays at (7,4)
	    queen.setPosition(new int[] {5, 2});
	    board.getBoard()[7][3] = null;
	    board.getBoard()[5][2] = queen;
	    board.getBoard()[6][3] = null;
	    
	    // Place Black Bishop diagonally (4,1) to pin the queen
	    board.getBoard()[3][0] = blackBishop;
	    
	    // Calculate legal moves for the Queen
	    moves = queen.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the pinned Queen: " + moves.size());
	    
	    // The Queen should only be able to move along the diagonal between the King and the Bishop
	    assertTrue(moves.size() == 3);  // Expecting 2 moves along the diagonal (to 4,1 and 6,3)

	    // Print all the legal moves
	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	}
	
	@Test
	void testQueenMustAttackKnightToRemoveCheck() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    ArrayList<int[]> moves = new ArrayList<>();
	    
	    // Set up the board
	    Queen queen = (Queen) board.getBoard()[7][3];  // White Queen starts at 7,3
	    King king = (King) board.getBoard()[7][4];     // White King starts at 7,4
	    Knight blackKnight = new Knight(new int[] {5, 5}, 'N', 'B');  // Black Knight putting King in check
	    
	    // Move Queen to (2,2) and King stays at (7,4)
	    queen.setPosition(new int[] {2, 2});
	    board.getBoard()[7][3] = null;
	    board.getBoard()[2][2] = queen;
	    
	    // Place Black Knight at (5,5) to check the King
	    board.getBoard()[5][5] = blackKnight;
	    
	    // Calculate legal moves for the Queen
	    moves = queen.calculateLegalMove(board);

	    // Print the board and check the moves
	    board.printBoard();
	    System.out.println("Moves available for the Queen while King is in check: " + moves.size());
	    
	    // The Queen should only have one move, which is to attack the Black Knight at (5,5) to remove check
	    assertTrue(moves.size() == 1);  // Expecting 1 move (to 5,5)
	    
	    // Ensure the only move is to capture the Knight
	    int[] expectedMove = {5, 5};
	    assertArrayEquals(expectedMove, moves.get(0));
	    
	    // Print the legal move
	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	}


}
