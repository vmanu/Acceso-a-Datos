package logica;


import java.util.HashMap;
import java.util.List;

import modelo.Alumno;
import modelo.Asignatura;
import DAO.AccesoDatosException;
import DAO.AlumnoDAOInterface;
import DAO.FactoriaDAO;
import DAO.AsignaturaDAOInterface;
import DAO.MatriculacionDAOInterface;

/**
 * @descrition Clase encargada de la lógica del negocio
 */


public class GestionMatricula {
	
	public String mostrarAsignaturasAlumno(int id_alumno) throws AccesoDatosException{
		MatriculacionDAOInterface matricula=FactoriaDAO.getInstance().getMatriculacionDAOInterface();
		HashMap <Integer,Boolean> valores=matricula.aprobadas(id_alumno);
		StringBuffer cadena=new StringBuffer();
		AlumnoDAOInterface alumno = FactoriaDAO.getInstance().getAlumnoDAOInterface();
		Alumno miAlumno = alumno.verAlumno(id_alumno);
		AsignaturaDAOInterface asignatura = FactoriaDAO.getInstance().getAsignaturaDAOInterface();
		List<Asignatura> asignaturas = asignatura.buscarAsignaturas(id_alumno);
		if(miAlumno!=null){
			cadena.append("Las asignaturas que ").append(miAlumno.getNombre()).append(" ha tenido son:\n");
			for(Asignatura subject:asignaturas){
				if(subject!=null){
					cadena.append(subject.toString()).append(". La cual está ").append(valores.get(subject.getId_Asignatura())?"aprobada":"suspensa").append("\n");
				}
			}
			cadena.append("Los datos del alumno son:\n").append(miAlumno.toString());
		}else{
			cadena.append("NO EXISTE DICHO ALUMNO");
		}
		return cadena.toString();
	}
}
