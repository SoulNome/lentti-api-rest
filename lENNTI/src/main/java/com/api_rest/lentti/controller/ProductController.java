package com.api_rest.lentti.controller;

import com.api_rest.lentti.model.Products;
import com.api_rest.lentti.services.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productsService;
    @GetMapping()
    public ResponseEntity<List <Products>> findAll()throws Exception{
        return new ResponseEntity<>(productsService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Products> findById(@PathVariable("id") Integer idProduct) throws Exception{
        return  new ResponseEntity<>(productsService.findById(idProduct),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Products products) throws Exception{
        productsService.insert(products);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Products products) throws Exception{
        productsService.update(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idProduct) throws Exception{
        productsService.delete(idProduct);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}