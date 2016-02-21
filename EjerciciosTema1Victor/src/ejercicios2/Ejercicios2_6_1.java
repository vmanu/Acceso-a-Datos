package ejercicios2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicios2_6_1 {
	
	public static void escribirFichero(String entrada,ArrayList<String> intr){
		try {
			Files.write(Paths.get(entrada).toRealPath(), intr, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (NoSuchFileException ex){
			System.out.println("No existe el fichero");
		}catch (IOException e) {
			System.out.println("Fallo");
		}
	}
	
	public static String leerTeclado(int i){
		Scanner keyb = new Scanner(System.in);
		System.out.println("Dime frase " + i + ". Pulse 'q' para salir.");
		return keyb.nextLine();
	}
	
	public static String leerNombreFichero(){
		Scanner keyb = new Scanner(System.in);
		System.out.println("Introduce nombre del archivo a crear:");
		return keyb.nextLine();
	}
	
	public static void lecturaFichero(String entrada){
		ArrayList<String> lectura;
		try{
			lectura=(ArrayList <String>)Files.readAllLines(Paths.get(entrada).toRealPath());
			for(int i=0;i<lectura.size();i++){
				System.out.println(lectura.get(i));
			}
		} catch (NoSuchFileException ex){
			System.out.println("No existe el fichero");
		} catch(IOException e){
			System.out.println("Otro tipo de fallo");
		}
	}
	
	public static void main(String[] args) {
		int i=0;
		ArrayList<String> intr = new ArrayList();
		String entrada = "";
		boolean sal=false;
		while (!sal) {
			i++;
			entrada = leerTeclado(i);
			if (!entrada.equalsIgnoreCase("q")) {
				intr.add(entrada);
			}else{
				sal=true;
				entrada=leerNombreFichero();
			}
		}
		escribirFichero(entrada,intr);
		lecturaFichero(entrada);
	}
}
