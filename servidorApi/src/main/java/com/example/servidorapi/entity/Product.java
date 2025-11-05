package com.example.servidorapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    private Integer idProduct;

    @Column(name = "productName", nullable = false, length = 40)
    private String productName;

    @JoinColumn(name = "supplierID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Supplier supplier;

    @JoinColumn(name = "categoryID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Category category;


    @Column(name = "unitPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "unitsInStock", nullable = false)
    private Integer unitsInStock;

    @Column(name = "unitsOnOrder", nullable = false)
    private Integer unitsOnOrder;

    @Column(name = "discontinued", nullable = false)
    private boolean discontinued;


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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }
    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Integer getUnitsOnOrder() {
        return unitsOnOrder;
    }
    public void setUnitsOnOrder(Integer unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }
    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
}
