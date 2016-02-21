package actividad3_2;

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
		/* Conexión a la Base de Datos */
		Connection con = null;
		/* Sentencia sql */
		Statement stmt = null;
		/* Conjunto de Resultados a obtener de la sentencia sql */
		ResultSet rs = null;
		try {
			con = new Utilidades1().getConnection();
			// Creación de la sentencia
			stmt = con.createStatement();
			// Ejecución de la consulta y obtención de resultados en un
			// ResultSet
			rs = stmt.executeQuery(SELECT_CAFES_QUERY);

			// Recuperación de los datos del ResultSet
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
			// Error al leer propiedades
			// En una aplicación real, escribo en el log y delego
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades1.printSQLException(sqle);
		} finally {
			try {
				// Liberamos todos los recursos pase lo que pase
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades1.closeConnection(con);
				}
			} catch (SQLException sqle) {
				Utilidades1.printSQLException(sqle);
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

		/* Conexión a la Base de Datos */
		Connection con = null;
		/* Sentencia Preparada sql */
		PreparedStatement stmt = null;
		
		try {
			con = new Utilidades1().getConnection();

			// Creamos un objeto PreparedStatement pasándole nuestra consulta
			// parametrizada
			stmt = con.prepareStatement(UPDATE_VENTAS_CAFE);
			// Le damos valoes a los parámetros de la consulta, indicando número
			// de parámetro
			// Y utilizando un método adecuado según el tipo de datos
			stmt.setFloat(1, ventas);
			stmt.setString(2, cafe);

			// método executeUpdate para ejecutar inserciones, actualizaciones y
			// borrado de datos
			stmt.executeUpdate();
			

		} catch (IOException e) {
			// Error al leer propiedades
			// En una aplicación real, escribo en el log y delego
			System.err.println(e.getMessage());
			
		} catch (SQLException sqle) {
			Utilidades1.printSQLException(sqle);
			
		} finally {
			try {
				// Liberamos todos los recursos pase lo que pase

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades1.closeConnection(con);
				}
			} catch (SQLException sqle) {
				Utilidades1.printSQLException(sqle);
			}
		}
	}
	
	public void buscar(String nombre) {
		/* Conexión a la Base de Datos */
		Connection con = null;
		/* Sentencia sql */
		PreparedStatement stmt = null;
		/* Conjunto de Resultados a obtener de la sentencia sql */
		ResultSet rs = null;
		try {
			con = new Utilidades1().getConnection();
			// Creación de la sentencia
			stmt = con.prepareStatement(SELECT_CAFES_QUERY_BY_NAME);
			// Ejecución de la consulta y obtención de resultados en un
			// ResultSet
			stmt.setString(1, nombre);
			rs = stmt.executeQuery();

			// Recuperación de los datos del ResultSet
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
			// Error al leer propiedades
			// En una aplicación real, escribo en el log y delego
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades1.printSQLException(sqle);
		} finally {
			try {
				// Liberamos todos los recursos pase lo que pase
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades1.closeConnection(con);
				}
			} catch (SQLException sqle) {
				Utilidades1.printSQLException(sqle);
			}
		}

	}
	//
	public void crear(String nombre, int provId,float precio,int ventas,int total) {
		Connection con = null;
		/* Sentencia Preparada sql */
		PreparedStatement stmt = null;
		
		try {
			con = new Utilidades1().getConnection();

			// Creamos un objeto PreparedStatement pasándole nuestra consulta
			// parametrizada
			stmt = con.prepareStatement(INSERT_CAFE_QUERY);
			// Le damos valoes a los parámetros de la consulta, indicando número
			// de parámetro
			// Y utilizando un método adecuado según el tipo de datos
			stmt.setString(1, nombre);
			stmt.setInt(2, provId);
			stmt.setFloat(3, precio);
			stmt.setInt(4, ventas);
			stmt.setInt(5, total);

			// método executeUpdate para ejecutar inserciones, actualizaciones y
			// borrado de datos
			stmt.executeUpdate();
			

		} catch (IOException e) {
			// Error al leer propiedades
			// En una aplicación real, escribo en el log y delego
			System.err.println(e.getMessage());
			
		} catch (SQLException sqle) {
			Utilidades1.printSQLException(sqle);
			
		} finally {
			try {
				// Liberamos todos los recursos pase lo que pase

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades1.closeConnection(con);
				}
			} catch (SQLException sqle) {
				Utilidades1.printSQLException(sqle);
			}
		}

	}
	
	public void borrar(String nombre) {
		Connection con = null;
		/* Sentencia Preparada sql */
		PreparedStatement stmt = null;
		
		try {
			con = new Utilidades1().getConnection();

			// Creamos un objeto PreparedStatement pasándole nuestra consulta
			// parametrizada
			stmt = con.prepareStatement(DELETE_CAFE_QUERY);
			// Le damos valoes a los parámetros de la consulta, indicando número
			// de parámetro
			// Y utilizando un método adecuado según el tipo de datos
			stmt.setString(1, nombre);

			// método executeUpdate para ejecutar inserciones, actualizaciones y
			// borrado de datos
			stmt.executeUpdate();
			

		} catch (IOException e) {
			// Error al leer propiedades
			// En una aplicación real, escribo en el log y delego
			System.err.println(e.getMessage());
			
		} catch (SQLException sqle) {
			Utilidades1.printSQLException(sqle);
			
		} finally {
			try {
				// Liberamos todos los recursos pase lo que pase

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades1.closeConnection(con);
				}
			} catch (SQLException sqle) {
				Utilidades1.printSQLException(sqle);
			}
		}

	}
	
}
