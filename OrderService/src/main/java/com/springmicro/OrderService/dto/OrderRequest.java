package com.springmicro.OrderService.dto;

import com.springmicro.OrderService.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
private List<OrderLineItemsDto>  orderLineItemsDtoList ;
}
