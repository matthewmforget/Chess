package Game;

import Pieces.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
	
	private Board board;
	private Player black;
	private Player white;
	private boolean whitesTurn;
	public static ArrayList<Move> moveHistory;
	
	public Game() {
		
		this.board = new Board();
		
		this.whitesTurn = true;
		
		// Set black player
		ArrayList<Piece> blackPieces = board.getBlackPieces();
		this.black = new Player('B', blackPieces, this);
		
		// Set white player
		ArrayList<Piece> whitePieces = board.getWhitePieces();
		this.white = new Player('W', whitePieces, this);
		
		// Create move history
		this.moveHistory = new ArrayList<Move>();
	}
	
	
	
	// GET METHODS //
	
		/**
		 * Returns the current board of the game.
		 * @return the Board object representing the current state of the chess board.
		 */
		public Board getBoard() {
			return this.board;
		}
		
		/**
		 * Returns the black player in the game.
		 * @return the Player object representing the black player.
		 */
		public Player getBlack() {
			return this.black;
		}
		
		/**
		 * Returns the white player in the game.
		 * @return the Player object representing the white player.
		 */
		public Player getWhite() {
			return this.white;
		}
		
		public ArrayList<Move> getMoveHistory() {
			return this.moveHistory;
		}
		
		
		// SET METHODS //
		
		/**
		 * Sets the board for the game.
		 * @param board the Board object to be set as the current chess board.
		 */
		public void setBoard(Board board) {
			this.board = board;
		}
		
		/**
		 * Sets the black player for the game.
		 * @param black the Player object to be set as the black player.
		 */
		public void setBlack(Player black) {
			this.black = black;
		}
		
		/**
		 * Sets the white player for the game.
		 * @param white the Player object to be set as the white player.
		 */
		public void setWhite(Player white) {
			this.white = white;
		}
		
		public void setMoveHistory(ArrayList<Move> history) {
			this.moveHistory = history;
		}
		
		
		
		
		// UTILITY METHODS
		
		
		public void addToMoveHistory (Move move) {
			this.moveHistory.add(move);
		}
		
		public Move getLastMove() {
			return this.moveHistory.getLast();
		}
		
		public boolean makeMove(Move move) {
			ArrayList<int[]> moves = move.getMovedPiece().calculateLegalMove(this.board);
			// Check if legal moves contains this move we want to make
			for (int[] moveCoordinate : moves) {
				if (moveCoordinate[0] == move.getNewPosition()[0] && 
				    moveCoordinate[1] == move.getNewPosition()[1]) {
					return true;
				}
			}
			return false;
		}
		
		
}
