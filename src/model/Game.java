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

	/**
	 * Atributo booleano que indica si el juego ha acabado
	 */
	private boolean gameEnded;
	/**
	 * Atributo Gameboard que almacena un tablero
	 */
	private Gameboard board;
	/**
	 * Atributo Piece que almacena la pieza actual
	 */
	private Piece currentPiece;
	/**
	 * Atributo Coordinate que almacena la posicion actual
	 */
	private Coordinate currentPosition;
	
	
	/**
	 * Constructor de la clase Game
	 * Construye un nuevo tablero y pone el juego como NO finalizado
	 * @param c Coordenada tamaño del tablero para iniciarlo
	 */
	public Game(Coordinate c) {
		
		this.board = new Gameboard(c);
		this.gameEnded = false;
	}
	
	
	//MOVEMENT METHODS
	/**
	 * Mueve la pieza a la izquierda
	 */
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
	
	/**
	 * Mueve la pieza a la derecha
	 */
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
	
	/**
	 * Mueve la pieza hacia abajo
	 */
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
	
	/**
	 * Rota la pieza en sentido antihorario
	 */
	public void rotateCurrentPieceCounterclockwise() {
		
		this.currentPiece.rotateCounterclockwise();
		this.board.removePiece(currentPiece);
		this.board.putPiece(currentPosition, currentPiece);
	}
	
	/**
	 * Rota la pieza en sentido horario
	 */
	public void rotateCurrentPieceClockwise() {
		
		this.currentPiece.rotateClockwise();
		this.board.removePiece(currentPiece);
		this.board.putPiece(currentPosition, currentPiece);
	}
	
	
	//GAME METHODS
	/**
	 * Crea una nueva pieza y la coloca en lo alto del tablero.
	 * @return Boolean que indica si hay pieza nueva
	 */
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
	
	/**
	 * Comprueba si la pieza esta fija
	 * @return Boolean que indica si la pieza esta fija (True) o si NO lo esta (False)
	 */
	public boolean isCurrentPieceFixed() {
		return this.currentPiece.isFixed();
	}
	
	/**
	 * Comprueba si el juego ha acabado
	 * @return Boolean que indica si ha acabado (True) o si NO ha acabado (False)
	 */
	public boolean isGameEnded() {	
		return this.gameEnded;
	}
	
	//OTHER METHODS
	/**
	 * Devuelve un string con las posiciones del tablero
	 * @return String con las posiciones del tablero
	 */
	@Override
	public String toString() {
		return this.board.toString();
	}
}
