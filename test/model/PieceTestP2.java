package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 *	Completa los siguientes test en este fichero
 *	
 *	testPiece() DONE
 *	testPiecePiece1() DONE
 *	testPiecePiece2() DONE
 *	testSetGetOrientation() DONE
 *	testRotateClockwise() DONE
 *	testRotateCounterclockwise() DONE
 *	testGetAbsoluteCellsD90() DONE
 *	testGetAbsoluteCellsD180() DONE
 *	testGetAbsoluteCellsD270() DONE
 *	testToStringD90() DONE
 *	testToStringD180() DONE
 *	testToStringD270() DONE
 *
 *  ¡Recuerda eliminar las aserciones fail() para que el test no falle!
*/

public class PieceTestP2 {
    
	Piece p1;
	
    static ArrayList<Coordinate> coorD0, coorD90, coorD180, coorD270;
    static String sD0, sD90, sD180, sD270;
    
    
	@BeforeClass //Se ejecuta una sola vez antes que todos los test
	public static void setUpBeforeClass() throws Exception {
		
		coorD0 = new ArrayList<Coordinate>();
		coorD90 = new ArrayList<Coordinate>();
		coorD180 = new ArrayList<Coordinate>();
		coorD270 = new ArrayList<Coordinate>();
		for (int i=0; i < 4; i++) {
			coorD0.add(new Coordinate(1,i));
			coorD270.add(new Coordinate(i,2));
			coorD180.add(new Coordinate(2,i));
			coorD90.add(new Coordinate(i,1));
		}
		 sD0 = "····\n▒▒▒▒\n····\n····\n";
		 sD270 = "··▒·\n··▒·\n··▒·\n··▒·\n";
		 sD180 = "····\n····\n▒▒▒▒\n····\n";
		 sD90 = "·▒··\n·▒··\n·▒··\n·▒··\n";
	}


	@Before //Se ejecuta antes de cada test
	public void setUp() throws Exception {
		p1 = new Piece();
		
	}

	@After  // Se ejecuta después de cada test
	public void tearDown() throws Exception {
	}

	/**
	 * Test del constructor por defecto de Pieza.
	 */
	@Test
	public void testPiece() {
		
		assertNotNull("P no es null",p1);
		
		// Se deben comprobar todas las propiedades de la pieza p1:
		// 1. Su orientación debe ser D0
		// 2. La pieza no debe estar fija
		// 3. El símbolo a usar para dibujar la pieza deber ser ▒ 
		
		assertEquals(Rotation.D0, p1.getOrientation());
		assertFalse(p1.isFixed());
		assertEquals('▒', p1.getBlockSymbol());

		
	}

	/**
	 * Test constructor copia de Pieza
	 */
	@Test
	public void testPiecePiece1() {
		
		Piece p = new Piece(p1);
		assertNotNull("P no es null",p);
		assertNotSame("p != p1",p1,p);
		
		// 1. Su orientación debe ser D0
		// 2. La pieza no debe estar fija
		// 3. El símbolo a usar para dibujar la pieza deber ser ▒	
		
		assertEquals(Rotation.D0, p.getOrientation());
		assertFalse(p.isFixed());
		assertEquals('▒', p.getBlockSymbol());

	
	}

	//Test constructor copia de una Pieza previamente modificada.
	@Test
	public void testPiecePiece2() {
		
		p1.setOrientation(Rotation.D270);
		p1.setFixed(true);
		Piece p = new Piece(p1);
		assertNotNull("P no es null",p);
		assertNotSame("p != p1",p1,p);
		
		// 1. Su orientación debe ser D270
		// 2. La pieza debe estar fija
		// 3. El símbolo a usar para dibujar la pieza deber ser ▒	
		
		assertEquals(Rotation.D270, p1.getOrientation());
		assertFalse(!p1.isFixed());
		assertEquals('▒', p1.getBlockSymbol());
		
	
	}
	
	/**
	 * Tests setFixed e isFixed
	 */
	@Test
	public void testSetIsFixed() {
		
		p1.setFixed(true);
		assertTrue("Fixed == true",p1.isFixed());
		p1.setFixed(false);
		assertFalse("Fixed == false",p1.isFixed());
	}

	/**
	 * Test setOrientation y getOrientation
	 */
	@Test
	public void testSetGetOrientation() {
		
		p1.setOrientation(Rotation.D180);
		assertEquals("Orientation == D180",Rotation.D180,p1.getOrientation());
		
		// Se debe comprobar que funciona el método Piece.setOrtientation con todos los valores
		// posibles de orientación
		
		p1.setOrientation(Rotation.D0);
		assertEquals("Piece p1.setOrientation(D0)", Rotation.D0, p1.getOrientation());
		p1.setOrientation(Rotation.D90);
		assertEquals("Piece p1.setOrientation(D90)", Rotation.D90, p1.getOrientation());
		p1.setOrientation(Rotation.D180);
		assertEquals("Piece p1.setOrientation(D180)", Rotation.D180, p1.getOrientation());
		p1.setOrientation(Rotation.D270);
		assertEquals("Piece p1.setOrientation(D270)", Rotation.D270, p1.getOrientation());
		

	}

