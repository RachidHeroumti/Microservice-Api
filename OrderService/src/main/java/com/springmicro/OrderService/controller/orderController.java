package com.springmicro.OrderService.controller;

import com.springmicro.OrderService.dto.OrderRequest;
import com.springmicro.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/order")
public class orderController {

    @Autowired
    OrderService orderService ;


    @PostMapping("/create")
    public ResponseEntity<String> CreateOrder(@RequestBody OrderRequest orderRequest){
        return orderService.createOrder(orderRequest) ;
    }
}
