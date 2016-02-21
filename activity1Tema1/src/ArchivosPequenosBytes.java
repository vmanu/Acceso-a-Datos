
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class ArchivosPequenosBytes {

	public static void main(String[] args) {
		Path entrada = Paths.get("cubo.png");
		Path salida = Paths.get("cubo1.png");
		//Array de bytes para leer todos los bytes del archivo
		byte[] fileArray;
		try {
			//Leemos de una vez un archivo entero de bytes utilizando java.nio
			fileArray = Files.readAllBytes(entrada);
			//Escribimos todos los bytes en el archivo salida.txt de una sola vez utilizando java.nio
			//Después de ejecutar comprobar que es igual a entrada.txt
			Files.write(salida, fileArray);
		} catch (IOException io) {
			System.err.println(io);
		}
	}

}
