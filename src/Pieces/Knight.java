package Pieces;
import java.util.ArrayList;

import Game.*;

public class Knight extends Piece{
	
	
	/**
	 * Constructor
	 * @param position is the position in the 2D array (the board) that this piece is on
	 * @param type is the type of piece (bishop, rook, etc.)
	 * @param team is the team the piece is on (black or white)
	 */
	public Knight (int[] position, char type, char team) {
		super(position, type, team);
	}
	
	@Override
	public Knight copy() {
		return new Knight(this.getPosition(), this.getType(), this.getTeam());
	}
	
	
	
	
	// MOVEMENTS //
	
	/**
	 * @return returns an array list of arrays corresponding to the possible positions this piece can move to on the
	 * 	       board
	 */
	public ArrayList<int[]> calculateLegalMove(Board board) {
		
		ArrayList<int[]> moves = new ArrayList<int[]>();
		
		// Get the knights position in the board 
		int row = this.getPosition()[0];
		int column = this.getPosition()[1];
		
		
		// Check first possible move
		if (row-2 >= 0 && column-1 >= 0) {
			if ( (board.getBoard()[row - 2][column - 1] == null) || 
				 (board.getBoard()[row - 2][column - 1].getTeam() != this.getTeam())) {
				int[] move = new int[] {row-2, column-1};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		// Check second possible move
		if (row-2 >= 0 && column+1 < 8) {
			if ( (board.getBoard()[row - 2][column + 1] == null) || 
				 (board.getBoard()[row - 2][column + 1].getTeam() != this.getTeam())) {
				int[] move = new int[] {row-2, column+1};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check third possible move
		if (row+2 < 8 && column-1 >= 0) {
			if ( (board.getBoard()[row + 2][column - 1] == null) || 
				 (board.getBoard()[row + 2][column - 1].getTeam() != this.getTeam())) {
				int[] move = new int[] {row+2, column-1};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check fourth possible move
		if (row+2 < 8 && column+1 < 8) {
			if ( (board.getBoard()[row + 2][column + 1] == null) || 
				 (board.getBoard()[row + 2][column + 1].getTeam() != this.getTeam())) {
				int[] move = new int[] {row+2, column+1};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check fifth possible move
		if (row+1 < 8 && column+2 < 8) {
			if ( (board.getBoard()[row + 1][column + 2] == null) || 
				 (board.getBoard()[row + 1][column + 2].getTeam() != this.getTeam())) {
				int[] move = new int[] {row+1, column+2};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check sixth possible move
		if (row+1 < 8 && column-2 >= 0) {
			if ( (board.getBoard()[row + 1][column - 2] == null) || 
				 (board.getBoard()[row + 1][column - 2].getTeam() != this.getTeam())) {
				int[] move = new int[] {row+1, column-2};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check seventh possible move
		if (row-1 >= 0 && column+2 < 8) {
			if ( (board.getBoard()[row - 1][column + 2] == null) || 
				 (board.getBoard()[row - 1][column + 2].getTeam() != this.getTeam())) {
				int[] move = new int[] {row-1, column+2};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check eighth possible move
		if (row-1 >= 0 && column-2 >= 0) {
			if ( (board.getBoard()[row - 1][column - 2] == null) || 
				 (board.getBoard()[row - 1][column - 2].getTeam() != this.getTeam())) {
				int[] move = new int[] {row-1, column-2};
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
		if (row-2 >= 0 && column-1 >= 0) {
			if ( (board[row - 2][column - 1] == null) || 
				 (board[row - 2][column - 1].getTeam() != this.getTeam())) {
				moves.add(new int[] {row-2, column-1});
			}
		}
		// Check second possible move
		if (row-2 >= 0 && column+1 < 8) {
			if ( (board[row - 2][column + 1] == null) || 
				 (board[row - 2][column + 1].getTeam() != this.getTeam())) {
				moves.add(new int[] {row-2, column+1});
			}
		}
		
		// Check third possible move
		if (row+2 < 8 && column-1 >= 0) {
			if ( (board[row + 2][column - 1] == null) || 
				 (board[row + 2][column - 1].getTeam() != this.getTeam())) {
				moves.add(new int[] {row+2, column-1});
			}
		}
		
		// Check fourth possible move
		if (row+2 < 8 && column+1 < 8) {
			if ( (board[row + 2][column + 1] == null) || 
				 (board[row + 2][column + 1].getTeam() != this.getTeam())) {
				moves.add(new int[] {row+2, column+1});
			}
		}
		
		// Check fifth possible move
		if (row+1 < 8 && column+2 < 8) {
			if ( (board[row + 1][column + 2] == null) || 
				 (board[row + 1][column + 2].getTeam() != this.getTeam())) {
				moves.add(new int[] {row+1, column+2});
			}
		}
		
		// Check sixth possible move
		if (row+1 < 8 && column-2 >= 0) {
			if ( (board[row + 1][column - 2] == null) || 
				 (board[row + 1][column - 2].getTeam() != this.getTeam())) {
				moves.add(new int[] {row+1, column-2});
			}
		}
		
		// Check seventh possible move
		if (row-1 >= 0 && column+2 < 8) {
			if ( (board[row - 1][column + 2] == null) || 
				 (board[row - 1][column + 2].getTeam() != this.getTeam())) {
				moves.add(new int[] {row-1, column+2});
			}
		}
		
		// Check eighth possible move
		if (row-1 >= 0 && column-2 >= 0) {
			if ( (board[row - 1][column - 2] == null) || 
				 (board[row - 1][column - 2].getTeam() != this.getTeam())) {
				moves.add(new int[] {row-1, column-2});
			}
		}
		
		return moves;
	}
}