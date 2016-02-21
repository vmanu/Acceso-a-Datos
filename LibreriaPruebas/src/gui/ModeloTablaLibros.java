/**
 *ModeloTablaLibros.java
 */

package gui;

import javax.swing.table.DefaultTableModel;

/**
 * Modelo Especifico para un JTable que visualiza libros del catálogo
 * @see
 */
public class ModeloTablaLibros extends DefaultTableModel{

   
	private static final long serialVersionUID = 1082503674356870038L;

	public ModeloTablaLibros(Object[][] datos, Object[] cabeceras){
        super(datos, cabeceras);
    }

    Class[] tipoColumn={java.lang.Integer.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.Integer.class,
        java.lang.String.class,
        java.lang.Integer.class
    };
    boolean[] editColumn={false,false,false,false};

    @Override
    public Class getColumnClass(int ind){
        return tipoColumn[ind];
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return editColumn[column];
    }


}
