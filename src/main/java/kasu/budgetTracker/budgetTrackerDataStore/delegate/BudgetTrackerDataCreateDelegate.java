package kasu.budgetTracker.budgetTrackerDataStore.delegate;

import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import kasu.budgetTracker.budgetTrackerDataStore.service.BudgetTrackerDataCreateSO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetTrackerDataCreateDelegate {

    @Autowired
    BudgetTrackerDataCreateSO budgetTrackerDataCreateSO;

    public void savePurchaseDataDelegate(NewPurchaseInputTO newPurchaseInputTo){
        budgetTrackerDataCreateSO.savePurchaseDataService(newPurchaseInputTo);
    }

    public void saveIncomeDataDelegate(NewIncomeAndTaxesInputTO newIncomeAndTaxesInputTo){
        budgetTrackerDataCreateSO.saveIncomeDataService(newIncomeAndTaxesInputTo);
    }

    public void saveInsuranceDataDelegate(NewInsuranceInputTO newInsuranceInputTo){
        budgetTrackerDataCreateSO.saveInsuranceDataService(newInsuranceInputTo);
    }

    public void saveLoansDataDelegate(NewLoanInputTO newLoanInputTo){
        budgetTrackerDataCreateSO.saveLoansDataService(newLoanInputTo);
    }

    public void saveNewBudgetAlarmDelegate(NewAlarmInputTO newAlarmInputTo){
        budgetTrackerDataCreateSO.saveAlarmsDataService(newAlarmInputTo);
    }
}
