package practica1;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class Cafe6Converter implements Converter{

	@Override
	public boolean canConvert(Class arg0) {
		return arg0.equals(Cafe6.class);
	}

	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		Cafe6 cafe= (Cafe6) obj;
		writer.addAttribute("marca", cafe.getNombre());
		writer.startNode("total");
		writer.setValue(Integer.toString(cafe.getTotal()));
		writer.startNode("ventas");
		writer.setValue(Integer.toString(cafe.getVentas()));
		writer.endNode();
		writer.startNode("precio");
		writer.setValue(Float.toString(cafe.getPrecio()));
		writer.endNode();
		writer.endNode();
		
		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		Cafe6 cafe = new Cafe6();
		cafe.setNombre(reader.getAttribute("marca"));
		reader.moveDown();
		cafe.setTotal(Integer.parseInt(reader.getValue()));
		reader.moveDown();
		cafe.setVentas(Integer.parseInt(reader.getValue()));
		cafe.setPrecio(Float.parseFloat(reader.getValue()));
		return cafe;
	}

}
