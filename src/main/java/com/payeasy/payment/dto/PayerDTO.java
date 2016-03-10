package com.payeasy.payment.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import com.payeasy.payment.PaymentMethod;

public class PayerDTO {

	@JsonProperty("payment_method")
	private PaymentMethod paymentMethod;

	@Deprecated //Jackson eyes only
	PayerDTO() {
	}
	
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public static PayerBuilder getBuilder() {
		return new PayerBuilder();
	}
	
	public static class PayerBuilder {
		
		private PayerDTO payerDTO;
		
		public PayerBuilder() {
			payerDTO = new PayerDTO();
		}

		public PayerBuilder withPaymentMethod(PaymentMethod method) {
			payerDTO.paymentMethod = method;
			return this;
		}
		
		public PayerDTO build() {
			return payerDTO;
		}
	}
	
}
