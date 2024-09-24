package Pieces;
import java.util.ArrayList;

import Game.*;

public class Queen extends Piece{
	
	
	/**
	 * Constructor
	 * @param position is the position in the 2D array (the board) that this piece is on
	 * @param type is the type of piece (bishop, rook, etc.)
	 * @param team is the team the piece is on (black or white)
	 */
	public Queen (int[] position, char type, char team) {
		super(position, type, team);
	}
	
	@Override
	public Queen copy() {
		return new Queen(this.getPosition(), this.getType(), this.getTeam());
	}
	
	
	
	// MOVEMENTS //
	
	/**
	 * Calculates the possible moves for the queen
	 * @return returns an array list of arrays corresponding to the possible positions this piece can move to on the
	 * 	       board
	 */
	public ArrayList<int[]> calculateLegalMove(Board board) {
		
		
		// QUEEN MOVES ARE JUST ROOK AND BISHOP MOVES
		
		ArrayList<int[]> moves = new ArrayList<>();
		
		int row = this.getPosition()[0];
		int column = this.getPosition()[1];
		
		
		// CHECK POSSIBLE ROOK MOVES FIRST

		
		
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
		
		
		// CHECK BISHOP POSSIBLE MOVES

		
		
		
		// Check tiles left and below this bishop
		for (int i = row-1, j = column-1; i >= 0 && j >= 0; i--, j--) {
			
			if (board.getBoard()[i][j] != null) {
				if (board.getBoard()[i][j].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, j};
					if (board.validateMove(this, move, false)) {
						moves.add(move);
					}
					break;
				}
			}
			else {
				int[] move = {i, j};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check tiles left and above this bishop
		for (int i = row+1, j = column-1; i < 8 && j >= 0; i++, j--) {
			
			if (board.getBoard()[i][j] != null) {
				if (board.getBoard()[i][j].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, j};
					if (board.validateMove(this, move, false)) {
						moves.add(move);
					}
					break;
				}
			}
			else {
				int[] move = {i, j};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check tiles right and below this bishop
		for (int i = row-1, j = column+1; i >= 0 && j < 8; i--, j++) {
			
			if (board.getBoard()[i][j] != null) {
				if (board.getBoard()[i][j].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, j};
					if (board.validateMove(this, move, false)) {
						moves.add(move);
					}
					break;
				}
			}
			else {
				int[] move = {i, j};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		// Check tiles right and above this bishop
		for (int i = row+1, j = column+1; i < 8 && j < 8; i++, j++) {
			
			if (board.getBoard()[i][j] != null) {
				if (board.getBoard()[i][j].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, j};
					if (board.validateMove(this, move, false)) {
						moves.add(move);
					}
					break;
				}
			}
			else {
				int[] move = {i, j};
				if (board.validateMove(this, move, false)) {
					moves.add(move);
				}
			}
		}
		
		return moves;
	}

	@Override
	public ArrayList<int[]> movesCheckChecker(Piece[][] board) {
		
		ArrayList<int[]> moves = new ArrayList<>();
		
		int row = this.getPosition()[0];
		int column = this.getPosition()[1];
		
		
		
		// CHECK ROOK POSSIBLE MOVES
		
		
		
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
		
		
		// CHECK BISHOP POSSIBLE MOVES

		
		
		// Check tiles left and below this bishop
		for (int i = row-1, j = column-1; i >= 0 && j >= 0; i--, j--) {
			
			if (board[i][j] != null) {
				if (board[i][j].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, j};
					moves.add(move);
					break;
				}
			}
			else {
				int[] move = {i, j};
				moves.add(move);
			}
		}
		
		// Check tiles left and above this bishop
		for (int i = row+1, j = column-1; i < 8 && j >= 0; i++, j--) {
			
			if (board[i][j] != null) {
				if (board[i][j].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, j};
					moves.add(move);
					break;
				}
			}
			else {
				int[] move = {i, j};
				moves.add(move);
			}
		}
		
		// Check tiles right and below this bishop
		for (int i = row-1, j = column+1; i >= 0 && j < 8; i--, j++) {
			
			if (board[i][j] != null) {
				if (board[i][j].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, j};
					moves.add(move);
					break;
				}
			}
			else {
				int[] move = {i, j};
				moves.add(move);
			}
		}
		
		// Check tiles right and above this bishop
		for (int i = row+1, j = column+1; i < 8 && j < 8; i++, j++) {
			
			if (board[i][j] != null) {
				if (board[i][j].getTeam() == this.getTeam()) {
					break;
				}
				else {
					int[] move = {i, j};
					moves.add(move);
					break;
				}
			}
			else {
				int[] move = {i, j};
				moves.add(move);
			}
		}
		
		return moves;
	}
}