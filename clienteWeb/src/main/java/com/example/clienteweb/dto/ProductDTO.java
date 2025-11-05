package com.example.clienteweb.dto;

import com.example.clienteweb.entity.Product;

public class ProductDTO {

    private String status;
//    private String mensaje;
    private Product producto;

    //Get and Set

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

//    public String getMensaje() {
//        return mensaje;
//    }
//    public void setMensaje(String mensaje) {
//        this.mensaje = mensaje;
//    }

    public Product getProducto() {
        return producto;
    }
    public void setProducto(Product producto) {
        this.producto = producto;
    }
}
