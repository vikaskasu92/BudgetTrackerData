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
import org.springframework.http.MediaType;
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

    @PostMapping(path=SAVE_PURCHASE_DATA,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void savePurchaseData(@ModelAttribute NewPurchaseInputTO newPurchaseInputTo, @RequestParam String username) {
        budgetTrackerCreateDelegate.savePurchaseDataDelegate(budgetTrackerDataHelper.createSavePurchasesInput(newPurchaseInputTo,username));
    }

    @PostMapping(path=SAVE_INCOME_DATA,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveIncomeData(@ModelAttribute NewIncomeAndTaxesInputTO newIncomeAndTaxesInputTo, @RequestParam String username) {
        budgetTrackerCreateDelegate.saveIncomeDataDelegate(budgetTrackerDataHelper.createNewIncomeDataInput(newIncomeAndTaxesInputTo,username));
    }


    @PostMapping(path=SAVE_INSURANCE_DATA,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveInsuranceData(@ModelAttribute NewInsuranceInputTO newInsuranceInputTo, @RequestParam String username) {
        budgetTrackerCreateDelegate.saveInsuranceDataDelegate(budgetTrackerDataHelper.createNewInsuranceDataInput(newInsuranceInputTo,username));
    }

    @PostMapping(path=SAVE_LOANS_DATA,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveLoansData(@ModelAttribute NewLoanInputTO newLoanInputTo, @RequestParam String username) {
        budgetTrackerCreateDelegate.saveLoansDataDelegate(budgetTrackerDataHelper.createNewLoanInput(newLoanInputTo,username));
    }

    @PostMapping(path=SAVE_BUDGET_ALARMS_DATA,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createNewBudgetAlarmInDB(@ModelAttribute NewAlarmInputTO newAlarmInputTo, @RequestParam String username) {
        budgetTrackerCreateDelegate.saveNewBudgetAlarmDelegate(budgetTrackerDataHelper.createNewAlarmInput(newAlarmInputTo,username));
    }

}
