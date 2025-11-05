package com.example.servidorapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer idProduct;

    @Column(name = "ProductName", nullable = false, length = 40)
    private String productName;

    @JoinColumn(name = "supplierID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"productos", "hibernateLazyInitializer"})
    private Supplier supplier;

    @JoinColumn(name = "CategoryID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"productos", "hibernateLazyInitializer"})
    private Category category;


    @Column(name = "Price", nullable = false, precision = 10, scale = 2)
    private BigDecimal Price;

    @Column(name = "Unit", nullable = false, length = 25)
    private String unit;



    // Get y Set
    public Integer getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Supplier getSupplier() {
        return supplier;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return Price;
    }
    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
