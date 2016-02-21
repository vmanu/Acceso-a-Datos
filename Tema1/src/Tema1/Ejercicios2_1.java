package Tema1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicios2_1 {

	public static void main(String[] args) {
		int i=0;
		Scanner lector = new Scanner(System.in);
		ArrayList<String> intr = new ArrayList();
		String entrada = "";
		boolean salYadios=false;
		while (!salYadios) {
			i++;
			System.out.println("Dime frase " + i + "\nPulse 'q' para salir.");
			entrada = lector.nextLine();
			if (!entrada.equalsIgnoreCase("q")) {
				intr.add(entrada);
			}else{
				salYadios=true;
				System.out.println("Introduce nombre del archivo a crear:");
				entrada=lector.nextLine();
			}
		}
		try {
			Files.write(Paths.get(entrada), intr, StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			System.out.println("Fallo");
		}

	}

}
