package DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

import modelo.Cafe;

public class JDBCCafeDAO implements CafeDAOInterface{

	// Consultas a realizar en BD
	private static final String SELECT_CAFES_QUERY = "select * from CAFES";
	private static final String SELECT_CAFES_QUERY_BY_NAME = "select CAF_NOMBRE, PROV_ID, PRECIO, VENTAS, TOTAL from CAFES where caf_nombre=?";
	private static final String SELECT_CAFES_QUERY_BY_ID = "select CAF_NOMBRE, PROV_ID, PRECIO, VENTAS, TOTAL from CAFES where PROV_ID=?";
	private static final String SELECT_PROVEEDOR_BY_ID="select * from PROVEEDORES where PROV_ID=?";
	// En una consulta parametrizada ponemos interrogaciones en los valores que
	// aún desconocemos
	private static final String UPDATE_VENTAS_CAFE = "update CAFES set VENTAS = ? where CAF_NOMBRE = ?";
	private static final String DELETE_CAFE_QUERY = "DELETE FROM CAFES WHERE CAF_NOMBRE = ?";
	private static final String INSERT_CAFE_QUERY = "INSERT Into CAFES (CAF_NOMBRE, PROV_ID, PRECIO, VENTAS, TOTAL) values(?,?,?,?,?)";
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	public JDBCCafeDAO(Connection con){
		this.con=con;
		stmt = null;
		rs = null;
	}

	@Override
	public List<Cafe> verTabla() {
		List<Cafe> cafes=new ArrayList();
		try {
			stmt = con.prepareStatement(SELECT_CAFES_QUERY);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String coffeeName = rs.getString("CAF_NOMBRE");
				int supplierID = rs.getInt("PROV_ID");
				float precio = rs.getFloat("PRECIO");
				int ventas = rs.getInt("VENTAS");
				int total = rs.getInt("TOTAL");
				cafes.add(new Cafe(supplierID, coffeeName, precio, ventas, total));
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
		return cafes;
	}

	@Override
	public void actualizarVentasCafe(String cafe, int ventas) {
		try {
			stmt = con.prepareStatement(UPDATE_VENTAS_CAFE);
			stmt.setInt(1, ventas);
			stmt.setString(2, cafe);
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
	}

	@Override
	public Cafe buscar(String nombre) {
		Cafe miCafe=null;
		try {
			stmt = con.prepareStatement(SELECT_CAFES_QUERY_BY_NAME);
			stmt.setString(1, nombre);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String coffeeName = rs.getString("CAF_NOMBRE");
				int supplierID = rs.getInt("PROV_ID");
				float precio = rs.getFloat("PRECIO");
				int ventas = rs.getInt("VENTAS");
				int total = rs.getInt("TOTAL");
				miCafe=new Cafe(supplierID,coffeeName,precio,ventas,total);
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
		return miCafe;

	}

	@Override
	public List<Cafe> buscarProveedor(int proveedor) {
		List<Cafe> cafes=new ArrayList();
		try {
			stmt = con.prepareStatement(SELECT_CAFES_QUERY_BY_ID);
			stmt.setInt(1, proveedor);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				String coffeeName = rs.getString("CAF_NOMBRE");
				int supplierID = rs.getInt("PROV_ID");
				float precio = rs.getFloat("PRECIO");
				int ventas = rs.getInt("VENTAS");
				int total = rs.getInt("TOTAL");
				cafes.add(new Cafe(supplierID,coffeeName,precio,ventas,total));
			}
			liberar();
			stmt = con.prepareStatement(SELECT_PROVEEDOR_BY_ID);
			stmt.setInt(1, proveedor);
			rs=stmt.executeQuery();
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
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
		return cafes;
	}

	@Override
	public void crear(Cafe cafe) {
		try {
			stmt = con.prepareStatement(INSERT_CAFE_QUERY);
			stmt.setString(1, cafe.getCoffeeName());
			stmt.setInt(2, cafe.getSuplierID());
			stmt.setFloat(3, cafe.getPrecio());
			stmt.setInt(4, cafe.getVentas());
			stmt.setInt(5, cafe.getTotal());
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
	}

	@Override
	public void borrar(String nombre) {
		try {
			stmt = con.prepareStatement(DELETE_CAFE_QUERY);
			stmt.setString(1, nombre);
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
	}

	@Override
	public void liberar(){
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		}
	}

	@Override
	public void closeConnection() {
		System.out.println("Releasing all open resources ...");
		try {
			if (con != null) {
				con.close();
				con= null;
			}
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}
	}

	@Override
	public void tranferencia(String cafe1, String cafe2) {
		try {
			boolean sal=false;
			int idProv=0,ventas=0,total=0;
			float precio=0;
			con.setAutoCommit(false);
			stmt=con.prepareStatement(SELECT_CAFES_QUERY,
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery();
			while(rs.next()&&!sal){
				if(rs.getString("CAF_NOMBRE").equals(cafe1)){
					ventas=rs.getInt("VENTAS");
					rs.updateInt("VENTAS", 0);
					rs.updateRow();
					sal=true;
				}
			}
			rs.absolute(0);
			if(sal) {
				sal=false;
				while(rs.next()&&!sal){
					if(rs.getString("CAF_NOMBRE").equals(cafe2)){
						rs.updateInt("VENTAS", rs.getInt("VENTAS")+ventas);
						rs.updateRow();
						sal=true;
						con.commit();
					}
				}
				if(!sal){
					System.out.println("No se ha encontrado el cafe de destino. "
							+ "Intentelo de nuevo si lo desea, mientras se "
							+ "resetearan los cambios");
					con.rollback();
				}
			} else {
				System.out.println("No se ha encontrado el cafe de origen. "
						+ "Intentelo de nuevo si lo desea");
			}
		} catch (SQLException e) {
			Utilidades.printSQLException(e);
			if(con!=null){
				try {
					con.rollback();
				} catch (SQLException e1) {
					Utilidades.printSQLException(e1);
				}
			}
		} finally {
			liberar();
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				Utilidades.printSQLException(e);
			}
		}
	}
}
