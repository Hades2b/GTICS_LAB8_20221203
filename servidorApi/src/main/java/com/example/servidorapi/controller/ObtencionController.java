package com.example.servidorapi.controller;

import com.example.servidorapi.entity.Product;
import com.example.servidorapi.repository.CategoryRepository;
import com.example.servidorapi.repository.ProductRepository;
import com.example.servidorapi.repository.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ObtencionController {

    final ProductRepository productRepository;
    final CategoryRepository categoryRepository;
    final SupplierRepository supplierRepository;

    public ObtencionController(ProductRepository productRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/product")
    public List<Product> listarProductos() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Map<String, Object> responseBody = Map.of(
                    "status", HttpStatus.OK.value(),
                    "producto", product.get()
            );
            return ResponseEntity.status(HttpStatus.OK).body(responseBody);
        } else {
            Map<String, Object> responseBody = Map.of(
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "error", "Producto con ID: "+id+" no encontrado"
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
        }
    }

}
