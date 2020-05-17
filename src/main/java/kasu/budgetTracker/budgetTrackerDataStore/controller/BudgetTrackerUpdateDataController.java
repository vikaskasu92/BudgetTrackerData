package kasu.budgetTracker.budgetTrackerDataStore.controller;

import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.BUDGET_TRACKER_DATA_STORE;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.CLOSE_LOAN;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RE_OPEN_LOAN;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.UPDATE_INCOME_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.UPDATE_INSURANCE_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.UPDATE_LOAN;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.UPDATE_PURCHASE_DATA;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kasu.budgetTracker.budgetTrackerDataStore.delegate.BudgetTrackerDataUpdateDelegate;
import kasu.budgetTracker.budgetTrackerDataStore.model.ChangeCustomerLoanStatusInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdateCustomerLoanInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdateIncomeAndTaxesInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdateInsuranceInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdatePurchaseInputTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(BUDGET_TRACKER_DATA_STORE)
public class BudgetTrackerUpdateDataController {

    @Autowired
    BudgetTrackerDataUpdateDelegate budgetTrackerUpdateDelegate;

    @PostMapping(path=UPDATE_LOAN,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomerLoan(@ModelAttribute UpdateCustomerLoanInputTO updateCustomerLoanInputTo) {
        budgetTrackerUpdateDelegate.updateCustomerLoanDelegate(updateCustomerLoanInputTo);
    }

    @PostMapping(path=UPDATE_INSURANCE_DATA,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateInsuranceData(@ModelAttribute UpdateInsuranceInputTO updateInsuranceInputTo) {
        budgetTrackerUpdateDelegate.updateInsuranceDataDelegate(updateInsuranceInputTo);
    }

    @PostMapping(path=UPDATE_INCOME_DATA,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateIncomeData(@ModelAttribute UpdateIncomeAndTaxesInputTO updateIncomeAndTaxesInputTo) {
        budgetTrackerUpdateDelegate.updateIncomeDataDelegate(updateIncomeAndTaxesInputTo);
    }

    @PostMapping(path=UPDATE_PURCHASE_DATA,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updatePurchaseData(@ModelAttribute UpdatePurchaseInputTO updatePurchaseInputTo) {
        budgetTrackerUpdateDelegate.updatePurchaseDataDelegate(updatePurchaseInputTo);
    }

    @PostMapping(path=CLOSE_LOAN,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void closeCustomerLoan(@ModelAttribute ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo) {
        budgetTrackerUpdateDelegate.closeCustomerLoanDelegate(changeCustomerLoanStatusInputTo);
    }

    @PostMapping(path=RE_OPEN_LOAN,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void reOpenCustomerLoan(@ModelAttribute ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo) {
        budgetTrackerUpdateDelegate.reOpenCustomerLoanDelegate(changeCustomerLoanStatusInputTo);
    }

}
