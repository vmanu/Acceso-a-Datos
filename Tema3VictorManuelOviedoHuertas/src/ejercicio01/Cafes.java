package ejercicio01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cafes {

	// Consultas a realizar en BD
	private static final String SELECT_CAFES_QUERY = "select CAF_NOMBRE, PROV_ID, PRECIO, VENTAS, TOTAL from CAFES";
	private static final String SELECT_CAFES_QUERY_BY_NAME = "select CAF_NOMBRE, PROV_ID, PRECIO, VENTAS, TOTAL from CAFES where caf_nombre=?";
	private static final String SELECT_CAFES_QUERY_BY_ID = "select CAF_NOMBRE, PROV_ID, PRECIO, VENTAS, TOTAL from CAFES where PROV_ID=?";
	private static final String SELECT_PROVEEDOR_BY_ID="select * from PROVEEDORES where PROV_ID=?";
	// En una consulta parametrizada ponemos interrogaciones en los valores que
	// aún desconocemos
	private static final String UPDATE_VENTAS_CAFE = "update CAFES set VENTAS = ? where CAF_NOMBRE = ?";
	private static final String DELETE_CAFE_QUERY = "DELETE FROM CAFES WHERE CAF_NOMBRE = ?";
	private static final String INSERT_CAFE_QUERY = "INSERT Into CAFES (CAF_NOMBRE, PROV_ID, PRECIO, VENTAS, TOTAL) values(?,?,?,?,?)";

	/**
	 * Metodo que muestra por pantalla los datos de la tabla cafes
	 * 
	 * @param con
	 * @throws SQLException
	 */
	public void verTabla() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = new Utilidades().getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_CAFES_QUERY);
			while (rs.next()) {
				String coffeeName = rs.getString("CAF_NOMBRE");
				int supplierID = rs.getInt("PROV_ID");
				float PRECIO = rs.getFloat("PRECIO");
				int VENTAS = rs.getInt("VENTAS");
				int total = rs.getInt("TOTAL");
				System.out.println(coffeeName + ", " + supplierID + ", "
						+ PRECIO + ", " + VENTAS + ", " + total);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades.closeConnection(con);
				}
			} catch (SQLException sqle) {
				Utilidades.printSQLException(sqle);
			}
		}

	}

	/**
	 * Método que actualiza las ventas de un café con un PreparedStatement
	 * 
	 * @param cafe
	 * @param ventas
	 */
	public void actualizarVentasCafe(String cafe, int ventas) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = new Utilidades().getConnection();
			stmt = con.prepareStatement(UPDATE_VENTAS_CAFE);
			stmt.setInt(1, ventas);
			stmt.setString(2, cafe);
			stmt.executeUpdate();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades.closeConnection(con);
				}
			} catch (SQLException sqle) {
				Utilidades.printSQLException(sqle);
			}
		}
	}
	
	public void buscar(String nombre) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = new Utilidades().getConnection();
			stmt = con.prepareStatement(SELECT_CAFES_QUERY_BY_NAME);
			stmt.setString(1, nombre);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String coffeeName = rs.getString("CAF_NOMBRE");
				int supplierID = rs.getInt("PROV_ID");
				float PRECIO = rs.getFloat("PRECIO");
				int VENTAS = rs.getInt("VENTAS");
				int total = rs.getInt("TOTAL");
				System.out.println(coffeeName + ", " + supplierID + ", "
						+ PRECIO + ", " + VENTAS + ", " + total);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades.closeConnection(con);
				}
			} catch (SQLException sqle) {
				Utilidades.printSQLException(sqle);
			}
		}

	}
	
	public void buscarProveedor(int proveedor) {
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmtP=null;
		ResultSet rs = null;
		try {
			con = new Utilidades().getConnection();
			stmt = con.prepareStatement(SELECT_CAFES_QUERY_BY_ID);
			stmtP = con.prepareStatement(SELECT_PROVEEDOR_BY_ID);
			stmt.setInt(1, proveedor);
			stmtP.setInt(1, proveedor);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String coffeeName = rs.getString("CAF_NOMBRE");
				int supplierID = rs.getInt("PROV_ID");
				float PRECIO = rs.getFloat("PRECIO");
				int VENTAS = rs.getInt("VENTAS");
				int total = rs.getInt("TOTAL");
				System.out.println(coffeeName + ", " + supplierID + ", "
						+ PRECIO + ", " + VENTAS + ", " + total);
			}
			rs.close();
			rs=stmtP.executeQuery();
			while (rs.next()) {
				//PROV_ID, PROV_NOMBRE, CALLE, CIUDAD, PAIS, CP
				int supplierID = rs.getInt("PROV_ID");
				String nombreProv=rs.getString("PROV_NOMBRE");
				String calle=rs.getString("CALLE");
				String ciudad=rs.getString("CIUDAD");
				String pais=rs.getString("PAIS");
				int cp=rs.getInt("CP");
				System.out.println(supplierID + ", "
						+ nombreProv + ", " + calle + ", " + ciudad + ", "
						+ pais + ", " + cp);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades.closeConnection(con);
				}
			} catch (SQLException sqle) {
				Utilidades.printSQLException(sqle);
			}
		}

	}

	public void crear(String nombre, int provId,float precio,int ventas,int total) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = new Utilidades().getConnection();
			stmt = con.prepareStatement(INSERT_CAFE_QUERY);
			stmt.setString(1, nombre);
			stmt.setInt(2, provId);
			stmt.setFloat(3, precio);
			stmt.setInt(4, ventas);
			stmt.setInt(5, total);
			stmt.executeUpdate();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades.closeConnection(con);
				}
			} catch (SQLException sqle) {
				Utilidades.printSQLException(sqle);
			}
		}
	}
	
	public void borrar(String nombre) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = new Utilidades().getConnection();
			stmt = con.prepareStatement(DELETE_CAFE_QUERY);
			stmt.setString(1, nombre);
			stmt.executeUpdate();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades.closeConnection(con);
				}
			} catch (SQLException sqle) {
				Utilidades.printSQLException(sqle);
			}
		}
	}
}
