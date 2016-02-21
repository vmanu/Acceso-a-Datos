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

public class JDBCAlumnoDAO implements AlumnoDAOInterface{

	private static final String INSERT_ALUMNO_QUERY = "INSERT Into ALUMNO (NUM_EXPEDIENTE, NOMBRE, APELLIDOS, GRADO, CURSO) values(?,?,?,?,?)";
	private static final String DELETE_ALUMNO_QUERY_ALUMNO = "DELETE FROM ALUMNO WHERE NUM_EXPEDIENTE = ?";
	private static final String DELETE_ALUMNO_QUERY_ASIGNATURA = "DELETE FROM ALUMNO_ASIGNATURA WHERE NUM_EXPEDIENTE = ?";
	private static final String SELECT_ALUMNO_QUERY = "select * from ALUMNO WHERE NUM_EXPEDIENTE=?";
	private static final String SELECT_ALUMNOS_QUERY = "select * from ALUMNO";
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	public JDBCAlumnoDAO(Connection con){
		this.con=con;
		stmt = null;
		rs = null;
	}

	@Override
	public Alumno verAlumno(int id_alumno) {
		Alumno alumno=null;
		try {
			stmt = con.prepareStatement(SELECT_ALUMNO_QUERY);
			stmt.setInt(1, id_alumno);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String nombre = rs.getString("NOMBRE");
				String apellidos = rs.getString("APELLIDOS");
				int grado = rs.getInt("GRADO");
				String curso = rs.getString("CURSO");
				alumno=new Alumno(id_alumno, nombre, apellidos, grado, curso);
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
		return alumno;
	}
	
	@Override
	public void darAlta(Alumno alumno) {
		try {
			stmt = con.prepareStatement(INSERT_ALUMNO_QUERY);
			stmt.setInt(1, alumno.getId_Alumno());
			stmt.setString(2, alumno.getNombre());
			stmt.setString(3, alumno.getApellidos());
			stmt.setInt(4, alumno.getGrado());
			stmt.setString(5, alumno.getCurso());
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
	}

	@Override
	public void borrarAlumno(int id_alumno) {
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement(DELETE_ALUMNO_QUERY_ASIGNATURA);
			stmt.setInt(1, id_alumno);
			stmt.executeUpdate();
			liberar();
			stmt = con.prepareStatement(DELETE_ALUMNO_QUERY_ALUMNO);
			stmt.setInt(1, id_alumno);
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
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

	@Override
	public List<Alumno> verAlumnos() {
		List<Alumno> alumno=new ArrayList();
		try {
			stmt = con.prepareStatement(SELECT_ALUMNOS_QUERY);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id_alumno=rs.getInt("NUM_EXPEDIENTE");
				String nombre = rs.getString("NOMBRE");
				String apellidos = rs.getString("APELLIDOS");
				int grado = rs.getInt("GRADO");
				String curso = rs.getString("CURSO");
				alumno.add(new Alumno(id_alumno, nombre, apellidos, grado, curso));
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
		return alumno;
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
