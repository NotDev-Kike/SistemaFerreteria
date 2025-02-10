package modelo.factura;

import modelo.productos.Producto;

public class LineaDetalle {

    public LineaDetalle() {
        producto = null;
        cantidad = 0;
        precio = 0;
        despachado = false;
    }
    public LineaDetalle(Producto producto, int cantidad, double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.despachado = false;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDespachado(boolean despachado) {
        this.despachado = despachado;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDespachado() {
        return despachado;
    }
    
    Producto producto;
    int cantidad;
    double precio;
    boolean despachado;
}
