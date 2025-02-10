package modelo.productos;

public class Producto {

    public Producto() {
        codigo = "";
        descripcion = "";
        unidadMedida = "";
        precio = 0;
        activo = false;        
        costo = 0;
    }
    
    public Producto(String codigo, String descripcion, String unidadMedida, double precio, boolean activo, double  costo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.precio = precio;
        this.activo = activo;
        this.costo = costo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public String getCodigo() {
        return codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getUnidadMedida() {
        return unidadMedida;
    }
    public double getPrecio() {
        return precio;
    }
    public boolean isActivo() {
        return activo;
    }
    
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public double getCosto() {
        return costo;
    }
    
    String codigo;
    String descripcion;
    String unidadMedida;
    double precio;
    boolean activo;
    double costo;
}