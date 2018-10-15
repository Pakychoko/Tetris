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
	
	private Piece p;
	
	
	public Game(Coordinate c) {
		
		this.board = new Gameboard(c);
	}
	
	
	//MOVEMENT METHODS
	public void moveCurrentPieceLeft() {
		
	}
	
	public void moveCurrentPieceRight() {
		
	}
	
	public void moveCurrentPieceDown() {
		
	}
	
	public void rotateCurrentPieceCounterclockwise() {
		
	}
	
	public void rotateCurrentPieceClockwise() {
		
	}
	
	
	//GAME METHODS
	public boolean nextPiece() {
		
		this.p = new Piece();	
		Coordinate currentPosition = new Coordinate(0, board.getWidth() / 2 - 2);
		return false;
	}
	
	public boolean isCurrentPieceFixed() {
		return p.isFixed();
	}
	
	public boolean isGameEnded() {	
		return this.gameEnded;
	}
	
	//OTHER METHODS
	@Override
	public String toString() {
		return board.toString();
	}
}
