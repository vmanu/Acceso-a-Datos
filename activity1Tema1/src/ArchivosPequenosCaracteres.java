
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArchivosPequenosCaracteres {

	public static void main(String[] args) {
		Path entrada = Paths.get("cubo.png");
		Path salida = Paths.get("cubo2.png");
		//Lista de cadenas para leer las lineas
		List<String> fileLista;
		Charset charset;
		try {
			charset = Charset.forName("UTF-8");
			//Leemos de una vez un archivo entero de caracteres utilizando java.nio
			fileLista = Files.readAllLines(entrada);
			//Escribimos una vez un archivo entero de caracteres utilizando java.nio
			Files.write(salida, fileLista,charset);
		} catch (IOException io) {
			System.err.println(io);
		}
	}

}
