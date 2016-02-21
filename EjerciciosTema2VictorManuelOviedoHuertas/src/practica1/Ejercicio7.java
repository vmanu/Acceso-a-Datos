package practica1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream.GetField;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public class Ejercicio7 {

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
	
	public static float obtenFloat(int min,String pregunta,String fallo){
		float valor=0;
		Scanner keyb=new Scanner(System.in);
		boolean sal;
		do{
			sal=true;
			System.out.println(pregunta);
			try{
				valor=keyb.nextFloat();
				if(valor<=min){
					System.out.print(fallo+". ");
					sal=false;
					keyb.nextLine();
				}
			}catch(InputMismatchException e){
				System.out.print("El valor introducido no es un número o no cumple con la estructura Float. ");
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
	
	public static boolean obtenNacion (String pais){
		return pais.equalsIgnoreCase("España");
	}
	
	public static Proveedor crearProveedor(int identificador, String nombre, String calle,
			String ciudad, String pais, int cp){
		Proveedor proveedor=new Proveedor();
		proveedor.setCalle(calle);
		proveedor.setCiudad(ciudad);
		proveedor.setCp(cp);
		proveedor.setEsNacional(obtenNacion(pais));
		proveedor.setIdentificador(identificador);
		proveedor.setNombre(nombre);
		proveedor.setPais(pais);
		proveedor.setCafes(crearArrayCafes());
		return proveedor;
	}
	
	public static ArrayList<Cafe6> crearArrayCafes(){
		ArrayList<Cafe6> cafes=new ArrayList();
		int size=obtenNumero(1,50000000,"¿Cuantos cafés va a contener este proveedor?",
				"No ha introducido un numero válido de cafés a introducir (entre 1 y 50000000)");
		for(int i = 0;i<size;i++){
			cafes.add(crearCafe());
		}
		return cafes;
	}
	
	public static Cafe6 crearCafe(){
		Cafe6 cafe=new Cafe6();
		cafe.setNombre(obtenString("Nombre del café"));
		cafe.setPrecio(obtenFloat(0, "Precio del café",
				"El precio del cafe debe ser mayor que cero, a partir de 0.01 inclusive"));
		cafe.setVentas(obtenNumero(0, 50000000, "Indique el numero de ventas del producto", 
				"El numero introducido debe ir entre 0 y 50000000"));//int
		cafe.setTotal(obtenNumero(cafe.getVentas(), 50000000,
				"Indique el numero total de producto (incluyendo lo vendido)",
				"El numero introducido debe ir entre "+cafe.getVentas()+" y 50000000"));//int
		return cafe;
	}
	
	public static void limpiarPrevios(XStream xstream){
		PersistenceStrategy pstr=new FilePersistenceStrategy(
				new File("OtherResources/Ejercicio7Archivos"),xstream);
		XmlArrayList lista = new XmlArrayList(pstr);
		for(Iterator it = lista.iterator();it.hasNext();) {
			it.next();
			it.remove();
		}
	}
	
	public static void guardarPersistance(Proveedor proveedor,XStream xstream){
		limpiarPrevios(xstream);
		PersistenceStrategy pstr=new FilePersistenceStrategy(
				new File("OtherResources/Ejercicio7Archivos"),xstream);
		XmlArrayList provee=new XmlArrayList(pstr);
		provee.add(proveedor);
	}
	
	public static void cargarPersistance(XStream xstream){
		PersistenceStrategy pstr=new FilePersistenceStrategy(
				new File("OtherResources/Ejercicio7Archivos"),xstream);
		XmlArrayList lista = new XmlArrayList(pstr);
		ArrayList <Proveedor> proveedores=new ArrayList();
		for(Iterator it = lista.iterator();it.hasNext();) {
			proveedores.add((Proveedor) it.next());
		}
		if(proveedores.size()==1){
			System.out.println(proveedores.get(0).toString());
		}else{
			System.out.println("No se recoge un unico proveedor");
		}
	}
	
	public static XStream generarXStream(){
		XStream xstream = new XStream(new DomDriver("UTF-8"));
		xstream.alias("proveedor", Proveedor.class);
		xstream.useAttributeFor(Proveedor.class,"identificador");
		xstream.useAttributeFor(Proveedor.class,"nombre");
		xstream.aliasAttribute("cif", "identificador");
		xstream.aliasAttribute("empresa", "nombre");
		xstream.registerConverter(new BooleanConverter("Nacional","Importacion",false));
		xstream.alias("cafe", Cafe6.class);
		xstream.omitField(Cafe6.class, "total");
		return xstream;
	}
	
	public static void guardaToXML(Proveedor proveedor,XStream xstream){
		OutputStream os=null;
		try {
			os=Files.newOutputStream(
					Paths.get("OtherResources/Ejercicio7Archivos/conToXMLfromXML.xml"));
		} catch (IOException e) {
			System.out.println("FALLA");
		}
		if(os!=null){
			xstream.toXML(proveedor, os);
		}
	}
	
	public static void cargaFromXML(XStream xstream){
		InputStream is=null;
		Proveedor proveedor=null;
		try {
			is=Files.newInputStream(Paths.get("OtherResources/Ejercicio7Archivos/conToXMLfromXML.xml"));
		} catch (IOException e) {
			System.out.println("FALLA");
		}
		if(is!=null){
			proveedor=(Proveedor)xstream.fromXML(is);
			System.out.println(proveedor.toString());
		}
		
	}
	
	public static boolean eligeMetodo(){
		int valor=obtenNumero(1, 2, "Elige entre una de las dos metodologías:"
				+ "\n\t1. PersistanceStrategy\n\t2. Usando toXML/fromXML"
				+ " y OutputStream/InputStream",
				"No es una opcion elegible");
		return !(valor%2==0);
	}
	
	public static void main(String[] args) {
		XStream xstream=generarXStream();
		Proveedor proveedor=crearProveedor(obtenNumero(0, 9999, "Introduzca el id del proveedor", "El numero ha de ir entre 0 y 9999"),
				obtenString("Indique el nombre del proveedor"), 
				obtenString("Indique la calle donde se encuentra el proveedor"), 
				obtenString("Indique la ciudad donde se situa el proveedor"), 
				obtenString("Indique el pais donde se encuentra el proveedor"), 
				obtenNumero(1, 99999, "Indique el cp del proveedor", "El cp sólo puede ir de 1 a 99999"));
		if(eligeMetodo()){
			guardarPersistance(proveedor,xstream);
			cargarPersistance(xstream);
		}else{
			guardaToXML(proveedor, xstream);
			cargaFromXML(xstream);
		}
	}

}
