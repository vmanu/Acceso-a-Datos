package ejercicios1;


import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio3 {

	/*
	 * Para ejecutar Botón derecho --> Run as --> Run Configurations --> En
	 * argumentos escribir entrada.txt. Es necesario para probar toAbsolutePath
	 */
	public static void main(String[] args) {

		// Primer método toUri
		Path p1 = Paths.get("entrada.txt");

		System.out.format("%s%n", "URI " + p1.toUri());
/* RESPUESTA: Este metodo devuelve la direccion dada en el path y desde donde se ejecuta en una unica
 * dirección, de tipo URI*/
		// -------------------------------------------------------------------------------

		// Segundo método toAbsolutePath

		if (args.length < 1) {
			System.out
					.println("debes pasar un nombre de archivo como argumento");
			System.exit(-1);
		}

		Path inputPath = Paths.get(args[0]);
		Path fullPath = inputPath.toAbsolutePath();
/* RESPUESTA: Este metodo convierte el path dado (en este caso por argumento de entrada) en un path
 * absoluto, independientemente de si existe o no. Además, en el caso de pasarle un path absoluto,
 * te devuelve ese mismo path, ya que el path ya partiría de raiz (/ ó C:/ según SO)*/
		System.out.println("Path absoluto " + fullPath);

		// -------------------------------------------------------------------------------

		// Tercer método toRealPath

		Path p2 = Paths.get("./entrada.txt");
		try {

			Path fp = p2.toRealPath();
/* RESPUESTA: Este metodo devuelve la dirección absoluta del archivo si es existente, si no existe, lanza
 * una excepción "NoSuchFileException". En caso de darle una dirección absoluta y existir, te devuelve la misma
 * dirección absoluta pasada */
			System.out.println("Path real " + fp);
		} catch (NoSuchFileException x) {

			System.err.format("%s: no existe" + " el fichero o directorio %n",
					p2);

		} catch (IOException x) {

			System.err.format("%s%n", x);

		}

	}

}
