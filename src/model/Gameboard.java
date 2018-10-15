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
		this.height = c.getRow();
		this.width = c.getColumn();
		
	}
	
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	
	public boolean isPlaceValid(Coordinate c, Piece p) {
		return false; f
	}
	
	public boolean isPlaceFree(Coordinate c, Piece p) {
		return false; f
	}

	
	public void putPiece(Coordinate c, Piece p) {
		f
	}
	
	public void removePiece(Piece p) {
		f
	}
	
	public Piece getCellContent(Coordinate c) {
		
	}
	
	public void setCellContent(Coordinate c, Piece p) {
		f
	}
	
	
	public String toString() {
		
		String board = new String();
		
		for(int i = 0; i < this.height; i++) {
			
			for(int j = 0; j < this.width; j++) {
				
				if(position empty) board = board + "·";
				else if(position !empty) board = board + p.getBlockSymbol();
			}
			
			board = board + "\n";
		}
		
		return board;
	}
	
	
}
