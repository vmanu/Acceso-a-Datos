package com.hibernate.utilidades;

import org.hibernate.LockMode;
import org.hibernate.Session;

import com.hibernate.modelo.Seguro;

public class Funcionalidades {
	
	public static void darAlta(Session session,Seguro seguro){
		session.beginTransaction();
		session.save(seguro);
		session.getTransaction().commit();
    }
	
	public static Seguro getSeguro(Session session,int idSeguro){
		session.beginTransaction();
		Seguro load=(Seguro)session.load(Seguro.class,idSeguro);
		session.getTransaction().commit();
		return load;
	}
	
	public static void deleteSeguro(Session session,Seguro seguro){
		session.beginTransaction();
		session.delete(seguro);
		session.getTransaction().commit();
	}
	
	public static void updateSeguro(Session session,Seguro seguro){
		session.beginTransaction(); 		
		session.update(seguro);
		session.getTransaction().commit();
	}

	public static int dameId(Session session,Seguro escrito) {
		session.beginTransaction();
		Seguro load=(Seguro)session.load(Seguro.class,escrito.getIdSeguro());
		session.getTransaction().commit();
		return load.getIdSeguro();
	}
}
