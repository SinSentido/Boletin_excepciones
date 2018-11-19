package ejercicio2;

import static ejercicio2.Ejercicio2.calc;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio2_test {

	//EQUIVALENCIAS VÁLIDAS
	
	//Suma
	@Test
	void testSuma() {
		//2 operandos positivos
		assertEquals(calc(5,8,'+'),13); //int
		assertEquals(calc(3.5, 2.7, '+'),6.2); //double
		//1 operando negativo
		assertEquals(calc(-5,6,'+'),1); //int
		assertEquals(calc(3,-1,'+'),2); //int
		assertEquals(calc(-3.5,2.7,'+'),-0.8); //double
		assertEquals(calc(6.1,-1.3,'+'),4.8); //double
		//2 operandos negativos
		assertEquals(calc(-5,-6,'+'),-11); //int
		assertEquals(calc(-3.5,-2.7,'+'),-6.2); //double
		//Valores límites
		assertEquals(calc(0,100,'+'),100); //int
		assertEquals(calc(-1,100,'+'),99); //int
		assertEquals(calc(-1,-100,'+'),-101); //int
		assertEquals(calc(0.1,99.9,'+'),100); //double
		assertEquals(calc(-0.1,99.9,'+'),99.8); //double
		assertEquals(calc(-0.1,-99.9,'+'),-100); //double
	}
	
	//Resta
	@Test
	void testResta() {
		//2 operandos positivos
		assertEquals(calc(5,8,'-'),-3); //int
		assertEquals(calc(3.5, 2.7, '-'),0.8); //double
		//1 operando negativo
		assertEquals(calc(-5,6,'-'),-1); //int
		assertEquals(calc(3,-1,'-'),4); //int
		assertEquals(calc(-3.5,2.7,'-'),-6.2); //double
		assertEquals(calc(6.1,-1.3,'-'),7.4); //double
		//2 operandos negativos
		assertEquals(calc(-5,-6,'-'),1); //int
		assertEquals(calc(-3.5,-2.7,'-'),-0.8); //double
		//Valores límites
		assertEquals(calc(0,100,'-'),-100); //int
		assertEquals(calc(-1,100,'-'),-101); //int
		assertEquals(calc(-1,-100,'-'),99); //int
		assertEquals(calc(0.1,99.9,'-'),-99.8); //double
		assertEquals(calc(-0.1,99.9,'-'),-100); //double
		assertEquals(calc(-0.1,-99.9,'-'),99.8); //double
	}

	//Multiplicación
	@Test
	void testMultiplicación() {
		//2 operandos positivos
		assertEquals(calc(5,8,'*'),40); //int
		assertEquals(calc(3.5, 2.7, '*'),9.45); //double
		//1 operando negativo
		assertEquals(calc(-5,6,'*'),-30); //int
		assertEquals(calc(3,-1,'*'),-3); //int
		assertEquals(calc(-3.5,2.7,'*'),-9.45); //double
		assertEquals(calc(6.1,-1.3,'*'),-7.93); //double
		//2 operandos negativos
		assertEquals(calc(-5,-6,'*'),30); //int
		assertEquals(calc(-3.5,-2.7,'*'),9.45); //double
		//Valores límites
		assertEquals(calc(0,100,'*'),0); //int
		assertEquals(calc(-1,100,'*'),-100); //int
		assertEquals(calc(-1,-100,'*'),100); //int
		assertEquals(calc(0.1,99.9,'*'),9.99); //double
		assertEquals(calc(-0.1,99.9,'*'),-9.99); //double
		assertEquals(calc(-0.1,-99.9,'*'),9.99); //double
	}

	//Division
	@Test
	void testDivision() {
		//2 operandos positivos
		assertEquals(calc(5,8,'/'),0); //int
		assertEquals(calc(3.5, 2.7, '/'),1.29); //double
		//1 operando negativo
		assertEquals(calc(-5,6,'/'),0); //int
		assertEquals(calc(3,-1,'/'),-3); //int
		assertEquals(calc(-3.5,2.7,'/'),-1.29); //double
		assertEquals(calc(6.1,-1.3,'/'),-4.69); //double
		//2 operandos negativos
		assertEquals(calc(-5,-6,'/'),0); //int
		assertEquals(calc(-3.5,-2.7,'/'),1.29); //double
		//Valores límites
		assertEquals(calc(0,100,'/'),0); //int
		assertEquals(calc(-1,100,'/'),0); //int
		assertEquals(calc(-1,-100,'/'),0); //int
		assertEquals(calc(0.1,99.9,'/'),0.001); //double
		assertEquals(calc(-0.1,99.9,'/'),-0.001); //double
		assertEquals(calc(-0.1,-99.9,'/'),0.001); //double
	}

	//EQUIVALENCIAS NO VÁLIDAS
	
	@Test
	void dividirEntre0() {
		assertThrows(ArithmeticException.class, () -> calc(5,0,'/'));
		assertThrows(ArithmeticException.class, () -> calc(-5,0,'/'));
	}


}
