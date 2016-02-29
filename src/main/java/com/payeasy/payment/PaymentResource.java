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

@Path("/payments/payment")
@Stateless
public class PaymentResource {

	@Inject
	private Payments payments;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Payment payment) throws URISyntaxException {
		payments.create(payment);
		
		Response response = null;
		try {
			response = Response
					.created(new URI("http://localhost:8080/payeasy/payments/payment/" + payment.getId()))
					.build();
		} catch (Exception e) {
			response = Response
					.serverError()
					.build();
		}
		return response;
	}
	
}
