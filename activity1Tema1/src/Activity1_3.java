import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Activity1_3 {

	public static void main(String[] args) {
		Path p1= Paths.get("cubo.png");
		Path p2= Paths.get("entrada.txt");
		Path p3= Paths.get("bufferreader.txt");
		try {
			Files.readAllBytes(p1);
		} catch (IOException e) {
			System.out.println("CALLATEEEEE!!!");
		}
		try {
			Files.readAllLines(p2);
		} catch (IOException e) {
			System.out.println("CALLATEEEEE2!!!");
		}
		try {
			Files.newBufferedWriter(p3);
		} catch (IOException e) {
			System.out.println("CALLATEEEEE3!!!");
		}
		try {
			Files.newBufferedReader(p3);
		} catch (IOException e) {
			System.out.println("CALLATEEEEE4!!!");
		}
	}

}
