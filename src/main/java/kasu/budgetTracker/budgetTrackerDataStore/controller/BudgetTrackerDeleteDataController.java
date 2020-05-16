package kasu.budgetTracker.budgetTrackerDataStore.controller;

import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.BUDGET_TRACKER_DATA_STORE;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.DELETE_PURCHASE_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.DELETE_INCOME_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.DELETE_INSURANCE_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.DELETE_LOAN;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.DELETE_ALARM;

import kasu.budgetTracker.budgetTrackerDataStore.delegate.BudgetTrackerDataDeleteDelegate;
import kasu.budgetTracker.budgetTrackerDataStore.model.ChangeCustomerLoanStatusInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.DeleteByID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(BUDGET_TRACKER_DATA_STORE)
public class BudgetTrackerDeleteDataController {

    @Autowired
    BudgetTrackerDataDeleteDelegate budgetTrackerDeleteDelegate;

    @PostMapping(DELETE_PURCHASE_DATA)
    public void deletePurchaseData(@RequestBody @Valid DeleteByID deleteById) {
        budgetTrackerDeleteDelegate.deletePurchaseDataDelegate(deleteById);
    }

    @PostMapping(DELETE_INCOME_DATA)
    public void deleteIncomeData(@RequestBody @Valid DeleteByID deleteById) {
        budgetTrackerDeleteDelegate.deleteIncomeDataDelegate(deleteById);
    }

    @PostMapping(DELETE_INSURANCE_DATA)
    public void deleteInsuranceData(@RequestBody @Valid DeleteByID deleteById) {
        budgetTrackerDeleteDelegate.deleteInsuranceDataDelegate(deleteById);
    }

    @PostMapping(DELETE_LOAN)
    public void deleteCustomerLoan(@RequestBody @Valid DeleteByID deleteById) {
        budgetTrackerDeleteDelegate.deleteCustomerLoanDelegate(deleteById);
    }

    @PostMapping(DELETE_ALARM)
    public void deleteAlarm(@RequestBody @Valid DeleteByID deleteById) {
        budgetTrackerDeleteDelegate.deleteAlarmDelegate(deleteById);
    }

}
