package com.springmicro.OrderService.service;

import com.springmicro.OrderService.dto.OrderLineItemsDto;
import com.springmicro.OrderService.dto.OrderRequest;
import com.springmicro.OrderService.model.Order;
import com.springmicro.OrderService.model.OrderLineItems;
import com.springmicro.OrderService.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo ;
    public ResponseEntity<String> createOrder(OrderRequest orderRequest) {

        try {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());

            List<OrderLineItems> lsOrderLineItems = orderRequest.getOrderLineItemsDtoList()
                    .stream()
                    .map(this::mapToDto).toList() ;

            order.setLsOrderLineItems(lsOrderLineItems);
            orderRepo.save(order) ;
            return new ResponseEntity<>("create successfuly !", HttpStatus.CREATED) ;

        }catch (Exception e){
            return new ResponseEntity<>("server error!", HttpStatus.INTERNAL_SERVER_ERROR) ;
        }

    }



    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
