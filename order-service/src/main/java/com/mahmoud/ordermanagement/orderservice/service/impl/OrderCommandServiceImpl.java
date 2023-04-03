package com.mahmoud.ordermanagement.orderservice.service.impl;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.mahmoud.ordermanagement.core_api.command.CreateOrderCommand;
import com.mahmoud.ordermanagement.orderservice.aggregate.OrderStatus;
import com.mahmoud.ordermanagement.orderservice.dto.CreateOrderDTO;
import com.mahmoud.ordermanagement.orderservice.service.OrderCommandService;


@Service
public class OrderCommandServiceImpl implements OrderCommandService {
		
	
	
	private final  CommandGateway commandGateway; 
	
	
	
	
	public OrderCommandServiceImpl(CommandGateway commandGateway) {
		
		this.commandGateway = commandGateway;
	}




	@Override
	public CompletableFuture<String> createOrder(CreateOrderDTO createOrderDTO) {
		// TODO Auto-generated method stub
		return commandGateway.send(new CreateOrderCommand(UUID.randomUUID().toString(),createOrderDTO.getItemType(),
				createOrderDTO.getPrice(),createOrderDTO.getCurrency(),OrderStatus.CREATED.toString()));
	}

}
