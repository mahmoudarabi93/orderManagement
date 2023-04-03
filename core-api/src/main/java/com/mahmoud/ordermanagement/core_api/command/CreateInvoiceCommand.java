package com.mahmoud.ordermanagement.core_api.command;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateInvoiceCommand {
	
	public final String orderId;
	
	@TargetAggregateIdentifier
	public final String paymentId;

	public CreateInvoiceCommand(String orderId, String paymentId) {
		super();
		this.orderId = orderId;
		this.paymentId = paymentId;
	}
	
	
	
	
}
