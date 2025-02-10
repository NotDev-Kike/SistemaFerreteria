package modelo.productos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import modelo.database.DataBaseConnection;

public class ConjuntoProductos {

    public ConjuntoProductos(DataBaseConnection dbc) {
        this.dbc = dbc;
    }

    public LinkedList<Producto> getAllProductos() {
        LinkedList<Producto> listaResultado = new LinkedList<>();
        try {
        String query = "SELECT * " + "FROM Producto";
        ResultSet rs = dbc.executeQuery(query);
        while(rs.next())
            listaResultado.add(producto(rs));
        } catch (Exception e) {
        }        
        return listaResultado;
    }
    
    public Producto getProductoByCod(String cod) throws Exception{
        String query = "SELECT * " + "FROM Producto WHERE Codigo = '%s'";
        query = String.format(query, cod);
        ResultSet rs = dbc.executeQuery(query);
        if(rs.next()) {
            return producto(rs);
        }
        else {
            throw new Exception("Producto inexistente.");
        }
    }
    public LinkedList<Producto> searchProductoByDesc(String desc) throws Exception{
        LinkedList<Producto> listaResultado = new LinkedList<>();
        try {
            String query = "SELECT * " + "FROM Producto WHERE Descripcion like '%%%s%%'";
            query = String.format(query, desc);
            ResultSet rs = dbc.executeQuery(query);
            while (rs.next()) {
                listaResultado.add(producto(rs));
            }
        } catch (SQLException ex) {
        }
        return listaResultado;
    }
    public void deleteProducto(String cod) throws Exception{
        String query = "DELETE FROM Producto WHERE Codigo = '%s'";
        query = String.format(query, cod);
        int result = dbc.executeUpdate(query);
        if(result == 0) {
            throw new Exception("Producto inexistente.");
        }
    }
public void addProducto(Producto product) throws Exception{
    String query = "INSERT INTO `ferreteriadatos`.`producto` (`Codigo`, `Descripcion`, `UnidadMedida`, `Precio`, `costo`, `isActivo`) VALUES ('%s', '%s', '%s', '%f', '%f', '%d');";
    query = String.format(query, product.getCodigo(), product.getDescripcion(), product.getUnidadMedida(), product.getPrecio(), product.getCosto(), toInt(product.isActivo()));
    int result = dbc.executeUpdate(query);
    if(result == 0) {
        throw new Exception("Producto existente.");
    }
}
public void updateProducto(Producto product) throws Exception{
    String query = "UPDATE `ferreteriadatos`.`producto` SET `Descripcion`='%s', `UnidadMedida`='%s', `Precio`='%f', `Costo`='%f', `isActivo`='%d' WHERE `Codigo`='%s';";
    query = String.format(query, product.getDescripcion(), product.getUnidadMedida(), product.getPrecio(), product.getCosto(), toInt(product.isActivo()), product.getCodigo());
    int result = dbc.executeUpdate(query);
    if(result == 0) {
        throw new Exception("Producto inexistente.");
    }
}
    
    private Producto producto(ResultSet rs) {
        try {
            Producto product = new Producto();
            product.setCodigo(rs.getString("Codigo"));
            product.setDescripcion(rs.getString("Descripcion"));
            product.setUnidadMedida(rs.getString("UnidadMedida"));
            product.setPrecio(rs.getDouble("Precio"));
            product.setActivo(rs.getBoolean("isActivo"));
            return product;            
        } catch (SQLException ex) {
            return null;
        }
    }
    int toInt(Boolean b) {
        return Boolean.compare(b, false);
    }
    
    DataBaseConnection dbc;
}