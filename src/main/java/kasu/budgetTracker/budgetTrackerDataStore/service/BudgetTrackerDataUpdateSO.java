package kasu.budgetTracker.budgetTrackerDataStore.service;

import kasu.budgetTracker.budgetTrackerDataStore.dao.BudgetTrackerDataUpdateDAO;
import kasu.budgetTracker.budgetTrackerDataStore.helper.BudgetTrackerDataHelper;
import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetTrackerDataUpdateSO implements  BudgetTrackerDataUpdateService {

    @Autowired
    BudgetTrackerDataUpdateDAO budgetTrackerDataUpdateDAO;
    @Autowired
    BudgetTrackerDataHelper budgetTrackerDataHelper;

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
    
    private void setIdToDbForLoansOpenClose(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
    	changeCustomerLoanStatusInputTo.setIdToDB(Integer.parseInt(changeCustomerLoanStatusInputTo.getId()));
    }

}
