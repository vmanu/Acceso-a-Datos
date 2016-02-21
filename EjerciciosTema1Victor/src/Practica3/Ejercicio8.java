package Practica3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Ejercicio8 {
	
	public static void generateXML(Empresa empresa){
		try {
			File file = new File("empresa.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Empresa.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(new JAXBElement(new QName("", "Empresa"), Empresa.class, empresa), file);
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("uno");
		}	
	}
	
	public static Empresa devuelveXML(){
		Empresa empresa=null;
		try {
			File file = new File("empresa.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Empresa.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Source source=new StreamSource(file);
			JAXBElement<Empresa> read=jaxbUnmarshaller.unmarshal(source,Empresa.class);
			empresa= read.getValue();
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("dos");
		}
		return empresa;
	}
	
	public static Empresa getEmpresa(){
		ArrayList<Empleado> empleados= new ArrayList();
		empleados.add(new Empleado());
		empleados.add(new Empleado());
		empleados.add(new Empleado());
		empleados.add(new Empleado());
		ArrayList <String> nombresEmpleados= new ArrayList(){{ add("Carlos"); add("Marco");add("Maria");add("Tamara");}};
		ArrayList <String> titulosEmpleados= new ArrayList(){{ add("Capataz"); add("Jefe");add("Secret");add("Capataz");}};
		ArrayList <Integer> numEmpleados= new ArrayList(){{ add(2822); add(2820);add(2860);add(2830);}};
		ArrayList <Date> dateEmpleados= new ArrayList(){{ add(new Date(98, 2, 12)); add(new Date(104, 8, 31));add(new Date(106, 11, 2));add(new Date(111, 10, 5));}};
		ArrayList <Boolean> activoEmpleado=new ArrayList(){{ add(false); add(true);add(true);add(true);}};
		for(int i=0;i<empleados.size();i++){
			empleados.get(i).setId((int)(Math.random()*99999999));
			empleados.get(i).setFechaAlta(dateEmpleados.get(i));
			empleados.get(i).setActivo(activoEmpleado.get(i));
			empleados.get(i).setNombre(nombresEmpleados.get(i));
			empleados.get(i).setNumeroEmpl(numEmpleados.get(i));
			empleados.get(i).setTitulo(titulosEmpleados.get(i));
		}
		Empresa empresa=new Empresa();
		empresa.setDireccion("Calle Marmota que bota");
		empresa.setIdEmpresa(123);
		empresa.setNombreEmpresa("Mangosta");
		empresa.setNumEmpleados(3);
		empresa.setEmpleados(empleados);
		return empresa;
	}
	
	public static void main(String[] args) {
		generateXML(getEmpresa());
		Empresa empresa=devuelveXML();
		if(empresa!=null){
			System.out.println(empresa.toString());
		}else{
			System.out.println("Empresa vacia");
		}
	}
}
