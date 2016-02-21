package Practica3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;

public class Ejercicio2 {

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
		ByteBuffer bb=ByteBuffer.allocate(4);
		bb.putInt(valor);
		try{
			FileChannel fc = (FileChannel.open(Paths.get("enteros2.dat"), READ, WRITE));
			fc.position(fc.size());
			bb.flip();
			fc.write(bb);
		} catch (IOException e){
			System.out.println("Fallo de Stream");
		}
	}
	
	public static void muestraArchivo(){
		ByteBuffer copy=ByteBuffer.allocate(4);
		try {
			FileChannel fc = (FileChannel.open(Paths.get("enteros2.dat"), READ, WRITE));
			while(fc.read(copy)!=-1){
				copy.flip();
				int num=copy.getInt(0);
				System.out.println(num);
			}
			fc.close();
		} catch (IOException s){
			System.out.println("Fallo de Stream");
		} 
	}

	public static void main(String[] args) {
		agregarValor(leerNumero());
		muestraArchivo();
	}

}
