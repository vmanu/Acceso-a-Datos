package GUI;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Profesor;

import org.hibernate.Query;
import org.hibernate.Session;

import utilities.Utilidades;

public class Prueba {
//EJERCICIO 1
	/**
	 * Navegar por una propiedad
	 */
	public void navegarPropiedad(Session session) {

		System.out.println("----------- Navegar por una propiedad -----------");
        String ape1 = (String) session.getNamedQuery("ejercicio1NavegarPropiedad").uniqueResult();
        System.out.println("Ape1="+ape1);
	}

	/**
	 * Navegar por varias propiedades enlazadas
	 */
	public void navegarPropiedadesEnlazadas(Session session) {

		System.out.println("----------- Navegar por varias propiedades enlazadas-----------");
        Query query = session.getNamedQuery("ejercicio1NavegarPropiedadesEnlazadas");
        List<Object[]> listDatos = (List<Object[]>) query.list();
        for (Object[] datos : listDatos) {
            System.out.println("El profesor " + datos[0] + " vive en " + datos[1]);
        }
	}

	/**
	 * Función SIZE en colecciones
	 */
	public void sizeColeccion(Session session) {
		System.out.println("----------- Función SIZE en colecciones -----------");
        Query query = session.getNamedQuery("ejercicio1SizeColecciones");
        List<Object[]> listDatos = (List<Object[]>) query.list();
        for (Object[] datos : listDatos) {
        	System.out.println("El profesor " + datos[0] + " tiene  " + datos[1]+ " direcciones de correo electrónico");
        }
	}

	/**
	 * Función IS EMPTY en colecciones
	 */
	public void isEmptyColecciones(Session session) {
		System.out.println("----------- Función IS EMPTY en colecciones -----------");
	    Query query = session.getNamedQuery("ejercicio1EmptyColecciones");
	    List<Object> listDatos = (List<Object>) query.list();
	    for (Object datos : listDatos) {
	    	System.out.println("El profesor " + datos + " no tiene  direcciones de correo electrónico");
	    }
	}
//EJERCICIO 2
	public void ejercicio2_1(Session session) {
		System.out.println("----------- Ejercicio 2.1 -----------");
		Query query = session.getNamedQuery("ejercicio2.1");
		List<Object[]> listDatos = (List<Object[]>) query.list();
	    for (Object[] datos : listDatos) {
	    	System.out.println("El correo " + datos[0] + " es provisto por "+datos[1]);
	    }
	}
	
	public void ejercicio2_2(Session session) {
		System.out.println("----------- Ejercicio 2.2 -----------");
		Query query = session.getNamedQuery("ejercicio2.2");
		List<Object[]> listDatos = (List<Object[]>) query.list();
	    for (Object[] datos : listDatos) {
	    	System.out.println("El proveedor " + datos[0] + " tiene "+datos[1]+" correos");
	    }
	}
	
	public void ejercicio2_3(Session session) {
		System.out.println("----------- Ejercicio 2.3 -----------");
		Query query = session.getNamedQuery("ejercicio2.3");
		List<Object[]> listDatos = (List<Object[]>) query.list();
	    for (Object[] datos : listDatos) {
	    	System.out.println("El proveedor " + datos[0] + " tiene "+datos[1]+" correos");
	    }
	}
	
	public void ejercicio2_4(Session session,int id) {
		System.out.println("----------- Ejercicio 2.4 -----------");
		Query query = session.getNamedQuery("ejercicio2.4").setParameter("id",id);
		int datos = (int) query.uniqueResult();
    	System.out.println("El profesor con id= " + id + " tiene "+datos+" correos");	    
	}
	
	public void ejercicio2_5(Session session,int id) {
		System.out.println("----------- Ejercicio 2.5 -----------");
		Query query = session.getNamedQuery("ejercicio2.5").setParameter("id",id);
		Object[] datos = (Object[]) query.uniqueResult();
    	System.out.println("El profesor con id= " + id + ", ape1= "+datos[0]+", calle= "+datos[1]+",\n\tprovincia= "+datos[2]+", municipio="+datos[3]);	
	}
	
	public void ejercicio2_6(Session session) {
		System.out.println("----------- Ejercicio 2.6 -----------");
		Query query = session.getNamedQuery("ejercicio2.6");
		List<String> listDatos = (List<String>) query.list();
	    for (String datos : listDatos) {
	    	System.out.println(datos);
	    }
	}
	
	public void ejercicio2_7(Session session) {
		System.out.println("----------- Ejercicio 2.7 -----------");
		Query query = session.getNamedQuery("ejercicio2.7");
		Object[] listDatos = (Object[]) query.uniqueResult();
    	System.out.println("Promedio= " + listDatos[0] + ", Maximo= "+listDatos[1]+", Minimo= "+listDatos[2]);
	    
	}
	

	public static void main(String[] args) {
		String pregunta_id="Introduzca numero id del profesor";
		Session session = Utilidades.getSessionFactory().openSession();
		Prueba prueba = new Prueba();
		
		//EJERCICIO 1
		prueba.navegarPropiedad(session);
		prueba.navegarPropiedadesEnlazadas(session);
		prueba.sizeColeccion(session);
		prueba.isEmptyColecciones(session);		      

		//EJERCICIO 2
		prueba.ejercicio2_1(session);
		prueba.ejercicio2_2(session);
		prueba.ejercicio2_3(session);
		prueba.ejercicio2_4(session,getNum(pregunta_id));
		prueba.ejercicio2_5(session,getNum(pregunta_id));
		prueba.ejercicio2_6(session);
		prueba.ejercicio2_7(session);
		Utilidades.getSessionFactory().close();
	}

	
	public static int getNum(String pregunta){
		Scanner keyb=new Scanner(System.in);
		int num=0;
		do{
			System.out.println(pregunta);
			try{
				num=keyb.nextInt();
				if(num<=0){
					System.out.print("Numero menor o igual a 0. ");
				}
			}catch(InputMismatchException e){
				System.out.print("No es numerico. ");
			}
		}while(num<=0);
		return num;
	}
}
