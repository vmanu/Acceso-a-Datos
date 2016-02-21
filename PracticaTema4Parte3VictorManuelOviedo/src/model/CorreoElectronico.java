
package model;

import java.io.Serializable;



public class CorreoElectronico implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String direccion;
    private String proveedor;
    
    
    public CorreoElectronico() {
        
    }
         

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Correo [id=" + id + ", direccion=" + direccion + ", proveedor="
				+ proveedor + "]";
	}



	

}
