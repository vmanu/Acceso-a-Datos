package practica1;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DomicilioConverter implements SingleValueConverter{

	@Override
	public boolean canConvert(Class clazz) {
		return clazz.equals(Direccion.class);
	}

	@Override
	public Object fromString(String arg0) {
		String [] cadena=arg0.split(",");
		Direccion direccion= new Direccion(cadena[0],Integer.parseInt(cadena[1]));
		return direccion;
	}

	@Override
	public String toString(Object arg0) {
		Direccion dir=(Direccion)arg0;
		return dir.getCalle()+","+dir.getNumero();
	}

}