	/**
	 * Test rotateClockwise
	 */
	@Test
	public void testRotateClockwise() {
		
		p1.rotateClockwise();
		assertEquals("Orientation == D270", Rotation.D270, p1.getOrientation());
		p1.rotateClockwise();
		assertEquals("Orientation == D180", Rotation.D180, p1.getOrientation());
		p1.rotateClockwise();
		assertEquals("Orientation == D90", Rotation.D90, p1.getOrientation());
		p1.rotateClockwise();
		assertEquals("Orientation == D0", Rotation.D0, p1.getOrientation());
		
		// Se debe comprobar que rotateClockwise funciona correctamente para todas
		// las rotaciones posibles.

		
	}
	
	/**
	 * Test rotateCounterclockwise
	 */
	@Test
	public void testRotateCounterclockwise() {
		
		// Se debe comprobar que rotateCounterclockwise funciona correctamente para todas
		// las rotaciones posibles.		
		
		p1.rotateCounterclockwise();
		assertEquals("Orientation == D90", Rotation.D90, p1.getOrientation());
		p1.rotateCounterclockwise();
		assertEquals("Orientation == D180", Rotation.D180, p1.getOrientation());
		p1.rotateCounterclockwise();
		assertEquals("Orientation == D270", Rotation.D270, p1.getOrientation());
		p1.rotateCounterclockwise();
		assertEquals("Orientation == D0", Rotation.D0, p1.getOrientation());

	}

	/**
	 * Test getAbsoluteCells para D0
	 */
	@Test
	public void testGetAbsoluteCellsD0() {
		
		Coordinate c1 = new Coordinate(13,27);
		Set<Coordinate> cells = p1.getAbsoluteCells(c1);
		
		for (int i = 0; i < 4; i++){
			assertTrue("Valores Absolutos celdas D0+c1", cells.contains(coorD0.get(i).add(c1)));
		}
	}

	
	// ¡CREAR TRES TEST ADICIONALES!
	
	/**
	 *  1. Un test para comprobar que getAbsoluteCells funciona correctamente para la orientación D90
	 */
	@Test
    public void testGetAbsoluteCellsD90() {
		
		Coordinate c1 = new Coordinate(13,27);
		Set<Coordinate> cells = p1.getAbsoluteCells(c1);
		
		for (int i = 0; i < 4; i++){
			assertTrue("Valores Absolutos celdas D90+c1", cells.contains(coorD90.get(i).add(c1)));
		}

	}
	
	/**
	 *  2. Un test para comprobar que getAbsoluteCells funciona correctamente para la orientación D180
	 */ 
	@Test
    public void testGetAbsoluteCellsD180() {
		
		Coordinate c1 = new Coordinate(13,27);
		Set<Coordinate> cells = p1.getAbsoluteCells(c1);
		
		for (int i = 0; i < 4; i++){
			assertTrue("Valores Absolutos celdas D180+c1", cells.contains(coorD180.get(i).add(c1)));
		}
		
	}
	
	/**
	 *  3. Un test para comprobar que getAbsoluteCells funciona correctamente para la orientación D270
	 */ 
	@Test
    public void testGetAbsoluteCellsD270() {
		
		Coordinate c1 = new Coordinate(13,27);
		Set<Coordinate> cells = p1.getAbsoluteCells(c1);
		
		for (int i = 0; i < 4; i++){
			assertTrue("Valores Absolutos celdas D270+c1", cells.contains(coorD270.get(i).add(c1)));
		}
		
	}

	
	/**
	 * Test toString para D0
	 */
	@Test
	public void testToStringD0() {
		assertEquals("D0 toString",sD0,p1.toString());
	}

	// ¡CREAR TRES TEST ADICIONALES!
	
	
	/**
	 *  1. Un test para comprobar que toString funciona correctamente para la orientación D90
	 */  
	@Test
	public void testToStringD90() {
		p1.setOrientation(Rotation.D90);
		assertEquals("D90 toString",sD90,p1.toString());
	}
	
	/**
	 *  2. Un test para comprobar que toString funciona correctamente para la orientación D180
	 */
	@Test
	public void testToStringD180() {
		p1.setOrientation(Rotation.D180);
		assertEquals("D180 toString",sD180,p1.toString());
	}
	
	/**
	 *  3. Un test para comprobar que toString funciona correctamente para la orientación D270
	 */  
	@Test
	public void testToStringD270() {
		p1.setOrientation(Rotation.D270);
		assertEquals("D270 toString",sD270,p1.toString());
	}

}
