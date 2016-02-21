package DAO;

import java.sql.SQLException;
import java.util.List;

import modelo.Alumno;
import modelo.Asignatura;

public interface AlumnoDAOInterface {

	public void darAlta(Alumno cafe);
	
	public void borrarAlumno(int id);
	
	public Alumno verAlumno(int id_alumno);
	
	public List<Alumno> verAlumnos();
	
	public void closeConnection();
	
	public void liberar();
}
