package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	private RateDomainModel R;

	public RateException(RateDomainModel r) {
		super();
		R = r;
	}

	public RateDomainModel getR() {
		return R;
	}
	
	
}