package ejercicio7;

import static ejercicio7.Keyboard.*;
import java.util.Random;

public class Ejercicio7 {
	
	static Random random = new Random();
	
	public static void main(String[] args) {
		
		/*
		 *1. Cada jugador escribe su nombre.
		 *2. Se establecen las apuestas.
		 *		2.1 El jugador1 establece la apuesta inicial.
		 *		2.2 El jugador2 iguala o supera la apuesta.
		 *		2.3 Si el jugador2 supera la apuesta, el jugador 1 tiene que igualar o superar.
		 *		2.4 Se repiten los puntos 2.2 y 2.3 hasta que uno de los jugadores iguale la apuesta del rival
		 *			o no pueda superar.
		 *3. Empieza el turno del jugador 1
		 *		3.1 Se le reparten 2 cartas al jugador1 y se cuenta su puntuación.	
		 *		3.2 El jugador1 elige plantarse o pedir más cartas
		 *		3.3 Cuando el jugador1 se plante o se pase acabará su turno.
		 *4. Empieza el turno del jugador 2
		 *		4.1 Se le reparten 2 cartas al jugador2 y se cuenta su puntuación.
		 *		4.2 El jugador2 elige plantarse o pedir más cartas.
		 *		4.3 Cuando el jugador2 se plante o se pase acabará su turno.
		 *5. Se comparan las manos de los jugadores. El jugador ganador se lleva el bote de las apuestas. 
		 *	 Si empatan cada uno se lleva su parte.
		 *6. Al finalizar la ronda se preguna a los jugadores si quieren seguir jugando pero en caso de que uno de
		 *	 los jugadores se quede sin dinero la partida acaba.
		 * */
		
		byte selector = 0;
		int player1Money=30, player2Money=100, bet, totalBet1, totalBet2, player1Points=0, player2Points=0;
		String namePlayer1, namePlayer2, player1Hand="", player2Hand="";
		boolean gameRunning=true, betting=true, askingForCard = true;
		
		message(3);//Muestra el mensaje inicial del programa
		
		//1. Cada jugador escribe su nombre.
		System.out.println("Nombre del jugador 1:");
		namePlayer1 = readString();
		namePlayer1 = namePlayer1.toUpperCase();
		System.out.println("Nombre del jugador 2:");
		namePlayer2 = readString();
		namePlayer2 = namePlayer2.toUpperCase();
		
		do {
			//2. Se establecen las apuestas.
			totalBet1=0;
			totalBet2=0;
			//2.1 El jugador1 establece la apuesta inicial.
			System.out.printf("%s hace la apuesta inicial:%n", namePlayer1);
			bet = readMayorMenor(player1Money, MayorMenor.MENOR_IGUAL);
			player1Money -= bet;
			totalBet1 += bet;
			selector = 0;
			do {
				//2.2 El jugador2 iguala o supera la apuesta.
				if(selector % 2 == 0) {
					System.out.printf("%s ha apostado %d. El total de la apuesta es %d%n%n", namePlayer1, bet, totalBet1+totalBet2 );
					if(bet > player2Money) {//En caso de que no pueda cubrir la totalidad de la apuesta
						System.out.printf("%s, no puedes cubrir la totalidad de la apuesta, tienes que ir con todo lo que tienes (%d).%n%n", namePlayer2, player2Money);
						totalBet2 += player2Money;
						player2Money = 0;
						//Se le devuelve la diferencia por encima al jugador1
						player1Money += (totalBet1 - totalBet2);
						totalBet1 -= (totalBet1 - totalBet2);
						betting = false;
					}
					else {
						totalBet2 += bet;
						player2Money -= bet;
						betting = readBoolean(namePlayer2 + " apuesta:","Subir","Igualar");
						if(player2Money == 0 && betting) {
							System.out.printf("No puedes subir la apuesta, no tienes suficiente dinero.%n%n");
							betting = false;
						}
						else if(!betting) {
							System.out.printf("Has igualado la apuesta.%n");
						}
						else {
							System.out.printf("%s sube la apuesta:%n", namePlayer2);
							bet = readMayorMenor(player2Money, MayorMenor.MENOR_IGUAL);
							totalBet2 += bet;
							player2Money -= bet;
						}
					}
				}
				//2.3 Si el jugador1 supera la apuesta, el jugador 1 tiene que igualar o superar.
				else {
					System.out.printf("%s ha apostado %d. El total de la apuesta es %d%n%n", namePlayer2, bet, totalBet1+totalBet2 );
					if(bet > player1Money) {//En caso de que no pueda cubrir la totalidad de la apuesta
						System.out.printf("%s, no puedes cubrir la totalidad de la apuesta, tienes que ir con todo lo que tienes (%d).%n%n", namePlayer1, player1Money);
						totalBet1 += player1Money;
						player1Money = 0;
						//Se le devuelve la diferencia por encima al jugador2.
						player2Money += (totalBet2 - totalBet1);
						totalBet2 -= (totalBet2 - totalBet1);
						betting = false;
					}
					else {
						totalBet1 += bet;
						player1Money -= bet;
						betting = readBoolean(namePlayer1 + " apuesta:","Subir","Igualar");
						if(player2Money == 0 && betting) {
							System.out.printf("No puedes subir la apuesta, no tienes suficiente dinero.%n%n");
							betting = false;
						}
						else if(!betting) {
							System.out.printf("Has igualado la apuesta.%n");
						}
						else {
							System.out.printf("%s sube la apuesta:%n", namePlayer1);
							bet = readMayorMenor(player1Money, MayorMenor.MENOR_IGUAL);
							totalBet1 += bet;
							player1Money -= bet;
						}
					}
				}
				selector++; //Cambia el turno de apuesta entre el jugador 1 y el jugador 2
			}
			//2.4 Se repiten los puntos 2.2 y 2.3 hasta que uno de los jugadores iguale la apuesta del rival o no pueda superar.
			while(betting); 
			
			//3. Empieza el turno del jugador 1
			message(1);
			player1Hand = ""; //Se limpia la mano de la ronda anterior
			//3.1 Se le reparten 2 cartas al jugador1 y se cuenta su puntuación.	
			player1Hand += handOut();
			player1Hand += handOut();
			//3.2 El jugador1 elige plantarse o pedir más cartas
			do {
				player1Points = puntuation(player1Hand);
				System.out.printf("Tu mano: %s = %d puntos%n", player1Hand, player1Points);
				if(puntuation(player1Hand) > 21) {
					System.out.printf("Te has pasado. Estás eliminado.%n");
					askingForCard = false;
					player1Points = 0;
				}
				else {
					askingForCard = readBoolean("¿Quieres otra carta?");
					if (askingForCard) {
						player1Hand += handOut();
					}
					else {
						System.out.printf("Te has plantado con %d puntos%n", player1Points);
					}
				}
			}
			//3.3 Cuando el jugador1 se plante o se pase acabará su turno.
			while(askingForCard);
			
			//4. Empieza el turno del jugador 2
			message(2);
			player2Hand = ""; //Se limpia la mano de la ronda anterior
			//4.1 Se le reparten 2 cartas al jugador2 y se cuenta su puntuación.	
			player2Hand += handOut();
			player2Hand += handOut();
			//4.2 El jugador2 elige plantarse o pedir más cartas
			do {
				player2Points = puntuation(player2Hand);
				System.out.printf("Tu mano: %s = %d puntos%n", player2Hand, player2Points);
				if(puntuation(player2Hand) > 21) {
					System.out.printf("Te has pasado. Estás eliminado.%n");
					askingForCard = false;
					player2Points = 0;
				}
				else {
					askingForCard = readBoolean("¿Quieres otra carta?");
					if (askingForCard) {
						player2Hand += handOut();
					}
					else {
						System.out.printf("Te has plantado con %d puntos%n", player2Points);
					}
				}
			}
			//4.3 Cuando el jugador2 se plante o se pase acabará su turno.
			while(askingForCard);
			
			 /*5. Se comparan las manos de los jugadores. El jugador ganador se lleva el bote de las apuestas. 
			      Si empatan cada uno se lleva su parte.*/
			if(player1Points > player2Points) {
				System.out.printf("Ha ganado: %s%n", namePlayer1);
				player1Money += totalBet1 + totalBet2;
			}
			else if(player2Points > player1Points) {
				System.out.printf("Ha ganado: %s%n", namePlayer2);
				player2Money += totalBet1 + totalBet2;
			}
			else {
				player1Money += totalBet1;
				player2Money += totalBet2;
			}
			
			 /*6. Al finalizar la ronda se preguna a los jugadores si quieren seguir jugando pero en caso de que uno de
			 	  los jugadores se quede sin dinero la partida acaba.*/
			if(player1Money == 0) {
				System.out.printf("%s no puede seguir jugando, no tiene más dinero", namePlayer1);
				gameRunning = false;
			}
			else if(player2Money == 0) {
				System.out.printf("%s no puede seguir jugando, no tiene más dinero", namePlayer2);
				gameRunning = false;
			}
			else {
				gameRunning = readBoolean("¿Quereis seguir jugando?");
				if(!gameRunning) {
					System.out.println("---FIN DE LA PARTIDA---");;
				}
			}
		}
		while(gameRunning);
	}
	
