package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Game.*;
import Pieces.*;

class BishopTest {

	@Test
	void testMoves() {
		Game game = new Game();
		Board board = game.getBoard();
		
		ArrayList<Piece> whitePieces = board.getWhitePieces();
		ArrayList<int[]> moves = new ArrayList<>();
		
		// Set Bishop
		Bishop bishop = (Bishop) board.getBoard()[7][2];
		bishop.setPosition(new int[] {4, 0});
		board.getBoard()[7][2] = null;
		board.getBoard()[4][0] = bishop;
		
		// Calculate moves
		moves = bishop.calculateLegalMove(board);
		board.printBoard();
		System.out.println(moves.size());
		assertTrue(moves.size() == 4);
		
		/*for (int[] move : moves) {
			System.out.println(move[0] + ", " + move[1]);
		}*/
		
	}
	
	@Test
	void testBishopPinnedToKingByRook() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    // Set White Bishop in position to be pinned
	    Bishop bishop = (Bishop) board.getBoard()[7][2];
	    bishop.setPosition(new int[] {4, 4});
	    board.getBoard()[7][2] = null;
	    board.getBoard()[4][4] = bishop;

	    // Set White King
	    King whiteKing = (King) board.getBoard()[7][4];
	    whiteKing.setPosition(new int[] {4, 7});
	    board.getBoard()[4][7] = whiteKing;
	    board.getBoard()[7][4] = null;

	    // Set Black Rook pinning the Bishop to the King
	    Rook blackRook = (Rook) board.getBoard()[0][7];
	    blackRook.setPosition(new int[] {4, 1});
	    board.getBoard()[0][7] = null;
	    board.getBoard()[4][1] = blackRook;

	    // Calculate moves for the pinned Bishop
	    ArrayList<int[]> moves = bishop.calculateLegalMove(board);
	    
	    // Print the board and check moves
	    board.printBoard();
	    System.out.println("Moves available for the pinned bishop: " + moves.size());

	    // Assert that the Bishop is pinned and can only move along the pin line
	    assertTrue(moves.size() == 0);  // Bishop should have no legal moves

	    // Print the possible moves
	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	}
	
	@Test
	void testBishopPinnedToKingByQueen() {
	    Game game = new Game();
	    Board board = game.getBoard();
	    
	    // Set White Bishop in position to be pinned
	    Bishop bishop = (Bishop) board.getBoard()[7][2];
	    bishop.setPosition(new int[] {3, 3});
	    board.getBoard()[7][2] = null;
	    board.getBoard()[3][3] = bishop;

	    // Set White King
	    King whiteKing = (King) board.getBoard()[7][4];
	    whiteKing.setPosition(new int[] {5, 5});
	    board.getBoard()[5][5] = whiteKing;
	    board.getBoard()[7][4] = null;

	    // Set Black Rook pinning the Bishop to the King
	    Queen blackQueen = (Queen) board.getBoard()[0][3];
	    blackQueen.setPosition(new int[] {1, 1});
	    board.getBoard()[0][3] = null;
	    board.getBoard()[1][1] = blackQueen;

	    // Calculate moves for the pinned Bishop
	    ArrayList<int[]> moves = bishop.calculateLegalMove(board);
	    
	    // Print the board and check moves
	    board.printBoard();
	    System.out.println("Moves available for the pinned bishop: " + moves.size());

	    // Assert that the Bishop is pinned and can only move along the pin line
	    assertTrue(moves.size() == 3);  // Bishop should have no legal moves

	    // Print the possible moves
	    for (int[] move : moves) {
	        System.out.println("Move: " + move[0] + ", " + move[1]);
	    }
	}

}
