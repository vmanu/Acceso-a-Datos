package ejercicios1;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio4 {

	public static void main(String[] args) {
		// Microsoft Windows
		Path p0 = Paths.get("C:\\Usuarios\\pepe\\fotos");
		
		System.out.format("%s%n", p0.resolve("docs"));
	/* RESPUESTA: resolve agrega en este caso un nuevo nivel de inmersion en la dirección dada, agregando a la dirección
	 * un subnivel "docs" (C:\Usuarios\pepe\fotos\docs), este cambio, comprobandolo con un System.out.format("%s%n",p0.toAbsolutePath());
	 * concluyo que no modifica la variable path, solo te muestra lo anteriormente explicado.*/
		
		Path p1=Paths.get("fotos");
		System.out.format("%s%n", p1.resolve("C:\\Usuarios\\pepe"));
		/* RESPUESTA: resolve en este caso muestra lo que se le pasa en el String, ya que parte de raiz, ignorando
		 * el path. En este caso, tampoco modifica el Path*/
		//------------------------------------------------------------------
		
		Path p2 = Paths.get("pepe");
		Path p3 = Paths.get("juan");
		
		Path p2_to_p3 = p2.relativize(p3);
		System.out.format("%s%n", p2_to_p3);
		/* RESPUESTA: genera una ruta relativa que supone se da para ir de una carpeta a otra, supone, ya que no comprueba si
		 * existe dicha dirección*/
		
		Path p3_to_p2 = p3.relativize(p2);
		System.out.format("%s%n", p3_to_p2);
		/* RESPUESTA: Misma situación que la anterior, solo que invirtiendo el destino, en vez de a juan, va
		 * a la carpeta pepe*/
		
		Path p4 = Paths.get("Usuarios");
		Path p5 = Paths.get("Usuarios\\juan\\docs");
		
		Path p4_to_p5 = p4.relativize(p5);
		System.out.format("%s%n", p4_to_p5);
				
		Path p5_to_p4 = p5.relativize(p4);
		System.out.format("%s%n",p5_to_p4);
		
		/* RESPUESTA (A los dos metodos anteriores[con los Path p4 y p5]): Describe el camino a seguir desde la carpeta definida en el primer Path
		 * hacia la segunda, siempre con rutas relativas*/

	}

}
