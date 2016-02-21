package DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import modelo.Alumno;
import modelo.Asignatura;

public interface MatriculacionDAOInterface {

	public HashMap<Integer,Boolean> aprobadas(int id_alumno);
	
	public void matricular(int id_alumno, int id_asignatura, boolean aprobado);
	
	public void closeConnection();
	
	public void liberar();
}
