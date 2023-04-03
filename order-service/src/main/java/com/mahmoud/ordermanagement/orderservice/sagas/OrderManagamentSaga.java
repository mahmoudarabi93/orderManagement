package com.mahmoud.ordermanagement.orderservice.sagas;

import java.util.UUID;

import javax.inject.Inject;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import com.mahmoud.ordermanagement.core_api.command.CreateInvoiceCommand;
import com.mahmoud.ordermanagement.core_api.command.CreateShippingCommand;
import com.mahmoud.ordermanagement.core_api.command.UpdateOrderStatusCommand;
import com.mahmoud.ordermanagement.core_api.event.InvoiceCreatedEvent;
import com.mahmoud.ordermanagement.core_api.event.OrderCreatedEvent;
import com.mahmoud.ordermanagement.core_api.event.OrderStatusUpdatedEvent;
import com.mahmoud.ordermanagement.core_api.event.ShippingCreatedEvent;
import com.mahmoud.ordermanagement.orderservice.aggregate.OrderStatus;

@Saga
public class OrderManagamentSaga {
	
	@Inject
	private transient CommandGateway commandGateway;
	
	
	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderCreatedEvent orderCreatedEvent) {
		
		String paymentId = UUID.randomUUID().toString();
		
		System.out.println("Saga Invoked");
		
		SagaLifecycle.associateWith("paymentId",paymentId);
		
		System.out.println("Order Id :"+orderCreatedEvent.orderId);
		
		
		commandGateway.send(new CreateInvoiceCommand(orderCreatedEvent.orderId,paymentId));
		
	}
	
	
	
	@SagaEventHandler(associationProperty = "paymentId")
	public void handle(InvoiceCreatedEvent invoiceCreatedEvent) {
		
		String shippingId =  UUID.randomUUID().toString();
		
		System.out.println("Saga continued");
		
		SagaLifecycle.associateWith("shippngId",shippingId);
		
		System.out.println("Payment ID : "+invoiceCreatedEvent.paymentId);
		
		
		commandGateway.send(new CreateShippingCommand(invoiceCreatedEvent.orderId,
				invoiceCreatedEvent.paymentId,shippingId));
		
	}
	
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(ShippingCreatedEvent shippingCreatedEvent) {
		
		System.out.println("Saga continued");
		
		
		commandGateway.send(new UpdateOrderStatusCommand(shippingCreatedEvent.orderId,
				String.valueOf(OrderStatus.SHIPPED)));
		
	}
	
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderStatusUpdatedEvent orderStatusUpdatedEvent) {
		
		SagaLifecycle.end();
		
	}

}
