package com.mahmoud.ordermanagement.orderservice.aggregate;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.mahmoud.ordermanagement.core_api.command.CreateOrderCommand;
import com.mahmoud.ordermanagement.core_api.command.UpdateOrderStatusCommand;
import com.mahmoud.ordermanagement.core_api.event.OrderCreatedEvent;
import com.mahmoud.ordermanagement.core_api.event.OrderStatusUpdatedEvent;

@Aggregate
public class OrderAggregate {
	
	private String orderId;
	private String currency;
	private BigDecimal price;
	private ItemType itemType;
	private OrderStatus orderStatus;
	
	
	public OrderAggregate() {
		
	}
	
	@CommandHandler
	public OrderAggregate(CreateOrderCommand createOrderCommand) {
		
		
		AggregateLifecycle.apply(new OrderCreatedEvent(createOrderCommand.orderId,createOrderCommand.itemtype,createOrderCommand.price,createOrderCommand.currency,createOrderCommand.OrderStatus));
		
	}
	
	@EventSourcingHandler
	protected void on(OrderCreatedEvent orderCreatedEvent) {
		this.orderId=orderCreatedEvent.orderId;
		this.itemType= ItemType.valueOf(orderCreatedEvent.itemType);
		this.currency = orderCreatedEvent.currency;
		this.orderStatus=OrderStatus.valueOf(orderCreatedEvent.orderStatus);
		
		
	
	}
	
	
	@CommandHandler
	protected  void on(UpdateOrderStatusCommand updateOrderStatusCommand) {
		AggregateLifecycle.apply(new OrderStatusUpdatedEvent(updateOrderStatusCommand.orderId,
				updateOrderStatusCommand.orderStatus));
		
	}
	
	@EventSourcingHandler
	protected void on(OrderStatusUpdatedEvent orderStatusUpdatedEvent) {
		this.orderId=orderStatusUpdatedEvent.orderId;
		this.orderStatus=OrderStatus.valueOf( orderStatusUpdatedEvent.orderStatus);
	}
}
