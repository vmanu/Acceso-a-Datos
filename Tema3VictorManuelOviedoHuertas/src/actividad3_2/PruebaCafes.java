package actividad3_2;

import java.util.Scanner;


public class PruebaCafes {

	public static void main(String[] args) {
	
			Scanner keyb=new Scanner(System.in);
			Cafes miCafe = new Cafes();
			System.out.println("\n-------------------------------Contenido de la tabla CAFES-------------------------------");
			miCafe.verTabla();
			System.out.println("Introduce nombre del caf�:");
			String cafe=keyb.nextLine();
			System.out.println("\n-------------------------------Mostrando b�squeda con "+cafe+"-------------------------------");
			miCafe.buscar(cafe);
			System.out.println("\nMostrado b�squeda con "+cafe);
			System.out.println("Introduce nombre del caf�:");
			String nomCafe=keyb.nextLine();
			System.out.println("Introduzca nuevo valor de venta");
			int ventas=keyb.nextInt();
			System.out.println("\n-------------------------------A�adiendo valor-------------------------------");
			miCafe.actualizarVentasCafe(nomCafe, ventas);
			System.out.println("\nValor a�adido");
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
