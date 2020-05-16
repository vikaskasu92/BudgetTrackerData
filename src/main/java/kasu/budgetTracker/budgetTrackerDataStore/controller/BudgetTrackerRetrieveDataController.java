package kasu.budgetTracker.budgetTrackerDataStore.controller;

import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RETRIEVE_BUDGET_TRACKER_DATA;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RETRIEVE_INCOME_EXPENSE_SUMMARY;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RETRIEVE_YEARLY_EXPENSE_SUMMARY;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RETRIEVE_PENDING_LOANS_SUMMARY;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RETRIEVE_CATEGORIES_EXPENSE_SUMMARY;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RETRIEVE_YEAR_BY_YEAR_CATEGORY_EXPENSE;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RETRIEVE_OPEN_CLOSED_LOANS;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RETRIEVE_ALL_YEARS_FOR_CUSTOMER;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RETRIEVE_RAW_DATA_BY_INPUT_AND_DATE;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.RETRIEVE_ALL_ALARMS;
import static kasu.budgetTracker.budgetTrackerDataStore.util.BudgetTrackerDataStoreContants.CHECK_AND_INITIATE_ALARM;

import kasu.budgetTracker.budgetTrackerDataStore.delegate.BudgetTrackerDataRetrieveDelegate;
import kasu.budgetTracker.budgetTrackerDataStore.helper.BudgetTrackerDataHelper;
import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(RETRIEVE_BUDGET_TRACKER_DATA)
public class BudgetTrackerRetrieveDataController {

    @Autowired
    BudgetTrackerDataRetrieveDelegate retrieveBudgetTrackerDataDelegate;
    @Autowired
    BudgetTrackerDataHelper budgetTrackerDataHelper;


    @GetMapping(RETRIEVE_INCOME_EXPENSE_SUMMARY)
    public Map<String,Object> retrieveIncomeExpenseSummary(@RequestParam("username") String username, @RequestParam String fromDate, @RequestParam String toDate) {
        return retrieveBudgetTrackerDataDelegate.retrieveIncomeExpenseSummaryDelegate(budgetTrackerDataHelper.buildIncomeExpenseSummaryInputTo(username,fromDate,toDate));
    }

   @GetMapping(RETRIEVE_YEARLY_EXPENSE_SUMMARY)
    public YearlyExpenseSummaryTO retrieveYearlyExpenseSummary(@RequestParam("username") String username, @RequestParam String fromDate, @RequestParam String toDate) {
        return retrieveBudgetTrackerDataDelegate.retrieveYearlyExpenseSummaryDelegate(budgetTrackerDataHelper.yearlyExpenseInput(username,fromDate,toDate));
    }

    @GetMapping(RETRIEVE_PENDING_LOANS_SUMMARY)
    public List<OverallPendingLoansTO> retrievePendingLoansSummary(@RequestParam ("username") String username) {
        return retrieveBudgetTrackerDataDelegate.retrieveAllPendingLoansSummaryDelegate(budgetTrackerDataHelper.pendingLoansInput(username));
    }

    @GetMapping(RETRIEVE_CATEGORIES_EXPENSE_SUMMARY)
    public List<ExpenseByCategoryTO> retrieveCategoriesExpenseSummary(@RequestParam("username") String username, @RequestParam String category, @RequestParam String subCategory) {
        return retrieveBudgetTrackerDataDelegate.retrieveExpenseByCategorySummaryDelegate(budgetTrackerDataHelper.categoryByExpense(username, category, subCategory));
    }

    @GetMapping(RETRIEVE_YEAR_BY_YEAR_CATEGORY_EXPENSE)
    public List<YearByYearExpenseCategoryTO> retrieveYearByYearCategoryExpense(@RequestParam("username") String username, @RequestParam String fromDate, @RequestParam String toDate, @RequestParam String category) {
        return retrieveBudgetTrackerDataDelegate.retrieveYearByYearExpenseCategoryDelegate(budgetTrackerDataHelper.yearByYearExpenseCategory(username, fromDate, toDate, category));
    }

    @GetMapping(RETRIEVE_OPEN_CLOSED_LOANS)
    public OpenClosedLoansTO retrieveOpenClosedLoans(@RequestParam("username") String username) {
        return retrieveBudgetTrackerDataDelegate.retrieveAllOpenClosedLoansDelegate(budgetTrackerDataHelper.allOpenClosedLoans(username));
    }

    @GetMapping(RETRIEVE_ALL_YEARS_FOR_CUSTOMER)
    public List<AllYearsForCustomerTO> retrieveAllYearsForCustomer(@RequestParam("username") String username) {
        return retrieveBudgetTrackerDataDelegate.retrieveAllYearsForCustomerDelegate(budgetTrackerDataHelper.allYearsForCustomer(username));
    }

    @GetMapping(RETRIEVE_RAW_DATA_BY_INPUT_AND_DATE)
    public RawDataByInputAndDateResponseTO retrieveRawDataByInputAndDate(@RequestParam("username") String username, @RequestParam String inputType, @RequestParam String fromDate, @RequestParam String toDate, @RequestParam String minPage) {
        return retrieveBudgetTrackerDataDelegate.retrieveRawDataByInputAndDateDelegate(budgetTrackerDataHelper.retrieveRawDataByInputAndDate(username,inputType,fromDate,toDate,minPage));
    }

    @GetMapping(RETRIEVE_ALL_ALARMS)
    public List<AllAlarmsResponseTO> retrieveAllAlarms(@RequestParam("username") String username) {
        return retrieveBudgetTrackerDataDelegate.retrieveAllAlarmsDelegate(budgetTrackerDataHelper.retrieveAllAlarms(username));
    }

    @PostMapping(CHECK_AND_INITIATE_ALARM)
    public void checkAndInitiateAlarm(@RequestBody List<InitiateAlarmInputTO> initiateAlarmInputTO) {
        retrieveBudgetTrackerDataDelegate.initiateAlarmsDelegate(initiateAlarmInputTO);
    }

}
