package com.api_rest.lentti.repository;

import com.api_rest.lentti.model.Deliveries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeliveryRepository extends JpaRepository<Deliveries, Long> {
}
