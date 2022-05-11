package com.example.maquinaexpendedora;

import java.io.Serializable;

public class Maquina implements Serializable {
    private String codigoProducto;
    private String categoriaProducto;
    private String nombreProducto;
    private int cantidad;
    private int precio;


    public Maquina( String codigoProducto, String categoriaProducto,String nombreProducto, int cantidad,int precio) {
        this.codigoProducto = codigoProducto;
        this.categoriaProducto = categoriaProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCodigoProducto() {return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return   "Codigo: " + codigoProducto + '\n'
                            + categoriaProducto + '\n'
                            + nombreProducto + '\n' +
                            + cantidad +'\n' +
                             precio +'\n' +
                            "Billete"+'\n'+

                "No fue trabado" ;
    }
}
