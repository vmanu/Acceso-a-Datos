package actividad3_2;

import java.util.Scanner;


public class PruebaCafes {

	public static void main(String[] args) {
	
			Scanner keyb=new Scanner(System.in);
			Cafes miCafe = new Cafes();
			System.out.println("\n-------------------------------Contenido de la tabla CAFES-------------------------------");
			miCafe.verTabla();
			System.out.println("Introduce nombre del café:");
			String cafe=keyb.nextLine();
			System.out.println("\n-------------------------------Mostrando búsqueda con "+cafe+"-------------------------------");
			miCafe.buscar(cafe);
			System.out.println("\nMostrado búsqueda con "+cafe);
			System.out.println("Introduce nombre del café:");
			String nomCafe=keyb.nextLine();
			System.out.println("Introduzca nuevo valor de venta");
			int ventas=keyb.nextInt();
			System.out.println("\n-------------------------------Añadiendo valor-------------------------------");
			miCafe.actualizarVentasCafe(nomCafe, ventas);
			System.out.println("\nValor añadido");
			System.out.println("\n-------------------------------Contenido de la tabla CAFES-------------------------------");
			miCafe.verTabla();
			System.out.println("\n-------------------------------borrando-------------------------------");
			miCafe.borrar("Espresso");
			System.out.println("\nborrado");
			System.out.println("\n-------------------------------Contenido de la tabla CAFES-------------------------------");
			miCafe.verTabla();
			System.out.println("\n-------------------------------creando-------------------------------");
			miCafe.crear("Espresso",150, (float)9.99, 0, 0);
			System.out.println("\ncreando");
			System.out.println("\n-------------------------------Contenido de la tabla CAFES-------------------------------");
			miCafe.verTabla();
			
	}
}
