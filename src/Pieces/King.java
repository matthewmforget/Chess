package Pieces;
import java.util.ArrayList;

import Game.*;

public class King extends Piece{
	
	private boolean isFirstMove;
	
	
	/**
	 * Constructor
	 * @param position is the position in the 2D array (the board) that this piece is on
	 * @param type is the type of piece (bishop, rook, etc.)
	 * @param team is the team the piece is on (black or white)
	 */
	public King (int[] position, char type, char team) {
		super(position, type, team);
		this.isFirstMove = true;
	}
	
	
	// GET METHODS
	
	/**
	 * Returns true if this is the kings first move
	 * @return a boolean value to tell if this is the kings first move
	 */
	public boolean getIsFirstMove() {
		return this.isFirstMove;
	}
	
	@Override
	public King copy() {
		return new King(this.getPosition(), this.getType(), this.getTeam());
	}
	
	
	
	// SET METHODS
	
	/**
	 * Method to set if this is the kings first move or not
	 * @param a boolean value to tell if this is the kings first move
	 */
	public void setIsFirstMove() {
		this.isFirstMove = false;
	}
	
	
	
	// MOVEMENTS //
	
	/**
	 * Finds the kings possible move
	 * @return returns an array list of arrays corresponding to the possible positions this piece can move to on the
	 * 	       board
	 */
	public ArrayList<int[]> calculateLegalMove(Board board) {
		
		ArrayList<int[]> moves = new ArrayList<int[]>();
		
		// Get the knights position in the board 
		int row = this.getPosition()[0];
		int column = this.getPosition()[1];
		System.out.println("row : "+row);
		
		// Check first possible move
		if (row-1 >= 0 && column-1 >= 0) {
			System.out.println("we in first condition");
			if ( (board.getBoard()[row - 1][column - 1] == null) || 
				 (board.getBoard()[row - 1][column - 1].getTeam() != this.getTeam())) {
				System.out.println("we in second condition");
				int[] move = {row-1, column-1};
				if (board.validateMove(this, move, false)) {
					System.out.println("we in third condition");
					moves.add(move);
				}
			}
		}
		// Check second possible move
		if (row-1 >= 0 && column+1 < 8) {
			if ( (board.getBoard()[row - 1][column + 1] == null) || 
				 (board.getBoard()[row - 1][column + 1].getTeam() != this.getTeam())) {
				int[] move = {row-1, column+1};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check third possible move
		if (row+1 < 8 && column-1 >= 0) {
			if ( (board.getBoard()[row + 1][column - 1] == null) || 
				 (board.getBoard()[row + 1][column - 1].getTeam() != this.getTeam())) {
				int[] move = {row+1, column-1};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		// Check fourth possible move
		if (row+1 < 8 && column+1 < 8) {
			if ( (board.getBoard()[row + 1][column + 1] == null) || 
				 (board.getBoard()[row + 1][column + 1].getTeam() != this.getTeam())) {
				int[] move = {row+1, column+1};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check fifth possible move
		if (row+1 < 8) {
			if ( (board.getBoard()[row + 1][column] == null) || 
				 (board.getBoard()[row + 1][column].getTeam() != this.getTeam())) {
				int[] move = {row+1, column};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check sixth possible move
		if (row-1 >= 0) {
			if ( (board.getBoard()[row - 1][column] == null) || 
				 (board.getBoard()[row - 1][column].getTeam() != this.getTeam())) {
				int[] move = {row-1, column};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check seventh possible move
		if (column+1 < 8) {
			if ( (board.getBoard()[row][column + 1] == null) || 
				 (board.getBoard()[row][column + 1].getTeam() != this.getTeam())) {
				int[] move = {row, column+1};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check eighth possible move
		if (column-1 >= 0) {
			if ( (board.getBoard()[row][column - 1] == null) || 
				 (board.getBoard()[row][column - 1].getTeam() != this.getTeam())) {
				int[] move = {row, column-1};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		return moves;
	}


	@Override
	public ArrayList<int[]> movesCheckChecker(Piece[][] board) {
		
		ArrayList<int[]> moves = new ArrayList<int[]>();
		
		// Get the knights position in the board 
		int row = this.getPosition()[0];
		int column = this.getPosition()[1];
		
		// Check first possible move
		if (row-1 >= 0 && column-1 >= 0) {
			if ( (board[row - 1][column - 1] == null) || 
				 (board[row - 1][column - 1].getTeam() != this.getTeam())) {
				moves.add(new int[] {row-1, column-1});
			}
		}
		// Check second possible move
		if (row-1 >= 0 && column+1 < 8) {
			if ( (board[row - 1][column + 1] == null) || 
				 (board[row - 1][column + 1].getTeam() != this.getTeam())) {
				moves.add(new int[] {row-1, column+1});
			}
		}
		
		// Check third possible move
		if (row+1 < 8 && column-1 >= 0) {
			if ( (board[row + 1][column - 1] == null) || 
				 (board[row + 1][column - 1].getTeam() != this.getTeam())) {
				moves.add(new int[] {row+1, column-1});
			}
		}
		// Check fourth possible move
		if (row+1 < 8 && column+1 < 8) {
			if ( (board[row + 1][column + 1] == null) || 
				 (board[row + 1][column + 1].getTeam() != this.getTeam())) {
				moves.add(new int[] {row+1, column+1});
			}
		}
		
		// Check fifth possible move
		if (row+1 < 8) {
			if ( (board[row + 1][column] == null) || 
				 (board[row + 1][column].getTeam() != this.getTeam())) {
				moves.add(new int[] {row+1, column});
			}
		}
		
		// Check sixth possible move
		if (row-1 >= 0) {
			if ( (board[row - 1][column] == null) || 
				 (board[row - 1][column].getTeam() != this.getTeam())) {
				moves.add(new int[] {row-1, column});
			}
		}
		
		// Check seventh possible move
		if (column+1 < 8) {
			if ( (board[row][column + 1] == null) || 
				 (board[row][column + 1].getTeam() != this.getTeam())) {
				moves.add(new int[] {row, column+1});
			}
		}
		
		// Check eighth possible move
		if (column-1 >= 0) {
			if ( (board[row][column - 1] == null) || 
				 (board[row][column - 1].getTeam() != this.getTeam())) {
				moves.add(new int[] {row, column-1});
			}
		}
		
		return moves;
	}
}