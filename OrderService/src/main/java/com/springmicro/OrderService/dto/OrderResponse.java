package com.springmicro.OrderService.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private long id ;
    private String orderNumber ;
    private List<OrderLineItemsDto> orderLineItemsDtoList ;

}