	//Función para calcular los puntos en la mano de un jugador
	public static int puntuation(String s) {
		int points = 0, aCounter=0;
		//Modifico el string para que pueda comparar los números de las cartas.
		s = s.replaceAll(" ", "");
		//Transformo el 10 en 1 ya que el 1 está representado por el A y solo puedo leer un elemento del array.
		s = s.replaceAll("0", "");
		
		//Recorre la mano del jugador para identificar sus cartas
		for(int i=0; i<s.length(); i++) {
			//Solo compara los valores de las cartas, los palos los ignora.
			if(i%2 == 0) {
				//Si es un A suma 11 puntos
				if(s.charAt(i) == 'A') {
					points += 11;
					aCounter++;
				}
				//Si es una figura suma 10 puntos
				else if(s.charAt(i) == 'J' || s.charAt(i) == 'Q' || s.charAt(i) == 'K' || s.charAt(i) == '1') {
					points += 10;
				}
				//Para cualquier otra carta suma su valor numérico.
				else {
					points += Character.getNumericValue(s.charAt(i));
				}
			}
		}
		
		//Resta los valores de A si se pasa de 21. Es decir hace como si A valiera 1 en lugar de 11.
		if(points > 21) {
			points -= 10*aCounter;	
		}
		
		return points;
	}
	
