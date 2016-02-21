package practica1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class Ejercicio11 {

	public static Cafe6 crearCafe(){
		Cafe6 cafe=new Cafe6();
		cafe.setNombre("Saimaza");
		cafe.setPrecio((float)12.42);
		cafe.setTotal(900);
		cafe.setVentas(298);
		return cafe;
	}
	
	public static String crearXStream(Cafe6 cafe){
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("cafe", Cafe6.class);
		return xstream.toXML(cafe);
	}
	
	public static void main(String[] args) {
		Cafe6 cafe=crearCafe();
		System.out.println(crearXStream(cafe));
	}

}
