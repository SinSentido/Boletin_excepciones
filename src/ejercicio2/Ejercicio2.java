package ejercicio2;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArithmeticException;

public class Ejercicio2 {
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/*
		 * 1. El usuario elige si quiere operar con enteros o decimales.
		 * 2. El usuario elige que tipo de operación quiere realizar.
		 * 3. El usuario elige los operandos.
		 * */

		int x=0, y=0, menuChoice=0;
		double d=0, n=0;
		char c;
		boolean menu = true;
		
		//1. El usuario elige si quiere operar con enteros o decimales.
		while(menu) {
			System.out.println("¿Quieres realizar una operación con decimales o con enteros? \n1.ENTEROS\n2.DECIMALES");
			try {
				menuChoice = keyboard.nextInt();
				menu = false;
				if(menuChoice < 1 || menuChoice >2) {
					System.out.println("Elección no válida, elige 1 o 2.");
					menu = true;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Elección no válida, elige 1 o 2.");
				menu = true;
			}
			finally {
				keyboard.nextLine();
			}
		}
			
		//2. El usuario elige que tipo de operación quiere realizar.
		c = operationMenu();
			
		//3. El usuario elige los operandos.
		if(menuChoice == 1) {
			menu = true;
			while(menu) {	
				try {
						
					System.out.println("Introduce los números enteros que quieres operar.");
					x = keyboard.nextInt();
					y = keyboard.nextInt();
					menu = false;
					calc(x,y,c);
				}
				catch(InputMismatchException e) {
					System.out.println("ERROR. Introduce un número.");
					menu = true;
				}
				catch(ArithmeticException e) {
					System.out.println("Esa división no es posible.");
				}
			}

		}
		else if(menuChoice == 2) {
			menu=true;
			while(menu) {
				try {
					//3. El usuario elige los operandos.
					System.out.println("Introduce los número decimales que quieres operar");
					d = keyboard.nextDouble();
					n = keyboard.nextDouble();
					menu = false;
					calc(d,n,c);
				}
				catch(InputMismatchException e) {
					System.out.println("ERROR. Introduce un número.");
					menu = true;
				}
				catch(ArithmeticException e) {
					System.out.println("Esa división no es posible.");
				}
			}

		}
		
	keyboard.close();
	}
	
	public static char operationMenu() {
		char c = 'a';
		boolean menu = true;
		
		while(menu) {
			System.out.println("Elige el tipo de operación que quieres realizar: \n +\n -\n *\n /");
			c = keyboard.next().charAt(0);
			menu = false;
			if(c != '+' && c != '-' && c != '*' && c != '/') {
				System.out.println("Elección no válida. Vuelve a introducir la operación que quieres realizar:");
				menu = true;
			}
		}

		return c;
	}
	
	//FUNCIÓN QUE OPERA CON NÚMEROS ENTEROS
	public static int calc(int x, int y, char c) throws ArithmeticException {
		int result=0;
		switch(c) {
		case '+':
			result = x + y;
			System.out.println("El resultado es: " +result);
			break;
		case '-':
			result = x - y;
			System.out.println("El resultado es: " +result);
			break;
		case'*':
			result = x * y;
			System.out.println("El resultado es: " +result);
			break;
		case '/':
			result = x / y;
			System.out.println("El resultado es: " +result);
			break;
		default:
			System.out.println("Operación no válida");
			break;
		}
		return result;
	}
	
	//FUNCIÓN QUE OPERA CON NÚMERO DECIMALES
	public static double calc(double x, double y, char c) throws ArithmeticException {
		double result=0;
		switch(c) {
		case '+':
			result = x + y;
			System.out.println("El resultado es: " +result);
			break;
		case '-':
			result = x - y;
			System.out.println("El resultado es: " +result);
			break;
		case'*':
			result = x * y;
			System.out.println("El resultado es: " +result);
			break;
		case '/':
			result = x / y;
			System.out.println("El resultado es: " +result);

			break;
		default:
			System.out.println("Operación no válida");
			break;
		}	
		return result;
	}
	
	
}
