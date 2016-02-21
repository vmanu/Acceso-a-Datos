package Practica3;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @descrition
 * @author Laura
 * @date 7/4/2015
 * @version 1.0
 * @license GPLv3
 */

/*
 * Si os fijáis usamos 3 anotaciones: XmlRootElement, XmlType y XmlElement.
 * 
 * La primera marca el elemento raíz de nuestra clase (en nuestro caso el nombre
 * de la clase).Con XmlType y la propiedad ‘propOrder’ cambiamos el orden en que
 * se escribirán los atributos en el xml resultante.Finalmente usando XmlElement
 * en el setter de los atributos que nos interesa que se incluyan en el xml,
 * marcamos los campos de nuestro interés.
 */

@XmlRootElement(name="Empresa")
@XmlType(propOrder = { "nombreEmpresa", "idEmpresa", "direccion",
		"numEmpleados", "empleados" })
public class Empresa{


	private int idEmpresa;
	private String nombreEmpresa;
	private String direccion;
	private int numEmpleados;
	private ArrayList<Empleado> empleados;

	public int getIdEmpresa() {
		return idEmpresa;
	}

	@XmlElement
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	@XmlElement
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getDireccion() {
		return direccion;
	}

	@XmlElement
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNumEmpleados() {
		return numEmpleados;
	}

	@XmlElement
	public void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	@XmlElement
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	/////////////CODIGO GENERADO POR VICTOR MANUEL OVIEDO HUERTAS
	
	@Override
	public String toString() {
		StringBuffer cadena=new StringBuffer();
		cadena.append("idEmpresa=").append(idEmpresa).append("\tnombreEmpresa=")
				.append(nombreEmpresa).append("\tdireccion=").append(direccion)
				.append("\tnumEmpleados=").append(numEmpleados).append("\templeados=");
		for(int i=0;i<empleados.size();i++){
			cadena.append("\n\t").append(empleados.get(i).toString());
		}
		return cadena.toString();
	}
	
	
	
}
