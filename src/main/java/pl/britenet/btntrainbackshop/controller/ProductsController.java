package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jakub.adminpanel.obj.Product;
import pl.jakub.adminpanel.service.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId) {
        Optional<Product> product = productService.findProduct(productId);
        return ResponseEntity.of(product);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void updateProduct(@PathVariable int productId) {
        productService.removeProduct(productId);
    }
}
