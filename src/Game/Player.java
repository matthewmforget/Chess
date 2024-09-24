package Game;

import Pieces.*;
import java.util.ArrayList;

public class Player {
	
	private char team;
	private ArrayList<Piece> pieces;
	private Game game;
	
	/**
	 * Constructor
	 * @param team is a char that tells us what team this player is on. 'W' for white, 'B' for black
	 * @param pieces is a list of Piece for this player
	 * @param game is the Game object this player is playing on
	 */
	public Player (char team, ArrayList<Piece> pieces, Game game) {
		this.team = team;
		this.pieces = pieces;
		this.game = game;
	}
	
	
	
	// GET METHODS
	
	/**
	 * Returns the team this player is on
	 * @return is a char associated with this Players team. 'W' for white. 'B for black.
	 */
	public char getTeam() {
		return this.team;
	}
	
	/**
	 * Returns this players active pieces
	 * @return is an ArrayList of this players active Piece objects
	 */
	public ArrayList<Piece> getPieces() {
		return this.pieces;
	}
	
	/**
	 * Returns the game this player is playing
	 * @return is a Game object associated with this player
	 */
	public Game getGame() {
		return this.game;
	}
	
	
	
	// SET METHODS
	
	/**
	 * Sets the team for this player
	 * @param team is a char. Either 'W' for white, or 'B' for black
	 */
	public void setTeam(char team) {
		this.team = team;
	}
	
	/**
	 * Sets the list of pieces for this player
	 * @param pieces is a List of Piece objects for this player
	 */
	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}
	
	/**
	 * Sets the Game for this player
	 * @param game is a Game object that this player is using
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	
	
	
	// UTILITY METHODS
	
	/**
	 * Adds a piece to the list of pieces. Mostly for pawn promotion, or potential other game types
	 * @param piece is the Piece object to be added
	 */
	public void addPiece(Piece piece) {
		this.pieces.add(piece);
	}
	
	/**
	 * Removes a piece to the list of pieces. Mostly for pawn promotion, or potential other game types
	 * @param piece is the Piece object to be added
	 */
	public void removePiece(Piece piece) {
		this.pieces.remove(piece);
	}
	
	public void move(Piece piece, int[] destination) {
		Move move = new Move(piece.getPosition(), destination, piece, 
						this.game.getBoard().getBoard()[destination[0]][destination[1]], 
						this.game.getBoard().getBoard());
		if (this.game.makeMove(move)) {
			this.game.getBoard().setBoard(piece, destination);
		}
	}
	
	public void pieceClicked(Piece piece) {
		ArrayList<int[]> moves = piece.calculateLegalMove(this.game.getBoard());
		/*
		 * TODO think of how to highlight moves like chess.com does. Maybe this can be done in the GUI
		 * this.game.getBoard().highlightPossibleMoves(moves);
		 */
	}
}
