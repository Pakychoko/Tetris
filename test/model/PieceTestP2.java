package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 *	Completa los siguientes test en este fichero
 *	
 *	testPiece()
 *	testPiecePiece1()
 *	testPiecePiece2()
 *	testSetGetOrientation()
 *	testRotateClockwise()
 *	testRotateCounterclockwise()
 *	testGetAbsoluteCellsD90()
 *	testGetAbsoluteCellsD180()
 *	testGetAbsoluteCellsD270()
 *	testToStringD90()
 *	testToStringD180()
 *	testToStringD270()
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

	//Test del constructor por defecto de Pieza.
	@Test
	public void testPiece() {
		assertNotNull("P no es null",p1);
		
		// ¡COMPLETA EL TEST!
		// Se deben comprobar todas las propiedades de la pieza p1:
		// 1. Su orientación debe ser D0
		// 2. La pieza no debe estar fija
		// 3. El símbolo a usar para dibujar la pieza deber ser ▒ 
		
		fail("¡Completa testPiece()!");
		
	}

	//Test constructor copia de Pieza
	@Test
	public void testPiecePiece1() {
		Piece p = new Piece(p1);
		assertNotNull("P no es null",p);
		assertNotSame("p != p1",p1,p);
		
		// ¡COMPLETA EL TEST!
		// Se deben comprobar todas las propiedades de la pieza p:
		// 1. Su orientación debe ser D0
		// 2. La pieza no debe estar fija
		// 3. El símbolo a usar para dibujar la pieza deber ser ▒	
		
		fail("¡Completa testPiecePiece1()!");
	
	}

	//Test constructor copia de una Pieza previamente modificada.
	@Test
	public void testPiecePiece2() {
		p1.setOrientation(Rotation.D270);
		p1.setFixed(true);
		Piece p = new Piece(p1);
		assertNotNull("P no es null",p);
		assertNotSame("p != p1",p1,p);
		
		// ¡COMPLETA EL TEST!
		// Se deben comprobar todas las propiedades de la pieza p1:
		// 1. Su orientación debe ser D270
		// 2. La pieza debe estar fija
		// 3. El símbolo a usar para dibujar la pieza deber ser ▒	
		
		fail("¡Completa testPiecePiece2()!");
	
	}
	
	//Tests setFixed e isFixed
	@Test
	public void testSetIsFixed() {
		p1.setFixed(true);
		assertTrue("Fixed == true",p1.isFixed());
		p1.setFixed(false);
		assertFalse("Fixed == false",p1.isFixed());
	}

	//Test setOrientation y getOrientation
	@Test
	public void testSetGetOrientation() {
		p1.setOrientation(Rotation.D180);
		assertEquals("Orientation == D180",Rotation.D180,p1.getOrientation());
		
		// ¡COMPLETA EL TEST!
		// Se debe comprobar que funciona el método Piece.setOrtientation con todos los valores
		// posibles de orientación
		
		fail("¡Completa testSetGetOrientation()!");

	}

	//Test rotateClockwise
	@Test
	public void testRotateClockwise() {
		p1.rotateClockwise();
		assertEquals("Orientation == D270", Rotation.D270, p1.getOrientation());
		p1.rotateClockwise();
		assertEquals("Orientation == D180", Rotation.D180, p1.getOrientation());
		
		// ¡COMPLETA EL TEST!
		// Se debe comprobar que rotateClockwise funciona correctamente para todas
		// las rotaciones posibles.

		fail("¡Completa testRotateClockwise()!");
		
	}
	
	//Test rotateCounterclockwise
	@Test
	public void testRotateCounterclockwise() {
		// ¡COMPLETA EL TEST!
		// Se debe comprobar que rotateCounterclockwise funciona correctamente para todas
		// las rotaciones posibles.		
		
		fail("¡Completa testRotateCounterclockwise()!");

	}

	//Test getAbsoluteCells para D0
	@Test
	public void testGetAbsoluteCellsD0() {
		Coordinate c1 = new Coordinate(13,27);
		Set<Coordinate> cells = p1.getAbsoluteCells(c1);
		for (int i=0; i<4; i++){
			assertTrue("Valores Absolutos celdas D0+c1", cells.contains(coorD0.get(i).add(c1)));
		}
	}

	// ¡CREAR TRES TEST ADICIONALES!
	// 1. Un test para comprobar que getAbsoluteCells funciona correctamente para la
	//    orientación D90
	@Test
    public void testGetAbsoluteCellsD90() {
		fail("¡Crea el test testGetAbsoluteCellsD90()!");
	}
	// 2. Un test para comprobar que getAbsoluteCells funciona correctamente para la
	//    orientación D180
	@Test
    public void testGetAbsoluteCellsD180() {
		fail("¡Crea el test testGetAbsoluteCellsD180()!");
	}
	// 3. Un test para comprobar que getAbsoluteCells funciona correctamente para la
	//    orientación D270
	@Test
    public void testGetAbsoluteCellsD270() {
		fail("¡Crea el test testGetAbsoluteCellsD270()!");
	}

	
	//Test toString para D0
	@Test
	public void testToStringD0() {
		assertEquals("D0 toString",sD0,p1.toString());
	}

	// ¡CREAR TRES TEST ADICIONALES!
	// 1. Un test para comprobar que toString funciona correctamente para la
	//    orientación D90
	@Test
	public void testToStringD90() {
		fail("¡Crea el test testToStringD90()!");
	}
	// 2. Un test para comprobar que toString funciona correctamente para la
	//    orientación D180
	@Test
	public void testToStringD180() {
		fail("¡Crea el test testToStringD180()!");
	}
	// 3. Un test para comprobar que toString funciona correctamente para la
	//    orientación D270
	@Test
	public void testToStringD270() {
		fail("¡Crea el test testToStringD270()!");
	}

}
