package DAO;

import java.util.List;

import modelo.Asignatura;

public interface AsignaturaDAOInterface {
	
	public List<Asignatura> buscarAsignaturas(int id_alumno);
	
	public List<Asignatura> verAsignaturas();
	
	public void liberar();
	
	public void closeConnection();
}
