package com.api_rest.lentti.services;

import com.api_rest.lentti.model.Products;
import com.api_rest.lentti.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    void  insert(Products products) throws  Exception;
    void update(Products products) throws Exception;
    void delete(Integer idProduct) throws Exception;
    Products findById(Integer idProduct) throws  Exception;
    List<Products> findAll() throws Exception;
}
