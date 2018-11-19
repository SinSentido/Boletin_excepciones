package ejercicio1;

import static ejercicio1.Ejercicio1.calc;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio1_test {

	//CLASES DE EQUIVALENCIA VÁLIDAS
	
	//Suma
	@Test
	void testSuma() {
		//2 operandos positivos
		assertEquals(calc(5,6,'+'),11);
		//1 operando negativo
		assertEquals(calc(-5,6,'+'),1);
		assertEquals(calc(3,-1,'+'),2);
		//2 operandos negativos
		assertEquals(calc(-5,-6,'+'),-11);
		//Valores límites
		assertEquals(calc(0,100,'+'),100);
		assertEquals(calc(-1,100,'+'),99);
		assertEquals(calc(-1,-100,'+'),-101);
	}
	
	//Resta
	@Test
	void testResta() {
		//2 operandos positivos
		assertEquals(calc(5,6,'-'),-1);
		//1 operando negativo
		assertEquals(calc(-5,6,'-'),-11);
		assertEquals(calc(3,-1,'-'),4);
		//2 operandos negativos
		assertEquals(calc(-5,-6,'-'),1);
		//Valores límites
		assertEquals(calc(0,100,'-'),-100);
		assertEquals(calc(-1,100,'-'),-101);
		assertEquals(calc(-1,-100,'-'),99);		
	}
	
	//Multiplicación
	@Test
	void testMultiplicación() {
		//2 operandos positivos
		assertEquals(calc(5,6,'*'),30);
		//1 operando negativo
		assertEquals(calc(-5,6,'*'),-30);
		assertEquals(calc(3,-1,'*'),-3);
		//2 operandos negativos
		assertEquals(calc(-5,-6,'*'),30);
		//Valores límites
		assertEquals(calc(0,100,'*'),0);
		assertEquals(calc(-1,100,'*'),-100);
		assertEquals(calc(-1,-100,'*'),100);
	}
	
	//División
	@Test
	void testDivision() {
		//2 operandos positivos
		assertEquals(calc(10,5,'/'),2);
		//1 operando negativo
		assertEquals(calc(-10,5,'/'),-2);
		assertEquals(calc(3,-1,'/'),-3);
		//2 operandos negativos
		assertEquals(calc(-10,-5,'/'),2);
		//Valores límites
		assertEquals(calc(1,100,'/'),0);
		assertEquals(calc(-1,100,'/'),0);
		assertEquals(calc(-1,-100,'/'),0);
	}
	
	//CLASES DE EQUIVALENCIA NO VÁLIDAS
	
	//Operando 2 == 0
	@Test
	void dividirEntre0() {
		assertThrows(ArithmeticException.class, () -> calc(10,0,'/'));
		assertThrows(ArithmeticException.class, () -> calc(-10,0,'/'));
		assertThrows(ArithmeticException.class, () -> calc(-10,-0,'/'));
	}
	

}
