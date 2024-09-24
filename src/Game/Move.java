package Game;

import Pieces.*;

public class Move {
	
	private int[] oldPosition;
	private int[] newPosition;
	private Piece movedPiece;
	private Piece takenPiece;
	private Piece[][] boardBeforeMove;
	
	/**
	 * Constructor
	 * @param currentPosition is the current position on the board for the piece. An array with index 0 being
	 * 		  the row of the chess board, and index 1 being the column
	 * @param destinationPosition is the destination position on the board for the piece. An array with index 0 being
	 * 		  the row of the chess board, and index 1 being the column
	 * @param piece is the Piece object to be moved on the chess board
	 */
	public Move (int[] currentPosition, int[] destinationPosition, Piece piece, Piece takenPiece, Piece[][] board) {
		this.oldPosition = currentPosition;
		this.newPosition = destinationPosition;
		this.movedPiece = piece;
		this.takenPiece = takenPiece;
		this.boardBeforeMove = board;
	}
	
	
	
	
	// GET METHODS
	
	
	/**
	 * Returns the current position for this move
	 * @return returns an int[] that corresponds to the current position of this move. index 0 of the int[] is the row on
	 * 		   chess board, index 1 is the column
	 */
	public int[] getOldPosition() {
		return this.oldPosition;
	}
	
	/**
	 * Returns the destination position for this move
	 * @return returns an int[] that corresponds to the destination position of this move. index 0 of the int[] is the row on
	 * 		   chess board, index 1 is the column
	 */
	public int[] getNewPosition() {
		return this.newPosition;
	}
	
	/**
	 * Returns the Piece being moved
	 * @return is a Piece object that is being moved
	 */
	public Piece getMovedPiece() {
		return this.movedPiece;
	}
	
	public Piece getTakenPiece() {
		return this.takenPiece;
	}
	
	public Piece[][] getBoardBeforeMove() {
		return this.boardBeforeMove;
	}
	
	
	
	
	// SET METHODS
	
	/**
	 * Sets the current position for this move
	 * @param currentPosition is an int[] that corresponds to the current position of this move. index 0 of the int[] is the row on
	 * 		   chess board, index 1 is the column
	 */
	public void setCurrentPosition(int[] currentPosition) {
		this.oldPosition = currentPosition;
	}
	
	/**
	 * Sets the destination position for this move
	 * @param destinationPosition is an int[] that corresponds to the current position of this move. index 0 of the int[] is the row on
	 * 		   chess board, index 1 is the column
	 */
	public void destinationPosition(int[] destinationPosition) {
		this.newPosition = destinationPosition;
	}
	
	/**
	 * Sets the Piece for this move
	 * @param piece is the Piece object that we want to move on the chess board
	 */
	public void setMovedPiece(Piece piece) {
		this.movedPiece = piece;
	}
	
	public void setTakenPiece(Piece piece) {
		this.takenPiece = piece;
	}
	
	public void setBoardBeforeMove(Piece[][] board) {
		this.boardBeforeMove = board;
	}
}
