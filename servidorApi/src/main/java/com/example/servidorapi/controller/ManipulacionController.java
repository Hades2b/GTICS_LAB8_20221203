package com.example.servidorapi.controller;

import com.example.servidorapi.entity.Product;
import com.example.servidorapi.repository.CategoryRepository;
import com.example.servidorapi.repository.ProductRepository;
import com.example.servidorapi.repository.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ManipulacionController {

    final ProductRepository productRepository;
    final CategoryRepository categoryRepository;
    final SupplierRepository supplierRepository;

    public ManipulacionController(ProductRepository productRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }


    @PostMapping("/product")
    public ResponseEntity<?> crearProducto(@RequestBody Product product) {
        productRepository.save(product);

        Map<String, Object> responseBody = Map.of(
                "status", HttpStatus.BAD_REQUEST.value(),
                "mensaje","Producto actualizado con éxito",
                "producto", product
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PutMapping("/product")
    public ResponseEntity<?> actualizarProducto(@RequestBody Product product) {
        boolean existe = productRepository.existsById(product.getIdProduct());
        if (existe) {
            productRepository.save(product);

            Map<String, Object> responseBody = Map.of(
                    "status", HttpStatus.OK.value(),
                    "mensaje",  "Producto actualizado con éxito",
                    "producto", product
            );
            return ResponseEntity.status(HttpStatus.OK).body(responseBody);
        } else {
            Map<String, Object> responseBody = Map.of(
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "error", "Producto con ID: "+product.getIdProduct()+" no encontrado"
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
        boolean exist = productRepository.existsById(id);
        if (exist) {
            productRepository.deleteById(id);

            Map<String, Object> responseBody = Map.of(
                    "status", HttpStatus.OK.value(),
                    "mensaje", "Producto eliminado con éxito"
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
