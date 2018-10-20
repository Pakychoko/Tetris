/**
 * 
 */
package model;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * Busca en este fichero los test
 *
 *	testGameboard() DONE
 *	testPutPieceD270()
 *	testPutPieceD180()
 *	testPutPieceD90()
 *  testIsPlaceValidError2() DONE
 *  testIsPlaceValidError3() DONE
 *	testIsPlaceValidError4() DONE
 *	testIsPlaceFree3() DONE
 *	testIsPlaceFree5() DONE
 *	testRemovePiece1()
 *	testRemovePiece3()
 *	testRemovePiece4()
 *
 *  y complétalos.
 *  ¡Recuerda eliminar las aserciones fai() para que el test no falle una vez completado!
*/

/**
 * @author jgonzalo
 *
 */
public class GameboardTestP2 {

	Coordinate c1;
	static Gameboard gb1;
	Piece p1;
	static String board0, board1, board3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass //Se ejecuta una sola vez antes que todos los test
	public static void setUpBeforeClass() throws Exception {
		
		gb1 = new Gameboard(new Coordinate(10,7));
		board0 = new String();
		
		for (int i = 0; i < gb1.getHeight(); i++) {
			for (int j=0; j < gb1.getWidth();j++) {
				
				board0 += "·";
				board3 += "▒";
			}
			board0 += "\n";
			board3 += "\n";
		}
		
		board1="···▒···\n" +
			   "···▒···\n" +
			   "···▒···\n" +
			   "···▒···\n" +
			   "·▒▒▒▒▒·\n" +
			   "·····▒·\n" +
			   "·····▒·\n" +
			   "·····▒·\n" +
			   "···▒▒▒▒\n" +
			   "·······\n";		
	}
	
	@Before //Se ejecuta antes de cada test
	public void setUp() throws Exception {
		
		c1 = new Coordinate(10,7);
		p1 = new Piece();
		gb1 = new Gameboard(c1);
		
	}

	//Test constructor de Gameboard
	@Test
	public final void testGameboard() {
		
		assertEquals ("heigth = row", c1.getRow(),gb1.getHeight());
		assertEquals ("width == column", c1.getColumn(), gb1.getWidth());
		
		// Comprueba que todas las celdas del tablero están vacías
		for(int i = 0; i < gb1.getHeight(); i++) {
			
			for(int j = 0; j < gb1.getWidth(); j++) {
				assertNull("Celda vacia",gb1.getCellContent(new Coordinate(j,i)));
			}
		}

	}

	/*
	 * Comprobamos que la pieza con rotación D0 que se pone en el tablero está en las
	 * coordenadas correctas (y solo esas):
	 */
	@Test
	public final void testPutPieceD0() {
		
		Coordinate c = new Coordinate(5,3);
		Piece p = new Piece();
		gb1.putPiece(c, p);
		Coordinate caux;
		
		for (int i = 0; i < gb1.getWidth(); i++)
			
			for (int j = 0; j < gb1.getHeight(); j++) {
				
				if ((i >= c.getColumn()) && (i <= c.getColumn() + 4) && (j == c.getRow()+1)) {
					
					caux = new Coordinate(j,i);
					assertSame("Pieza en "+caux, p, gb1.getCellContent(new Coordinate(j,i)));
				
				} else {
					assertNull("Celda vacia",gb1.getCellContent(new Coordinate(j,i)));
				}
			}
	}

