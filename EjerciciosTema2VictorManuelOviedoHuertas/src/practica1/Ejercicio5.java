package practica1;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;


public class Ejercicio5 {

	public static int num(int min,int max,String pregunta,String fallo){
		Scanner keyb=new Scanner(System.in);
		boolean sal;
		int valor=0;
		do{
			sal=true;
			System.out.println(pregunta);
			try{
				valor=keyb.nextInt();
				if(valor<min||valor>max){
					System.out.print(fallo+". ");
					sal=false;
					keyb.nextLine();
				}
			}catch(InputMismatchException e){
				System.out.print("El valor introducido no es un número. ");
				sal=false;
				keyb.nextLine();
			}
		}while(!sal);
		return valor;
	}
	
	public static String cadena(String pregunta){
		System.out.println(pregunta);
		return new Scanner(System.in).nextLine();
	}
	
	public static Aula creaAula(int tamano){
		int alumnos=num(1,tamano,
				"Indique el numero de alumnos que desea introducir ahora.",
				"No ha introducido un valor válido, min=1; max="+tamano);
		Aula aula=new Aula(tamano);
		for (int i=0;i<alumnos;i++){
			System.out.println("NUEVO ALUMNO:");
			String nombre=cadena("Introduzca el nombre del alumno");
			String apellido=cadena("Introduzca el apellido del alumno");
			int anno=num(1970,2015,"Indique el año de nacimiento del alumno",
					"No ha introducido un valor válido (1970-2015");
			String domicilio=cadena("Introduzca la calle donde vive el alumno");
			int numero=num(1,500,"Indique el numero de la dirección del alumno",
					"No ha introducido un valor válido (1-500)");
			Alumno al=new Alumno(nombre,apellido,anno,domicilio,numero);
			aula.add(al);
		}
		return aula;
	}
	
	public static void escribeXML(Aula aula,XStream xstream){
		PersistenceStrategy pstr=new FilePersistenceStrategy(
				new File("OtherResources/Ejercicio5Archivos"),xstream);
		XmlArrayList aulas=new XmlArrayList(pstr);
		aulas.add(aula);
	}
	
	public static void imprimeXML(XStream xstream){
		PersistenceStrategy pstr=new FilePersistenceStrategy(
				new File("OtherResources/Ejercicio5Archivos"),xstream);
		XmlArrayList lista = new XmlArrayList(pstr);
		ArrayList <Aula> aula=new ArrayList();
		for(Iterator it = lista.iterator();it.hasNext();) {
			aula.add((Aula) it.next());
		}
		for(int i=0;i<aula.size();i++){
			aula.get(i).informacionAlumnos();
		}
	}
	
	public static XStream creaXStream(){
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("aula", Aula.class);
		xstream.addImplicitCollection(Aula.class, "alumnos");
		xstream.alias("alumno", Alumno.class);
		xstream.aliasField("fecha", Alumno.class, "annoNacimiento");
		xstream.alias("domicilio", Direccion.class);
		xstream.omitField(Aula.class, "tamano");
		xstream.omitField(Aula.class, "numalumnos");
		return xstream;
	}

	public static void main(String[] args) {
		Aula aulaAntes=creaAula(num(1, 30,
				"Indique el tamaño del aula (el máximo numero de alumnos a admitir)",
				"No ha introducido un valor dentro del rango (1 - 30)"));
		XStream xs=creaXStream();		
		escribeXML(aulaAntes,xs);
		imprimeXML(xs);
	}
}
