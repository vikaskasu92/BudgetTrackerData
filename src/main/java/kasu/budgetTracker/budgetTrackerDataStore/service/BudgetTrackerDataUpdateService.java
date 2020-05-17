package kasu.budgetTracker.budgetTrackerDataStore.service;

import kasu.budgetTracker.budgetTrackerDataStore.model.*;

public interface BudgetTrackerDataUpdateService {

    public void updateCustomerloanService(UpdateCustomerLoanInputTO updateCustomerLoanInputTo);

    public void updateInsuranceService(UpdateInsuranceInputTO updateInsuranceInputTo);

    public void updateIncomeService(UpdateIncomeAndTaxesInputTO updateIncomeAndTaxesInputTo);

    public void updatePurchaseService(UpdatePurchaseInputTO updatePurchaseInputTo);

    public void updateLoanStatusToCloseService(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo);

    public void updateLoanStatusToOpenService(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo);
    
    public void initiateAlarmsService(UserTO inputTo);

}
