package kasu.budgetTracker.budgetTrackerDataStore.delegate;

import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import kasu.budgetTracker.budgetTrackerDataStore.service.BudgetTrackerDataUpdateSO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetTrackerDataUpdateDelegate {

    @Autowired
    BudgetTrackerDataUpdateSO budgetTrackerDataUpdateSO;

    public void updateCustomerLoanDelegate(UpdateCustomerLoanInputTO updateCustomerLoanInputTo){
        budgetTrackerDataUpdateSO.updateCustomerloanService(updateCustomerLoanInputTo);
    }

    public void updateInsuranceDataDelegate(UpdateInsuranceInputTO updateInsuranceInputTo){
        budgetTrackerDataUpdateSO.updateInsuranceService(updateInsuranceInputTo);
    }

    public void updateIncomeDataDelegate(UpdateIncomeAndTaxesInputTO updateIncomeAndTaxesInputTo){
        budgetTrackerDataUpdateSO.updateIncomeService(updateIncomeAndTaxesInputTo);
    }

    public void updatePurchaseDataDelegate(UpdatePurchaseInputTO updatePurchaseInputTo){
        budgetTrackerDataUpdateSO.updatePurchaseService(updatePurchaseInputTo);
    }

    public void closeCustomerLoanDelegate(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
        budgetTrackerDataUpdateSO.updateLoanStatusToCloseService(changeCustomerLoanStatusInputTo);
    }

    public void reOpenCustomerLoanDelegate(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
        budgetTrackerDataUpdateSO.updateLoanStatusToOpenService(changeCustomerLoanStatusInputTo);
    }
    
    public void initiateAlarmsDelegate(UserTO inputTo) {
    	budgetTrackerDataUpdateSO.initiateAlarmsService(inputTo);
    }

}
