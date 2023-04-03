package com.mahmoud.ordermanagement.core_api.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateShippingCommand {
	
	public final String orderId;
	public final String paymentId;
	@TargetAggregateIdentifier
	public final String shippingId;

	public CreateShippingCommand(String orderId, String paymentId, String shippingId) {
		
		this.orderId = orderId;
		this.paymentId = paymentId;
		
		this.shippingId = shippingId;
	}
	
	

}
