package com.payeasy.payment.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class PaymentDTO {

	@JsonProperty(value = "intent")
	private String intent;
	
	@JsonProperty(value = "payer")
	private PayerDTO payer;

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	public PayerDTO getPayer() {
		return payer;
	}

	public void setPayer(PayerDTO payer) {
		this.payer = payer;
	}

	public static PaymentBuilder getBuilder() {
		return new PaymentBuilder();
	}
	
	public static class PaymentBuilder {
		
		private PaymentDTO paymentDTO;
		
		public PaymentBuilder() {
			paymentDTO = new PaymentDTO();
		}
		
		public PaymentBuilder withIntent(String name) {
			paymentDTO.intent = name;
			return this;
		}
		
		public PaymentBuilder withPayer(PayerDTO payerDTO) {
			paymentDTO.payer = payerDTO;
			return this;
		}
		
		public PaymentDTO build() {
			return paymentDTO;
		}
	}
	
}
