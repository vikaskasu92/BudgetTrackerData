package kasu.budgetTracker.budgetTrackerDataStore.controller;

import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.BUDGET_TRACKER_DATA_STORE;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.UPDATE_LOAN;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.UPDATE_INSURANCE_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.UPDATE_INCOME_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.UPDATE_PURCHASE_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.CLOSE_LOAN;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RE_OPEN_LOAN;

import kasu.budgetTracker.budgetTrackerDataStore.delegate.BudgetTrackerDataUpdateDelegate;
import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(BUDGET_TRACKER_DATA_STORE)
public class BudgetTrackerUpdateDataController {

    @Autowired
    BudgetTrackerDataUpdateDelegate budgetTrackerUpdateDelegate;

    @PutMapping(UPDATE_LOAN)
    public void updateCustomerLoan(@RequestBody @Valid UpdateCustomerLoanInputTO updateCustomerLoanInputTo) {
        budgetTrackerUpdateDelegate.updateCustomerLoanDelegate(updateCustomerLoanInputTo);
    }

    @PutMapping(UPDATE_INSURANCE_DATA)
    public void updateInsuranceData(@RequestBody @Valid UpdateInsuranceInputTO updateInsuranceInputTo) {
        budgetTrackerUpdateDelegate.updateInsuranceDataDelegate(updateInsuranceInputTo);
    }

    @PutMapping(UPDATE_INCOME_DATA)
    public void updateIncomeData(@RequestBody @Valid UpdateIncomeAndTaxesInputTO updateIncomeAndTaxesInputTo) {
        budgetTrackerUpdateDelegate.updateIncomeDataDelegate(updateIncomeAndTaxesInputTo);
    }

    @PutMapping(UPDATE_PURCHASE_DATA)
    public void updatePurchaseData(@RequestBody @Valid UpdatePurchaseInputTO updatePurchaseInputTo) {
        budgetTrackerUpdateDelegate.updatePurchaseDataDelegate(updatePurchaseInputTo);
    }

    @PatchMapping(CLOSE_LOAN)
    public void closeCustomerLoan(@RequestBody @Valid ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo) {
        budgetTrackerUpdateDelegate.closeCustomerLoanDelegate(changeCustomerLoanStatusInputTo);
    }

    @PatchMapping(RE_OPEN_LOAN)
    public void reOpenCustomerLoan(@RequestBody @Valid ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo) {
        budgetTrackerUpdateDelegate.reOpenCustomerLoanDelegate(changeCustomerLoanStatusInputTo);
    }

}
