package com.api_rest.lentti.repository;

import com.api_rest.lentti.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Products,Integer> {
}
