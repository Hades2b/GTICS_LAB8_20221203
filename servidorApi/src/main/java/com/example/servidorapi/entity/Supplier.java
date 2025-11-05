package com.example.servidorapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierID")
    private Integer idSupplier;

    @Column(name = "SupplierName", nullable = false, length = 40)
    private String supplierName;

    @Column(name = "Address", nullable = false, length = 60)
    private String address;

    //Relaciones
    @OneToMany(mappedBy = "supplier",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> productos;

    // Get y Set
    public Integer getIdSupplier() {
        return idSupplier;
    }
    public void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProductos() {
        return productos;
    }
    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }
}
