package com.mahmoud.ordermanagement.orderservice.service;

import java.util.concurrent.CompletableFuture;

import com.mahmoud.ordermanagement.orderservice.dto.CreateOrderDTO;

public interface OrderCommandService {

	
	public CompletableFuture<String> createOrder(CreateOrderDTO createOrderDTO);
}
