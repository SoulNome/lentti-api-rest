package com.api_rest.lentti.services;

import com.api_rest.lentti.exepction.BadRequestException;
import com.api_rest.lentti.exepction.ConflictException;
import com.api_rest.lentti.exepction.ModelNotFoundException;
import com.api_rest.lentti.model.Deliveries;
import com.api_rest.lentti.repository.IDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveriesService implements IDeliveriesService {
    @Autowired
    private IDeliveryRepository deliveryRepository;

    public void validation(Deliveries deliveries) throws Exception {
        if (deliveries == null) {
            throw new BadRequestException("Es obligatorio el registro");
        }
        if (deliveries.getDeliveryDocument() == 0) {
            throw new BadRequestException("El documento del repartidor es obligatorio");
        }
        if (deliveries.getName().isEmpty()) {
            throw new BadRequestException("El Nombre del repartidor es obligatorio");
        }
        if (deliveries.getAddress().isEmpty()) {
            throw new BadRequestException("la direccion  del repartidor es obligatorio");
        }
        if (deliveries.getVehicle().isEmpty()) {
            throw new BadRequestException("El tipo del vehiculo es obligatorio");
        }
        if (deliveries.getVehicle().isEmpty()) {
            throw new BadRequestException("El tipo del vehiculo es obligatorio");
        }
        if ("".equals(deliveries.getPassword()) || deliveries.getPassword() == null) {
            throw new BadRequestException("La constraseña no puede estar vacia");
        }
        if (deliveries.getEmail().isEmpty()) {
            throw new BadRequestException("el correo es obligatorio");
        }
    }

    @Override
    public void insert(Deliveries deliveries) throws Exception {
        validation(deliveries);
        Optional<Deliveries> oldUser = deliveryRepository.findById(deliveries.getDeliveryDocument());
        if (oldUser.isPresent()) {
            throw new ConflictException("Ya existe un usuario con este documento");
        }
        deliveryRepository.save(deliveries);
    }

    @Override
    public void update(Deliveries deliveries) throws Exception {
        validation(deliveries);
        Optional<Deliveries> oldUser = deliveryRepository.findById(deliveries.getDeliveryDocument());
        if (!oldUser.isPresent()) {
            throw new ModelNotFoundException("No existe un usuario con este documento");
        }
        deliveryRepository.save(deliveries);
    }

    @Override
    public void delete(Long document) throws Exception {
        Optional<Deliveries> oldDeliveries = deliveryRepository.findById(document);
        if (document == 0) {
            throw new BadRequestException("El documento no puede estar vacio");
        }
        if (!oldDeliveries.isPresent()) {
            throw new ModelNotFoundException("El usuario no existe");
        }
        deliveryRepository.deleteById(document);
    }

    @Override
    public Deliveries findById(Long deliveryDocument) throws Exception {
        Optional<Deliveries> oldDeliveries = deliveryRepository.findById(deliveryDocument);
        if (deliveryDocument == 0){
            throw new BadRequestException("El documento no puede estar vacio");
        }if (!oldDeliveries.isPresent()){
            throw new ModelNotFoundException("El usuario no existe");
        }
        return oldDeliveries.orElse(null);
    }

    @Override
    public List<Deliveries> findAll() throws Exception {
        return deliveryRepository.findAll();
    }
}