package Game;

import java.util.ArrayList;
import java.util.HashMap;

import Pieces.*;

public class Board {
	
	private Piece[][] board;
	private char inCheck;
	
	/**
	 * Constructor. Initializes a new board with new pieces in position
	 */
	public Board () {
		
		this.inCheck = 'N';
		
		// Initialize black pieces
		
		// Black pieces 
		this.board = new Piece[8][8];
		this.board[0][0] = new Rook(new int[]{0, 0}, 'R', 'B');
        this.board[0][1] = new Knight(new int[]{0, 1}, 'N', 'B');
        this.board[0][2] = new Bishop(new int[]{0, 2}, 'B', 'B');
        this.board[0][3] = new Queen(new int[]{0, 3}, 'Q', 'B');
        this.board[0][4] = new King(new int[]{0, 4}, 'K', 'B');
        this.board[0][5] = new Bishop(new int[]{0, 5}, 'B', 'B');
        this.board[0][6] = new Knight(new int[]{0, 6}, 'N', 'B');
        this.board[0][7] = new Rook(new int[]{0, 7}, 'R', 'B');
        
        // Black pawns
        this.board[1][0] = new Pawn(new int[]{1, 0}, 'P', 'B');
        this.board[1][1] = new Pawn(new int[]{1, 1}, 'P', 'B');
        this.board[1][2] = new Pawn(new int[]{1, 2}, 'P', 'B');
        this.board[1][3] = new Pawn(new int[]{1, 3}, 'P', 'B');
        this.board[1][4] = new Pawn(new int[]{1, 4}, 'P', 'B');
        this.board[1][5] = new Pawn(new int[]{1, 5}, 'P', 'B');
        this.board[1][6] = new Pawn(new int[]{1, 6}, 'P', 'B');
        this.board[1][7] = new Pawn(new int[]{1, 7}, 'P', 'B');
        
        // Initialize white pieces
        
        // White pieces
        this.board[7][0] = new Rook(new int[]{7, 0}, 'R', 'W');
        this.board[7][1] = new Knight(new int[]{7, 1}, 'N', 'W');
        this.board[7][2] = new Bishop(new int[]{7, 2}, 'B', 'W');
        this.board[7][3] = new Queen(new int[]{7, 3}, 'Q', 'W');
        this.board[7][4] = new King(new int[]{7, 4}, 'K', 'W');
        this.board[7][5] = new Bishop(new int[]{7, 5}, 'B', 'W');
        this.board[7][6] = new Knight(new int[]{7, 6}, 'N', 'W');
        this.board[7][7] = new Rook(new int[]{7, 7}, 'R', 'W');

        // White pawns
        this.board[6][0] = new Pawn(new int[]{6, 0}, 'P', 'W');
        this.board[6][1] = new Pawn(new int[]{6, 1}, 'P', 'W');
        this.board[6][2] = new Pawn(new int[]{6, 2}, 'P', 'W');
        this.board[6][3] = new Pawn(new int[]{6, 3}, 'P', 'W');
        this.board[6][4] = new Pawn(new int[]{6, 4}, 'P', 'W');
        this.board[6][5] = new Pawn(new int[]{6, 5}, 'P', 'W');
        this.board[6][6] = new Pawn(new int[]{6, 6}, 'P', 'W');
        this.board[6][7] = new Pawn(new int[]{6, 7}, 'P', 'W');
	}
	
	
	
	
	// GET METHODS
	
	/**
	 * Returns if there is a check and which colour is in check
	 * @return is char. 'B' for black, 'W' for white, and 'N' for no check
	 */
	public char getInCheck() {
		return this.inCheck;
	}
	
	/**
	 * Returns the current board
	 * @return is a Piece 2D array corresponding with the current board
	 */
	public Piece[][] getBoard(){
		return this.board;
	}
	
	
	
	
	// SET METHODS
	
	/**
	 * Sets if a player is in check
	 * @param inCheck is a char to set if a player is in check or not
	 */
	public void setInCheck(char inCheck) {
		this.inCheck = inCheck;
	}
	
