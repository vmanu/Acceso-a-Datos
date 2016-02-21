package gui;


import java.util.List;
import java.util.Scanner;
import logica.GestionLibreria;
import modelo.Libro;
import modelo.LibreriaException;;

/**
 * @descrition Clase encargada de la lógica del negocio
 */

//Esta clase no tiene ninguna dependencia con la implementación de la persistencia de los datos
public class IUTextoLibreria {
	
	/**
	 * Método auxiliar para recorrer una lista de libros y mostrarla por pantalla
	 * @param libros
	 */
	public static void imprimeLista(List<Libro> libros){
		System.out.println("\nCatálogo:");
		for(int i=0;i<libros.size();i++){
			System.out.println(libros.get(i).toString());
		}
	}
	public static void main(String[] args) {
		//Actualiza número de copias y vemos catálogo antes y después.
		try {
			int num1,num2;
			Scanner escaner = new Scanner(System.in);
			System.out.println("Por favor introduzca el número de isbn");
			num1=escaner.nextInt();
			escaner.nextLine();
			System.out.println("Por favor introduzca el nuevo número de copias");
			num2=escaner.nextInt();
			escaner.nextLine();
			escaner.close();					
			imprimeLista(new GestionLibreria().actualizaLibreria(num1, num2));
			
		
		} catch (LibreriaException e) {
			/*
			 * En la GUI o en la clase con la que interacciona el usuario
			 * capturamos las excepciones de alto nivel de nuestra apliación e
			 * informamos correctamente al usuario
			 */
			System.out.println("Lo sentimos ocurrión un error en la apliación"
					+ e.getMessage());

		}

	}
}
