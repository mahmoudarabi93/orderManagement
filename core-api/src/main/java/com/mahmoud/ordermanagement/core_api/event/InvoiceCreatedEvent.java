package com.mahmoud.ordermanagement.core_api.event;

public class InvoiceCreatedEvent {
	
	public final String orderId;
	public final String paymentId;
	public InvoiceCreatedEvent(String orderId, String paymentId) {
		super();
		this.orderId = orderId;
		this.paymentId = paymentId;
	}
	
	

}
