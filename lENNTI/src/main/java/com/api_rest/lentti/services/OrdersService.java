package com.api_rest.lentti.services;

import com.api_rest.lentti.exepction.BadRequestException;
import com.api_rest.lentti.exepction.ConflictException;
import com.api_rest.lentti.exepction.ModelNotFoundException;
import com.api_rest.lentti.model.Orders;
import com.api_rest.lentti.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService implements IOrdersService  {

    @Autowired
    private IOrderRepository orderRepository;
    public void validation(Orders orders) throws Exception{
        if (orders == null){
            throw new BadRequestException("Es obligatorio el registro");
        }if (orders.getIdOrder() == 0){
            throw  new BadRequestException("El id es obligatorio");
        }if(orders.getDeliveryDocument() == null){
            throw new BadRequestException("El documento del repartidor es obligatorio");
        }if (orders.getUserDocument() == null){
            throw new BadRequestException("El documento del cliente es obligatorio");
        }if (orders.getQuantityProducts() == 0 ){
            throw  new BadRequestException("la cantidad del producto es obligatorio");
        }if (orders.getTotalPrice() == 0 ){
            throw  new BadRequestException("el precio total del producto es obligatorio");
        }if (orders.getPickUpLocation() == null ){
            throw  new BadRequestException("el lugar de recojida  del producto es obligatorio");
        }if (orders.getPlaceOfDelivery()== null){
            throw  new BadRequestException("el lugar de entrega  del producto es obligatorio");
        }if (orders.getDescription()== null){
            throw  new BadRequestException("la descripcion es obligatorio");
        }

    }
    @Override
    public void insert(Orders orders) throws Exception {
        validation(orders);
        Optional<Orders> oldUser =orderRepository.findById(orders.getIdOrder());
        if (oldUser.isPresent()){
            throw  new ConflictException("Ya existe una orden con este id");
        }
        orderRepository.save(orders);
    }
    @Override
    public void update(Orders orders) throws Exception {
        validation(orders);
        Optional<Orders> oldUser = orderRepository.findById(orders.getIdOrder());
        if (!oldUser.isPresent()){
            throw new ModelNotFoundException("No existe una orden con este id");
        }
        orderRepository.save(orders);
    }

    @Override
    public void delete(Integer idOrder) throws Exception {
        Optional<Orders> oldOrders = orderRepository.findById(idOrder);
        if (idOrder == 0){
            throw new BadRequestException("El id no puede estar vacio");
        }if (!oldOrders.isPresent()){
            throw new ModelNotFoundException("El orden no existe");
        }
        orderRepository.deleteById(idOrder);
    }

    @Override
    public Orders findById(Integer idOrder) throws Exception {
        Optional<Orders> oldOrders = orderRepository.findById(idOrder);
        if (idOrder == 0){
            throw new BadRequestException("la orden no puede estar vacio");
        }if (!oldOrders.isPresent()){
            throw new ModelNotFoundException("la orden no existe");
        }
        return oldOrders.orElse(null);
    }

    @Override
    public List<Orders> findAll() throws Exception {
        return orderRepository.findAll();
    }
}
