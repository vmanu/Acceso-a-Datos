package ejercicio10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import ejercicio09.Utilidades;

public class Libros {
	private static final String SELECT_LIBROS_QUERY = "select * from LIBROS order by TITULO ASC";
	private static final String UPDATE_COPIAS_LIBRO = "update LIBROS set COPIAS = ? where ISBN = ?";
	private static final String SELECT_LIBROS_QUERY_ISBN = "select * from LIBROS where ISBN=?";
	private static final String DELETE_LIBROS_QUERY = "DELETE FROM LIBROS WHERE ISBN = ?";
	private static final String INSERT_LIBROS_QUERY = "INSERT Into LIBROS (ISBN, TITULO, AUTOR, EDITORIAL, PAGINAS, COPIAS) values(?,?,?,?,?,?)";
	private static final String SELECT_CAMPOS_QUERY = "SELECT * FROM LIBROS LIMIT 1";
	
	
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public Libros(){
		try {
			con = new Utilidades().getConnection();
		} catch (SQLException e) {
			Utilidades.printSQLException(e);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		};
		stmt = null;
		rs = null;
	}

	public void crear(int isbn, String titulo, String autor, String editorial, int paginas, int copias) {
		try {
			stmt = con.prepareStatement(INSERT_LIBROS_QUERY);
			stmt.setInt(1, isbn);
			stmt.setString(2, titulo);
			stmt.setString(3, autor);
			stmt.setString(4, editorial);
			stmt.setInt(5, paginas);
			stmt.setInt(6, copias);
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
	}

	public void borrar(int isbn) {
		try {
			stmt = con.prepareStatement(DELETE_LIBROS_QUERY);
			stmt.setInt(1, isbn);
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
	}

	public void verTabla() {
		try {
			stmt = con.prepareStatement(SELECT_LIBROS_QUERY);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String titulo = rs.getString("TITULO");
				int isbn = rs.getInt("ISBN");
				String autor = rs.getString("AUTOR");
				String editorial=rs.getString("EDITORIAL");
				int paginas = rs.getInt("PAGINAS");
				int copias = rs.getInt("COPIAS");
				float precio=rs.getFloat("PRECIO");
				System.out.println(titulo + ", " + isbn + ", "
						+ autor + ", " + editorial + ", " + paginas + ", " + copias
						+ ", " + precio);
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
	}

	public void actualizar(HashMap<Integer,Integer> data) {
		try {
			stmt=con.prepareStatement(SELECT_LIBROS_QUERY,
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery();
			while(rs.next()){
				int isbn=rs.getInt("ISBN");
				if(data.get(isbn)!=null){
					int valor=rs.getInt("COPIAS");
					rs.updateInt("COPIAS", valor+data.get(isbn));
					rs.updateRow();
				}
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
	}

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
	
	public void closeConnection() {
		System.out.println("Releasing all open resources ...");
		try {
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}
	}
	
	
	
	public String[] getCamposLibro() throws AccesoDatosException {
        stmt = null;
        rs= null;
        ResultSetMetaData rsmd = null;
        String[] campos = null;
        try {
            stmt = con.prepareStatement(SELECT_CAMPOS_QUERY);
            rs = stmt.executeQuery();
            rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            campos = new String[columns];
            for (int i = 0; i < columns; i++) {
                campos[i] = rsmd.getColumnLabel(i + 1);
            }
            return campos;
        } catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
			throw new AccesoDatosException(
					"Ocurrió un error al acceder a los datos");
		} finally{
			liberar();
		}
	}

	public void verCatalogoInverso() {
		try {
			stmt = con.prepareStatement(SELECT_LIBROS_QUERY);
			rs = stmt.executeQuery();
			rs.afterLast();
			while (rs.previous()) {
				String titulo = rs.getString("TITULO");
				int isbn = rs.getInt("ISBN");
				String autor = rs.getString("AUTOR");
				String editorial=rs.getString("EDITORIAL");
				int paginas = rs.getInt("PAGINAS");
				int copias = rs.getInt("COPIAS");
				float precio = rs.getFloat("PRECIO");
				System.out.println(titulo + ", " + isbn + ", "
						+ autor + ", " + editorial + ", " + paginas + ", " + copias
						+ ", " + precio);
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
	}
	
	public void mostrar(ArrayList<Integer> lista){
		try {
			stmt = con.prepareStatement(SELECT_LIBROS_QUERY);
			rs = stmt.executeQuery();
			for (int i=0;i<lista.size();i++) {
				if(rs.absolute(lista.get(i))){
					String titulo = rs.getString("TITULO");
					int isbn = rs.getInt("ISBN");
					String autor = rs.getString("AUTOR");
					String editorial=rs.getString("EDITORIAL");
					int paginas = rs.getInt("PAGINAS");
					int copias = rs.getInt("COPIAS");
					float precio=rs.getFloat("PRECIO");
					System.out.println(titulo + ", " + isbn + ", "
							+ autor + ", " + editorial + ", " + paginas + ", " + copias
							+ ", " + precio);
				}
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
	}
	
	public void marcarPrecio(float precioPagina){
		try {
			stmt=con.prepareStatement(SELECT_LIBROS_QUERY,
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery();
			while(rs.next()){
				rs.updateFloat("PRECIO", rs.getInt("PAGINAS")*precioPagina);
				rs.updateRow();
			}
		} catch (SQLException sqle) {
			Utilidades.printSQLException(sqle);
		} finally {
			liberar();
		}
	}
	
	public void cambiarPrecios(int isbn1, int isbn2, float precio){
		try {
			boolean entra1=false, entra2=false;
			float price1=0,price2=0,max=0;
			con.setAutoCommit(false);
			stmt=con.prepareStatement(SELECT_LIBROS_QUERY,
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery();
			int row=0;
			while(rs.next()&&!(entra1&&entra2)){
				int isbn=rs.getInt("ISBN");
				if(isbn==isbn1){
					price1=rs.getInt("PAGINAS")*precio;
					rs.updateFloat("PRECIO", price1);
					rs.updateRow();	
					entra1=true;
					row=rs.getRow();
				}else{
					if(isbn==isbn2){
						price2=rs.getInt("PAGINAS")*precio;
						max=price2>price1?price2:price1;
						rs.updateFloat("PRECIO", max);
						rs.updateRow();	
						entra2=true;
					}
				}
			}
			if(entra1&&entra2&&max!=price1){
				rs.absolute(row);
				while(rs.next()){
					rs.updateFloat("PRECIO", max);
					rs.updateRow();
				}
			}
			if(entra1&&entra2){
				con.commit();
			}else{
				con.rollback();
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
	
	
	////////////////////AÑADIDO
	public void actualizarLibroYPrecio(int isbn, int paginas, float precio){
		try {
			boolean sal=false;
			con.setAutoCommit(false);
			stmt=con.prepareStatement(SELECT_LIBROS_QUERY,
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery();
			while(rs.next()&&!sal){
				if(rs.getInt("ISBN")==isbn){
					int paginasFinal=paginas+rs.getInt("PAGINAS");
					rs.updateInt("PAGINAS", paginasFinal);
					rs.updateFloat("PRECIO", precio*paginasFinal);
					rs.updateRow();
					con.commit();
					sal=true;
				}
			}
			if(!sal){
				System.out.println("No se ha encontrado dicho isbn. Intentelo de nuevo si lo desea");
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
	/////////////////
}
