package kasu.budgetTracker.budgetTrackerDataStore.service;

import kasu.budgetTracker.budgetTrackerDataStore.model.*;

public interface BudgetTrackerDataCreateService {

    public void savePurchaseDataService(NewPurchaseInputTO newPurchaseInputTo);

    public void saveIncomeDataService(NewIncomeAndTaxesInputTO newIncomeAndTaxesInputTo);

    public void saveInsuranceDataService(NewInsuranceInputTO newInsuranceInputTo);

    public void saveLoansDataService(NewLoanInputTO newLoanInputTo);

    public void saveAlarmsDataService(NewAlarmInputTO newAlarmInputTo);
}
