package kasu.budgetTracker.budgetTrackerDataStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kasu.budgetTracker.budgetTrackerDataStore.dao.BudgetTrackerDataRetrieveDAO;
import kasu.budgetTracker.budgetTrackerDataStore.dao.BudgetTrackerDataUpdateDAO;
import kasu.budgetTracker.budgetTrackerDataStore.email.RetrieveBudgetTrackerInitiateEmail;
import kasu.budgetTracker.budgetTrackerDataStore.helper.BudgetTrackerDataHelper;
import kasu.budgetTracker.budgetTrackerDataStore.model.AllAlarmsResponseTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.ChangeCustomerLoanStatusInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.InitiateAlarmInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdateCustomerLoanInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdateIncomeAndTaxesInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdateInsuranceInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdatePurchaseInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UserTO;

@Service
public class BudgetTrackerDataUpdateSO implements  BudgetTrackerDataUpdateService {

    @Autowired
    BudgetTrackerDataUpdateDAO budgetTrackerDataUpdateDAO;
    @Autowired
    BudgetTrackerDataRetrieveDAO budgetTrackerDataRetrieveDAO;
    @Autowired
    BudgetTrackerDataHelper budgetTrackerDataHelper;
    @Autowired
    RetrieveBudgetTrackerInitiateEmail retrieveBudgetTrackerInitiateEmail;

    @Override
    public void updateCustomerloanService(UpdateCustomerLoanInputTO updateCustomerLoanInputTo){
    	updateCustomerLoanInputTo.setIdToDB(Integer.parseInt(updateCustomerLoanInputTo.getId()));
        budgetTrackerDataUpdateDAO.updateCustomerLoanInDB(updateCustomerLoanInputTo);
    }

    @Override
    public void updateInsuranceService(UpdateInsuranceInputTO updateInsuranceInputTo){
    	updateInsuranceInputTo.setIdToDB(Integer.parseInt(updateInsuranceInputTo.getId()));
    	updateInsuranceInputTo.setInsurancePaidDateToDB(budgetTrackerDataHelper.formatedDate(updateInsuranceInputTo.getInsurancePaidDate()));
        budgetTrackerDataUpdateDAO.updateInsuranceInDB(updateInsuranceInputTo);
    }

    @Override
    public void updateIncomeService(UpdateIncomeAndTaxesInputTO updateIncomeAndTaxesInputTo){
    	updateIncomeAndTaxesInputTo.setIdToDB(Integer.parseInt(updateIncomeAndTaxesInputTo.getId()));
    	updateIncomeAndTaxesInputTo.setDateRecievedToDB(budgetTrackerDataHelper.formatedDate(updateIncomeAndTaxesInputTo.getDateRecieved()));
        budgetTrackerDataUpdateDAO.updateIncomeInDB(updateIncomeAndTaxesInputTo);
    }

    @Override
    public void updatePurchaseService(UpdatePurchaseInputTO updatePurchaseInputTo){
    	updatePurchaseInputTo.setIdToDB(Integer.parseInt(updatePurchaseInputTo.getId()));
    	updatePurchaseInputTo.setDateToDB(budgetTrackerDataHelper.formatedDate(updatePurchaseInputTo.getDate()));
        budgetTrackerDataUpdateDAO.updatePurchaseInDB(updatePurchaseInputTo);
    }

    @Override
    public void updateLoanStatusToCloseService(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
    	setIdToDbForLoansOpenClose(changeCustomerLoanStatusInputTo);
    	changeCustomerLoanStatusInputTo.setIdToDB(Integer.parseInt(changeCustomerLoanStatusInputTo.getId()));
        budgetTrackerDataUpdateDAO.updateLoanToClosedInDB(changeCustomerLoanStatusInputTo);
    }

    @Override
    public void updateLoanStatusToOpenService(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
    	setIdToDbForLoansOpenClose(changeCustomerLoanStatusInputTo);
        budgetTrackerDataUpdateDAO.updateLoanToOpenInDB(changeCustomerLoanStatusInputTo);
    }
    
    @Override
    public void initiateAlarmsService(UserTO inputTo) {
    	List<AllAlarmsResponseTO> allAlarmsResponseTO = budgetTrackerDataRetrieveDAO.retrieveAllAlarmsFromDB(inputTo);
    	List<InitiateAlarmInputTO> initiateAlarmInputTO = new ArrayList<>();
    	for (int i = 0; i < initiateAlarmInputTO.size(); i++) {
    	     BeanUtils.copyProperties(initiateAlarmInputTO.get(i), allAlarmsResponseTO.get(i));
    	}
        for(InitiateAlarmInputTO inputTO:initiateAlarmInputTO) {
            if(!inputTO.isAlarmSent()) {
                checkForAlarmIntiation(budgetTrackerDataUpdateDAO.initiateAlarmsCheck(inputTO),inputTO);
            }
        }
    }

    private void checkForAlarmIntiation(Map<String,Object> result,InitiateAlarmInputTO initiateAlarmInputTO) {
        float expenses = (float) result.get("expenses");
        if(initiateAlarmInputTO.getBudgetAmount() < expenses){
            buildSubjectAndMessageForOverBudget(initiateAlarmInputTO,expenses);
            if(retrieveBudgetTrackerInitiateEmail.triggerEmailToClient(initiateAlarmInputTO.getBudgetEmail(),initiateAlarmInputTO.getSubject(),initiateAlarmInputTO.getMessage())) {
            	budgetTrackerDataUpdateDAO.deleteAlarmTriggered(initiateAlarmInputTO);
            }
        }
    }

    private void buildSubjectAndMessageForOverBudget(InitiateAlarmInputTO initiateAlarmInputTO, float expenses) {
        initiateAlarmInputTO.setSubject(initiateAlarmInputTO.getAlarmBy()+" spending limit crossed!");
        StringBuilder message = new StringBuilder();
        message.append("Hello User, Hope you are having a great day! ");
        message.append("You are recieving this e-mail from the Budget Tracker (VikasPortfolio) application as you have crossed the Budget limit of $"+initiateAlarmInputTO.getBudgetAmount()+". Your total expenses add's up to $"+expenses+" for the "+ initiateAlarmInputTO.getAlarmBy()+". ");
        message.append("This alarm will now be marked as complete and will be removed from the Budget Tracker application, please setup a new alarm, if you choose to do so. ");
        initiateAlarmInputTO.setMessage(message.toString());
    }
    
    private void setIdToDbForLoansOpenClose(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
    	changeCustomerLoanStatusInputTo.setIdToDB(Integer.parseInt(changeCustomerLoanStatusInputTo.getId()));
    }

}
