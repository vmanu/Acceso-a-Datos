package GUI;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import modelo.Cafe;
import modelo.Proveedor;
import DAO.ProveedorDAOInterface;
import DAO.Utilidades;
import DAO.AccesoDatosException;
import DAO.CafeDAOInterface;
import DAO.FactoriaDAO;
import DAO.JDBCCafeDAO;


public class Ejercicio14 {

	private static final int sal=10;
	
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
	
	
	///MODIFICADO MAIN DE EJERCICIO 13-->AÑADIMOS OPCION 8 y 9
	public static void main(String[] args) {
		CafeDAOInterface cafe;
		ProveedorDAOInterface proveedor;
		List<Cafe> cafes;
		Cafe miCafe;
		Proveedor miProveedor;
		try {
			cafe = FactoriaDAO.getInstance().getCafeDAOInterface();
			proveedor=FactoriaDAO.getInstance().getProveedorDAOInterface();
			int op=0;
			do{
				op=num(1,sal,"Elige opción:"
						+ "\n\t1.Ver todo\n\t2.Buscar por Nombre Cafe"
						+ "\n\t3.Buscar por id proveedor\n\t4.Actualizar Ventas"
						+ "\n\t5.Borrar por Nombre Café\n\t6.Crear Cafe"
						+ "\n\t7.Traspasar ventas JDBCCafeDAO\n\t8.Añadir Proveedor"
						+ "\n\t9.Buscar Proveedor\n\t10.Salir",
						"No es una opción válida");
				switch(op){
					case 1:
						cafes=cafe.verTabla();
						for(Cafe coffee:cafes){
							if(coffee!=null){
								System.out.println(coffee.toString());
							}
						}
						break;
					case 2:
						miCafe=cafe.buscar(string("Introduzca el nombre del cafe "
								+ "que desea buscar:"));
						if(miCafe!=null){
							System.out.println(miCafe.toString());
						}
						break;
					case 3:
						cafes=cafe.buscarProveedor(num(1,999999999,"Introduce el id del proveedor","po no"));
						for(Cafe coffee:cafes){
							if(coffee!=null){
								System.out.println(coffee.toString());
							}
						}
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
						cafe.crear(new Cafe(provId, nombreCafe, precio, ventas, total));
						break;
					case 7:
						cafe.tranferencia(string("Introduzca nombre de cafe dador"),
								string("Introduzca nombre de cafe receptor"));
						break;
					case 8:
						proveedor.crearProveedor(new Proveedor(num(1,999999999,"Introduzca id proveedor",
								"No es un valor valido"),string("Indique el nombre del proveedor"),
								string("Indique nombre de la calle"),string("Indique la ciudad"),
								string("Indique el pais"),num(1,99999,"Indique cp","No es un valor valido")));
						break;
					case 9:
						miProveedor=proveedor.buscarProveedor(num(1,999999999,"Introduzca el id",
								"No es un valor valido"));
						if(miProveedor!=null){
							System.out.println(miProveedor.toString());
						}
						break;
					case sal:
						System.out.println("Adios");
						cafe.closeConnection();
				}
			}while(op!=sal);
		} catch (AccesoDatosException e) {
			e.printStackTrace();
		}
		
	}
}
