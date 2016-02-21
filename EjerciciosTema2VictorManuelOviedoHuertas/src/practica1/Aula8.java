/**
 *Aula8.java
 *@author Laura Lozano
 *@version 1.0
 */

package practica1;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Aula8 {
    private List<Alumno8> alumnos;
    private Date fechaCreacion;
    

    /**
     * Constructor del Almacén con un determinado tamano
     * @param tamano
     */
    public Aula8(int tamano){
        alumnos=new ArrayList<Alumno8>(tamano);
        
        
    }
   
    /**
     * Anade un nuevo elemento al almacén si hay sitio
     * @param valor a anadir al almacén
     */
    public void add(Alumno8 alumno8){        
            alumnos.add(alumno8);            
    }
    /**
     * Elimina un elemento del almacén si está en el almacen
     * @param valor
     * @return true si elimina el elemento, false en caso contrario
     */
    public boolean eliminar(Alumno8 alumno8){
    	return alumnos.remove(alumno8);
        
    }
         
    public List<Alumno8> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno8> alumnos) {
		this.alumnos = alumnos;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL,
                new Locale("es"));
		return "Aula [alumnos=" + alumnos.toString() + ", fechaCreacion=" + formatter.format(fechaCreacion)
				+ "]";
	}

	
}