	// ¡CREAR TRES TEST ADICIONALES!
	// 1. Un test para comprobar que la pieza con rotación D270 que se pone en el 
	//    tablero está en las coordenadas correctas (y solo esas)
	@Test
    public final void testPutPieceD270() {
		fail("¡Crea el test testPutPieceD270!");
	}
	// 2. Un test para comprobar que la pieza con rotación D180 que se pone en el 
	//    tablero está en las coordenadas correctas (y solo esas)
	@Test
    public final void testPutPieceD180() {
		fail("¡Crea el test testPutPieceD180!");
	}
	// 3. Un test para comprobar que la pieza con rotación D90 que se pone en el 
	//    tablero está en lascoordenadas correctas (y solo esas)
	@Test
    public final void testPutPieceD90() {
		fail("¡Crea el test testPutPieceD90!");
	}

	
	/* Test que comprueba que no hay restricción en poner una pieza en las celdas
	 * válidas aunque ésta no quepa en el tablero (solo para esta práctica p2)
	 */
	@Test
	public final void testPutPieceInSmallBoard() {
		
		Gameboard gb2 = new Gameboard(new Coordinate(3,3));
		Coordinate c = new Coordinate(0,0);
		Piece p = new Piece();
		gb2.putPiece(c, p);
		Coordinate caux;
		
		for (int i = 0; i < gb2.getWidth(); i++)
			for (int j = 0; j < gb2.getHeight(); j++) {
				
			  caux = new Coordinate(j,i);
			  if ((i >= c.getColumn()) && (i<=c.getColumn() + 4) && (j == c.getRow()+1)) 
					assertSame("Pieza en "+caux, p, gb2.getCellContent(new Coordinate(j,i)));
			  else
				assertNull("Celda vacia",gb2.getCellContent(new Coordinate(j,i)));
			}
	}
	
	//Comprobación de getWidth
	@Test
	public final void testGetWidth() {
		assertEquals("width == 7 ",7,gb1.getWidth());
	}

	//Comprobación de getHeight
	@Test
	public final void testGetHeight() {
		assertEquals ("heigth == 10 ",10, gb1.getHeight());
	}

