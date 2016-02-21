package ejercicios1;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Ejercicio5 {

	public static void main(String[] args) {
		Path p1=Paths.get("..\\Usuarios\\Pepe\\misDocumentos\\manifest.xml");
		Path p2=Paths.get("..\\Usuarios\\Pepe\\misDocumentos\\Monofun.wmv");
		Path p3=Paths.get("Usuarios\\Pepe\\misDocumentos\\manifest.xml");
		Path p4=Paths.get("Usuarios\\Pepe\\misDocumentos");
		Path p5=Paths.get("Usuarios\\Pepe\\misDocumentos\\manifest.xml");
		System.out.format("%s%n",p1.endsWith(p3));//endsWith comprueba si p1 termina con lo que tiene escrito el path p3
		System.out.format("%s%n",p1.endsWith(p2));//Define que p1 no acaba con la misma linea que p2 (integramente)
		System.out.format("%s%n",p3.startsWith(p4));//Define si p3 contiene absolutamente en su ruta, la ruta al completo (exactamente igual) de p4
		System.out.format("%s%n",p3.equals(p1));//equals compara si los String de las rutas son idénticas, en este caso no
		System.out.format("%s%n",p3.equals(p5));//En este caso si son identicas, por tanto, da true...
		/*En ninguno de estos caso se comprueba la existencia de estas direcciones...*/
	}

}
