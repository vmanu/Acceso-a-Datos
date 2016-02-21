package ejercicios2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicios2_6_3 {

	public static void escribirFichero(String entrada,StringBuffer cadena){
		BufferedWriter bw;
		try {
			bw=Files.newBufferedWriter(Paths.get(entrada).toRealPath());
			bw.write(cadena.toString());
			bw.close();
		} catch (NoSuchFileException ex){
			System.out.println("No existe el fichero");
		} catch (IOException e) {
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
	
	public static void leerFichero(String entrada){
		String lectura = "";
		BufferedReader br;
		try{
			br=Files.newBufferedReader(Paths.get(entrada).toRealPath());
			while((lectura=br.readLine())!=null){
				System.out.println(lectura);
			}
		} catch (NoSuchFileException ex){
			System.out.println("No existe el fichero");
		} catch(IOException e){
			System.out.println("fallo lectura");
		}
	}
	
	public static void main(String[] args) {
		int i=0;
		StringBuffer cadena = new StringBuffer();
		String entrada = "";
		boolean sal=false;
		while (!sal) {
			i++;
			entrada = leerTeclado(i);
			if (!entrada.equalsIgnoreCase("q")) {
				cadena.append(entrada).append(System.lineSeparator());
			}else{
				sal=true;
				entrada=leerNombreFichero();
			}
		}
		escribirFichero(entrada, cadena);
		leerFichero(entrada);
	}
}
