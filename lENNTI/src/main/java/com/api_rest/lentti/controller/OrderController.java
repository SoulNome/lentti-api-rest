package com.api_rest.lentti.controller;

import com.api_rest.lentti.model.Orders;
import com.api_rest.lentti.services.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrdersService ordersService;
    @GetMapping()
    public ResponseEntity<List <Orders>> findAll()throws Exception{
        return new ResponseEntity<>(ordersService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Orders> findById(@PathVariable("id") Integer idOrder) throws Exception{
        return  new ResponseEntity<>(ordersService.findById(idOrder),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Orders orders) throws Exception{
        ordersService.insert(orders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Orders orders) throws Exception{
        ordersService.update(orders);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idOrder) throws Exception{
        ordersService.delete(idOrder);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}