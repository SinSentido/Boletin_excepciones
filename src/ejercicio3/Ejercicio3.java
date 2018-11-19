package ejercicio3;



public class Ejercicio3 {
	public static void main(String[] args) {

		//Muestra los número primos hasta el 10000.
		for(int i=1; i<=10000; i++ ) {
			if(primeCheck(i)) {
				System.out.println(i);
			}
		}
	}
	
	//Función que comprueba si un número es primo o no.
	public static boolean primeCheck(int x) {
		boolean prime = false;
		for(int i=2; i<=x; i++) {
			if(i == x) {
				prime = true;
			}
			else if (x%i == 0) {
				prime = false;
			}
		}
		return prime;
	}

}
