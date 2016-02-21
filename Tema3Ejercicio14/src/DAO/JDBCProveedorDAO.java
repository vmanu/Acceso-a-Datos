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
import modelo.Proveedor;

public class JDBCProveedorDAO implements ProveedorDAOInterface{

	// Consultas a realizar en BD
	private static final String SELECT_PROVEEDOR_BY_ID="select * from PROVEEDORES where PROV_ID=?";
	private static final String INSERT_PROVEEDOR_QUERY = "INSERT Into PROVEEDORES (PROV_ID, PROV_NOMBRE, CALLE, CIUDAD, PAIS, CP) values(?,?,?,?,?,?)";
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	public JDBCProveedorDAO(Connection con){
		this.con = con;
		stmt = null;
		rs = null;
	}

	@Override
	public Proveedor buscarProveedor(int proveedor) {
		Proveedor prov=null;
		try {
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
				prov=new Proveedor(supplierID,nombreProv,calle,ciudad,pais,cp);
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
		return prov;
	}

	@Override
	public void crearProveedor(Proveedor prov) {
		try {
			stmt = con.prepareStatement(INSERT_PROVEEDOR_QUERY);
			stmt.setInt(1, prov.getSuplierID());
			stmt.setString(2, prov.getProvName());
			stmt.setString(3, prov.getCalle());
			stmt.setString(4, prov.getCiudad());
			stmt.setString(5, prov.getPais());
			stmt.setInt(6, prov.getCp());
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
}
