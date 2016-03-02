package com.payeasy.payment;

public interface Converter<F, T> {

	T convertFrom(F t);
	
}
