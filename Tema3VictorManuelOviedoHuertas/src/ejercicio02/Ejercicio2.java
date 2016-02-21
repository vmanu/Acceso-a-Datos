package ejercicio02;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Ejercicio2 {

	private static final int sal=7;
	
	public static int num(int min,int max,String pregunta,String fallo){
		Scanner keyb=new Scanner(System.in);
		boolean sal;
		int valor=0;
		do{
			sal=true;
			System.out.println(pregunta);
			try{
				valor=keyb.nextInt();
				if(valor<min||valor>max){
					System.out.print(fallo+". ");
					sal=false;
					keyb.nextLine();
				}
			}catch(InputMismatchException e){
				System.out.print("El valor introducido no es un número. ");
				sal=false;
				keyb.nextLine();
			}
		}while(!sal);
		return valor;
	}
	
	public static String string(String pregunta){
		System.out.println(pregunta);
		return new Scanner(System.in).nextLine();
	}
	
	public static void main(String[] args) {
		Cafes cafe = new Cafes();
		int op=0;
		do{
			op=num(1,sal,"Elige opción:"
					+ "\n\t1.Ver todo\n\t2.Buscar por Nombre Cafe"
					+ "\n\t3.Buscar por id proveedor\n\t4.Actualizar Ventas"
					+ "\n\t5.Borrar por Nombre Café\n\t6.Crear Cafe\n\t7.Salir",
					"No es una opción válida");
			switch(op){
				case 1:
					cafe.verTabla();
					break;
				case 2:
					cafe.buscar(string("Introduzca el nombre del cafe "
							+ "que desea buscar:"));
					break;
				case 3:
					cafe.buscarProveedor(num(1,999999999,"Introduce el id del proveedor","po no"));
					break;
				case 4:
					System.out.println("Introduzca el nombre del cafe que desea modificar");
					cafe.actualizarVentasCafe(new Scanner(System.in).nextLine(), num(1,999999999,
							"Introduzca el numero de ventas","No esta dentro del rango"));
					break;
				case 5:
					System.out.println("Introduzca el nombre del cafe a borrar");
					cafe.borrar(new Scanner(System.in).nextLine());
					break;
				case 6:
					Scanner keyb=new Scanner(System.in);
					System.out.println("Introduzca el nombre del cafe");
					String nombreCafe=keyb.nextLine();
					int provId=num(1,999999999,"Introduzca id proveedor","No es un valor valido");
					System.out.println("Introduzca precio");
					float precio=keyb.nextFloat();
					int ventas=num(1,999999999,"Introduzca las ventas de cafe conseguidas",
							"No está dentro del rango");
					int total=num(ventas,999999999,"Introduzca las ventas totales",
							"No está dentro del rango");
					cafe.crear(nombreCafe, provId, precio, ventas, total);
					break;
				case sal:
					System.out.println("Adios");
					cafe.closeConnection();
			}
		}while(op!=sal);
	}
}
