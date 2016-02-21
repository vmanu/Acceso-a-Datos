package GUI;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.AsistenciaMedica;
import model.Seguro;

import org.hibernate.Query;
import org.hibernate.Session;

import utilities.Utilidades;

public class Prueba {

	public void ejercicio3_1(Session session) {
		System.out.println("----------- Ejercicio 3.1 -----------");
		Query query = session.getNamedQuery("ejercicio3.1");
		List<Seguro> listDatos = (List<Seguro>) query.list();
	    for (Seguro datos : listDatos) {
	    	System.out.println(datos);
	    }
	}
	
	public void ejercicio3_2(Session session) {
		System.out.println("----------- Ejercicio 3.2 -----------");
		Query query = session.getNamedQuery("ejercicio3.2");
		List<Object[]> listDatos = (List<Object[]>) query.list();
	    for (Object[] datos : listDatos) {
	    	System.out.println("nombre="+datos[1]+", NIF=["+datos[0]+"]");
	    }
	}
	
	public void ejercicio3_3(Session session) {
		System.out.println("----------- Ejercicio 3.3 -----------");
		Query query = session.getNamedQuery("ejercicio3.3").setParameter("nombre", "Maria").setParameter("ape1", "Garcia").setParameter("ape2", "Lozano");
		Object datos = (Object) query.uniqueResult();
		System.out.println("Maria Garcia Lozano tiene un DNI=" + datos);
	    
	}
	
	public void ejercicio3_4(Session session,BigDecimal d1) {
		System.out.println("----------- Ejercicio 3.4 -----------");
		Query query = session.getNamedQuery("ejercicio3.4").setBigDecimal("dec1", d1);
		List<Object> datos = (List<Object>) query.list();
    	for(Object dato:datos){
    		System.out.println("id= " + dato);	    
    	}
	}
	
	public void ejercicio3_5(Session session,BigDecimal d1,BigDecimal d2) {
		System.out.println("----------- Ejercicio 3.5 -----------");
		Query query = session.getNamedQuery("ejercicio3.5").setBigDecimal("dec1", d1).setBigDecimal("dec2", d2);
		List<Object> datos = (List<Object>) query.list();
    	for(Object dato:datos){
    		System.out.println("id= " + dato);	    
    	}	
	}
	
	public void ejercicio3_6(Session session) {
		System.out.println("----------- Ejercicio 3.6 -----------");
		Query query = session.getNamedQuery("ejercicio3.6");
		Object datos = (Object) query.uniqueResult();
	    System.out.println("El total de importe es: "+datos);
	}
	
	public void ejercicio3_7(Session session) {
		System.out.println("----------- Ejercicio 3.7 -----------");
		Query query = session.getNamedQuery("ejercicio3.7");
		Object datos = (Object) query.uniqueResult();
    	System.out.println("El promedio de importe es: "+datos);
	    
	}
	
	public void ejercicio3_8(Session session) {
		System.out.println("----------- Ejercicio 3.8 -----------");
		Query query = session.getNamedQuery("ejercicio3.8");
		Object datos = (Object) query.uniqueResult();
    	System.out.println("Hay "+datos+" seguros");	    
	}
	
	public void ejercicio3_9(Session session) {
		System.out.println("----------- Ejercicio 3.9 -----------");
		Query query = session.getNamedQuery("ejercicio3.9");
		List<Seguro> listDatos = (List<Seguro>) query.list();
		for (Seguro datos : listDatos) {
	    	System.out.println("El nombre="+datos.getNombre()+", dni="+datos.getNif().getNif()+", numero de asistencias="+datos.getAsistenciasMedicas().size());
	    }	
	}
	
	public void ejercicio3_10(Session session) {
		System.out.println("----------- Ejercicio 3.10 -----------");
		Query query = session.getNamedQuery("ejercicio3.10");
		List<Object> listDatos = (List<Object>) query.list();
	    for (Object datos : listDatos) {
	    	System.out.println(datos);
	    }
	}
	
	public void ejercicio3_11(Session session) {
		System.out.println("----------- Ejercicio 3.11 -----------");
		Query query = session.getNamedQuery("ejercicio3.1");
		List<Seguro> listDatos = (List<Seguro>) query.list();
    	for(Seguro data:listDatos){
    		for(AsistenciaMedica a:data.getAsistenciasMedicas())
    		System.out.println("id="+a.getIdAsistenciaMedica());
    		
    	}
	    
	}

	public static void main(String[] args) {
		String pregunta1="Introduzca valor minimo del importe";
		String pregunta2="Introduzca valor máximo del importe";
		Session session = Utilidades.getSessionFactory().openSession();
		Prueba prueba = new Prueba();
		prueba.ejercicio3_1(session);
		prueba.ejercicio3_2(session);
		prueba.ejercicio3_3(session);
		prueba.ejercicio3_4(session,getBigDecimal(pregunta1));
		prueba.ejercicio3_5(session,getBigDecimal(pregunta1),getBigDecimal(pregunta2));
		prueba.ejercicio3_6(session);
		prueba.ejercicio3_7(session);
		prueba.ejercicio3_8(session);
		prueba.ejercicio3_9(session);
		prueba.ejercicio3_10(session);
		prueba.ejercicio3_11(session);
		Utilidades.getSessionFactory().close();
	}

	
	public static BigDecimal getBigDecimal(String pregunta){
		Scanner keyb=new Scanner(System.in);
		double num=0;
		do{
			System.out.println(pregunta);
			try{
				num=keyb.nextDouble();
				if(num<=0){
					System.out.print("Numero menor o igual a 0. ");
				}
			}catch(InputMismatchException e){
				System.out.print("No es numerico o esta mal formado. ");
			}
		}while(num<=0);
		return BigDecimal.valueOf(num);
	}
}
