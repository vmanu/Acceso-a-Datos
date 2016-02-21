package com.hibernate.main;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.hibernate.Session;

import com.hibernate.modelo.Seguro;
import com.hibernate.modelo.Seguro.*;
import com.hibernate.utilidades.Utilidades;
import com.hibernate.utilidades.Funcionalidades;

public class Prueba {
	private static final int sal=5;
	
	public static void main(String[] args) {
		Seguro escrito = new Seguro();
		escrito.setNif("44112233E");
		escrito.setNombre("Patrick");
		escrito.setApe1("Jane");
		escrito.setApe2("Lubeck");
		escrito.setCasado(true);
		escrito.setEdad(28);
		escrito.setNumHijos(1);
		escrito.setSexo(TipoSexo.HOMBRE);
		escrito.setTipo(TipoSeguro.COCHE);
		escrito.setFechaCreacion(new Date());
		escrito.setFechaNacimiento(new Date(87,10,8));
		escrito.setHoraNacimiento(new Date(escrito.getFechaNacimiento().getTime()+500000));
		escrito.setClaves(new char[]{'a','b'});
		escrito.setComentarios("Hola, soy un tio majo");
		
		Seguro leido=null;
		Session session=null;
		int opcion;
		try{
			session = Utilidades.getSessionFactory().openSession();
			do{
				opcion=getOcpion();
				switch(opcion){
					case 1:
						Funcionalidades.darAlta(session,escrito);
						break;
					case 2:
						leido=Funcionalidades.getSeguro(session,getIdVer());
						System.out.println(leido.toString());
						break;
					case 3:
						//leido.setApe2("Watson");
						leido.setComentarios("Hola, soy un tio majo");
						Funcionalidades.updateSeguro(session, leido);
						break;
					case 4:
						Funcionalidades.deleteSeguro(session, leido);
						System.out.println("Borrado Correctamente");
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

	private static int getIdVer(){
		Scanner keyb=new Scanner(System.in);
		boolean salir;
		int valor=0;
		do{
			salir=true;
			System.out.println("Introduce id del cliente a mostrar (Se supone que lo sabes)");
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
	
	private static int getOcpion() {
		Scanner keyb=new Scanner(System.in);
		boolean salir;
		int valor=0;
		do{
			salir=true;
			System.out.println("Introduce una de las siguientes opciones:\n\t1.Dar Alta\n\t2.Mostrar (se usara el objeto a mostrar para modificar y eliminar, como un selector)\n\t3.Modificar\n\t4.Dar Baja"+"\n\t"+sal+".Salir");
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
