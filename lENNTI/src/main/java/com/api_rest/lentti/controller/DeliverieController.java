package com.api_rest.lentti.controller;

import com.api_rest.lentti.model.Deliveries;

import com.api_rest.lentti.services.IDeliveriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/deliveries")
public class  DeliverieController {
    @Autowired
    private IDeliveriesService deliveriesService;
    @GetMapping()
    public ResponseEntity<List <Deliveries>>findAll()throws Exception {
        return new ResponseEntity<>(deliveriesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Deliveries> findById(@PathVariable("id") long document) throws Exception{
        return  new ResponseEntity<>(deliveriesService.findById(document),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Deliveries deliveries) throws Exception{
        deliveriesService.insert(deliveries);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Deliveries deliveries) throws Exception{
        deliveriesService.update(deliveries);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long document) throws Exception{
        deliveriesService.delete(document);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}


