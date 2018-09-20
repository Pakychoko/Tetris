/**
 * 
 */
package model;

/**
 * Clase Coordinate
 * Crea y gestiona coordenadas
 * @author Francisco Azorin Gil 48643667R
 *
 */
public class Coordinate {

	/**
	 * Atributo fila de la clase Coordinate
	 */
	private int row;
	/**
	 * Atributo columna de la clase Coordinate
	 */
	private int column;
	/**
	 * Contador de Coordenadas
	 */
	private static int COORDINATE_COUNT = 0;


	/**
	 * Metodo constructor de la clase Coordinate
	 * @param row
	 * @param column
	 */
	public Coordinate(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		COORDINATE_COUNT++;
	}
	
	/**
	 * Metodo constructor de la clase Coordinate
	 * @param c
	 */
	public Coordinate(Coordinate c) {
		this.row = c.row;
		this.column = c.column;
		COORDINATE_COUNT++;
	}
	
	/**
	 * Metodo constructor por defecto de la clase Coordinate
	 */
	public Coordinate() {
		
	}
	
	
	
	
	/**
	 * Devuelve la fila de la coordenada
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Devuelve la columna de la coordenada
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	
	
	/**
	 * Metodo que devuelve la cantidad de coordenadas
	 * @return COORDINATE_COUNT
	 */
	public static int getCoordinateCount() {
		return COORDINATE_COUNT;
	}



	/**
	 * Metodo que devuelve la coordenada en forma de Cadena de texto
	 * @return String of Coordinate
	 */
	@Override
	public String toString() {
		return "[" + row + "," + column + "]";
	}


	/**
	 * Metodo que compara coordenadas y devuelve si es igual o no
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}


	
	public Coordinate add(Coordinate c) {
		return new Coordinate(this.row + c.row, this.column + c.column);
	}

	
	
	
}
