package com.api_rest.lentti.services;

import com.api_rest.lentti.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IOrdersService {
    void  insert(Orders orders) throws  Exception;
    void update(Orders orders) throws Exception;
    void delete(Integer idOrder) throws Exception;
    Orders findById(Integer idOrder) throws  Exception;
    List<Orders> findAll() throws Exception;
}
