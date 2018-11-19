package ejercicio6;

import static ejercicio6.Ejercicio6.mcd;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio6_test {

	//EQUIVALENCIAS VÁLIDAS
	
	@Test
	void test() {
		assertEquals(mcd(8,12), 4);
		assertEquals(mcd(23,46), 23);
		//Valores límite
		assertEquals(mcd(1,1000), 1);
	}

}
