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

import modelo.Alumno;
import modelo.Asignatura;

public class JDBCAsignaturaDAO implements AsignaturaDAOInterface{

	// Consultas a realizar en BD
	private static final String SELECT_ASIGNATURAS_BY_NUM_EXPEDIENTE="select * from ASIGNATURA a, ALUMNO_ASIGNATURA aa where aa.ID_ASIGNATURA=a.ID_ASIGNATURA AND aa.NUM_EXPEDIENTE=?";
	private static final String SELECT_ASIGNATURAS_QUERY="select * from ASIGNATURA";
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	public JDBCAsignaturaDAO(Connection con){
		this.con = con;
		stmt = null;
		rs = null;
	}
	
	@Override
	public List<Asignatura> buscarAsignaturas(int id_alumno) {
		List<Asignatura> asignaturas=new ArrayList();
		try {
			stmt = con.prepareStatement(SELECT_ASIGNATURAS_BY_NUM_EXPEDIENTE);
			stmt.setInt(1, id_alumno);
			rs=stmt.executeQuery();
			while (rs.next()) {
				int id_asignatura = rs.getInt("ID_ASIGNATURA");
				String nombre=rs.getString("NOMBRE_ASIGNATURA");
				String tipo=rs.getString("TIPO");
				int creditos=rs.getInt("CREDITOS");
				asignaturas.add(new Asignatura(id_asignatura,nombre,tipo,creditos));
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
		return asignaturas;
	}

	@Override
	public List<Asignatura> verAsignaturas() {
		List<Asignatura> asignaturas=new ArrayList();
		try {
			stmt = con.prepareStatement(SELECT_ASIGNATURAS_QUERY);
			rs=stmt.executeQuery();
			while (rs.next()) {
				int id_asignatura = rs.getInt("ID_ASIGNATURA");
				String nombre=rs.getString("NOMBRE_ASIGNATURA");
				String tipo=rs.getString("TIPO");
				int creditos=rs.getInt("CREDITOS");
				asignaturas.add(new Asignatura(id_asignatura,nombre,tipo,creditos));
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
		return asignaturas;
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
