package util;

import dominio.Producto;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samuel Vega
 */
public class Conversiones {
    private String columnasProductosPedido[] = {"Cantidad", "Producto", "Precio", ""};
    
    public DefaultTableModel productosPedidoModel(List<Producto> productos, List<Integer> cantidadProducto) {
        Object tabla[][];
        
        if(productos != null) {
            tabla = new Object[productos.size()][4];
            for(int i = 0; i < productos.size(); i++) {
                tabla[i][0] = cantidadProducto.get(i);
                tabla[i][1] = productos.get(i).getNombre();
                tabla[i][2] = cantidadProducto.get(i) * productos.get(i).getPrecio();
                tabla[i][3] = "Personalizar";
            }
            return new DefaultTableModel(tabla, columnasProductosPedido);
        }
        
        return null;
    }
}