package DAO;

public class FactoriaDAO {
	private static FactoriaDAO instance;
	private static final String cafeDAO = "JDBCCafeDAO";

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
		//Un if por cada tipo de DAO posible a instanciar
		if (cafeDAO.equals("JDBCCafeDAO")) {
			dao = new JDBCCafeDAO();
		}
		return dao;

	}

}
