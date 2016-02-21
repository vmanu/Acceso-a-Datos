package practica1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Ejercicio12 {
	
	public static Cafe6 crearCafe(){
		Cafe6 cafe=new Cafe6();
		cafe.setNombre("Saimaza");
		cafe.setPrecio((float)12.42);
		cafe.setTotal(900);
		cafe.setVentas(298);
		return cafe;
	}
	
	public static XStream crearXStream(){
		XStream xstream = new XStream(new DomDriver("UTF-8"));
		xstream.alias("cafe", Cafe6.class);
		return xstream;
	}
	
	public static String guardarXML(Cafe6 cafe,XStream xstream,Path file){
		try{
			OutputStream os=Files.newOutputStream(file);
			ObjectOutputStream oos=xstream.createObjectOutputStream(os);
			oos.writeObject(cafe);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xstream.toXML(cafe);
	}
	
	public static void leerXML(XStream xstream,Path file){
		try{
			InputStream is=Files.newInputStream(file);
			ObjectInputStream ois=xstream.createObjectInputStream(is);
			Cafe6 cafe=(Cafe6)ois.readObject();
			System.out.println(cafe.toString());
			ois.close();
			
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		XStream xs=crearXStream();
		Path path=Paths.get("OtherResources/Ejercicio12Archivos/ejercicio12.xml");
		guardarXML(crearCafe(), xs, path);
		leerXML(xs,path);
	}

}
