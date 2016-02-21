package gui;


import java.util.List;
import java.util.Scanner;
import logica.GestionLibreria;
import modelo.Libro;
import modelo.LibreriaException;;

/**
 * @descrition Clase encargada de la l�gica del negocio
 */

//Esta clase no tiene ninguna dependencia con la implementaci�n de la persistencia de los datos
public class IUTextoLibreria {
	
	/**
	 * M�todo auxiliar para recorrer una lista de libros y mostrarla por pantalla
	 * @param libros
	 */
	public static void imprimeLista(List<Libro> libros){
		System.out.println("\nCat�logo:");
		for(int i=0;i<libros.size();i++){
			System.out.println(libros.get(i).toString());
		}
	}
	public static void main(String[] args) {
		//Actualiza n�mero de copias y vemos cat�logo antes y despu�s.
		try {
			int num1,num2;
			Scanner escaner = new Scanner(System.in);
			System.out.println("Por favor introduzca el n�mero de isbn");
			num1=escaner.nextInt();
			escaner.nextLine();
			System.out.println("Por favor introduzca el nuevo n�mero de copias");
			num2=escaner.nextInt();
			escaner.nextLine();
			escaner.close();					
			imprimeLista(new GestionLibreria().actualizaLibreria(num1, num2));
			
		
		} catch (LibreriaException e) {
			/*
			 * En la GUI o en la clase con la que interacciona el usuario
			 * capturamos las excepciones de alto nivel de nuestra apliaci�n e
			 * informamos correctamente al usuario
			 */
			System.out.println("Lo sentimos ocurri�n un error en la apliaci�n"
					+ e.getMessage());

		}

	}
}
