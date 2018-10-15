/**
 * 
 */
package model;

/**
 * Clase que representa una partida al Tetris.
 * Incluye métodos para colocar una nueva pieza en lo alto del tablero,
 * y para moverla y rotarla hasta que quede fija;
 * @author Francisco Alejandro Azorin Gil 48643667R
 *
 */
public class Game {

	private boolean gameEnded;
	
	private Gameboard board;
	
	private Piece currentPiece;
	
	private Coordinate currentPosition;
	
	
	public Game(Coordinate c) {
		
		this.board = new Gameboard(c);
		this.gameEnded = false;
	}
	
	
	//MOVEMENT METHODS
	public void moveCurrentPieceLeft() {
		
		Coordinate newC = currentPosition.add(new Coordinate(0, -1));
		this.currentPosition = newC;

		if (!isCurrentPieceFixed() && !isGameEnded() && board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece)) {
			this.board.removePiece(currentPiece);
			this.board.putPiece(currentPosition, currentPiece);
		}
		else {
			this.currentPosition = currentPosition.add(new Coordinate(0, 1));
		}
	}
	
	public void moveCurrentPieceRight() {
		
		Coordinate newC = currentPosition.add(new Coordinate(0, 1));
		this.currentPosition = newC;
		
		if (!isCurrentPieceFixed() && !isGameEnded() && board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece)) {
			this.board.removePiece(currentPiece);
			this.board.putPiece(currentPosition, currentPiece);
		} else {
			this.currentPosition = currentPosition.add(new Coordinate(0, -1));
		}
	}
	
	public void moveCurrentPieceDown() {
		
		this.currentPosition = currentPosition.add(new Coordinate(1, 0));
		
		if (!this.board.isPlaceValid(currentPosition, currentPiece) || !board.isPlaceFree(currentPosition, currentPiece)) {
			
			this.currentPosition = currentPosition.add(new Coordinate(-1, 0));
			this.currentPiece.setFixed(true);

		} else {
			this.board.removePiece(currentPiece);
			this.board.putPiece(currentPosition, currentPiece);
		}
	}
	
	public void rotateCurrentPieceCounterclockwise() {
		
		this.currentPiece.rotateCounterclockwise();
		this.board.removePiece(currentPiece);
		this.board.putPiece(currentPosition, currentPiece);
	}
	
	public void rotateCurrentPieceClockwise() {
		
		this.currentPiece.rotateClockwise();
		this.board.removePiece(currentPiece);
		this.board.putPiece(currentPosition, currentPiece);
	}
	
	
	//GAME METHODS
	public boolean nextPiece() {
		
		this.currentPosition = new Coordinate(0, board.getWidth() / 2 - 2);
		boolean next = false;
		
		if (board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece)) {
			board.putPiece(currentPosition, currentPiece);
			next = true;
			
		} else {
			gameEnded = true;
		}
		
		return next;
	}
	
	public boolean isCurrentPieceFixed() {
		return this.currentPiece.isFixed();
	}
	
	public boolean isGameEnded() {	
		return this.gameEnded;
	}
	
	//OTHER METHODS
	@Override
	public String toString() {
		return this.board.toString();
	}
}
