package util;

import dominio.Cliente;
import dominio.Producto;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samuel Vega
 */
public class Conversiones {
    private final String columnasProductosPedido[] = {"Cantidad", "Producto", "Precio", ""};
    private final String columnasClientes[] = {"ID", "Nombres", "Apellido Paterno", "Apellido Materno", "Teléfono", "Dirección"};
    
    public DefaultTableModel productosPedidoModel(List<Producto> productos, List<Integer> cantidadProducto) {
        Object tabla[][];
        
        if(productos != null) {
            tabla = new Object[productos.size()][4];
            for(int i = 0; i < productos.size(); i++) {
                tabla[i][0] = cantidadProducto.get(i);
                tabla[i][1] = productos.get(i).getNombre();
                tabla[i][2] = "$ " + String.format("%.2f", cantidadProducto.get(i) * productos.get(i).getPrecio());
                tabla[i][3] = "Personalizar";
            }
            return new DefaultTableModel(tabla, columnasProductosPedido);
        }
        
        return null;
    }
    
    public DefaultTableModel clientesModel(List<Cliente> clientes) {
        Object tabla[][];
        
        if(clientes != null) {
            tabla = new Object[clientes.size()][6];
            for(int i = 0; i < clientes.size(); i++) {
                tabla[i][0] = clientes.get(i).getId();
                tabla[i][1] = clientes.get(i).getNombres();
                tabla[i][2] = clientes.get(i).getApellidoPaterno();
                tabla[i][3] = clientes.get(i).getApellidoMaterno();
                tabla[i][4] = clientes.get(i).getTelefono();
                tabla[i][5] = clientes.get(i).getDireccion();
            }
            return new DefaultTableModel(tabla, columnasClientes);
        }
        
        return null;
    }
}