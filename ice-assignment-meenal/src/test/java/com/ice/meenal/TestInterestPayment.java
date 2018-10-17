package com.ice.meenal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class TestInterestPayment {
	//current payment 
	static Payment currentPayment = new Payment(12,new BigDecimal("1.5") ); 
	InterestPayment iPay = new InterestPayment(currentPayment);
	
	
	@Test
	public void testUpdatePaymentTrue() {
		Payment newPayment = new Payment(17, new BigDecimal("1.5"));
		assertTrue(iPay.updatePayment(newPayment));
	}
	
	@Test
	public void testUpdatePaymentFalse() {
		Payment newPayment = new Payment(27, new BigDecimal("1.5"));
		assertFalse(iPay.updatePayment(newPayment));
	}
	
	@Test(expected = NumberFormatException.class)
	public void testUpdatePaymentExpectedException() {
		Payment newPayment = new Payment(27, new BigDecimal(""));
		assertTrue(iPay.updatePayment(newPayment));
	}
	
	@Test
	public void testUpdatePaymentThrowException() {
		Payment newPayment = new Payment(17, new BigDecimal(""));
		assertTrue(iPay.updatePayment(newPayment));
	}
	
}
