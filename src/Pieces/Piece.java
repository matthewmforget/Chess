package Pieces;

import Game.*;
import java.util.ArrayList;

public abstract class Piece {
	
	private int[] position; // the location of this Piece on the chess board which is a 2D array
	private char type; // P for pawn, R for rook, etc.
	private char team; // W for white, B for black
	
	/**
	 * Constructor
	 * @param position is the position in the 2D array (the board) that this piece is on
	 * @param type is the type of piece (bishop, rook, etc.)
	 * @param team is the team the piece is on (black or white)
	 */
	Piece (int[] position, char type, char team) {
		this.position = position;
		this.type = type;
		this.team = team;
	}
	
	
	
	
	// GET METHODS //
	
	/**
	 * Returns the current team for this piece
	 * @return returns a char ('W' for white, 'B' for black) 
	 */
	public char getTeam() {
		return this.team;
	}
	
	/**
	 * Returns the current type for this piece
	 * @return returns a char ('R' for rook, 'K' for king, etc.) 
	 */
	public char getType() {
		return this.type;
	}
	
	/**
	 * Returns the current position for this piece
	 * @return returns an array that corresponds to the 2D array of the chess board. The element at index 0 is the row,
	 *         and the element at index 1 is the column
	 */
	public int[] getPosition(){
		return this.position;
	}
	
	
	
	
	// SET METHODS //
	
	/**
	 * Sets the team for this piece
	 * @param team is a char that is the team to be set to this piece (W for white, B for black)
	 */
	public void setTeam(char team) {
		this.team = team;
	}
	
	/**
	 * Sets the type for this piece
	 * @param type is a char that is the type to be set to this piece (R for rook, K for king, etc.)
	 */
	public void setType(char type) {
		this.type = type;
	}
	
	/**
	 * Sets the position on the chess board for this piece
	 * @param position is an array with 2 elements that correspond with the 2D array for the chess board. index 0 of
	 *        the position array is the row of the chess board, and index 1 is the column
	 */
	public void setPosition(int[] position) {
		this.position = position;
	}
	
	
	
	
	// MOVEMENTS //
	public abstract ArrayList<int[]> calculateLegalMove(Board board);
	public abstract ArrayList<int[]> movesCheckChecker(Piece[][] board);
	public abstract Piece copy();
}
