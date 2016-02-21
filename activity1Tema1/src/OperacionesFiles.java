

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;


public class OperacionesFiles {

	public static void main(String[] args) {
		//Realiza una copia de entrada.txt antes de ejecutar el ejercicio, ya que se va a borrar
		Path p1 = Paths.get("entrada.txt");
		Path p3 = Paths.get("noexiste");
		/*
		 * p4 es un archivo inaccesible al que hemos deshabilitado la herencia
		 * de permisos y despu�s hemos quitado todos los permisos para todos los
		 * usuarios. El propietario siempre podr� luego asignar permisos
		 */
		Path p4 = Paths.get("inaccesible.txt");

		/*
		 * Prueba el siguiente c�digo, a partir de lo que devuelven los m�todos
		 * y consultando el API, �Es equivalente !Files.exists(path) a
		 * Files.notExists(path)? 
		 */
		System.out.println(Files.exists(p1)); // true
		System.out.println(Files.notExists(p1)); // false
		System.out.println(!Files.exists(p1)); // false

		System.out.println(Files.exists(p3)); // false
		System.out.println(Files.notExists(p3)); // true
		System.out.println(!Files.exists(p3)); // true

		System.out.println(Files.exists(p4)); // false
		System.out.println(Files.notExists(p4)); // false
		System.out.println(!Files.exists(p4)); // true

		/* �Qu� hace el siguiente c�digo. Pru�balo con p1 y p2? */
		
		boolean isRegularExecutableFile = Files.isRegularFile(p1)
				& Files.isReadable(p1) & Files.isExecutable(p1);
		System.out.println(isRegularExecutableFile); // con p1

		try {
			// Intentamos borrar el archivo o directorio
			Files.delete(p1);
		} catch (NoSuchFileException x) {
			// No existe el archivo o directorio
			System.err.format("%s: no existe" + " el archivo o directorio%n",
					p1);
		} catch (DirectoryNotEmptyException x) {
			// Si el directorio no est� vac�o no se borra
			System.err.format("%s No est� vac�oy%n", p1);
		} catch (IOException x) {
			// Posibles problemas con permisos se recoger�an aqu�.
			System.err.println(x);
		}

		/*
		 * �Para qu� sirve el m�todo deleteIfExists(Path)? �En qu� se diferencia
		 * de delete(Path)? Consulta el API y pru�balo
		 */

		
		
		/*Realiza copias de archivos y directorios*/
		/*Prueba a cambiar p5 por .. �Qu� ocurre?*/
		/*�Qu� diferencia hay entre poner o no la opci�n REPLACE_EXISTING? Pru�balo y anota la diferencia*/
		Path p5 = Paths.get("../copia2.txt");
		Path p6 = Paths.get("copia.txt");
		try {
			Files.copy(p6, p5,REPLACE_EXISTING);
		} catch (FileAlreadyExistsException x) {
			// Si el destino es un directorio no vac�o
			System.err.println(x);
		} catch (IOException x) {
			// Posibles problemas con permisos se recoger�an aqu�.
			System.err.println(x);
		}
		
		
		/*�Qu� hace el siguiente c�digo?*/
		Path p7 = Paths.get("../mover.txt");
		Path p8 = Paths.get("mover.txt");
		try {
			Files.move(p8, p7,REPLACE_EXISTING);
		} catch (FileAlreadyExistsException x) {
			// Si el destino es un directorio no vac�o
			System.err.println(x);
		} catch (IOException x) {
			// Posibles problemas con permisos se recoger�an aqu�.
			System.err.println(x);
		}

	}

}
