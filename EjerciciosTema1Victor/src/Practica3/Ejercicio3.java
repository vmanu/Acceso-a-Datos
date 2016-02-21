package Practica3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

	public static String solicitaArchivo(){
		System.out.println("Introduzca el nombre del archivo");
		return new Scanner(System.in).nextLine();
	}
	
	public static int solicitaPosicion(){
		int pos=0;
		Scanner keyb=new Scanner(System.in);
		boolean correcto;
		do{
			correcto=true;
			System.out.println("Introduzca posicion a partir de la que se va a escribir (de 1 en adelante)");
			try{
				pos=keyb.nextInt();
				if (pos<1){
					System.out.print("El valor introducido es menor que 1. ");
					correcto=false;
				}
			}catch(InputMismatchException e){
				System.out.print("No ha introducido un valor numérico. ");
				keyb.nextLine();
				correcto=false;
			}
		}while(!correcto);
		return pos;
	}
	
	public static void escribeFichero(int pos, String path){
		try {
			RandomAccessFile raf=new RandomAccessFile(path, "rw");
			if(raf.read()==-1){
				throw new IOException();
			}else{
				boolean sal=false;
				String valor="";
				for(int i=1;i<=pos&&!sal;i++){
					if((valor=raf.readLine())==null){
						throw new ArrayIndexOutOfBoundsException();
					}
				}
				System.out.print(valor);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra fichero");
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("La posición dada es mayor que la longitud del fichero.");
		} catch (IOException e) {
			System.out.println("El fichero está vacío");
		}
	}
	
	public static void main(String[] args) {
		String path=solicitaArchivo();
		try {
			Paths.get(path).toRealPath();
			escribeFichero(solicitaPosicion(), path);
		} catch (IOException e) {
			System.out.println("El fichero no existe");
		}
	}

}
