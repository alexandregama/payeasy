package com.payeasy.payment;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class HibernatePaymentsDao implements Payments {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Payment create(Payment payment) {
		manager.persist(payment);
		
		return payment;
	}

}
