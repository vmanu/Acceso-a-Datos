package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class FactoriaDAO {
	private static FactoriaDAO instance;
	private static Connection con;
	private static final String cafeDAO = "JDBCCafeDAO";
	private static final String proveedorDAO = "JDBCProveedorDAO";
	
	public static FactoriaDAO getInstance() {
		if (instance == null) {
			instance = new FactoriaDAO();
		}
		return instance;
	}

	private FactoriaDAO() {

	}

	public CafeDAOInterface getCafeDAOInterface() throws AccesoDatosException {
		CafeDAOInterface dao = null;
		if (cafeDAO.equals("JDBCCafeDAO")) {
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
			dao = new JDBCCafeDAO(con);
		}
		return dao;

	}

	public ProveedorDAOInterface getProveedorDAOInterface() throws AccesoDatosException{
		ProveedorDAOInterface dao = null;
		if (proveedorDAO.equals("JDBCProveedorDAO")) {
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
			dao = new JDBCProveedorDAO(con);
		}
		return dao;
	}
}
