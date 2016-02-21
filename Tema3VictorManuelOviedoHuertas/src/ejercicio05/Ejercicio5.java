package ejercicio05;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Ejercicio5 {

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
		Libros libros = new Libros();
		int op=0;
		do{
			op=num(1,sal,"Elige opción:"
					+ "\n\t1.Añadir Libro\n\t2.Borrar Libro"
					+ "\n\t3.Mostrar Catalogo\n\t4.Actualizar Copias"
					+ "\n\t5.Muestra las columnas de la tabla"
					+ "\n\t6.Mostrar Catalogo Invertido\n\t7.Salir",
					"No es una opción válida");
			switch(op){
				case 1:
					Scanner keyb=new Scanner(System.in);
					System.out.println("Introduzca el titulo del libro");
					String titulo=keyb.nextLine();
					int isbn=num(1,999999999,"Introduzca isbn","No es un valor valido");
					System.out.println("Introduzca nombre del autor");
					String precio=keyb.nextLine();
					System.out.println("Introduzca la editorial del libro");
					String editorial=keyb.nextLine();
					int paginas=num(1,999999999,"Introduzca las paginas del libro",
							"No está dentro del rango");
					int copias=num(1,999999999,"Introduzca las copias",
							"No está dentro del rango");
					libros.crear(isbn, titulo, precio, editorial, paginas, copias);
					break;
				case 2:
					libros.borrar(num(1,999999999,"Introduzca ISBN a eliminar",
							"No está en el rango posible"));
					break;
				case 3:
					libros.verTabla();
					break;
				case 4:
					libros.actualizar(num(1,999999999,
							"Introduzca el ISBN del libro a modificar",
								"No esta dentro del rango"), num(1,999999999,
							"Introduzca el nuevo numero de copias","No esta dentro del rango"));
					break;
				case 5:
					String [] muestra=null;
					try {
						muestra=libros.getCamposLibro();
					} catch (AccesoDatosException e) {
						System.out.println(e.getMessage());
					}
					if(muestra!=null){
						for(int i=0;i<muestra.length;i++){
							System.out.println(muestra[i]);
						}
					}
					break;
				case 6:
					libros.verCatalogoInverso();
					break;
				case sal:
					System.out.println("Adios");
					libros.closeConnection();
			}
		}while(op!=sal);
	}
}
