package com.example.servidorapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierID")
    private Integer idSupplier;

    @Column(name = "companyName", nullable = false, length = 40)
    private String companyName;

    @Column(name = "address", nullable = false, length = 60)
    private String address;

    //Relaciones
    @OneToMany(mappedBy = "supplier",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> productos;

    // Get y Set
    public Integer getIdSupplier() {
        return idSupplier;
    }
    public void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