	//Función para repartir una carta
	public static String handOut() {
		String card = "";
		String suits = "♠♥♦♣";
		int cardNumber = random.nextInt(13)+1;
		
		//Se le asigna el valor a la carta
		if(cardNumber == 1) {
			card += "A"; 
		}
		else if(cardNumber == 11) {
			card += "J";
		}
		else if(cardNumber == 12) {
			card += "Q";
		}
		else if(cardNumber == 13) {
			card += "K";
		}
		else {
			card += cardNumber;
		}
		
		//Se le asigna el palo a la carta
		card += suits.charAt(random.nextInt(suits.length()));
		card += " ";
		return card;
	}
	
	
	//Funcion para sacar por pantalla los mensajes de los turnos
	public static void message(int x) {
		if(x == 1) {
			System.out.printf("|||||| ||  || |||||| |||||| |||||| |||||| ||||||     |||%n"
							 +"    || ||  || ||     ||  ||   || | ||  || ||  ||      ||%n"
							 +"    || ||  || || ||| ||  ||   || | ||  || ||||||      ||%n"
							 +"||  || ||  || ||  || ||||||   || | ||  || || ||       ||%n"
							 +"|||||| |||||| |||||| ||  || |||||| |||||| ||  ||    ||||||%n%n");
		}
		else if(x == 2){
			System.out.printf("|||||| ||  || |||||| |||||| |||||| |||||| ||||||    ||||||%n"
					         +"    || ||  || ||     ||  ||   || | ||  || ||  ||        ||%n"
					         +"    || ||  || || ||| ||  ||   || | ||  || ||||||    ||||||%n"
					         +"||  || ||  || ||  || ||||||   || | ||  || || ||     ||%n"
					         +"|||||| |||||| |||||| ||  || |||||| |||||| ||  ||    ||||||%n%n");
		}
		else if(x == 3) {
			System.out.printf("||||||||   ||      ||||||  ||||||  ||  ||   ||||||  ||||||  ||||||  ||  ||%n"
					         +"  ||  ||   ||      ||  ||  ||      ||  ||       ||  ||  ||  ||      ||  ||%n"	
					         +"  ||  ||   ||      ||  ||  ||      ||  ||       ||  ||  ||  ||      ||  ||%n" 
					         +"  ||||||   ||      ||||||  ||      ||||         ||  ||||||  ||      ||||%n"
					         +"  ||  ||   ||      ||  ||  ||      ||  ||       ||  ||  ||  ||      ||  ||%n"
					         +"  ||  ||   ||      ||  ||  ||      ||  ||       ||  ||  ||  ||      ||  ||%n"
					         +"  ||  ||   ||      ||  ||  ||      ||  ||   ||  ||  ||  ||  ||      ||  ||%n"
					         +"||||||||   ||||||  ||  ||  ||||||  ||  ||   ||||||  ||  ||  ||||||  ||  ||%n%n");
		}
	}
}
