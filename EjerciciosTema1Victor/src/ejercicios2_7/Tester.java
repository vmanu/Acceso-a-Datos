package ejercicios2_7;

import java.io.IOException;

public class Tester {

	public static void main(String[] args) {
		Alumno al1=new Alumno("Pepe","Martinez",1990,"Mejico",3);
		Alumno al2=new Alumno("Pedro","Calvario",1989,"Chile",42);
		Alumno al3=new Alumno("Hector","Contreras",1991,"Mendoza",5);
		Alumno al4=new Alumno("Carlos","Cadete",1988,"Principes de Espana",6);
		Alumno al5=new Alumno("Pablo","Piqueras",1992,"Uruguay",10);
		Alumno al6=new Alumno("Zahir","Zapata",1989,"Argentina",20);
		Aula aul1=new Aula();
		aul1.add(al1);
		aul1.add(al2);
		aul1.add(al3);
		aul1.add(al4);
		aul1.add(al5);
		aul1.add(al6);
		try{
			aul1.escribirAlumnos("prueba.txt");
			aul1.leerAlumnos("prueba.txt");
		}catch (IOException e){
			System.out.println("problema al guardar /Cargar");
		}
	}

}
