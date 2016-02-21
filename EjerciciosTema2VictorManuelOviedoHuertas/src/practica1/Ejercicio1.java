package practica1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Ejercicio1 {

	public static Cafe creaCafe(String nombre,int proveedor,float precio,int ventas,int total){
		Cafe cafe=new Cafe();
		cafe.setNombre(nombre);
		cafe.setPrecio(precio);
		cafe.setProveedorId(proveedor);
		cafe.setTotal(total);
		cafe.setVentas(ventas);
		return cafe;
	}
	
	public static XStream creaXStream(){
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("cafe", Cafe.class);
		xstream.aliasField("marca", Cafe.class, "nombre");
		xstream.omitField(Cafe.class, "proveedorId");
		return xstream;
	}
	
	public static String escribeXML(Cafe cafe, XStream xstream){
		return xstream.toXML(cafe);
	}
	
	public static void imprimeXML(String xml, XStream xstream){
		Cafe cafe=(Cafe)xstream.fromXML(xml);
		System.out.println(cafe.toString());		
	}
	
	public static void main(String[] args) {
		XStream xs=creaXStream();
		String xmlCafe1=escribeXML(creaCafe("Nescafe",2336,(float)0.92,265,900),xs);
		String xmlCafe2=escribeXML(creaCafe("Marcilla",1225,(float)1.20,122,950),xs);
		System.out.println(xmlCafe1);
		System.out.println(xmlCafe2);
		imprimeXML(xmlCafe1,xs);
		imprimeXML(xmlCafe2,xs);
	}
}
