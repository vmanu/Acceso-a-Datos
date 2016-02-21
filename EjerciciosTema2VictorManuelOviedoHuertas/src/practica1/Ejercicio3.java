package practica1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Ejercicio3 {
	
	public static Cafe creaCafe(String nombre,int proveedor,float precio,int ventas,int total){
		Cafe cafe=new Cafe();
		cafe.setNombre(nombre);
		cafe.setPrecio(precio);
		cafe.setProveedorId(proveedor);
		cafe.setTotal(total);
		cafe.setVentas(ventas);
		return cafe;
	}
	
	public static String escribeXML(Cafe cafe, XStream xstream){
		return xstream.toXML(cafe);
	}
	
	public static void imprimeXML(String xml, XStream xstream){
		Cafe cafe=(Cafe)xstream.fromXML(xml);
		System.out.println(cafe.toString());		
	}
	
	public static XStream crearXStream(){
		XStream xstream = new XStream(new DomDriver());
		xstream.aliasPackage("cafes.com", "practica1");
		return xstream;
	}
	
	public static void main(String[] args) {
		XStream xs=crearXStream();
		String xmlCafe1=escribeXML(creaCafe("Nescafe",2336,(float)0.92,265,900),xs);
		System.out.println(xmlCafe1);
		imprimeXML(xmlCafe1,xs);
	}

}