	/* Test isPlaceValid para p1 con alguna coordenada no correcta en la esquina
	 superior izquierda*/
	@Test
	public final void testIsPlaceValidError1() {
		Coordinate c = new Coordinate(-1,-1);
		assertFalse ("Error [0,-1]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D90);
		assertFalse ("Error [-1,1]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D180);
		assertFalse ("Error [1,-1]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D270);
		assertFalse ("Error [-1,2]",gb1.isPlaceValid(c, p1));
	}

	// ¡CREAR TRES TEST ADICIONALES!
	//
	// Fijáte en el test anterior para hacerlos.
	//
	// 1. Uno para comprobar el funcionamiento de isPlaceValid para p1 
	//    con alguna coordenada no correcta en la esquina inferior izquierda
	@Test
    public final void testIsPlaceValidError2() {
		
		Coordinate c = new Coordinate(gb1.getHeight()+1, -1);
		
		assertFalse ("Error [12,-1]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D90);
		assertFalse ("Error [11,1]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D180);
		assertFalse ("Error [13,-1]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D270);
		assertFalse ("Error [11,2]",gb1.isPlaceValid(c, p1));
	}
	// 2. Uno para comprobar el funcionamiento de isPlaceValid para p1 
	//    con alguna coordenada no correcta en la esquina superior derecha
	@Test
    public final void testIsPlaceValidError3() {
		
		Coordinate c = new Coordinate(-1, gb1.getWidth()+1);
		
		assertFalse ("Error [0,11]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D90);
		assertFalse ("Error [-1,13]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D180);
		assertFalse ("Error [1,11]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D270);
		assertFalse ("Error [-1,14]",gb1.isPlaceValid(c, p1));
	}
	// 3. Uno para comprobar el funcionamiento de isPlaceValid para p1 
	//    con alguna coordenada no correcta en la esquina inferior derecha 
	@Test
    public final void testIsPlaceValidError4() {
		
		Coordinate c = new Coordinate(gb1.getHeight()+1, gb1.getWidth()+1);
		
		assertFalse ("Error [12,11]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D90);
		assertFalse ("Error [11,13]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D180);
		assertFalse ("Error [13,11]",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D270);
		assertFalse ("Error [11,14]",gb1.isPlaceValid(c, p1));
	}
		
	//Tests de posiciones válidas para la pieza p1
	@Test
	public final void testIsPlaceValidOk1() {
		Coordinate c = new Coordinate(-1,0);
		assertTrue ("Ok",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D180);
		assertTrue ("Ok",gb1.isPlaceValid(c, p1));
	}
	
	@Test
	public final void testIsPlaceValidOk2() {
		Coordinate c = new Coordinate(-1,3);
		assertTrue ("Ok",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D180);
		assertTrue ("Ok",gb1.isPlaceValid(c, p1));
	}
	
	@Test
	public final void testIsPlaceValidOk3() {
		Coordinate c = new Coordinate(6,-1);
		p1.setOrientation(Rotation.D90);
		assertTrue ("Ok",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D270);
		assertTrue ("Ok",gb1.isPlaceValid(c, p1));
	}
	
	@Test
	public final void testIsPlaceValidOk4() {
		Coordinate c = new Coordinate(6,4);
		p1.setOrientation(Rotation.D90);
		assertTrue("Ok",gb1.isPlaceValid(c, p1));
		p1.setOrientation(Rotation.D270);
		assertTrue ("Ok",gb1.isPlaceValid(c, p1));
	}
	
	//Prueba  isPlaceFree en celda vacía
	@Test
	public final void testIsPlaceFree1() {
		Coordinate c = new Coordinate(3,3);
		assertTrue(gb1.isPlaceFree(c, p1));
	}
	
	
	//Prueba  isPlaceFree en celdas ocupadas por la misma pieza no fija
	@Test
	public final void testIsPlaceFree2() {
		Coordinate c = new Coordinate(3,3);
		gb1.putPiece(c, p1);
		assertTrue(gb1.isPlaceFree(c, p1));
	}
	
	// ¡CREA UN TEST!
	// Comprueba que isPlaceFree devuelve cierto en celdas ocupadas por otra pieza no fija
    @Test
    public final void testIsPlaceFree3() {
		Coordinate c = new Coordinate(3,3);
		Piece p2 = new Piece();
		
		gb1.putPiece(c, p1);
		gb1.putPiece(c, p2);
		assertTrue(gb1.isPlaceFree(c, p2));
	}
	
	//Prueba isPlaceFree en celdas ocupadas por la misma pieza fija.
	@Test
	public final void testIsPlaceFree4() {
		Coordinate c = new Coordinate(3,3);
		gb1.putPiece(c, p1);
		p1.setFixed(true);
		assertFalse(gb1.isPlaceFree(c, p1));
		
	}
	
	// ¡CREA UN TEST!
	// Comprueba que isPlaceFree devuelve falso en celdas ocupadas por otra pieza fija
    @Test
    public final void testIsPlaceFree5() {
		Coordinate c = new Coordinate(3,3);
		Piece p2 = new Piece();
		
		gb1.putPiece(c, p1);
		p1.setFixed(true);
		
		gb1.putPiece(c, p2);
		assertTrue(gb1.isPlaceFree(c, p2));
	}
	
	//Elimina todas las piezas
	@Test
	public final void testRemovePiece1() {
		gb1.putPiece(new Coordinate(3,1), p1);
		gb1.putPiece(new Coordinate (7,3), p1);
		p1.setOrientation(Rotation.D270);
		gb1.putPiece(new Coordinate (4,4), p1);
		gb1.putPiece(new Coordinate(0,2), p1);
		gb1.removePiece(p1);
		
		// ¡COMPLETA EL TEST!
		// Comprueba que todas las celdas están vacías 
		
		for (int i=0; i<gb1.getHeight(); i++) {
			for (int j=0; j<gb1.getWidth();j++) {
				c1 = new Coordinate(i,j);
				assertNull("Posicion "+c1.toString()+" vacia ",gb1.getCellContent(c1));
			}
		}

	}
	
	//Elimina todas menos una
	@Test
	public final void testRemovePiece2() {
		gb1.putPiece(new Coordinate(3,1), p1);
		gb1.putPiece(new Coordinate (7,3), p1);
		p1.setOrientation(Rotation.D270);
		gb1.putPiece(new Coordinate (4,4), p1);
		Piece p2 = new Piece(p1); //No la va a eliminar
		gb1.putPiece(new Coordinate(0,2), p2);
		gb1.removePiece(p1);
		Coordinate c1;
		//Almacenamos en cells las celdas ocupadas por p2
		Set<Coordinate> cells = p2.getAbsoluteCells(new Coordinate(0,2));
		for (int i = 0; i < gb1.getHeight(); i++) {
			for (int j = 0; j < gb1.getWidth(); j++) {
				c1 = new Coordinate(i,j);
				if (cells.contains(c1)) 
					assertEquals ("Posicion de p2 "+c1.toString(),p2,gb1.getCellContent(c1));
				else
					assertNull("Posicion "+c1.toString()+" vacia ",gb1.getCellContent(c1));
			}
		}
	}
		
	//Pone piezas en todo el tablero y las quita todas.
	@Test
	public final void testRemovePiece3() {
		//Ponemos la misma pieza en todo el gameboard
		for (int i = 0; i < gb1.getHeight(); i++) 
			for (int j = 0; j < gb1.getWidth(); j++) 
				gb1.setCellContent(new Coordinate(i,j), p1);
		
		gb1.removePiece(p1);
		Coordinate c1;
		
		// ¡COMPLETA EL TEST!
		// Comprueba que  no hay ninguna pieza en el tablero 	
		
		for (int i = 0; i < gb1.getHeight(); i++) {
			for (int j = 0; j < gb1.getWidth(); j++) {
				c1 = new Coordinate(i,j);
				assertNull("Posicion "+c1.toString()+" vacia ",gb1.getCellContent(c1));
			}
		}
	}

	//Pone dos piezas en todo el tablero: p1 en celdas donde i==j y p2
	//en el resto. Quita la p1.
	@Test
	public final void testRemovePiece4() {
		//Ponemos las piezas en todo el gameboard
		Piece p2 = new Piece(p1);
		Coordinate c1;
		for (int i = 0; i < gb1.getHeight(); i++) 
			for (int j = 0; j < gb1.getWidth(); j++) {
				c1 = new Coordinate(i,j);
				if (i == j) 
					gb1.setCellContent(c1, p1);
				else 
					gb1.setCellContent(c1, p2);
			}
		
		gb1.removePiece(p1);
				
		// ¡COMPLETA EL TEST!
		// Comprueba que  en el talbero no está p1 pero sí p2 	
		Set<Coordinate> cells = p2.getAbsoluteCells(new Coordinate(0,2));
		
		for (int i = 0; i < gb1.getHeight(); i++) {
			for (int j = 0; j < gb1.getWidth(); j++) {
				c1 = new Coordinate(i,j);
				if (cells.contains(c1)) 
					assertEquals ("Posicion de p2 "+c1.toString(),p2,gb1.getCellContent(c1));
				else
					assertNull("Posicion "+c1.toString()+" vacia ",gb1.getCellContent(c1));
			}
		}
	
	}
	
	// Obtiene la pieza que pone antes en una celda.
	@Test
	public final void testSetGetCellContent() {
		assertNull("Pieza == NULL", gb1.getCellContent(new Coordinate(5,0)));
		gb1.setCellContent(new Coordinate (5,0), p1);
		
		for (int i=0; i<gb1.getHeight(); i++)
			for (int j=0; j<gb1.getWidth(); j++)
				if ( (i==5) && (j==0)) 
					assertSame("Pieza == p1", p1, gb1.getCellContent(new Coordinate(5,0)));
				else
					assertNull("Pieza NULL", gb1.getCellContent(new Coordinate(i,j)));
	}
	
	//Tablero vacío
	@Test
	public final void testToString1() {
		
		assertEquals(board0,gb1.toString());
	}
	
	//Tablero con piezas.
	@Test
	public final void testToString2() {
		gb1.putPiece(new Coordinate(3,1), p1);
		gb1.putPiece(new Coordinate (7,3), p1);
		p1.setOrientation(Rotation.D90);
		gb1.putPiece(new Coordinate (4,4), p1);
		Piece p2 = new Piece(p1); //No la va a eliminar
		gb1.putPiece(new Coordinate(0,2), p2);
		assertEquals(board1,gb1.toString());
	}

}