	public void setBoard(Piece piece, int[] index) {
		this.board[index[0]][index[1]] = piece;
	}
	
	
	
	
	// UTILITY METHODS
	
	
	/**
	 * Returns a list of black pieces on the board
	 * @return an ArrayList of Pieces with team = 'B' (team black)
	 */
	public ArrayList<Piece> getBlackPieces() {
		ArrayList<Piece> blackPieces = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.board[i][j] != null && this.board[i][j].getTeam() == 'B') {
					blackPieces.add(this.board[i][j]);
				}
			}
		}
		return blackPieces;
	}
	
	/**
	 * Returns a list of white pieces on the board
	 * @return an ArrayList of Pieces with team = 'W' (team white)
	 */
	public ArrayList<Piece> getWhitePieces() {
		ArrayList<Piece> whitePieces = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.board[i][j] != null && this.board[i][j].getTeam() == 'W') {
					whitePieces.add(this.board[i][j]);
				}
			}
		}
		return whitePieces;
	}
	
	public King getKing(char team, Piece[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] != null && board[i][j].getType() == 'K' && board[i][j].getTeam() == team) {
					return (King) board[i][j];
				}
			}
		}
		return null;
	}
	
	
	public boolean isKingInCheck(char team, Piece[][] board) {
		
		// Lets return all ghe pieces causing the king to be in check
		// TODO add this functionality. Replace return value 'boolean' with 'HashMap'
		HashMap<Piece, int[]> piecesCausingCheck = new HashMap<Piece, int[]>();
		
		
		// An array to store the pieces from the chess board and one to store each pieces movies
		ArrayList<Piece> pieces = new ArrayList<>();
		ArrayList<int[]> moves = new ArrayList<>();
		
		// Get the king so we 
		King king = getKing(team, board);
		
		
		// Get black or white pieces on current board
		if (team == 'W') { 
			// get black pieces
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] != null && board[i][j].getTeam() == 'B') {
						pieces.add(board[i][j]);
						//System.out.println("Piece :" + this.boa);
					}
				}
			}
		}
		else {
			// get white pieces
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] != null && board[i][j].getTeam() == 'W') {
						pieces.add(board[i][j]);
					}
				}
			}
		}
		
		// For each piece, calculate its legal moves, and see if any of the moves land on the kings space
		// If it does, then the current move on the board object is illegal since it puts the ally king in check
		for (Piece piece : pieces) {
			moves = piece.movesCheckChecker(board);
			for (int[] move : moves) {
				if (move[0] == king.getPosition()[0] && move[1] == king.getPosition()[1]) {
					System.out.println("inside ting mon");
					System.out.println("Piece: " + piece.getType() + "Team: " + piece.getTeam());
					System.out.println("Position: " + piece.getPosition()[0] + ", " + piece.getPosition()[1]);
					System.out.println("Move :" + move[0] + ", " + move[1]);
					for (int r = 0; r < 8; r++) {
				        for (int c = 0; c < 8; c++) {
				            if (board[r][c] == null) {
				                System.out.print(" - ");  // Empty square
				            } else {
				                System.out.print(" " + board[r][c].getType() + " ");  // Piece's symbol
				            }
				        }
				        System.out.println();  // Move to the next row
				    }
				    System.out.println();
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean validateMove(Piece piece, int[] move, boolean enpassant) {
		
		if (enpassant) {
			Piece[][] newBoard = new Piece[8][8];
			
			// Copy original board
			for (int r=0; r<8; r++) {
				for (int c=0; c<8; c++) {
					if (this.board[r][c] != null) {
						newBoard[r][c] = this.board[r][c].copy();
					}
					else {
						newBoard[r][c] = null;
					}
				}
			}	
			
			Piece copy = newBoard[piece.getPosition()[0]][piece.getPosition()[1]];
			newBoard[move[0]][move[1]] = copy;
			copy.setPosition(new int[] {move[0], move[1]});
			int[] nums = piece.getPosition();
			newBoard[nums[0]][nums[1]] = null;
			int team = 1;
			if (piece.getTeam() == 'W') {
				team = -1;
			}
			newBoard[move[0]-team][move[1]] = null;
			
			
			return !this.isKingInCheck(piece.getTeam(), newBoard);
		}
		
		Piece[][] newBoard = new Piece[8][8];
		
		// Copy original board
		for (int r=0; r<8; r++) {
			for (int c=0; c<8; c++) {
				if (this.board[r][c] != null) {
					newBoard[r][c] = this.board[r][c].copy();
				}
				else {
					newBoard[r][c] = null;
				}
			}
		}	
		
		Piece copy = newBoard[piece.getPosition()[0]][piece.getPosition()[1]];
		newBoard[move[0]][move[1]] = copy;
		copy.setPosition(new int[] {move[0], move[1]});
		int[] nums = piece.getPosition();
		newBoard[nums[0]][nums[1]] = null;
		
		/*for (int r = 0; r < 8; r++) {
	        for (int c = 0; c < 8; c++) {
	            if (newBoard[r][c] == null) {
	                System.out.print(" - ");  // Empty square
	            } else {
	                System.out.print(" " + newBoard[r][c].getType() + " ");  // Piece's symbol
	            }
	        }
	        System.out.println();  // Move to the next row
	    }
	    System.out.println();*/
		
		return !this.isKingInCheck(piece.getTeam(), newBoard);
	}
	
	public void printBoard() {
	    for (int r = 0; r < 8; r++) {
	        for (int c = 0; c < 8; c++) {
	            if (this.board[r][c] == null) {
	                System.out.print(" - ");  // Empty square
	            } else {
	                System.out.print(" " + this.board[r][c].getType() + " ");  // Piece's symbol
	            }
	        }
	        System.out.println();  // Move to the next row
	    }
	    System.out.println();
	}

}