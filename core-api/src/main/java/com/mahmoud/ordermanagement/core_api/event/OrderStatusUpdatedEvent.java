package com.mahmoud.ordermanagement.core_api.event;

public class OrderStatusUpdatedEvent {

	
	
	public final String orderId;
	
	public final String orderStatus;

	public OrderStatusUpdatedEvent(String orderId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}
	
	
}
