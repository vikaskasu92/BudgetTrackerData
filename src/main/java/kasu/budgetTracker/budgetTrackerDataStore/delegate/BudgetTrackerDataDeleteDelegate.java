package kasu.budgetTracker.budgetTrackerDataStore.delegate;

import kasu.budgetTracker.budgetTrackerDataStore.model.DeleteByID;
import kasu.budgetTracker.budgetTrackerDataStore.service.BudgetTrackerDataDeleteSO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetTrackerDataDeleteDelegate {

    @Autowired
    BudgetTrackerDataDeleteSO budgetTrackerDataDeleteService;

    public void deletePurchaseDataDelegate(DeleteByID deleteById){
        budgetTrackerDataDeleteService.deletePurchaseDataService(deleteById);
    }

    public void deleteIncomeDataDelegate(DeleteByID deleteById){
        budgetTrackerDataDeleteService.deleteIncomeAndTaxesService(deleteById);
    }

    public void deleteInsuranceDataDelegate(DeleteByID deleteById){
        budgetTrackerDataDeleteService.deleteInsuranceDataService(deleteById);
    }

    public void deleteCustomerLoanDelegate(DeleteByID deleteById){
        budgetTrackerDataDeleteService.deleteCustomerLoanService(deleteById);
    }

    public void deleteAlarmDelegate(DeleteByID deleteById){
        budgetTrackerDataDeleteService.deleteAlarmService(deleteById);
    }

}
