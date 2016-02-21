package com.hibernate.utilidades;

import org.hibernate.LockMode;
import org.hibernate.Session;

import com.hibernate.modelo.Profesor;

public class Funcionalidades {
	
	public static void darAlta(Session session,Profesor profesor){
		session.beginTransaction();
		session.save(profesor);
		session.getTransaction().commit();
    }
	
	public static Profesor getProfesor(Session session,int idProfesor){
		session.beginTransaction();
		Profesor load=(Profesor)session.load(Profesor.class,idProfesor);
		session.getTransaction().commit();
		return load;
	}
}
