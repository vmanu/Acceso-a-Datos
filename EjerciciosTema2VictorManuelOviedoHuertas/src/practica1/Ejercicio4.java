package practica1;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Ejercicio4 {
	
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
				System.out.print("El valor introducido no es un n�mero. ");
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
				"No ha introducido un valor v�lido, min=1; max="+tamano);
		Aula aula=new Aula(tamano);
		for (int i=0;i<alumnos;i++){
			System.out.println("NUEVO ALUMNO:");
			String nombre=cadena("Introduzca el nombre del alumno");
			String apellido=cadena("Introduzca el apellido del alumno");
			int anno=num(1970,2015,"Indique el a�o de nacimiento del alumno",
					"No ha introducido un valor v�lido (1970-2015)");
			String domicilio=cadena("Introduzca la calle donde vive el alumno");
			int numero=num(1,500,"Indique el numero de la direcci�n del alumno",
					"No ha introducido un valor v�lido (1-500)");
			Alumno al=new Alumno(nombre,apellido,anno,domicilio,numero);
			aula.add(al);
		}
		return aula;
	}
	
	public static String escribeXML(Aula aula,XStream xstream){
		return xstream.toXML(aula);
	}
	
	public static void imprimeXML(String xml,XStream xstream){
		Aula aula=(Aula)xstream.fromXML(xml);
		aula.informacionAlumnos();		
	}
	
	public static XStream crearXStream(){
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("aula", Aula.class);
		xstream.addImplicitCollection(Aula.class, "alumnos");
		xstream.alias("alumno", Alumno.class);
		xstream.aliasField("fecha", Alumno.class, "annoNacimiento");
		xstream.aliasField("domicilio", Alumno.class,"direccion");
		xstream.omitField(Aula.class, "tamano");
		xstream.omitField(Aula.class, "numalumnos");
		return xstream;
	}
	
	/*
	 * para que pinte bien y no salga esta anotaci�n:
	 * <outer-class reference="../.."/> 
	 * declaro la clase Direccion como clase est�tica
	 * siendo �ste el �nico cambio que se ejecuta sobre la
	 * clase Alumno8*/
	public static void main(String[] args) {
		XStream xs=crearXStream();
		String xmlAula=escribeXML(creaAula(num(1, 30,
				"Indique el tama�o del aula (el m�ximo numero de alumnos a admitir)",
				"No ha introducido un valor dentro del rango (1 - 30)")),xs);
		System.out.println(xmlAula);
		imprimeXML(xmlAula,xs);
	}
}
