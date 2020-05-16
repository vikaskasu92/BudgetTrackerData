package kasu.budgetTracker.budgetTrackerDataStore.service;

import kasu.budgetTracker.budgetTrackerDataStore.dao.BudgetTrackerDataUpdateDAO;
import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetTrackerDataUpdateSO implements  BudgetTrackerDataUpdateService {

    @Autowired
    BudgetTrackerDataUpdateDAO budgetTrackerDataUpdateDAO;

    @Override
    public void updateCustomerloanService(UpdateCustomerLoanInputTO updateCustomerLoanInputTo){
        budgetTrackerDataUpdateDAO.updateCustomerLoanInDB(updateCustomerLoanInputTo);
    }

    @Override
    public void updateInsuranceService(UpdateInsuranceInputTO updateInsuranceInputTo){
        budgetTrackerDataUpdateDAO.updateInsuranceInDB(updateInsuranceInputTo);
    }

    @Override
    public void updateIncomeService(UpdateIncomeAndTaxesInputTO updateIncomeAndTaxesInputTo){
        budgetTrackerDataUpdateDAO.updateIncomeInDB(updateIncomeAndTaxesInputTo);
    }

    @Override
    public void updatePurchaseService(UpdatePurchaseInputTO updatePurchaseInputTo){
        budgetTrackerDataUpdateDAO.updatePurchaseInDB(updatePurchaseInputTo);
    }

    @Override
    public void updateLoanStatusToCloseService(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
        budgetTrackerDataUpdateDAO.updateLoanToClosedInDB(changeCustomerLoanStatusInputTo);
    }

    @Override
    public void updateLoanStatusToOpenService(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
        budgetTrackerDataUpdateDAO.updateLoanToOpenInDB(changeCustomerLoanStatusInputTo);
    }

}
