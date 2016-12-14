package rocketBase;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	private static double iRate;
	
	public static double getRate(int GivenCreditScore) throws RateException
	{
		ArrayList<RateDomainModel> RateArray = RateDAL.getAllRates();
		
		for (RateDomainModel RDM : RateArray){
			if (RDM.getiMinCreditScore() == GivenCreditScore){
				iRate = RDM.getdInterestRate();
			}
		}
		return iRate;
		
		
	}
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}


