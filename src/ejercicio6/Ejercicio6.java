package ejercicio6;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio6 {
	public static void main(String[] args) {
		
		/*
		 * 1.El usuario elige los 2 números de los que quiere hallar el máximo común divisor.
		 * 2.Comprueba los distintos divisores de los números y se queda con el más grande que tengan en común.
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		int x=0, y=0;
		boolean sentinel=true;
		
		//1.El usuario elige los 2 números de los que quiere hallar el máximo común divisor.
		while(sentinel) {
			try {
				System.out.println("Introduce el primer número:");
				x = keyboard.nextInt();
				System.out.println("Introduce el segundo número:");
				y = keyboard.nextInt();
				sentinel = false;
			}
			catch(InputMismatchException e) {
				System.out.println("Tipo de dato no válido. Introduce un número");
				sentinel = true;
				keyboard.nextLine(); //Limpia el buffer
			}
		}
		//2.Comprueba los distintos divisores de los números y se queda con el más grande que tengan en común.
		System.out.printf("El MCD de %d y %d es: %d", x, y, mcd(x,y));
		keyboard.close();
	}
	
	//Función que halla el MCD de don números
	public static int mcd(int x, int y) {
		int max=0, change;
		//Se asegura de que 'x' es el valor más pequeño de los dos.
		if(x>y) {
			change = x;
			x = y;
			y = change;
		}
		for(int i=1; i<=x; i++) {
			if(x%i == 0 && y%i == 0) {
				max = i;
			}
		}
		
		return max;
	}

}
