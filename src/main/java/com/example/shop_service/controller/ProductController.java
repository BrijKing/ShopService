package com.example.shop_service.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop_service.dto.ProductDto;
import com.example.shop_service.model.Product;
import com.example.shop_service.service.ProductService;

@RestController
@RequestMapping("/shop/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@ModelAttribute ProductDto product) throws IOException{
        
        return new ResponseEntity<>(productService.addProductWithImage(product), HttpStatus.OK);
    }
    
//    @GetMapping("/allProducts")
//    public ResponseEntity<List<ProductDto>> getAllProducts(){
//        
//        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
//    }
//
//    @GetMapping("/getProduct")
//    public ResponseEntity<ProductDto> getProduct(@RequestParam String id) throws ProductNotFoundException{
//        
//        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto product){
//        
//        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
//    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam String id){
        
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
}
