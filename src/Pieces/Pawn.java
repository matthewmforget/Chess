package Pieces;
import java.util.ArrayList;

import Game.*;

public class Pawn extends Piece{
	
	private boolean isFirstMove;
	
	
	/**
	 * Constructor
	 * @param position is the position in the 2D array (the board) that this piece is on
	 * @param type is the type of piece (bishop, rook, etc.)
	 * @param team is the team the piece is on (black or white)
	 */
	public Pawn (int[] position, char type, char team) {
		super(position, type, team);
		this.isFirstMove = true;
	}
	
	
	
	
	// GET METHODS
	
	/**
	 * Returns true if this is the pawns first move
	 * @return a boolean value to tell if this is the pawns first move
	 */
	public boolean getIsFirstMove() {
		return this.isFirstMove;
	}
	
	@Override
	public Pawn copy() {
		return new Pawn(this.getPosition(), this.getType(), this.getTeam());
	}
	
	
	
	// SET METHODS
	
		/**
		 * Method to set if this is the pawns first move or not
		 * @param a boolean value to tell if this is the pawns first move
		 */
		public void setIsFirstMove() {
			this.isFirstMove = false;
		}
	
	
	
	
	// MOVEMENTS //
	
	/**
	 * @return returns an array list of arrays corresponding to the possible positions this piece can move to on the
	 * 	       board
	 */
	protected ArrayList<int[]> calculateLegalMove() {
		return null;
	}




	@Override
	public ArrayList<int[]> calculateLegalMove(Board board) {
		
		ArrayList<int[]> moves = new ArrayList<>();
		
		int row = this.getPosition()[0];
		int column = this.getPosition()[1];
		int team;
		if (this.getTeam() == 'W') {
			team = -1;
		}
		else {
			team = 1;
		}
		
		// Check first move
		if (row + team >= 0 && row + team < 8) {
			if (board.getBoard()[row+team][column] == null) {
				if (board.validateMove(this, new int[] {row+team, column}, false)) {
					moves.add(new int[] {row+team, column});
				}
			}
		}
		
		if (this.isFirstMove) {
			if (board.getBoard()[row+team][column] == null && board.getBoard()[row+team+team][column] == null) {
				if (board.validateMove(this, new int[] {row+team+team, column}, false)) {
					moves.add(new int[] {row+team+team, column});
				}
			}
		}
		
		
		// Check en passant to the right
		 
		if (!this.isFirstMove && Game.moveHistory.size() > 0) {
			if (column+1 < 8) {
				if (board.getBoard()[row][column+1] != null) {
					if (board.getBoard()[row][column+1].getType() == 'P' && board.getBoard()[row][column+1].getTeam() != this.getTeam()) {
						if (Game.moveHistory.getLast().getMovedPiece() == board.getBoard()[row][column+1] &&
								Game.moveHistory.getLast().getOldPosition()[0] == board.getBoard()[row][column+1].getPosition()[0] - 2) {
							if (board.validateMove(this, new int[] {row+team, column+1}, true)) {
								moves.add(new int[] {row+team, column+1});
							}
						}
					}
				}
			}
		}
		
		// Check en passant to the left
		
		if (!this.isFirstMove && Game.moveHistory.size() > 0) {
			System.out.println("moveHistory size: " + Game.moveHistory.size());
			if (column-1 >= 0) {
				if (board.getBoard()[row][column-1] != null) {
					System.out.println("inside checker now");
					System.out.println(Game.moveHistory.getLast().getMovedPiece() == board.getBoard()[row][column-1]);
					System.out.println(Game.moveHistory.getLast().getOldPosition()[0]);
					if (board.getBoard()[row][column-1].getType() == 'P' && board.getBoard()[row][column-1].getTeam() != this.getTeam()) {
						if (Game.moveHistory.getLast().getMovedPiece() == board.getBoard()[row][column-1] &&
								Game.moveHistory.getLast().getOldPosition()[0] == board.getBoard()[row][column-1].getPosition()[0] - 2) {
							System.out.println("inside final step of checker");
							if (board.validateMove(this, new int[] {row+team, column-1}, true)) {
								moves.add(new int[] {row+team, column-1});
							}
						}
					}
				}
			}
		}
		
		
		// Check possible diagonal attack
		if (row+team < 8 && row+team >= 0 && column+1 < 8) {
			if (board.getBoard()[row+team][column+1] != null) {
				if (board.getBoard()[row+team][column+1].getTeam() != this.getTeam()) {
					if (board.validateMove(this, new int[] {row+team, column+1}, false)) {
						moves.add(new int[] {row+team, column+1});
					}
				}
			}
		}
		
		// Check other possible diagonal attack
		if (row+team < 8 && row+team >= 0 && column-1 >= 0) {
			if (board.getBoard()[row+team][column-1] != null) {
				if (board.getBoard()[row+team][column-1].getTeam() != this.getTeam()) {
					if (board.validateMove(this, new int[] {row+team, column-1}, false)) {
						moves.add(new int[] {row+team, column-1});
					}
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
		int team;
		if (this.getTeam() == 'W') {
			team = -1;
		}
		else {
			team = 1;
		}
		
		// Check first move
		if (row + team >= 0 && row + team < 8) {
			if (board[row+team][column] == null) {
				moves.add(new int[] {row+team, column});
			}
		}
		
		if (this.isFirstMove) {
			if (board[row+team][column] == null && board[row+team+team][column] == null) {
				moves.add(new int[] {row+team+team, column});
			}
		}
		
		
		// Check en passant
		 
		if (!this.isFirstMove && Game.moveHistory.size() > 0) {
			if (column+1 < 8) {
				if (board[row][column+1] != null) {
					if (board[row][column+1].getType() == 'P' && board[row][column+1].getTeam() != this.getTeam()) {
						if (Game.moveHistory.getLast().getMovedPiece() == board[row][column+1] &&
								Game.moveHistory.getLast().getOldPosition()[0] == board[row][column+1].getPosition()[0] - 2) {
							moves.add(new int[] {row+team, column+1});
						}
					}
				}
			}
		}
		
		// Check en passant
		 
		if (!this.isFirstMove && Game.moveHistory.size() > 0) {
			if (column-1 >= 0) {
				if (board[row][column-1] != null) {
					if (board[row][column-1].getType() == 'P' && board[row][column-1].getTeam() != this.getTeam()) {
						if (Game.moveHistory.getLast().getMovedPiece() == board[row][column-1] &&
								Game.moveHistory.getLast().getOldPosition()[0] == board[row][column-1].getPosition()[0] - 2) {
							moves.add(new int[] {row+team, column-1});
						}
					}
				}
			}
		}
		
		
		// Check possible diagonal attack
		if (row+team < 8 && row+team >= 0 && column+1 < 8) {
			if (board[row+team][column+1] != null) {
				if (board[row+team][column+1].getTeam() != this.getTeam()) {
					moves.add(new int[] {row+team, column+1});
				}
			}
		}
		
		// Check other possible diagonal attack
		if (row+team < 8 && row+team >= 0 && column-1 >= 0) {
			if (board[row+team][column-1] != null) {
				if (board[row+team][column-1].getTeam() != this.getTeam()) {
					moves.add(new int[] {row+team, column-1});
				}
			}
		}
		
		return moves;
	}
}