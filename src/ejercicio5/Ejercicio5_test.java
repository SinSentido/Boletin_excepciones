package ejercicio5;

import static ejercicio5.Ejercicio5.perfecto;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio5_test {
	
	//EQUIVALENCIAS VÁLIDAS

	@Test
	void numeroPerfecto() {
		assertTrue(perfecto(28));
		assertTrue(perfecto(496));
		//Valores límite
		assertTrue(perfecto(6));
		assertTrue(perfecto(8128));
	}
	
	@Test
	void numeroNoPerfecto() {
		assertFalse(perfecto(4));
		assertFalse(perfecto(55));
		//Valores límite
		assertFalse(perfecto(1));
		assertFalse(perfecto(10000));
	}

	//EQUIVALENCIAS NO VÁLIDAS
	
	@Test
	void numeroNegativo() {
		assertFalse(perfecto(-43));
		assertFalse(perfecto(-15));
		//Valores límite
		assertFalse(perfecto(-1));
		assertFalse(perfecto(-10000));
	}
	
	@Test
	void numero0() {
		assertFalse(perfecto(0));
	}
}
