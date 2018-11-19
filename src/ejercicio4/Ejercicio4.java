package ejercicio4;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		/*
		 * 1. El usuario introduce un número.
		 * 2. Se muestra la descomposición en números primos de ese mismo número.
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		int x=0, i=2;
		boolean sentinel = true;
		
		//1. El usuario introduce un número.
		while(sentinel) {
			System.out.println("Introduce un número para descomponerlo en números primos: ");
			try {
				x = keyboard.nextInt();
				sentinel = false;
				if(x == 1) {
					System.out.println("El número 1 no se puede descomponer en número primos.");
					sentinel = true;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("El valor introducio no es válido.");
				sentinel = true;
				keyboard.nextLine();
			}
		}
		
		//2. Se muestra la descomposición en números primos de ese mismo número.
		while(x > 1) {
			if(primeCheck(i)) {
				if(x%i == 0) {
					System.out.printf("%d	|	%d%n", x, i);
					x /= i;
				}
				else {
					i++;
				}
			}
			else {
				i++;
			}
		}
		System.out.println(x); //Aquí la 'x' siempre tiene que valer 1, sino algo está mal.
		keyboard.close();
	}
	
	//Función que comprueba si un número es primo o no.
	public static boolean primeCheck(int x) {
		boolean prime = false;
		for(int i=2; i<=x; i++) {
			if(i == x) {
				prime = true;
			}
			else if(x%i == 0) {
				prime = false;
			}
		}
		return prime;
	}

}
