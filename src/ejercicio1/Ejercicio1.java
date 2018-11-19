package ejercicio1;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArithmeticException;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		/*
		 * 1. El usuario elige el tipo de operación que quiere realizar
		 * 2. El usuario introduce los numeros de la operación
		 * 3. Se muestra el resultado de la operación
		 */
		Scanner keyboard = new Scanner(System.in);
		
		int x = 0, y = 0;
		char c = 'a';
		boolean menu = true;
		
		//1. El usuario elige el tipo de operación que quiere realizar
		while(menu) {
			System.out.println("Escoge el tipo de operación que quieres realizar: \n+ \n- \n* \n/");
			c = keyboard.next().charAt(0);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				menu = false;
			}
			else {
				System.out.println("Opción no válida. Tienes que introducir el signo de la operación que quieres realizar.");
			}
		}
		
		//2. El usuario introduce los numeros de la operación
		menu = true;
		while(menu) {
			try {	
				System.out.println("Introduce el primer número: ");
				x = keyboard.nextInt();
				System.out.println("Introduce el segundo número: ");
				y = keyboard.nextInt();
				menu = false;
				//3. Se muestra el resultado de la operación
				System.out.println("El resultado es: " + calc(x,y,c));
			}
			catch(InputMismatchException e) {
				System.out.println("ERROR. Has introducido un carácter no válido.\nPor favor, vuelve a probar: ");
				menu = true;
				keyboard.nextLine(); //Limpia el buffer
			}
			catch(ArithmeticException e) {
				System.out.println("Es imposible dividir un número entre 0");
			}

		}
		
		keyboard.close();
	}
	
	//Función que realiza el calculo según el tipo de operación y los números que se indincan por parámetro.
	public static int calc (int x, int y, char c) throws ArithmeticException {
		int result;
		switch(c) {
		case '+': //Suma
			result = x + y;
			break;
		case '-': //Resta
			result = x - y;
			break;
		case '*': //Multiplicación
			result = x * y;
			break;
		case '/': //División
			result = x / y;
			break;
		default:
			result = 0;
			break;
		}
		return result;
	}
}
