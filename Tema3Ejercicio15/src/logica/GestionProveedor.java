package logica;


import java.util.List;

import modelo.Cafe;
import modelo.Proveedor;
import DAO.AccesoDatosException;
import DAO.CafeDAOInterface;
import DAO.FactoriaDAO;
import DAO.ProveedorDAOInterface;

/**
 * @descrition Clase encargada de la lógica del negocio
 */


public class GestionProveedor {

	public String mostrarBusquedaProveedor(int proveedorId) throws AccesoDatosException{
		StringBuffer cadena=new StringBuffer();
		CafeDAOInterface cafe = FactoriaDAO.getInstance().getCafeDAOInterface();
		List<Cafe> cafes = cafe.buscarProveedor(proveedorId);
		ProveedorDAOInterface proveedor = FactoriaDAO.getInstance().getProveedorDAOInterface();
		Proveedor miProveedor = proveedor.buscarProveedor(proveedorId);
		if(miProveedor!=null){
			cadena.append("Los cafes que provee ").append(miProveedor.getProvName()).append(" son:\n");
			for(Cafe coffee:cafes){
				if(coffee!=null){
					cadena.append(coffee.toString()).append("\n");
				}
			}
			cadena.append("Los datos del proveedor son:\n").append(miProveedor.toString());
		}else{
			cadena.append("NO EXISTE DICHO PROVEEDOR");
		}
		return cadena.toString();
	}
}
