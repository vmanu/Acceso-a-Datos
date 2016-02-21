package actividades;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Actividad2_2 {

	public static String guardaLibro(){
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("ejemplar", Libro.class);
		xstream.aliasField("escritor", Libro.class, "autor");
		Libro libroguarda=new Libro(4545218,"Ponme a Prueba","Salvat",293,"Francisco Marcuerna",5);
		return xstream.toXML(libroguarda);
	}
	
	public static void leeLibro(String xml){
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("ejemplar", Libro.class);
		xstream.aliasField("escritor", Libro.class, "autor");
		Libro libroLee=(Libro)xstream.fromXML(xml);
		System.out.println(libroLee.toString());
	}
	
	public static void main(String[] args) {
		String xml=guardaLibro();
		System.out.println(xml);
		leeLibro(xml);
	}

}
