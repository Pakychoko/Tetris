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

		boolean valid = true;
		Set<Coordinate>squares= p.getAbsoluteCells(c);
		
		for (Coordinate cor : squares) {
			if (cor.getRow() > this.getHeight() - 1 || cor.getColumn() > this.getWidth() - 1
					|| cor.getColumn() < 0 || cor.getRow() < 0) {// si es mayor o menor nos devolverá false
				valid = false;
			}
		}
		
		return valid;
	}
	
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

	
	public void putPiece(Coordinate c, Piece p) {

		Set<Coordinate> squares = p.getAbsoluteCells(c);
		for(Coordinate cor:squares) {
			gameboard.put(cor, p);
		}
	}
	
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
	
	public Piece getCellContent(Coordinate c) {
		
		Piece p;
		p = gameboard.get(c);
		return p;
	}
	
	public void setCellContent(Coordinate c, Piece p) {
		gameboard.put(c, p);
	}
	
	
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
