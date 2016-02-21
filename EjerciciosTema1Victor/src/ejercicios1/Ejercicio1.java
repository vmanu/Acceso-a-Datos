package ejercicios1;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Ejercicio1 {
	public static void main (String[] args){
		//Si estamos en un SO Windows
		//Para el objetivo de este ejercicio no hace falta que el archivo exista
		Path path = Paths.get("Usuarios\\pepe");
		//Si estamos en un SO GNU/Linux
		//Path path = Paths.get("/home/pepe/fotos");
		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(0): %s%n", path.getName(0));
		System.out.format("getNameCount: %d%n", path.getNameCount());
		System.out.format("subpath(0,2): %s%n", path.subpath(0,1));
		System.out.format("getParent: %s%n", path.getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
	}
}
