package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.modelo.Autor;
import com.hibernate.utilidades.Utilidades;

public class Prueba {
	public static void main(String[] args) {
		Autor emp = new Autor();
		Autor empR;
		emp.setNombre("Patrick");
		emp.setApellidos("Jane");
		emp.setFecha(new Date());
		emp.setPublicacion(true);

		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		
		// abrimos una transacción
		session.beginTransaction();
		// Guardamos el objeto en la sesión
		session.save(emp);
		// Commit de la transacción: sino no se hace persistente en BD, sólo actualiza el objeto
		session.getTransaction().commit();

		System.out.println("Autor ID=" + emp.getId());
				
		//Recuperamos un objeto cuyo identificador conocemos
		//session.beginTransaction();
		empR=(Autor)session.load(Autor.class,  emp.getId());
		//session.getTransaction().commit();
		System.out.println("Autor=" +empR.getId()+":"+ empR.getNombre()+":"+empR.getFecha());		

		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
