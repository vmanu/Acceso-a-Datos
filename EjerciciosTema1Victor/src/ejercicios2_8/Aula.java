package ejercicios2_8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Aula {
    private List<Alumno> alumnos;
    private int numalumnos; //atributo para controlar el n�mero real de elementos que tiene nuestro almac�n

    /**
     * Constructor del Almac�n con un determinado tamano
     * @param tamano
     */
    public Aula(){
        alumnos=new ArrayList<Alumno>();
        numalumnos=0;
        
    }
    /**
     * Comprueba si el almac�n est� vacio
     * @return true si est� vacio
     */
    public boolean estaVacio(){
        return alumnos.isEmpty();
    }

    /**
     * Anade un nuevo elemento al almac�n si hay sitio
     * @param valor a anadir al almac�n
     */
    public void add(Alumno alumno){
        alumnos.add(alumno);
        numalumnos++;
    }
    /**
     * Elimina un elemento del almac�n si est� en el almacen
     * @param valor
     * @return true si elimina el elemento, false en caso contrario
     */
    public boolean eliminar(Alumno alumno){
    	numalumnos--;
    	return alumnos.remove(alumno);
    }
   
   
    /**
     * Imprime por pantalla los elementos del almac�n
     */
    public void informacionAlumnos(){
        System.out.println("El aula tiene los siguientes alumnos:");
        for (int j=0;j<alumnos.size();j++){
             System.out.println(alumnos.get(j).toString()+" ");
         }
    }
    
    public void escribirAlumnos(String nombre) throws IOException{
    	if(!Files.notExists(Paths.get(nombre))){
    		Files.delete(Paths.get(nombre));
    	}
    	ArrayList <String> cadena=new ArrayList();
    	for(int i=0;i<alumnos.size();i++){
    		cadena.add(alumnos.get(i).toString());
    	}
    	Files.write(Paths.get(nombre), cadena,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
    }
    
    public void leerAlumnos(String nombre) throws IOException{
    	Charset cst=Charset.forName("UTF-8");
    	ArrayList<String> miLista=(ArrayList<String>)Files.readAllLines(Paths.get(nombre),cst);
    	for(int i=0;i<miLista.size();i++){
    		System.out.println(miLista.get(i));
    	}
    }
}
