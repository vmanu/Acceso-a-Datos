package Practica3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


public class Ejercicio7 {
	
	public static void generateDOM(ArrayList<Alumno7> arrayAlumnos){
		Document document=null;
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation().createDocument(null, "Alumnos", null);
		} catch (DOMException | ParserConfigurationException e1) {
			System.out.println("Fallo al generar el Document neceseario para el DOM");
		}
		if(document!=null){
			document.setXmlVersion("1.0");
			///////////////////////////////CREACION DE RAIZ
			Element raiz = document.getDocumentElement();
			for (int i = 0; i < arrayAlumnos.size(); i++) {
				Element itemNode = document.createElement("Alumno");
				//////////////////////////////NOMBRE
				Element keyNode1 = document.createElement("Nombre");
				Text nodeKeyValue1 = document.createTextNode(arrayAlumnos.get(i).getNombre());
				keyNode1.appendChild(nodeKeyValue1);
				//////////////////////////////APELLIDOS
				Element valueNode1 = document.createElement("Apellidos");
				Text nodeValueValue1 = document.createTextNode(arrayAlumnos.get(i).getApellidos());
				valueNode1.appendChild(nodeValueValue1);
				itemNode.appendChild(keyNode1);
				itemNode.appendChild(valueNode1);
				//////////////////////////////ANNO NACIMIENTO
				Element keyNode2 = document.createElement("AnnoNacimiento");
				Text nodeKeyValue2 = document.createTextNode(arrayAlumnos.get(i).getAnnoNacimiento()+"");
				keyNode2.appendChild(nodeKeyValue2);
				//////////////////////////////DIRECCION
				Element valueNode2 = document.createElement("Direccion");
				Text nodeValueValue2 = document.createTextNode(arrayAlumnos.get(i).getDireccion());
				valueNode2.appendChild(nodeValueValue2);
				itemNode.appendChild(keyNode2);
				itemNode.appendChild(valueNode2);
				//////////////////////////////MONTAMOS ITEM
				raiz.appendChild(itemNode); 
			}
			Source source = new DOMSource(document);
			Result result;
			try {
				result = new StreamResult(Files.newOutputStream(Paths.get("DOM_Ej7.xml")));
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(source, result);
			} catch (TransformerConfigurationException  | TransformerFactoryConfigurationError e) {
				e.printStackTrace();
			}catch (TransformerException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void generateJAXB(ArrayList<Alumno7> arrayAlumnos){
		try {
			File file = new File("JAXB_Ej7.xml");//
			JAXBContext jaxbContext = JAXBContext.newInstance(Alumno7[].class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			//Convertimos a Alumno7[] para poderle pasar Alumnos, con ArrayList no me sale...
			Alumno7 []alumnos=new Alumno7[arrayAlumnos.size()];
			for(int i=0;i<alumnos.length;i++){
				alumnos[i]=arrayAlumnos.get(i);
			}
			// Damos Formato
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//Generamos el fichero
			jaxbMarshaller.marshal(new JAXBElement(new QName("", "Alumno7"), Alumno7[].class, alumnos), file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Alumno7> devuelveDOM(){
		ArrayList<Alumno7> misAlumnos=new ArrayList<Alumno7>();
		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Files.newInputStream(Paths.get("DOM_Ej7.xml")));
			int tamano=document.getElementsByTagName("Alumno").getLength();
			for(int i=0;i<tamano;i++){
				Alumno7 alumnito=new Alumno7(document.getElementsByTagName("Nombre").item(i).getTextContent(),document.getElementsByTagName("Apellidos").item(i).getTextContent(),Integer.parseInt(document.getElementsByTagName("AnnoNacimiento").item(i).getTextContent()),document.getElementsByTagName("Direccion").item(i).getTextContent());
				misAlumnos.add(alumnito);
			}
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		return misAlumnos;
	}
	
	public static ArrayList<Alumno7> devuelveJAXB(){
		ArrayList<Alumno7> alums=new ArrayList();;
		try {
			File file = new File("JAXB_Ej7.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Alumno7[].class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Source source=new StreamSource(file);
			JAXBElement<Alumno7[]> read=jaxbUnmarshaller.unmarshal(source,Alumno7[].class);
			Alumno7[] alumnos = read.getValue();
			for(int i=0;i<alumnos.length;i++){
				alums.add(alumnos[i]);
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return alums;
	}
	
	public static boolean eligeMetodo(){
		Scanner keyb=new Scanner(System.in);
		int valor=0;
		boolean dom=true;
		do{
			System.out.println("Elige entre una de las dos metodologías:\n\t1. DOM\n\t2. JAXB");
			try{
				valor=keyb.nextInt();
				if(valor<1||valor>2){
					System.out.print("No es una opcion elegible. ");
				}else{
					if(valor==2){
						dom=false;
					}
				}
			}catch (InputMismatchException e){
				System.out.print("No es un valor numerico. ");
			}
		}while(valor<1||valor>2);
		return dom;
	}
	
	public static void main(String[] args) {
		Alumno7 al1=new Alumno7("Pepe","Martinez",1990,"Mejico");
		Alumno7 al2=new Alumno7("Pedro","Calvario",1989,"Chile");
		Alumno7 al3=new Alumno7("Hector","Contreras",1991,"Mendoza");
		ArrayList<Alumno7> arrayAlumnos=new ArrayList();
		arrayAlumnos.add(al1);
		arrayAlumnos.add(al2);
		arrayAlumnos.add(al3);
		ArrayList<Alumno7> arrayAlumnosXML=null;
		if(eligeMetodo()){
			//DOM
			generateDOM(arrayAlumnos);
			arrayAlumnosXML=devuelveDOM();
		}else{
			//JAXB
			generateJAXB(arrayAlumnos);
			arrayAlumnosXML=devuelveJAXB();
		}
		if(arrayAlumnosXML!=null){
			for(int i=0;i<arrayAlumnosXML.size();i++){
				System.out.println(arrayAlumnosXML.get(i).toString());
			}
		}
	}
}
