package rocket.app.view;

import java.text.DecimalFormat;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;

	private double txtIncome;
	private double txtExpenses;
	private int txtCreditScore;
	private double txtHouseCost;
	private double txtDownPayment;
	private String lblMortgagePayment;
	
	private ObservableList<Integer> termOptions = FXCollections.observableArrayList(15,30);
	final ComboBox<Integer> cmbTerm = new ComboBox<Integer>(termOptions);
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;

		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();

		lq.setExpenses(txtExpenses);
		lq.setiCreditScore(txtCreditScore);
		lq.setiDownPayment(txtDownPayment);
		lq.setIncome(txtIncome);
		lq.setiTerm(cmbTerm.getValue());
		lq.setdAmount(txtHouseCost-txtDownPayment);
		
		a.setLoanRequest(lq);
			
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		double calcPmt = lRequest.getdPayment();
		double PITI28 = lRequest.getIncome()*0.28;
		double PITI36 = lRequest.getiCreditScore()*0.36-lRequest.getExpenses();
		
		if (calcPmt>PITI28 | calcPmt>PITI36){
			lblMortgagePayment = "House cost too high.";
		}
		
		else{
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			String calcPmtStr = decimalFormat.format(calcPmt);
			lblMortgagePayment = calcPmtStr;
		}
		
	}
}