package Practica3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {

	public static int dameValorNumerico(String pregunta,String mensajeError,int minimo){
		boolean correcto;
		Scanner keyb=new Scanner(System.in);
		int valor=0;
		do{
			correcto=true;
			System.out.println(pregunta);
			try{
				valor=keyb.nextInt();
				if(valor<minimo){
					System.out.print(mensajeError);
					correcto=false;
					keyb.nextLine();
				}
			}catch(InputMismatchException e){
				System.out.print("Valor no numérico. ");
				keyb.nextLine();
				correcto=false;
			}
		}while(!correcto);
		return valor;
	}
	
	public static String dameDato (String pregunta){
		System.out.println(pregunta);
		return new Scanner(System.in).nextLine();
	}
	
	public static void main(String[] args) {
		String ruta=dameDato("Indique el nombre del archivo que desea crear.");
		if(serializadorAlumno.serializarAlumno(ruta, new Alumno(dameDato("Introduzca el nombre del alumno"),
				dameDato("Introduzca el/los apellidos del alumno"),
				dameValorNumerico("Introduzca el año de nacimiento del alumno",
						"El valor introducido es menor a 1970, año mínimo de entrada. ", 1970),
				dameDato("Dime la dirección del alumno"),dameValorNumerico("Dime el numero de la calle",
						"El valor introducido es menor que 1. ", 1)))){
			System.out.println(serializadorAlumno.deserializarAlumno(ruta).toString());
		}
		
	}

}
