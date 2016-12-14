package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@SuppressWarnings("static-access")
	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			try {
				lq.setdRate(_RateBLL.getRate(lq.getiCreditScore()));
			} catch (RateException r) {
				sendToAll(r);
				System.out.println("Invalid Credit Score, please try again.");
			}
			
			lq.setdPayment(_RateBLL.getPayment(lq.getdRate()/100, lq.getiTerm()* 12, lq.getdAmount()-lq.getiDownPayment(), 0.0, false));
			
			sendToAll(lq);
		}
	}
}