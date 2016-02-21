package Practica3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

	public static int leerNumero(){
		Scanner keyb=new Scanner(System.in);
		int valor=0;
		boolean sal;
		do{
			sal=true;
			System.out.println("Introduzca un numero entero");
			try{
				valor=keyb.nextInt();
			}catch(InputMismatchException e){
				sal=false;
				keyb.nextLine();
			}
		}while(!sal);
		return valor;
	}
	
	public static void agregarValor(int valor){
		try {
			RandomAccessFile raf = new RandomAccessFile("enteros.txt", "rw");
			raf.seek(raf.length());
			raf.writeInt(valor);
			raf.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra fichero");
		} catch (IOException s){
			System.out.println("Fallo de Stream");
		}
	}
	
	public static void muestraArchivo(){
		String value;
		try {
			RandomAccessFile raf = new RandomAccessFile("enteros.txt", "rw");
			raf.seek(0);
			while((value=raf.readInt()+"")!=""){
				System.out.println(value);
			}
			raf.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra fichero");
		} catch (IOException s){
			
		}
	}
	
	public static void main(String[] args) {
		agregarValor(leerNumero());
		muestraArchivo();
	}

}
