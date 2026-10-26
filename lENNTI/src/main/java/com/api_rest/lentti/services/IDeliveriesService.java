package com.api_rest.lentti.services;

import com.api_rest.lentti.model.Deliveries;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface IDeliveriesService {
    void  insert(Deliveries deliveries) throws  Exception;
    void update(Deliveries deliveries) throws Exception;
    void delete(Long deliveryDocument) throws Exception;
    Deliveries findById(Long deliveryDocument) throws  Exception;
    List<Deliveries> findAll() throws Exception;
}
