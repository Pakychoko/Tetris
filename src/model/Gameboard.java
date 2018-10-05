/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase representa la matriz de celdas necesaria para el tablero.
 * @author Francisco Alejandro Azorin Gil 48643667R
 *
 */
public class Gameboard {

	private Map<Coordinate, Piece> gameboard = new HashMap<Coordinate, Piece>();
	
	private int height;
	
	private int width;
	
	
	public Gameboard(Coordinate c) {
		this.height = c.getColumn();
		this.width = c.getRow();
		
		gameboard.
	}
}
