package rocketBase;

import static org.junit.Assert.*;
import rocketBase.RateBLL;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	@Test
	public void rate_test_one() throws RateException{
		double InterestRate = RateBLL.getRate(700);
		assertTrue(InterestRate == 4);
	}

	@Test
	public void Rate_Exception_Test(){
		boolean thrown = false;
		
		try{
			RateBLL.getRate(100);
		} catch (RateException r){
			thrown = true;
		}
		assertTrue(thrown);		
	}
	@Test
	public void test() {
		assert(1==1);
	}

}
