package practica1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public class Ejercicio2 {
	
	public static Cafe creaCafe(String nombre,int proveedor,float precio,int ventas,int total){
		Cafe cafe=new Cafe();
		cafe.setNombre(nombre);
		cafe.setPrecio(precio);
		cafe.setProveedorId(proveedor);
		cafe.setTotal(total);
		cafe.setVentas(ventas);
		return cafe;
	}
	
	public static XStream crearXStream(){
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("cafe", Cafe.class);
		xstream.aliasField("marca", Cafe.class, "nombre");
		xstream.omitField(Cafe.class, "proveedorId");
		return xstream;
	}
	
	public static void escribePersistanceStrategy(XStream xstream){
		PersistenceStrategy pstr=new FilePersistenceStrategy(
				new File("OtherResources/Ejercicio2Archivos"),xstream);
		Cafe cafe1=creaCafe("Nescafe",2336,(float)0.92,265,900);
		Cafe cafe2=creaCafe("Marcilla",1225,(float)1.20,122,950);
		XmlArrayList cafetitos=new XmlArrayList(pstr);
		cafetitos.add(cafe1);
		cafetitos.add(cafe2);
	}
	
	public static ArrayList <Cafe> leePersistanceStrategy(XStream xstream){
		PersistenceStrategy pstr=new FilePersistenceStrategy(
				new File("OtherResources/Ejercicio2Archivos"),xstream);
		XmlArrayList lista = new XmlArrayList(pstr);
		ArrayList <Cafe> cafes=new ArrayList();
		for(Iterator it = lista.iterator();it.hasNext();) {
			cafes.add((Cafe) it.next());
		}
		return cafes;
	}
	
	public static void muestraArrayLeido(ArrayList <Cafe> cafes){
		for(int i=0;i<cafes.size();i++){
			System.out.println(cafes.get(i).toString());
		}
	}
	
	public static void guardaToXML(XStream xstream){
		OutputStream os=null;
		ArrayList<Cafe> cafes=new ArrayList();
		cafes.add(creaCafe("Nescafe",2336,(float)0.92,265,900));
		cafes.add(creaCafe("Marcilla",1225,(float)1.20,122,950));
		for(int i=0;i<cafes.size();i++){
			try {
				os=Files.newOutputStream(
						Paths.get("OtherResources/Ejercicio2Archivos/conToXMLfromXML"+i+".xml"));
			} catch (IOException e) {
				System.out.println("FALLA");
			}
			if(os!=null){
				xstream.toXML(cafes.get(i), os);
			}
		}
	}
	
	public static ArrayList<Cafe> cargaFromXML(XStream xstream){
		InputStream is=null;
		ArrayList<Cafe> cafes=new ArrayList<Cafe>();
		Path path=Paths.get("OtherResources/Ejercicio2Archivos/conToXMLfromXML"+0+".xml");
		for(int i=0;Files.exists(path);i++){
			try {
				is=Files.newInputStream(path);
				path=Paths.get("OtherResources/Ejercicio2Archivos/conToXMLfromXML"+(i+1)+".xml");
			} catch (IOException e) {
				System.out.println("FALLA");
			}
			if(is!=null){
				cafes.add((Cafe)xstream.fromXML(is));
			}
		}
		return cafes;
		
	}
	
	public static void limpiarPrevios(XStream xstream){
		PersistenceStrategy pstr=new FilePersistenceStrategy(
				new File("OtherResources/Ejercicio2Archivos"),xstream);
		XmlArrayList lista = new XmlArrayList(pstr);
		for(Iterator it = lista.iterator();it.hasNext();) {
			it.next();
			it.remove();
		}
	}
	
	public static boolean eligeMetodo(){
		Scanner keyb=new Scanner(System.in);
		int valor=0;
		boolean persistance=true;
		do{
			System.out.println(
				"Elige entre una de las dos metodologías:"
				+ "\n\t1. PersistanceStrategy\n\t2. Usando toXML/fromXML"
				+ " y OutputStream/InputStream");
			try{
				valor=keyb.nextInt();
				if(valor<1||valor>2){
					System.out.print("No es una opcion elegible. ");
				}else{
					if(valor==2){
						persistance=false;
					}
				}
			}catch (InputMismatchException e){
				System.out.print("No es un valor numerico. ");
			}
		}while(valor<1||valor>2);
		return persistance;
	}
	
	public static void main(String[] args) {
		ArrayList <Cafe> cafes=null;
		XStream xs=crearXStream();
		if(eligeMetodo()){
			limpiarPrevios(xs);//ESTE METODO BORRA LOS ARCHIVOS CREADOS
//PREVIAMENTE EN ANTERIORES EJECUCIONES, ES PARA NO GENERAR DEMASIADOS ARCHIVOS.
			escribePersistanceStrategy(xs);
			cafes=leePersistanceStrategy(xs);
		}else{
			guardaToXML(xs);
			cafes=cargaFromXML(xs);
		}
		if(cafes!=null){
			muestraArrayLeido(cafes);
		}
	}
}
