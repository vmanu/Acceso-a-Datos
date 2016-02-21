package ejercicios1;


import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio3 {

	/*
	 * Para ejecutar Bot�n derecho --> Run as --> Run Configurations --> En
	 * argumentos escribir entrada.txt. Es necesario para probar toAbsolutePath
	 */
	public static void main(String[] args) {

		// Primer m�todo toUri
		Path p1 = Paths.get("entrada.txt");

		System.out.format("%s%n", "URI " + p1.toUri());
/* RESPUESTA: Este metodo devuelve la direccion dada en el path y desde donde se ejecuta en una unica
 * direcci�n, de tipo URI*/
		// -------------------------------------------------------------------------------

		// Segundo m�todo toAbsolutePath

		if (args.length < 1) {
			System.out
					.println("debes pasar un nombre de archivo como argumento");
			System.exit(-1);
		}

		Path inputPath = Paths.get(args[0]);
		Path fullPath = inputPath.toAbsolutePath();
/* RESPUESTA: Este metodo convierte el path dado (en este caso por argumento de entrada) en un path
 * absoluto, independientemente de si existe o no. Adem�s, en el caso de pasarle un path absoluto,
 * te devuelve ese mismo path, ya que el path ya partir�a de raiz (/ � C:/ seg�n SO)*/
		System.out.println("Path absoluto " + fullPath);

		// -------------------------------------------------------------------------------

		// Tercer m�todo toRealPath

		Path p2 = Paths.get("./entrada.txt");
		try {

			Path fp = p2.toRealPath();
/* RESPUESTA: Este metodo devuelve la direcci�n absoluta del archivo si es existente, si no existe, lanza
 * una excepci�n "NoSuchFileException". En caso de darle una direcci�n absoluta y existir, te devuelve la misma
 * direcci�n absoluta pasada */
			System.out.println("Path real " + fp);
		} catch (NoSuchFileException x) {

			System.err.format("%s: no existe" + " el fichero o directorio %n",
					p2);

		} catch (IOException x) {

			System.err.format("%s%n", x);

		}

	}

}
