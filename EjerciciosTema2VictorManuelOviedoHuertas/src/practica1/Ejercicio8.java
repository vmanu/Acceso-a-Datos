package practica1;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TimeZone;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Ejercicio8 {

	public static int obtenNumero(int min,int max,String pregunta,String fallo){
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
	
	public static String obtenString(String pregunta){
		System.out.println(pregunta);
		return new Scanner(System.in).nextLine();
	}
	
	public static Date obtenDate(String cadena){
		int year=obtenNumero(1970,2015,"Indique el año de "+cadena,
					"No ha introducido un valor válido (1970-2015)");
		year-=1900;//Esto compensa la suma que hace el date de 1900 años
		int month=obtenNumero(1,12,"Indique el mes de "+cadena,
				"No ha introducido un valor válido (1-12)");
		int day=obtenNumero(1,31,"Indique el dia de "+cadena,
				"No ha introducido un valor válido (1-31)");
		Date date=new Date(year,month,day);
		return date;
	}
	
	public static Aula8 creaAula(int tamano){
		int alumnos=obtenNumero(1,tamano,
				"Indique el numero de alumnos que desea introducir ahora.",
				"No ha introducido un valor válido, min=1; max="+tamano);
		Aula8 aula8=new Aula8(tamano);
		aula8.setFechaCreacion(obtenDate("creacion del aula"));
		for (int i=0;i<alumnos;i++){
			System.out.println("NUEVO ALUMNO:");
			String nombre=obtenString("Introduzca el nombre del alumno");
			String apellido=obtenString("Introduzca el apellido del alumno");
			Date anno=obtenDate("nacimiento del alumno");
			String domicilio=obtenString("Introduzca la calle donde vive el alumno");
			int numero=obtenNumero(1,500,"Indique el numero de la dirección del alumno",
					"No ha introducido un valor válido (1-500)");
			Alumno8 al=new Alumno8(nombre, apellido, anno, domicilio, numero);
			aula8.add(al);
		}
		return aula8;
	}
	
	public static XStream crearXStream(){
		XStream xstream = new XStream(new DomDriver("UTF-8"));
		xstream.alias("aula", Aula8.class);
		xstream.addImplicitCollection(Aula8.class, "alumnos");
		xstream.alias("alumno", Alumno8.class);
		xstream.aliasField("aniversario", Alumno8.class, "anoNacimiento");
		xstream.aliasField("domicilio", Alumno8.class, "direccion");
		xstream.aliasField("fecha", Aula8.class, "fechaCreacion");
		xstream.registerLocalConverter(Alumno8.class,"anoNacimiento",
				new DateConverter("dd/MM/yyyy",new String[] {}));
		xstream.registerLocalConverter(Aula8.class,"fechaCreacion",
				new DateConverter("yyyy",new String[] {}));
		return xstream;
	}
	
	public static String guardarXML(Aula8 aula8,XStream xstream){
		return xstream.toXML(aula8);
	}
	
	public static void leerXML(String xml,XStream xstream){
		Aula8 aula8=(Aula8)xstream.fromXML(xml);
		System.out.println(aula8.toString());
	}
	
	public static void main(String[] args) {
		XStream xstream=crearXStream();
		Aula8 miAula=creaAula(obtenNumero(1, 30,
				"Indique el tamaño del aula (el máximo numero de alumnos a admitir)",
				"No ha introducido un valor dentro del rango (1 - 30)"));
		String xml=guardarXML(miAula,xstream);
		System.out.println(xml);
		leerXML(xml,xstream);
	}

}
