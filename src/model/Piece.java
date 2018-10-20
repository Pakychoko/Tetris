/**
 * 
 */
package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa una pieza en el juego del Tetris.
 * Contiene su orientacion, si esta fija o no, el simbolo que usa, tamaño de su cuadro y la pieza dentro del cuadro.
 * 
 * @author Francisco Alejandro Azorin Gil 48643667R
 *
 */
public class Piece {

	/**
	 * Atributo de Piece que representa la orientacion de la pieza
	 */
	private Rotation orientation;
	
	/**
	 * Atributo de Piece que representa si esta fija o no
	 */
	private boolean fixed;
	
	/**
	 * Atributo de Piece que representa el simbolo de un bloque
	 */
	private char blockSymbol;
	
	/**
	 * Atributo de Piece que representa el tamaño del cuadro
	 */
	private static int BOUNDING_SQUARE_SIZE = 4;
	
	/**
	 * Atributo de Piece, almacena las 4 posiciones del Tetromino
	 */
	private int shape[][] = new int[][] {
	      { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
	      { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0 },
	      { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
	      { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } }; 
	
	/**
	 * Constructor por Defecto de Piece
	 */
	public Piece() {
		this.orientation = Rotation.D0;
		this.fixed = false;
		this.blockSymbol = '▒';
	}
	
	/**
	 * Constructor de Piece a partir de otra Piece
	 * @param p Objeto Piece
	 */
	public Piece(Piece p) {
		this.orientation = p.orientation;
		this.fixed = p.fixed;
		this.blockSymbol = p.blockSymbol;		
	}
	
	
	//METHODS GETTER SETTER TO STRING
	
	/**
	 * Metodo que indica si una pieza esta fijada o no
	 * @return True si esta fija o False si no lo esta
	 */
	public boolean isFixed() {
		return fixed;
	}
	
	/**
	 * Metodo que indica la orientacion de la pieza
	 * @return Rotation orientation
	 */
	public Rotation getOrientation() {
		return orientation;
	}
	
	/**
	 * Metodo que indica el simbolo de los bloques de la pieza
	 * @return character blockSymbol
	 */
	public char getBlockSymbol() {
		return blockSymbol;
	}
	
	/**
	 * Devuelve un conjunto (Set) que contiene todas las coordenadas del tablero que serán ocupadas 
	 * por la pieza si se posiciona con la esquina superior izquierda de su cuadrado delimitador
	 * en la posición del tablero indicada por el parámetro.
	 * @param c Coordenada posicion del tablero inicial
	 * @return squares Mapa con las coordenadas
	 */
	public Set<Coordinate> getAbsoluteCells(Coordinate c){
		
		Set<Coordinate> squares = new HashSet<Coordinate>();
		
		
		for(int height = 0; height < BOUNDING_SQUARE_SIZE; height++) {
			
			for(int width = 0; width < BOUNDING_SQUARE_SIZE; width++) {
				squares.add( new Coordinate(c.getRow() + height, c.getColumn() + width) );
			}
		}
			
		return squares;
	}
	
	/**
	 * Metodo que asigna una nueva orientacion a la pieza
	 * @param r Rotation que se le asigna
	 */
	public void setOrientation(Rotation r) {
		orientation = r;
	}
	
	/**
	 * Metodo que asigna valor de fijacion a la pieza
	 * @param b Boolean True es fija, False no lo es
	 */
	public void setFixed(Boolean b) {
		fixed = b;
	}
	
	
	/** 
	 * Devuelve una cadena que contiene una representación del cuadrado delimitador de una pieza de acuerdo a su orientación actual
	 * @return l Devuelve la representacion en forma de String
	 */
	@Override
	public String toString() {
		
		String l = new String();
		
		int valorOrientation = orientation.ordinal();
		
		for(int i = 0; i < shape[valorOrientation].length; i++) {
			
			if(shape[valorOrientation][i] == 1) l = l + this.getBlockSymbol();
			else l = l + '·';
			
			if(i == 3 || i == 7 || i == 11 || i == 15) l = l + "\n";
			
		}

		return l;
	}

	
	
	//OTHER METHODS

	/**
	 * Metodo que rota la pieza en sentido horario
	 */
	public void rotateClockwise() {
		
		switch(orientation) {
			case D0: orientation = Rotation.D270; break;
			case D270: orientation = Rotation.D180; break;
			case D180: orientation = Rotation.D90; break;
			case D90: orientation = Rotation.D0; break;
		}
	}
	
	/**
	 * Metodo que rota la pieza en sentido anti-horario
	 */
	public void rotateCounterclockwise() {
		
		switch(orientation) {
			case D0: orientation = Rotation.D90; break;
			case D90: orientation = Rotation.D180; break;
			case D180: orientation = Rotation.D270; break;
			case D270: orientation = Rotation.D0; break;
		}
	}
	
}
