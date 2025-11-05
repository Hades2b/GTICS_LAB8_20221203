package com.example.clienteweb.controller;

import com.example.clienteweb.dao.ProductDao;
import com.example.clienteweb.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/cliente")
public class ProductController {

    final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/products")
    public String listarProductos(Model model) {
        List<Product> listaProductos = productDao.listarProductos();
        model.addAttribute("listaProductos", listaProductos);
        return "listaProductos";
    }

    @GetMapping("/products/detalle")
    public String detalleProducto(Model model, @RequestParam(value="id", required=true) Integer idProducto, RedirectAttributes redirectAttributes) {
        Product product = productDao.obtenerProducto(idProducto);

        if(product != null) {
            model.addAttribute("producto", product);
            return "detalleProducto";

        } else {
            redirectAttributes.addFlashAttribute("err", "El producto no existe");
            return "redirect:/products";
        }

    }
}
