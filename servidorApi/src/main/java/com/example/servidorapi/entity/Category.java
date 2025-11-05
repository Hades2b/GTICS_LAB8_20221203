package com.example.servidorapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Integer idCategory;

    @Column(name = "CategoryName", nullable = false, length = 15)
    private String categoryName;

    @Column(name = "Description", nullable = false, length = 100)
    private String description;

    //Relaciones
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> productos;

    // Get y Set
    public Integer getIdCategory() {
        return idCategory;
    }
    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProductos() {
        return productos;
    }
    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }
}
