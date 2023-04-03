package com.mahmoud.ordermanagement.core_api.event;

public class ShippingCreatedEvent {

	
	
	public final String orderId;
	public final String paymentId;
	public final String shippingId;
	public ShippingCreatedEvent(String orderId, String paymentId, String shippingId) {
		super();
		this.orderId = orderId;
		this.paymentId = paymentId;
		this.shippingId = shippingId;
	}
	
}
