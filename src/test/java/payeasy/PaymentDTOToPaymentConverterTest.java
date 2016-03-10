package payeasy;

import static com.payeasy.payment.Intent.SALE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import com.payeasy.payment.Converter;
import com.payeasy.payment.Intent;
import com.payeasy.payment.Payment;
import com.payeasy.payment.PaymentMethod;
import com.payeasy.payment.converter.PaymentDTOToPaymentConverter;
import com.payeasy.payment.dto.PayerDTO;
import com.payeasy.payment.dto.PaymentDTO;

public class PaymentDTOToPaymentConverterTest {
	
	private Converter<PaymentDTO, Payment> converter;
	
	@Before
	public void before() {
		converter = new PaymentDTOToPaymentConverter();
	}

	@Test
	public void shouldConvertPaymentDTOInToPayment() throws Exception {
		PayerDTO payerDTO = PayerDTO.getBuilder()
			.withPaymentMethod(PaymentMethod.CREDIT_CARD)
			.build();
		
		PaymentDTO paymentDTO = PaymentDTO.getBuilder()
			.withIntent(Intent.SALE)
			.withPayer(payerDTO)
			.build();
		
		Payment payment = converter.convertFrom(paymentDTO);
		
		assertThat(payment.getIntent(), is(equalTo(SALE)));
	}
	
}
