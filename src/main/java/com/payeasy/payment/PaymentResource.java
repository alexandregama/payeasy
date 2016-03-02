package com.payeasy.payment;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.payeasy.payment.dto.PaymentDTO;

@Path("/payments/payment")
@Stateless
public class PaymentResource {

	@Inject
	private Payments payments;
	
	@Inject
	private Converter<PaymentDTO, Payment> converter;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(PaymentDTO paymentDTO) throws URISyntaxException {
		Payment payment = converter.convertFrom(paymentDTO);
		payments.create(payment);
		
		Response response = null;
		try {
			response = Response
					.created(new URI("http://localhost:8080/payeasy/payments/payment/" + payment.getId()))
					.entity(payment)
					.build();
		} catch (Exception e) {
			response = Response
					.serverError()
					.build();
		}
		return response;
	}
	
}
