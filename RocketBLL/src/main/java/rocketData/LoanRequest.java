package rocketData;

import java.io.Serializable;

public class LoanRequest implements Serializable {

	private int iTerm;
	private double dRate;
	private double dAmount;
	private int iCreditScore;
	private double iDownPayment;
	private double dPayment;
	private double income;
	private double expenses;
	
	public LoanRequest() {
		super();
	}
	public int getiTerm() {
		return iTerm;
	}
	public void setiTerm(int iTerm) {
		this.iTerm = iTerm;
	}
	public double getdRate() {
		return dRate;
	}
	public void setdRate(double dRate) {
		this.dRate = dRate;
	}
	public double getdAmount() {
		return dAmount;
	}
	public void setdAmount(double dAmount) {
		this.dAmount = dAmount;
	}
	public int getiCreditScore() {
		return iCreditScore;
	}
	public void setiCreditScore(int txtCreditScore) {
		this.iCreditScore = txtCreditScore;
	}
	public double getiDownPayment() {
		return iDownPayment;
	}
	public void setiDownPayment(double txtDownPayment) {
		this.iDownPayment = txtDownPayment;
	}
	public double getdPayment() {
		return dPayment;
	}
	public void setdPayment(double dPayment) {
		this.dPayment = dPayment;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getExpenses() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	
	
}