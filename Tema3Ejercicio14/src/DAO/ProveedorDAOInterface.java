package DAO;

import modelo.Proveedor;

public interface ProveedorDAOInterface {
	
	public void crearProveedor(Proveedor prov);
	
	public Proveedor buscarProveedor(int prov);
	
	public void liberar();
	
	public void closeConnection();

}
