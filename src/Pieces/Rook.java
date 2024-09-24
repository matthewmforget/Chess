package Pieces;
import java.util.ArrayList;

import Game.*;

public class Rook extends Piece{
	
	private boolean isFirstMove;
	
	
	/**
	 * Constructor
	 * @param position is the position in the 2D array (the board) that this piece is on
	 * @param type is the type of piece (bishop, rook, etc.)
	 * @param team is the team the piece is on (black or white)
	 */
	public Rook (int[] position, char type, char team) {
		super(position, type, team);
		this.isFirstMove = true;
	}
	
	
	// GET METHODS
	
	/**
	 * Returns true if this is the rooks first move
	 * @return a boolean value to tell if this is the rooks first move
	 */
	public boolean getIsFirstMove() {
		return this.isFirstMove;
	}
	
	@Override
	public Rook copy() {
		return new Rook(this.getPosition(), this.getType(), this.getTeam());
	}
	
	
	
	// SET METHODS
	
	/**
	 * Method to set if this is the rooks first move or not
	 * @param a boolean value to tell if this is the rooks first move
	 */
	public void setIsFirstMove() {
		this.isFirstMove = false;
	}
	
	
	
	
	// MOVEMENTS //
	
	/**
	 * @return returns an array list of arrays corresponding to the possible positions this piece can move to on the
	 * 	       board
	 */
	@Override
	public ArrayList<int[]> calculateLegalMove(Board board) {
		
		// Get the king
		
		ArrayList<int[]> moves = new ArrayList<>();
		
		int row = this.getPosition()[0];
		int column = this.getPosition()[1];
		
		
		// Check rows above this rook
		for (int i = row-1; i >= 0; i--) {
			
			if (board.getBoard()[i][column] != null) {
				if (board.getBoard()[i][column].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, column};
					if (board.validateMove(this, move, false)) {
						moves.add(move);
					}
					break;
				}
			}
			else {
				int[] move = {i, column};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check rows below this rook
		for (int i = row+1; i < 8; i++) {
			
			if (board.getBoard()[i][column] != null) {
				if (board.getBoard()[i][column].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, column};
					if (board.validateMove(this, move, false)) {
						moves.add(move);
					}
					break;
				}
			}
			else {
				int[] move = {i, column};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check columns to the right of this rook
		for (int i = column+1; i < 8; i++) {
			
			if (board.getBoard()[row][i] != null) {
				if (board.getBoard()[row][i].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {row, i};
					if (board.validateMove(this, move, false)) {
						moves.add(move);
					}
					break;
				}
			}
			else {
				int[] move = {row, i};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check columns to the left of this rook
		for (int i = column-1; i >= 0; i--) {
			
			
			if (board.getBoard()[row][i] != null) {
				if (board.getBoard()[row][i].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {row, i};
					if (board.validateMove(this, move, false)) {
						moves.add(move);
					}
					break;
				}
			}
			else {
				int[] move = {row, i};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		return moves;
	}
	
	@Override
	public ArrayList<int[]> movesCheckChecker(Piece[][] board) {
		
		// Get the king
		/*King king;
		
		for (int r=0; r<8; r++) {
			for (int c=0; c<8; c++) {
				if (board[r][c].getType() == 'K' && board[r][c].getTeam() == this.getTeam()) {
					king = (King) board[r][c];
				}
			}
		}*/
		
		ArrayList<int[]> moves = new ArrayList<>();
		
		int row = this.getPosition()[0];
		int column = this.getPosition()[1];
		
		
		// Check rows below this rook
		for (int i = row-1; i >= 0; i--) {
			
			if (board[i][column] != null) {
				if (board[i][column].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, column};
						moves.add(move);
						break;
				}
			}
			else {
				int[] move = {i, column};
				moves.add(move);
			}
		}
		
		// Check rows above this rook
		for (int i = row+1; i < 8; i++) {
			
			if (board[i][column] != null) {
				if (board[i][column].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, column};
					moves.add(move);
					break;
				}
			}
			else {
				int[] move = {i, column};
				moves.add(move);
			}
		}
		
		// Check columns to the right of this rook
		for (int i = column+1; i < 8; i++) {
			
			if (board[row][i] != null) {
				if (board[row][i].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {row, i};
					moves.add(move);
					break;
				}
			}
			else {
				int[] move = {row, i};
				moves.add(move);
			}
		}
		
		// Check columns to the left of this rook
		for (int i = column-1; i >= 0; i--) {
			
			if (board[row][i] != null) {
				if (board[row][i].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {row, i};
					moves.add(move);
					break;
				}
			}
			else {
				int[] move = {row, i};
				moves.add(move);
			}
		}
		
		return moves;
	}
}