package mainApp;

import java.util.Scanner;

import models.Baraja;
import models.Carta;

public class MainApp {
	public static void main (String[]args) {
		Scanner s = new Scanner(System.in);
		
		//Bienvenida:
		System.out.println();
		System.out.println("|------------------- BIENVENIDO AL JUEGO DE CARTAS: ------------------|");
		System.out.println("|                              7 y MEDIO                              |");
		
		//Aprovechamos el constructor de la baraja ya barajada para crear nuestra baraja:
		Baraja Baraja7yMedio = new Baraja (1,true);
		
		//Dibujamos el juego
		System.out.println("|                                                                     | ");
		System.out.println("|-------------------------- INSTRUCCIONES ----------------------------|");
		System.out.println("|               Su objetivo es obtener el valor de '7.5'              |");
		System.out.println("|            mediante la suma de los valores de sus cartas.           |");
		System.out.println("|                                                                     | ");
		System.out.println("|------------------------------ VALORES ------------------------------|");
		System.out.print("|  Carta  ");
		   
	    for (int i = 1; i <= 10; i++) {
	      System.out.printf("|%4d ", i);
	    }
		    
		System.out.println("|\n|---------|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
		System.out.print("|  Valor  ");
	    
	    for (int i = 1; i <= 10; i++) {
			Carta CartaValorar = new Carta(i);
		    double suValor;
		    suValor = CartaValorar.getValor7ymedia();
		    System.out.print("| " + suValor + " ");
	    }
	    
		System.out.println("|\n|---------------------------------------------------------------------|");
		System.out.println("                                                                        ");
		System.out.println("                        ¿Desea comenzar a jugar?                        ");
		System.out.println("                             1. SI | 2. NO                               ");
		System.out.println("                                                                        ");
		System.out.print("                              Respuesta:");
		
		int respuesta1 = Integer.parseInt(s.nextLine());
	
		if(respuesta1 == 1) {
			
			System.out.println("\n|---------------------------------------------------------------------|");
			System.out.println("|                      READY? LETS GO! GOOD LUCK                      | ");
			System.out.println("|                        ******BARAJANDO******                        | "); 
			System.out.println("|---------------------------------------------------------------------|");
			
			int respuesta2 = 0;
			double puntuacion = 0;			
			Carta cartaRobada = Baraja7yMedio.robar();			
			double valorCartaRobada = cartaRobada.getValor7ymedia();
					
			boolean finjuego = false;
			
			do {
				cartaRobada = Baraja7yMedio.robar();			
				valorCartaRobada = cartaRobada.getValor7ymedia();
				puntuacion += valorCartaRobada;
					 
				if (puntuacion >= 7.51) {
					System.out.println();
					System.out.println("                          CARTA: " + cartaRobada.getNombreCarta());
					System.out.println("                          VALOR: " + cartaRobada.getValor7ymedia());
					System.out.println("                          PUNTUACION: " + puntuacion);
					System.out.println();
					System.out.println("                             WA WA WAAAA....");
					System.out.println("                            Ha perdido ya que");
					System.out.println("                     su puntuación ha superado en " + (puntuacion-7.5));
					System.out.println("                                los 7.5");
					
					finjuego = true;
		
				}else{						
				
					System.out.println();
					System.out.println("                          CARTA: " + cartaRobada.getNombreCarta());
					System.out.println("                          VALOR: " + cartaRobada.getValor7ymedia());
					System.out.println("                          PUNTUACION: " + puntuacion);
					
					System.out.println();
					System.out.println("               ¿Desea seguir juagando o prefiere plantarse?               ");
					System.out.println("                         1. Seguir 2. Plantarse                         ");
					System.out.println("                                                                        ");
					System.out.print("                              Respuesta:");
					respuesta2 = Integer.parseInt(s.nextLine());
					
					if(respuesta2 == 2 && puntuacion == 7.5) {
						System.out.println("                      ¡ENHORABUENA! ");			
						System.out.println("            Ha conseguido la máxima puntuación. ");
						System.out.println("                      Premio: 100/100.");
						finjuego = true;
					}else if(respuesta2 == 2 && puntuacion < 7.5){
						System.out.println("\n                    Se ha quedado a " + (7.5-puntuacion) + " puntos de 7.5.");				
						
						System.out.println("                           Premio: 99/100.");
						finjuego = true;
					}
				}
				
				
				
			} while(finjuego == false);	
			
									
		}else {
			System.out.println("\n                          LA PRÓXIMA VEZ SERÁ...");
		}
		
		
		
		//habrá que mostrar la puntuación que vamos obteniendo y la carta que hemos robado
	
	}
}