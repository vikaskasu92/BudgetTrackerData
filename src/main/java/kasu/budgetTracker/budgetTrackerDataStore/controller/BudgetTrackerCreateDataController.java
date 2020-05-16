package kasu.budgetTracker.budgetTrackerDataStore.controller;

import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.SAVE_PURCHASE_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.SAVE_INCOME_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.SAVE_INSURANCE_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.SAVE_LOANS_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.SAVE_BUDGET_ALARMS_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.BUDGET_TRACKER_DATA_STORE;

import kasu.budgetTracker.budgetTrackerDataStore.delegate.BudgetTrackerDataCreateDelegate;
import kasu.budgetTracker.budgetTrackerDataStore.helper.BudgetTrackerDataHelper;
import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(BUDGET_TRACKER_DATA_STORE)
public class BudgetTrackerCreateDataController {

    @Autowired
    BudgetTrackerDataCreateDelegate budgetTrackerCreateDelegate;
    @Autowired
    BudgetTrackerDataHelper budgetTrackerDataHelper;

    @PostMapping(SAVE_PURCHASE_DATA)
    public void savePurchaseData(@RequestBody @Valid NewPurchaseInputTO newPurchaseInputTo, @RequestParam String username) {
        budgetTrackerCreateDelegate.savePurchaseDataDelegate(budgetTrackerDataHelper.createSavePurchasesInput(newPurchaseInputTo,username));
    }

    @PostMapping(SAVE_INCOME_DATA)
    public void saveIncomeData(@RequestBody @Valid NewIncomeAndTaxesInputTO newIncomeAndTaxesInputTo, @RequestParam String username) {
        budgetTrackerCreateDelegate.saveIncomeDataDelegate(budgetTrackerDataHelper.createNewIncomeDataInput(newIncomeAndTaxesInputTo,username));
    }


    @PostMapping(SAVE_INSURANCE_DATA)
    public void saveInsuranceData(@RequestBody @Valid NewInsuranceInputTO newInsuranceInputTo, @RequestParam String username) {
        budgetTrackerCreateDelegate.saveInsuranceDataDelegate(budgetTrackerDataHelper.createNewInsuranceDataInput(newInsuranceInputTo,username));
    }

    @PostMapping(SAVE_LOANS_DATA)
    public void saveLoansData(@RequestBody @Valid NewLoanInputTO newLoanInputTo, @RequestParam String username) {
        budgetTrackerCreateDelegate.saveLoansDataDelegate(budgetTrackerDataHelper.createNewLoanInput(newLoanInputTo,username));
    }

    @PostMapping(SAVE_BUDGET_ALARMS_DATA)
    public void createNewBudgetAlarmInDB(@RequestBody @Valid NewAlarmInputTO newAlarmInputTo, @RequestParam String username) {
        budgetTrackerCreateDelegate.saveNewBudgetAlarmDelegate(budgetTrackerDataHelper.createNewAlarmInput(newAlarmInputTo,username));
    }

}
