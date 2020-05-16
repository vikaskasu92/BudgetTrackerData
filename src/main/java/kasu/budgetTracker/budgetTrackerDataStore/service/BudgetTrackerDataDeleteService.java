package kasu.budgetTracker.budgetTrackerDataStore.service;

import kasu.budgetTracker.budgetTrackerDataStore.model.DeleteByID;

public interface BudgetTrackerDataDeleteService {

    public void deletePurchaseDataService(DeleteByID deleteById);

    public void deleteIncomeAndTaxesService(DeleteByID deleteById);

    public void deleteInsuranceDataService(DeleteByID deleteById);

    public void deleteCustomerLoanService(DeleteByID deleteById);

    public void deleteAlarmService(DeleteByID deleteById);

}
