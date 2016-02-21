package Practica3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

public class serializadorAlumno {
	public static boolean serializarAlumno(String ruta,Alumno al){
		boolean correcto=true;
		try {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File(ruta)));
			out.writeObject(al);
			out.close();
		} catch (IOException e) {
			System.out.println("Error al guardar en ruta"+Paths.get(ruta).toAbsolutePath());
			correcto=false;
		}
		return correcto;
	}
	
	public static Alumno deserializarAlumno(String ruta){
		Alumno devuelve=null;
		try{
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File(ruta)));
			devuelve=(Alumno)in.readObject();
			in.close();
		}catch (IOException e){
			System.out.println("Error al cargar el alumno");
		} catch (ClassNotFoundException e) {
			System.out.println("En este fichero no se ha leido un alumno, fallo de conversion.");
		}
		return devuelve;
	}
}
