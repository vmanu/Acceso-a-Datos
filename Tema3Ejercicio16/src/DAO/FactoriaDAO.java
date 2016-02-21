package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class FactoriaDAO {
	private static FactoriaDAO instance;
	private static Connection con;
	private static final String alumnoDAO = "JDBCAlumnoDAO";
	private static final String asignaturaDAO = "JDBCAsignaturaDAO";
	private static final String matriculaDAO = "JDBCMatriculaDAO";
	
	public static FactoriaDAO getInstance() {
		if (instance == null) {
			instance = new FactoriaDAO();
		}
		return instance;
	}

	private FactoriaDAO() {

	}

	/**
	 * Devuelve un objeto DAO adecuado dependiendo de como esté implementada la
	 * persistencia a datos
	 * 
	 * @return
	 * @throws AccesoDatosException
	 */
	public AlumnoDAOInterface getAlumnoDAOInterface() throws AccesoDatosException {
		AlumnoDAOInterface dao = null;
		if (alumnoDAO.equals("JDBCAlumnoDAO")) {
			if(con==null){
				try {
					con = new Utilidades().getConnection();
				} catch (SQLException e) {
					Utilidades.printSQLException(e);
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			dao = new JDBCAlumnoDAO(con);
		}
		return dao;

	}

	public AsignaturaDAOInterface getAsignaturaDAOInterface() throws AccesoDatosException{
		AsignaturaDAOInterface dao = null;
		if (asignaturaDAO.equals("JDBCAsignaturaDAO")) {
			if(con==null){
				try {
					con = new Utilidades().getConnection();
				} catch (SQLException e) {
					Utilidades.printSQLException(e);
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			dao = new JDBCAsignaturaDAO(con);
		}
		return dao;
	}
	
	public MatriculacionDAOInterface getMatriculacionDAOInterface() throws AccesoDatosException{
		MatriculacionDAOInterface dao = null;
		if (matriculaDAO.equals("JDBCMatriculaDAO")) {
			if(con==null){
				try {
					con = new Utilidades().getConnection();
				} catch (SQLException e) {
					Utilidades.printSQLException(e);
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			dao = new JDBCMatriculaDAO(con);
		}
		return dao;
	}
}
