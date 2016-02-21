package practica1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Ejercicio10 {

	public static Cafe6 crearCafe(){
		Cafe6 cafe=new Cafe6();
		cafe.setNombre("Saimaza");
		cafe.setPrecio((float)12.42);
		cafe.setTotal(900);
		cafe.setVentas(298);
		return cafe;
	}
	
	public static String crearXStream(Cafe6 cafe){
		XStream xstream = new XStream(new DomDriver("UTF-8"));
		xstream.alias("cafe", Cafe6.class);
		xstream.registerConverter(new Cafe6Converter());
		return xstream.toXML(cafe);
	}
	
	public static void main(String[] args) {
		String xml=crearXStream(crearCafe());
		System.out.println(xml);
	}

}
