package actividades;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Actividad2_1 {

	public static void main(String[] args) {
		XStream xstream = new XStream(new DomDriver());
		Libro libroguarda=new Libro(4545218,"Ponme a Prueba","Salvat",293,"Francisco Marcuerna",5);
		String xml=xstream.toXML(libroguarda);
		System.out.println(xml);		
		Libro libroLee=(Libro)xstream.fromXML(xml);
		System.out.println(libroLee.toString());
	}

}
