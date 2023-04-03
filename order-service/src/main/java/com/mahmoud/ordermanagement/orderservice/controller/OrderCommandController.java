package com.mahmoud.ordermanagement.orderservice.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahmoud.ordermanagement.orderservice.dto.CreateOrderDTO;
import com.mahmoud.ordermanagement.orderservice.service.OrderCommandService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/api/order")
@Api(value = "Order Commands", description = "Order Commands Related Endpoints", tags = "Order Commands")
public class OrderCommandController {
	
	
	
	
	private OrderCommandService orderCommandService ;
	
	public OrderCommandController(OrderCommandService orderCommandService) {
		this.orderCommandService =orderCommandService;
	}
	
	
	@PostMapping()
	public CompletableFuture<String> createOrder(@RequestBody CreateOrderDTO createOrderDTO){
		
		return orderCommandService.createOrder(createOrderDTO);
	}
	
	
	
	

}
