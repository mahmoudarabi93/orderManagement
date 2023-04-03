package com.mahmoud.ordermanagement.core_api.command;

import java.math.BigDecimal;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateOrderCommand {
	
	
	@TargetAggregateIdentifier
	public final String orderId;
	public final String itemtype;
	public final BigDecimal price;
	public final String currency;
	public final String OrderStatus;
	
	
	
	public CreateOrderCommand(String orderId, String itemtype, BigDecimal price, String currency, String orderStatus) {
		this.orderId = orderId;
		this.itemtype = itemtype;
		this.price = price;
		this.currency = currency;
		OrderStatus = orderStatus;
	}
	
	
	

}
