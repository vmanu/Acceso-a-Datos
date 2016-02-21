/**
 *Aula8.java
 *@author Laura Lozano
 *@version 1.0
 */

package practica1;

import java.util.ArrayList;
import java.util.List;

public class Aula {
    private List<Alumno> alumnos;
    

    /**
     * Constructor del Almacén con un determinado tamano
     * @param tamano
     */
    public Aula(int tamano){
        alumnos=new ArrayList<Alumno>(tamano);
        
        
    }
   
    /**
     * Anade un nuevo elemento al almacén si hay sitio
     * @param valor a anadir al almacén
     */
    public void add(Alumno alumno){        
            alumnos.add(alumno);            
    }
    /**
     * Elimina un elemento del almacén si está en el almacen
     * @param valor
     * @return true si elimina el elemento, false en caso contrario
     */
    public boolean eliminar(Alumno alumno){
    	return alumnos.remove(alumno);
        
    }
   
   
    /**
     * Imprime por pantalla los elementos del almacén
     */
    public void informacionAlumnos(){
        System.out.println("El aula tiene los siguientes alumnos:");
        for (int j=0;j<alumnos.size();j++){
             System.out.println(alumnos.get(j).toString()+" ");
         }
    }
}
