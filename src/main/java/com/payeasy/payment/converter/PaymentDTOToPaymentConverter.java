package com.payeasy.payment.converter;

import javax.ejb.Stateless;

import com.payeasy.payment.Converter;
import com.payeasy.payment.Payer;
import com.payeasy.payment.Payment;
import com.payeasy.payment.dto.PayerDTO;
import com.payeasy.payment.dto.PaymentDTO;

@Stateless
public class PaymentDTOToPaymentConverter implements Converter<PaymentDTO, Payment> {

	@Override
	public Payment convertFrom(PaymentDTO paymentDto) {
		Payment payment = new Payment();
		payment.setIntent(paymentDto.getIntent());
		
		Payer payer = new Payer();
		PayerDTO payerDto = paymentDto.getPayer();
		payer.setPaymentMethod(payerDto.getPaymentMethod());

		payment.setPayer(payer);
		
		return payment;
	}

}
