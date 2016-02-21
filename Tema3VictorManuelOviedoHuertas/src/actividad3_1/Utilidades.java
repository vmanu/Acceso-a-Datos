
package actividad3_1;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/**
 *  @description Clase que establece una conexi�n a BD utilizando la clase DriverManager. Lee los datos de un archivo de propiedades
 */
public class Utilidades {

	public String dbms;
	public String dbName;
	public String userName;
	public String password;
	public String urlString;

	private String driver;
	private String serverName;
	private int portNumber;
	private Properties prop;

	public Utilidades(String propertiesFileName)
			throws FileNotFoundException, IOException,
			InvalidPropertiesFormatException {
		super();
		this.setProperties(propertiesFileName);
	}

	/**
	 * Asignaci�n de propiedades de conexi�n de xml a atributos de clase
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InvalidPropertiesFormatException
	 */
	private void setProperties(String fileName) throws IOException, InvalidPropertiesFormatException {
		this.prop = new Properties();
	    prop.loadFromXML(Files.newInputStream(Paths.get(fileName)));

		this.dbms = this.prop.getProperty("dbms");
		this.driver = this.prop.getProperty("driver");
		this.dbName = this.prop.getProperty("database_name");
		this.userName = this.prop.getProperty("user_name");
		this.password = this.prop.getProperty("password");
		this.serverName = this.prop.getProperty("server_name");
		this.portNumber = Integer
				.parseInt(this.prop.getProperty("port_number"));

		System.out.println("Set the following properties:");
		System.out.println("dbms: " + dbms);
		System.out.println("driver: " + driver);
		System.out.println("dbName: " + dbName);
		System.out.println("userName: " + userName);
		System.out.println("serverName: " + serverName);
		System.out.println("portNumber: " + portNumber);

	}

	/**
	 * Conexion a Base de Datos
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {

		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		if (this.dbms.equals("mysql")) {
			/* Solicito a DriverManager una conexi�n con la base de datos */
			/*
			 * Para identificar el controlador a usar se le proporciona una
			 * URL, si no lo encuentra lanza SQLException
			 */
			/* formato de URL: jdbc:[host][:port]/[database] */
			/*
			 * La URL var�a seg�n el gestor de BD,
			 * jdbc:mysql://127.0.0.1:3306/libros,
			 * jdbc:oracle:thin:@192.168.239.142:1521:libros
			 */
			conn = DriverManager.getConnection("jdbc:" + this.dbms + "://"
					+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
					connectionProps);
		} else if (this.dbms.equals("derby")) {
			conn = DriverManager.getConnection("jdbc:" + this.dbms + ":"
					+ this.dbName + ";create=true", connectionProps);
		}
		System.out.println("Connectado a BD");
		return conn;
	}

	/**
	 * Cierre de conexi�n a BD
	 * @param connArg
	 */
	public static void closeConnection(Connection connArg) {
		System.out.println("Releasing all open resources ...");
		try {
			if (connArg != null) {
				connArg.close();
				connArg = null;
			}
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}
	}
	
	
}
