package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Game.*;
import Pieces.*;

class PawnTest {

	@Test
	void testOpeningMove() {
		Game game = new Game();
		Board board = game.getBoard();
		ArrayList<Piece> whitePieces = board.getWhitePieces();
		ArrayList<int[]> moves = new ArrayList<>();
		Pawn pawn = (Pawn) board.getBoard()[6][0];
		moves = pawn.calculateLegalMove(board);
		assert(moves.size() == 2);
		assert(moves.get(0)[0] == 5 && moves.get(0)[1] == 0);
		assert(moves.get(1)[0] == 4 && moves.get(1)[1] == 0);
		board.printBoard();
	}
	
	@Test
	void testEnPassant() {
		Game game = new Game();
		Board board = game.getBoard();
		//ArrayList<Piece> whitePieces = board.getWhitePieces();
		ArrayList<int[]> moves = new ArrayList<>();
		Pawn pawn = (Pawn) board.getBoard()[6][0];
		board.getBoard()[6][0] = null;
		board.getBoard()[3][5] = pawn;
		pawn.setPosition(new int[] {3, 5});
		pawn.setIsFirstMove();
		Move pawnMove = new Move(new int[] {6,0}, new int[] {3,5}, pawn, null, board.getBoard());
		Game.moveHistory.add(pawnMove);
		Pawn blackPawn = (Pawn) board.getBoard()[1][4];
		board.getBoard()[1][4] = null;
		board.getBoard()[3][4] = blackPawn;
		blackPawn.setPosition(new int[] {3, 4});
		blackPawn.setIsFirstMove();
		Move blackPawnMove = new Move(new int[] {1,4}, new int[] {3,4}, blackPawn, null, board.getBoard());
		Game.moveHistory.add(blackPawnMove);
		board.printBoard();
		moves = pawn.calculateLegalMove(board);
		assert(moves.size() == 2);
		for (int[] see : moves) {
			System.out.println("Move :" + see[0] + see[1]);
		}
		assert(moves.get(0)[0] == 2 && moves.get(0)[1] == 5);
		assert(moves.get(1)[0] == 2 && moves.get(1)[1] == 4);
	}
	
	@Test
	void testEnPassantWhileInCheck() {
		Game game = new Game();
		Board board = game.getBoard();
		//ArrayList<Piece> whitePieces = board.getWhitePieces();
		ArrayList<int[]> moves = new ArrayList<>();
		Pawn pawn = (Pawn) board.getBoard()[6][0];
		King king = (King) board.getKing('W', board.getBoard());
		board.getBoard()[king.getPosition()[0]][king.getPosition()[1]] = null;
		king.setPosition(new int[] {4, 4});
		board.getBoard()[4][4] = king;
		board.getBoard()[6][0] = null;
		board.getBoard()[3][5] = pawn;
		pawn.setPosition(new int[] {3, 5});
		pawn.setIsFirstMove();
		Move pawnMove = new Move(new int[] {6,0}, new int[] {3,5}, pawn, null, board.getBoard());
		Game.moveHistory.add(pawnMove);
		
		//Set bishop to pin pawn to king
		Bishop bishop = (Bishop) board.getBoard()[0][2];
		board.getBoard()[0][2] = null;
		board.getBoard()[2][6] = bishop;
		bishop.setPosition(new int[] {2, 6});
		
		//Set black pawn
		Pawn blackPawn = (Pawn) board.getBoard()[1][4];
		board.getBoard()[1][4] = null;
		board.getBoard()[3][4] = blackPawn;
		blackPawn.setPosition(new int[] {3, 4});
		blackPawn.setIsFirstMove();
		Move blackPawnMove = new Move(new int[] {1,4}, new int[] {3,4}, blackPawn, null, board.getBoard());
		Game.moveHistory.add(blackPawnMove);
		board.printBoard();
		moves = pawn.calculateLegalMove(board);
		for (int[] see : moves) {
			System.out.println("Move :" + see[0] + see[1]);
		}
		assert(moves.size() == 1);
		assert(moves.getFirst()[0] == 2 && moves.getFirst()[1] == 6);
	}
	
	@Test
	void testEnPassantWhileInCheck2() {
		Game game = new Game();
		Board board = game.getBoard();
		//ArrayList<Piece> whitePieces = board.getWhitePieces();
		ArrayList<int[]> moves = new ArrayList<>();
		
		//Set white pawn
		Pawn pawn = (Pawn) board.getBoard()[6][0];
		board.getBoard()[6][0] = null;
		board.getBoard()[3][5] = pawn;
		pawn.setPosition(new int[] {3, 5});
		pawn.setIsFirstMove();
		Move pawnMove = new Move(new int[] {6,0}, new int[] {3,5}, pawn, null, board.getBoard());
		Game.moveHistory.add(pawnMove);
		
		//Set king
		King king = (King) board.getKing('W', board.getBoard());
		board.getBoard()[king.getPosition()[0]][king.getPosition()[1]] = null;
		king.setPosition(new int[] {3, 1});
		board.getBoard()[3][1] = king;
		
		//Set rook to pin pawn to king
		Rook rook = (Rook) board.getBoard()[0][0];
		board.getBoard()[0][0] = null;
		board.getBoard()[3][6] = rook;
		rook.setPosition(new int[] {3, 6});
		
		//Set black pawn
		Pawn blackPawn = (Pawn) board.getBoard()[1][4];
		board.getBoard()[1][4] = null;
		board.getBoard()[3][4] = blackPawn;
		blackPawn.setPosition(new int[] {3, 4});
		blackPawn.setIsFirstMove();
		Move blackPawnMove = new Move(new int[] {1,4}, new int[] {3,4}, blackPawn, null, board.getBoard());
		Game.moveHistory.add(blackPawnMove);
		board.printBoard();
		moves = pawn.calculateLegalMove(board);
		System.out.println("moves size: " + moves.size());
		for (int[] see : moves) {
			System.out.println("Move :" + see[0] + see[1]);
		}
		assert(moves.size() == 1);
	}

}