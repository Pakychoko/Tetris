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
	 * @param row Fila en la que se situa la coordenada
	 * @param column Columna en la que se situa la coordenada
	 */
	public Coordinate(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		COORDINATE_COUNT++;
	}
	
	/**
	 * Metodo constructor de la clase Coordinate
	 * @param c Coordenada
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
	 * @return the row Devuelve la fila en la que se situa la coordenada
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Devuelve la columna de la coordenada
	 * @return the column Devuelve la columna en la que se situa la coordenada
	 */
	public int getColumn() {
		return column;
	}

	
	
	/**
	 * Metodo que devuelve la cantidad de coordenadas
	 * @return COORDINATE_COUNT Devuelve la cantidad de Coordenadas
	 */
	public static int getCoordinateCount() {
		return COORDINATE_COUNT;
	}



	/**
	 * Metodo que devuelve la coordenada en forma de Cadena de texto
	 * @return String Devuelve una cadena de texto con la posicion de la coordenada
	 */
	@Override
	public String toString() {
		return "[" + row + "," + column + "]";
	}


	/**
	 * Metodo que compara coordenadas y devuelve si es igual o no
	 * @return boolean Devuelve true si es igual o false si no lo es
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

	/**
	 * Metodo que devuelve un entero que debe ser el mismo para todas aquellas coordenadas 
	 * que son iguales de acuerdo al método equals();
	 * @return result Valor Hash para la coordenada
	 */
	public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + column;
	      result = prime * result + row;
	      return result;
	    }
	
	
	/**
	 * Metodo que añade coordenadas
	 * @param c Coordenada que se le pasa a la funcion
	 * @return Coordinate Devuelve una nueva coordenada resultado de la suma de coordenadas
	 */
	public Coordinate add(Coordinate c) {
		return new Coordinate(this.row + c.row, this.column + c.column);
	}

	
	
	
}
