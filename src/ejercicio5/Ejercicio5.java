package ejercicio5;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio5 {
	public static void main(String[] args) {
		/*
		 * 1.El usuario elige un número.
		 * 2.Identifica los divisores del número y los suma, sin incluir el propio número.
		 *   Compara el total de la suma con el número. Si es igual el número es perfecto.
		 * 3.Muestra los factores del número perfecto.
		 * 4.Realiza el mismo proceso desde el 1 hasta el 10000 
		 * */

		Scanner keyboard = new Scanner(System.in);
		int x=0;
		boolean sentinel = true;
		
		//1.El usuario elige un número.
		System.out.println("Elige un número para comprobar si es perfecto");
		while(sentinel) {
			try {
				x=keyboard.nextInt();
				sentinel = false;
			}
			catch(InputMismatchException e) {
				System.out.println("Dato no válido. Introduce un número");
				keyboard.nextLine();
				sentinel = true;
			}
		}
		
		/*
		 * 2.Identifica los divisores del número y los suma sin incluir el propio número.
		 *   Compara el total de la suma con el número, si es igual, el número es perfecto.
		 */
		if(perfecto(x)) {
			System.out.printf("%d es perfecto%n",x);
			//3.Muestra los factores del número perfecto.
			factoresPerfecto(x);
		}
		else {
			System.out.printf("%d no es perfecto%n",x);
		}
		
		//4.Realiza el mismo proceso desde el 1 hasta el 10000 
		System.out.println("\n--NUMEROS PERFECTOS DEL 1 AL 10000--");
		for(int i=1; i<=10000; i++) {
			factoresPerfecto(i);
		}
		keyboard.close();
	}
	
	//Función que determina si un número es perfecto o no
	public static boolean perfecto(int x) {
		boolean isPerfect=false;
		int total=0;
		
		for(int i=1; i<x; i++) {
			if(x%i == 0) {
				total += i;
			}
		}
		
		if(total == x && total > 0) {
			isPerfect = true;
		}
		
		return isPerfect;
	}
	
	//Función que descompone en factores un número perfecto
	public static void factoresPerfecto(int x) {
		int total = 0;
		if(perfecto(x)) {
			System.out.printf("%d = ", x);
			for(int i=1; i<x; i++) {
				if(x%i == 0) {
					System.out.printf("%d ", i);
					total += i;
					if(total < x ) {
						System.out.printf("+ ");
					}
				}
			}
			System.out.printf("%n");
		}
	}

}
