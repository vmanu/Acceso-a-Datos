package ejercicios2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Ejercicios2_6_4 {

	public static BufferedWriter contruyeBuffer(String entrada){
		BufferedWriter bw = null;
		try {
			Files.delete(Paths.get(entrada).toRealPath());
			bw = Files.newBufferedWriter(Paths.get(entrada),StandardOpenOption.APPEND,StandardOpenOption.CREATE);
		} catch (NoSuchFileException ex){
			System.out.println("No existe el fichero");
		} catch (IOException e) {
			
		}
		return bw;
	}
	
	public static void escribirFichero(BufferedWriter bw,int i){
		try {
			bw.write(leerFrases(i));
		} catch (IOException e) {
			System.out.println("Fallo2");
		}
	}
	
	public static String leerFrases(int i){
		Scanner keyb = new Scanner(System.in);
		System.out.println("Dime frase " + i + ".");
		return keyb.nextLine()+System.lineSeparator();
	}
	
	public static void cerrarFlujoFichero(BufferedWriter bw){
		try {
			bw.close();
		} catch (IOException e) {
			System.out.println("Fallo3");
		}
	}
		
	public static String leerNombreFichero(){
		Scanner keyb = new Scanner(System.in);
		System.out.println("introduce nombre del archivo a crear:");
		return keyb.nextLine();
	}
	
	public static boolean leerSeguir(){
		Scanner keyb = new Scanner(System.in);
		System.out.println("Desea continuar? Escriba N para salir");
		return keyb.nextLine().equalsIgnoreCase("N");
	}
	
	public static void leerFichero(String entrada){
		BufferedReader br;
		String lectura = "";
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
		int i = 0;
		String entrada=leerNombreFichero();
		Scanner keyb = new Scanner(System.in);
		BufferedWriter bw = null;
		boolean sal = false;
		if((bw=contruyeBuffer(entrada))==null){
			sal=true;
		}
		while (!sal) {
			i++;
			escribirFichero(bw,i);
			sal=leerSeguir();
		}
		if(bw!=null){
			cerrarFlujoFichero(bw);
		}
		leerFichero(entrada);
	}
}
