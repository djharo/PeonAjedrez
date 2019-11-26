package org.iesalandalus.programacion.peonajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un peón en el tablero de ajedrez");
		System.out.println("-------------------------------------------------------------------------");
		
		mostrarPeon();
		mostrarMenu();
		
		System.out.println("Hasta luego Lucas!!!!");
	}
	
	private static void mostrarPeon() {
		
		Peon.peon = new Peon();
		
		System.out.println("Representacion de un peón " + Peon.peon + "\n");
	}
	
	private static void mostrarMenu() {
		
		System.out.println("Opciones de nuestro programa Peón de Ajedrez");
		System.out.println("1.Elegir color\n2.Elegir columna inicial\n3.Mostrar menu movimientos\n4.Elegir movimiento."
				+ "\n5.Realizar movimiento.\n6.Crear peón inicial(por defecto)\n7.Crear un peón de color\n8.Crear un peón con un color y una columna inical."
				+ "\n9.Mover peon\n0.Salir");
		elegirOpcion();
	}
	
	private static void elegirOpcion() {
		
		System.out.println("Elija una opción del menú:");
		
		int opcion;
		
		opcion = Entrada.entero();
		
		while(opcion < 0 || opcion > 9) {
			
			System.out.println("Opción incorrecta,\nvuelva a elegir una opcion");
			
			opcion = Entrada.entero();
		}
		
		ejecutarOpcion(opcion);
	}
	
	private static void ejecutarOpcion(int opcion) {

		switch (opcion) {

		case 1:
			Color colorElegido = elegirColor();
			System.out.println("El color elgido para su peón es el: " + colorElegido + "\n");
			mostrarMenu();
			break;
		case 2:
			char columnaElegida = elegirColumnaInicial();
			System.out.println("La columna elgida para su peón es la: " + columnaElegida + "\n");
			mostrarMenu();
			break;
		case 6:
			crearPeonDefecto();
			mostrarMenu();
			break;
		case 7:
			crearPeonColor();
			mostrarMenu();
			break;
		case 8:
			crearPeonColorColumna();
			mostrarMenu();
			break;
		default:
			break;
		}
	}
	
	private static Color elegirColor() {
		
		System.out.println("Elija un color para el peón: ");
		
		String color = "";
		
		color = Entrada.cadena();
		
		while(!Color.BLANCO.toString().equalsIgnoreCase(color) && !Color.NEGRO.toString().equalsIgnoreCase(color)) {
			
			System.out.println("Color incorrecto:\nEl color tiene que ser blanco o negro." );
			
			color = Entrada.cadena();
		}
		
		Color colorElegido = Color.valueOf(color.toUpperCase());
		
		return colorElegido;
	}
	
	private static char elegirColumnaInicial() {
		
		System.out.println("Elija una columna para su peón");
		
		char columnaElegida = ' ';
		
		columnaElegida = Entrada.caracter();
		
		while(columnaElegida < 'a' || columnaElegida > 'h') {
			
			System.out.println("Columna errornea\nLa columna tien que estar entre la a y la h ambas incluidas.");
			columnaElegida = Entrada.caracter();
		}
		
		return columnaElegida;
	}
	
	private static void crearPeonDefecto() {
		
		mostrarPeon();
	}
	
	private static void crearPeonColor() {
		
		System.out.println("Crear peón color:\n");
		
		Color colorElegido =elegirColor();
		
		Peon.peon = new Peon(colorElegido);
		
		System.out.println("Su Peón elegido es: " + Peon.peon + "\n");
	}
	
	private static void crearPeonColorColumna() {
		
		System.out.println("Crear peón color y columna:\n");
		
		Color colorElegido =elegirColor();
		
		char columnaElegida = elegirColumnaInicial();
		
		Peon.peon = new Peon(colorElegido, columnaElegida);
		
		System.out.println("Su Peón elegido es: " + Peon.peon + "\n");
	}
}
