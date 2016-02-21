package model;


import java.io.Serializable;
import java.util.List;


public class Profesor implements Serializable  {

	private static final long serialVersionUID = 1L;

	
    private int id;
   
    private Nombre nombre;
        
 
    private Direccion direccion;

 
	private List<CorreoElectronico> correos;

    public Profesor(){ 
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  


    public Nombre getNombre() {
		return nombre;
	}


	public void setNombre(Nombre nombre) {
		this.nombre = nombre;
	}


	/**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<CorreoElectronico> getCorreos() {
		return correos;
	}

	public void setCorreos(List<CorreoElectronico> correos) {
		this.correos = correos;
	}


	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", direccion="
				+ direccion + ", correos=" + correos + "]";
	}


	

    
}
