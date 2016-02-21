package ejercicios2_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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
    	BufferedWriter bw=Files.newBufferedWriter(Paths.get(nombre),StandardOpenOption.CREATE);
    	for(int i=0;i<alumnos.size();i++){
    		bw.write(alumnos.get(i).toString()+System.lineSeparator());
    	}
    	bw.close();
    }
    
    public void leerAlumnos(String nombre) throws IOException{
    	String cadena;
    	BufferedReader br=Files.newBufferedReader(Paths.get(nombre));
    	while((cadena=br.readLine())!=null)
    		System.out.println(cadena);
    	br.close();
    }
}
