/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Esta clase representa la matriz de celdas necesaria para el tablero.
 * @author Francisco Alejandro Azorin Gil 48643667R
 *
 */
public class Gameboard {

	/**
	 * Atributo de clase Gameboard que contiene un Mapa con las piezas y sus posiciones
	 */
	private Map<Coordinate, Piece> gameboard = new HashMap<Coordinate, Piece>();
	
	/**
	 * Atributo de clase Gameboard que indica la altura del tablero
	 */
	private int height;
	
	/**
	 * Atributo de clase Gameboard que indica la anchura del tablero
	 */
	private int width;
	
	
	/**
	 * Constructor de clase Gameboard
	 * Construye un tablero a partir de la fila y la columna de la coordenada
	 * @param c Coordenada que contiene el tamaño del tablero
	 */
	public Gameboard(Coordinate c) {
		this.height = c.getRow();
		this.width = c.getColumn();
		
	}
	
	
	/**
	 * Metodo que obtiene la anchura del tablero
	 * @return width Anchura del tablero
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Metodo que obtiene la altura del tablero
	 * @return height Altura del tablero
	 */
	public int getHeight() {
		return this.height;
	}
	
	
	/**
	 * Metodo que comprueba si la posicion es valida o no
	 * @param c Coordinate
	 * @param p Piece
	 * @return Boolean que indica si la posicion es valida (True) o si NO lo es (False)
	 */
	public boolean isPlaceValid(Coordinate c, Piece p) {

		boolean valid = true;
		Set<Coordinate>squares = p.getAbsoluteCells(c);
		
		for (Coordinate cor : squares) {
			if (cor.getRow() > this.getHeight() - 1 || cor.getColumn() > this.getWidth() - 1 || cor.getColumn() < 0 || cor.getRow() < 0) {
				valid = false;
			}
		}
		
		return valid;
	}
	
	/**
	 * Metodo que comprueba si la posicion esta libre o no
	 * 
	 * @param c Coordinate
	 * @param p Piece
	 * @return Boolean que indica si la posicion esta libre (True) o si NO lo esta (False)
	 */
	public boolean isPlaceFree(Coordinate c, Piece p) {
		
		boolean free = true;
		Set<Coordinate> squares = p.getAbsoluteCells(c);
		
		for (Coordinate cor : squares) {
			if (gameboard.containsKey(cor) && gameboard.get(cor).isFixed()) {// Aqui se usa el containsKey para comprobar si está o no la pieza en la posicion y si está la pieza fija o no
				free = false;
			}
		}
		
		return free;
	}

	
	/**
	 * Metodo que pone una pieza en el tablero
	 * @param c Coordinate
	 * @param p Piece
	 */
	public void putPiece(Coordinate c, Piece p) {

		Set<Coordinate> squares = p.getAbsoluteCells(c);
		for(Coordinate cor:squares) {
			gameboard.put(cor, p);
		}
	}
	
	/**
	 * Metodo que elimina una pieza del tablero
	 * @param p Piece
	 */
	public void removePiece(Piece p) {
	
		for (int i = 0; i < width; i++) {
			
			for (int j = 0; j < height; j++) {
				
				Coordinate c = new Coordinate(j, i);
				Piece actual = gameboard.get(c);
				
				if (actual == p) {
					do {
						gameboard.values().remove(p);
					} while (gameboard.containsValue(p));

				}
			}
		}
	}
	
	/**
	 * Devuelve una referencia a la pieza contenida en la posición indicada 
	 * por el parámetro o null si esta posicion está vacía
	 * @param c Coordinate
	 * @return Piece (Referencia)
	 */
	public Piece getCellContent(Coordinate c) {
		return gameboard.get(c);
	}
	
	/**
	 * Añade la referencia pasada como segundo parámetro 
	 * al tablero en la posición indicada por el primer parámetro.
	 * @param c Coordinate
	 * @param p Piece
	 */
	public void setCellContent(Coordinate c, Piece p) {
		gameboard.put(c, p);
	}
	
	/**
	 * Metodo que devuelve un String con los simbolos del tablero y las piezas
	 */
	public String toString() {
		
		String board = new String();
		
		for(int i = 0; i < this.height; i++) {
			
			for(int j = 0; j < this.width; j++) {
				
				Coordinate c = new Coordinate(i,j);
				
				if (j == width - 1)	{
					
					if (gameboard.containsKey(c)) 	board += getCellContent(c).getBlockSymbol();
					else board += "·";
					
				} else {
					
					if (gameboard.containsKey(c)) board += getCellContent(c).getBlockSymbol();
					else board += "·";
				}

			}
	
			board = board + "\n";
		}
		
		return board;
	}
	
	
}
