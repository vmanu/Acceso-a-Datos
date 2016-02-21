package DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

import modelo.Alumno;
import modelo.Asignatura;

public class JDBCMatriculaDAO implements MatriculacionDAOInterface{

	private static final String APROBADAS_QUERY="Select * from alumno_asignatura where NUM_EXPEDIENTE=?";
	private static final String MATRICULAR_QUERY="insert into alumno_asignatura (ID_ASIGNATURA,NUM_EXPEDIENTE,APROBADO) values (?,?,?)";
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	public JDBCMatriculaDAO(Connection con){
		this.con=con;
		stmt = null;
		rs = null;
	}

	@Override
	public HashMap<Integer,Boolean> aprobadas(int id_alumno) {
		HashMap<Integer,Boolean> aprobadas=new HashMap();
		try {
			stmt = con.prepareStatement(APROBADAS_QUERY);
			stmt.setInt(1,id_alumno);
			rs = stmt.executeQuery();
			while (rs.next()) {
				aprobadas.put(rs.getInt("ID_ASIGNATURA"), rs.getBoolean("APROBADO"));
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
		return aprobadas;
	}

	@Override
	public void matricular(int id_alumno, int id_asignatura, boolean aprobado) {
		try {
			stmt = con.prepareStatement(MATRICULAR_QUERY);
			stmt.setInt(1,id_asignatura);
			stmt.setInt(2,id_alumno);
			stmt.setBoolean(3,aprobado);
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
