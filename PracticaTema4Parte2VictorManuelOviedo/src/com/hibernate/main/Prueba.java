package com.hibernate.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.hibernate.modelo.Correo;
import com.hibernate.modelo.Direccion;
import com.hibernate.modelo.Modulo;
import com.hibernate.modelo.Profesor;
import com.hibernate.utilidades.Funcionalidades;
import com.hibernate.utilidades.Utilidades;

public class Prueba {
	private static final int sal=3;
	
	public static void main(String[] args) {
		Session session=null;
		int opcion;
		try{
			session = Utilidades.getSessionFactory().openSession();
			do{
				opcion=getNumero();
				switch(opcion){
					case 1:
						Funcionalidades.darAlta(session,creaProfesor());
						break;
					case 2:
						Profesor leido=Funcionalidades.getProfesor(session,getIdVer());
						System.out.println(leido.toString());
						break;
					case sal:
						break;
				}
			}while(opcion!=sal);
		}finally{
			session.getSessionFactory().close();
			Utilidades.getSessionFactory().close();
		}
	}
	
	private static Profesor creaProfesor(){
		Scanner keyb=new Scanner(System.in);
		System.out.println("Introduce nombre del profesor");
		String nombre=keyb.nextLine();
		System.out.println("Introduce apellido 1 del profesor");
		String ape1=keyb.nextLine();
		System.out.println("Introduce apellido 2 del profesor");
		String ape2=keyb.nextLine();
		Direccion dir=creaDireccion();
		Modulo mod=creaModulo();
		List<Correo>correos=creaCorreos();
		return new Profesor(nombre,ape1,ape2,dir,mod,correos);
	}
	
	private static Direccion creaDireccion(){
		Scanner keyb=new Scanner(System.in);
		System.out.println("Introduce calle de la vivienda del profesor");
		String calle=keyb.nextLine();
		int numero=0;
		do{
			System.out.println("Introduce numero de la calle de la vivienda del profesor");
			try{
				numero=keyb.nextInt();
				if(numero<1){
					System.out.print("No puede ser menor que 1. ");
				}
			}catch(InputMismatchException s){
				System.out.print("Valor no numerico. ");
			}
			keyb.nextLine();
		}while(numero<1);
		System.out.println("Introduce poblacion de la vivienda del profesor");
		String poblacion=keyb.nextLine();
		System.out.println("Introduce provincia de la vivienda del profesor");
		String provincia=keyb.nextLine();
		return new Direccion(calle,numero,poblacion,provincia);
	}
	
	private static Modulo creaModulo(){
		Scanner keyb=new Scanner(System.in);
		System.out.println("Introduce nombre del modulo del profesor");
		String nombre=keyb.nextLine();
		float creditos=0;
		do{
			System.out.println("Introduce numero de creditos del modulo");
			try{
				creditos=keyb.nextFloat();
				if(creditos<=0){
					System.out.print("No puede ser 0 ni menor. ");
				}
			}catch(InputMismatchException s){
				System.out.print("Valor no numerico o con formato incorrecto. ");
			}
			keyb.nextLine();
		}while(creditos<=0);
		return new Modulo(nombre,creditos);
	}
	
	private static List<Correo> creaCorreos(){
		Scanner keyb=new Scanner(System.in);
		int numero=-10;
		do{
			System.out.println("Introduce numero de correos del profesor");
			try{
				numero=keyb.nextInt();
				if(numero<0){
					System.out.print("No puede ser menor que 0. ");
				}
			}catch(InputMismatchException s){
				System.out.print("Valor no numerico. ");
			}
			keyb.nextLine();
		}while(numero<0);
		List<Correo>correos=new ArrayList();
		for(int i=0;i<numero;i++){
			System.out.println("Introduce direccion del correo ("+(i+1)+") del profesor");
			String direccion=keyb.nextLine();
			System.out.println("Introduce proveedor del correo ("+(i+1)+") del profesor");
			String proveedor=keyb.nextLine();
			correos.add(new Correo(direccion,proveedor));
		}
		return correos;
	}
	
	private static int getIdVer(){
		Scanner keyb=new Scanner(System.in);
		boolean salir;
		int valor=0;
		do{
			salir=true;
			System.out.println("Introduce id del profesor a mostrar (Se supone que lo sabes)");
			try{
				valor=keyb.nextInt();
				if(valor<1){
					System.out.print("No es una opción válida. ");
					salir=false;
					keyb.nextLine();
				}
			}catch(InputMismatchException e){
				System.out.print("El valor introducido no es un número. ");
				salir=false;
				keyb.nextLine();
			}
		}while(!salir);
		return valor;
	}

	private static int getNumero() {
		Scanner keyb=new Scanner(System.in);
		boolean salir;
		int valor=0;
		do{
			salir=true;
			System.out.println("Introduce una de las siguientes opciones:\n\t1.Dar Alta\n\t2.Mostrar"
			+"\n\t"+sal+".Salir");
			try{
				valor=keyb.nextInt();
				if(valor<1||valor>sal){
					System.out.print("No es una opción válida. ");
					salir=false;
					keyb.nextLine();
				}
			}catch(InputMismatchException e){
				System.out.print("El valor introducido no es un número. ");
				salir=false;
				keyb.nextLine();
			}
		}while(!salir);
		return valor;
	}
}
