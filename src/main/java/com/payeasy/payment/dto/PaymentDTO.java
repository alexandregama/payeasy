package com.payeasy.payment.dto;

import org.codehaus.jackson.annotate.JsonIgnoreType;
import org.codehaus.jackson.annotate.JsonProperty;

import com.payeasy.payment.Intent;

public class PaymentDTO {

	@JsonProperty(value = "intent")
	private Intent intent;
	
	@JsonProperty(value = "payer")
	private PayerDTO payer;

	public PayerDTO getPayer() {
		return payer;
	}

	public void setPayer(PayerDTO payer) {
		this.payer = payer;
	}

	public static PaymentBuilder getBuilder() {
		return new PaymentBuilder();
	}
	
	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}

	@JsonIgnoreType
	public static class PaymentBuilder {
		
		private PaymentDTO paymentDTO;
		
		public PaymentBuilder() {
			paymentDTO = new PaymentDTO();
		}
		
		public PaymentBuilder withIntent(Intent name) {
			paymentDTO.setIntent(name);
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
