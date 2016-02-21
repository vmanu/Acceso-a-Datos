package ejercicio10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Ejercicio10 {

	private static final int sal=11;
	
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
	
	public static void editaHashMap(HashMap<Integer,Integer> data){
		int libros=num(1,999999999,"Indique cuantos libros desea modificar",
				"No está dentro del rango");
		for(int i=0;i<libros;i++){
			int isbn=num(1,999999999,"Indique el isbn que desa modificar (asegurese "
					+ "de que existe y de no repetir)","No está dentro del rango");
			int valor=num(1,500,"Indique cuantas copias extras hay que agregar",
					"No está dentro del rango");
			data.put(isbn,valor);
		}
	}

	public static ArrayList<Integer> creaListaFilas(){
		int tamano=num(1,999999999,"Indique cuantas filas desea visualizar",
				"No está dentro del rango");
		ArrayList<Integer> lista=new ArrayList();
		for(int i=0;i<tamano;i++){
			lista.add(num(1,999999999,"Inserte linea","No esta dentro de rango"));
		}
		return lista;
	}
	
	public static float obtenPrecio(){
		float precio=0;
		Scanner keyb=new Scanner(System.in);
		do{
			System.out.println("Indique el precio por pagina");
			try{
				precio=keyb.nextFloat();
				if(precio<=0){
					System.out.print("El precio por pagina ha de ser mayor que 0. ");
					keyb.nextLine();
				}
			}catch(InputMismatchException e){
				System.out.print("No es un formato numerico float. ");
				keyb.nextLine();
			}
		}while(precio<=0);
		return precio;
	}
	
/////////AÑADIDO
	
	public static void main(String[] args) {
		Libros libros = new Libros();
		int op=0;
		do{
			op=num(1,sal,"Elige opción:"
					+ "\n\t1.Añadir Libro\n\t2.Borrar Libro"
					+ "\n\t3.Mostrar Catalogo\n\t4.Actualizar Copias"
					+ "\n\t5.Muestra las columnas de la tabla"
					+ "\n\t6.Mostrar Catalogo Invertido"
					+ "\n\t7.Muestra lineas concretas\n\t8.Poner precio"
					+ "\n\t9.Poner precio a dos libros\n\t10.Actualizar paginas y precio"
					+ "\n\t"+sal+".Salir",
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
					HashMap<Integer,Integer> data=new HashMap<Integer,Integer>();
					editaHashMap(data);
					libros.actualizar(data);
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
				case 7:
					libros.mostrar(creaListaFilas());
					break;
				case 8:
					libros.marcarPrecio(obtenPrecio());
					break;
				case 9:
					int aisbn[]=new int[2];
					for(int i=0;i<aisbn.length;i++){
						aisbn[i]=num(1,999999999,"Introduzca el isbn del libro "+(i+1),
								"No esta dentro de rango");
					}
					libros.cambiarPrecios(aisbn[0], aisbn[1], obtenPrecio());
					break;
				case 10:
					libros.actualizarLibroYPrecio(num(1,999999999,"Introduzca el isbn del libro",
							"No esta dentro de rango"), num(1,999,"Introduzca las paginas extras",
									"No esta dentro de rango"), obtenPrecio());
					break;
				case sal:
					System.out.println("Adios");
					libros.closeConnection();
			}
		}while(op!=sal);
	}
}
