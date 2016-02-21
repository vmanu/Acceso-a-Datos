package GUI;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import logica.GestionMatricula;
import modelo.Alumno;
import modelo.Asignatura;
import DAO.AsignaturaDAOInterface;
import DAO.AccesoDatosException;
import DAO.AlumnoDAOInterface;
import DAO.FactoriaDAO;
import DAO.MatriculacionDAOInterface;


public class Ejercicio16 {

	private static final int sal=7;
	
	public static int num(int min,int max,String pregunta,String fallo){
		Scanner keyb=new Scanner(System.in);
		boolean sal;
		int valor=0;
		do{
			sal=true;
			System.out.println(pregunta);
			try{
				valor=keyb.nextInt();
				if(valor<min||valor>max){
					System.out.print(fallo+". ");
					sal=false;
					keyb.nextLine();
				}
			}catch(InputMismatchException e){
				System.out.print("El valor introducido no es un número. ");
				sal=false;
				keyb.nextLine();
			}
		}while(!sal);
		return valor;
	}
	
	public static String string(String pregunta){
		System.out.println(pregunta);
		return new Scanner(System.in).nextLine();
	}
	
	public static boolean aprobado(){
		boolean aprobado=false;
		if(num(1,2,"Indica una de las opciones:\n\t1.Aprobado\n\t2.Suspenso","Opcion no valida")==1){
			aprobado=true;
		}
		return aprobado;
	}
	
	public static void main(String[] args) {
		AlumnoDAOInterface alumno=null;
		AsignaturaDAOInterface asignatura;
		MatriculacionDAOInterface matricula;
		List<Alumno> alumnos;
		List<Asignatura> asignaturas;
		Alumno miAlumno;
		Asignatura miProveedor;
		try {
			alumno = FactoriaDAO.getInstance().getAlumnoDAOInterface();
			asignatura=FactoriaDAO.getInstance().getAsignaturaDAOInterface();
			matricula=FactoriaDAO.getInstance().getMatriculacionDAOInterface();
			int op=0;
			do{
				op=num(1,sal,"Elige opción:"
						+ "\n\t1. Dar de alta Alumno\n\t2. Dar de baja Alumno"
						+ "\n\t3. Matricular Alumno a Asignatura\n\t4. Mostrar info Alumno"
						+ "\n\t5. Mostrar todos los alumnos\n\t6. Mostrar Asignaturas"
						+ "\n\t7. Salir",
						"No es una opción válida");
				switch(op){
					case 1:
						int id_alumno=num(1,999999999,"Introduzca numero de expediente","No es un valor valido");
						String nombre=string("Introduzca el nombre del Alumno");
						String apellidos=string("Introduzca apellidos del Alumno");
						int grado=num(1,6,"Introduzca el grado en que está",
								"No está dentro del rango");
						String curso=string("Introduca la formacion cursada");
						alumno.darAlta(new Alumno(id_alumno, nombre, apellidos, grado, curso));
						break;
					case 2:
						alumno.borrarAlumno(num(1,999999999,"Introduzca numero de expediente","No es un valor valido"));
						break;
					case 3:
						matricula.matricular(num(1,999999999,"Introduzca el numero de expediente","No es un valor valido"),
								num(1,999999999,"Introduzca el id de la asignatura", "No es un valor valido"), aprobado());
						break;
					case 4:
						System.out.println(new GestionMatricula().mostrarAsignaturasAlumno(
								num(1,999999999,"Introduce el numero de expediente del alumno","No es un valor valido")));
						break;
					case 5:
						alumnos=alumno.verAlumnos();
						System.out.println("Los alumnos son:");
						for(Alumno miAlumnito:alumnos){
							if(miAlumnito!=null){
								System.out.println(miAlumnito.toString());
							}
						}
						break;
					case 6:
						asignaturas=asignatura.verAsignaturas();
						System.out.println("Los asignaturas disponibles son:");
						for(Asignatura miAsignaturita:asignaturas){
							if(miAsignaturita!=null){
								System.out.println(miAsignaturita.toString());
							}
						}
						break;
					case sal:
						System.out.println("Adios");
				}
			}while(op!=sal);
		} catch (AccesoDatosException e) {
			e.printStackTrace();
		} finally{
			if(alumno!=null){
				alumno.closeConnection();
			}
		}
		
	}
}
