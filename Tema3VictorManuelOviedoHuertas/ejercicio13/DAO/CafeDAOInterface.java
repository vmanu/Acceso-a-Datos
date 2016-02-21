package DAO;

import java.sql.SQLException;
import java.util.List;

import modelo.Cafe;

public interface CafeDAOInterface {

	public List<Cafe> verTabla();
	
	public void actualizarVentasCafe(String cafe, int ventas);
	
	public Cafe buscar(String nombre);
	
	public List<Cafe> buscarProveedor(int proveedor);

	public void crear(Cafe cafe);
	
	public void borrar(String nombre);
	
	public void liberar();
	
	public void closeConnection();

	public void tranferencia(String cafe1, String cafe2);
}
