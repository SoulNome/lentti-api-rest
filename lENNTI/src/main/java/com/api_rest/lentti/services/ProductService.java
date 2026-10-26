package com.api_rest.lentti.services;

import com.api_rest.lentti.exepction.BadRequestException;
import com.api_rest.lentti.exepction.ConflictException;
import com.api_rest.lentti.exepction.ModelNotFoundException;


import com.api_rest.lentti.model.Products;
import com.api_rest.lentti.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    public void validation(Products products) throws Exception {
        if (products == null) {
            throw new BadRequestException("Es obligatorio el registro");
        }if (products.getIdProduct() == 0) {
            throw new BadRequestException("El id es obligatorio");

        }if (products.getName().isEmpty()) {
        throw new BadRequestException("El nombre del producto es obligatorio");
        }if (products.getPrice()==0) {
            throw new BadRequestException("El precio del producto es obligatorio");
        }if (products.getCompany().isEmpty()) {
            throw new BadRequestException("la compañia es obligatorio");
        }
    }

    @Override
    public void insert(Products products) throws Exception {
        validation(products);
        Optional<Products> oldUser =productRepository.findById(products.getIdProduct());
        if (oldUser.isPresent()){
            throw  new ConflictException("Ya existe una orden con este id");
        }
        productRepository.save(products);
    }
    @Override
    public void update(Products products) throws Exception {
        validation(products);
        Optional<Products> oldUser = productRepository.findById(products.getIdProduct());
        if (!oldUser.isPresent()){
            throw new ModelNotFoundException("No existe una orden con este id");
        }
        productRepository.save(products);
    }

    @Override
    public void delete(Integer idOrder) throws Exception {
        Optional<Products> oldProducts = productRepository.findById(idOrder);
        if (idOrder == 0){
            throw new BadRequestException("El id no puede estar vacio");
        }if (!oldProducts.isPresent()){
            throw new ModelNotFoundException("El orden no existe");
        }
        productRepository.deleteById(idOrder);
    }

    @Override
    public Products findById(Integer idOrder) throws Exception {
        Optional<Products> oldProducts = productRepository.findById(idOrder);
        if (idOrder == 0){
            throw new BadRequestException("la orden no puede estar vacio");
        }if (!oldProducts.isPresent()){
            throw new ModelNotFoundException("la orden no existe");
        }
        return oldProducts.orElse(null);
    }

    @Override
    public List<Products> findAll() throws Exception {
        return productRepository.findAll();
    }
}