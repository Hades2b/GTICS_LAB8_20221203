package com.example.servidorapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryID")
    private Integer idCategory;

    @Column(name = "categoryName", nullable = false, length = 15)
    private String categoryName;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    //Relaciones
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    @JsonManagedReference
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
