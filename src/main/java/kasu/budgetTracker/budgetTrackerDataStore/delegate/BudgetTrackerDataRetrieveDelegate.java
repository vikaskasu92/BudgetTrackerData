package kasu.budgetTracker.budgetTrackerDataStore.delegate;

import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import kasu.budgetTracker.budgetTrackerDataStore.service.BudgetTrackerDataRetrieveSO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BudgetTrackerDataRetrieveDelegate {

    @Autowired
    BudgetTrackerDataRetrieveSO budgetTrackerDataRetrieveSo;

    public Map<String,Object> retrieveIncomeExpenseSummaryDelegate(ExpenseIncomeSummaryInputTO inputTo) {
        return budgetTrackerDataRetrieveSo.retrieveIncomeExpenseSummaryService(inputTo);
    }

    public YearlyExpenseSummaryTO retrieveYearlyExpenseSummaryDelegate(YearlyExpenseSummaryInputTO inputTo) {
        return budgetTrackerDataRetrieveSo.retrieveYearlyExpenseSummaryService(inputTo);
    }

    public List<OverallPendingLoansTO> retrieveAllPendingLoansSummaryDelegate(UserTO inputTo) {
        return budgetTrackerDataRetrieveSo.retrieveAllPendingLoansSummaryService(inputTo);
    }

    public List<ExpenseByCategoryTO> retrieveExpenseByCategorySummaryDelegate(ExpenseByCategorySummaryInputTO inputTo){
        return budgetTrackerDataRetrieveSo.retrieveExpenseByCategorySummaryService(inputTo);
    }

    public List<YearByYearExpenseCategoryTO> retrieveYearByYearExpenseCategoryDelegate(YearByYearExpenseCategoryInputTO inputTo) {
        return budgetTrackerDataRetrieveSo.retrieveYearByYearExpenseCategoryService(inputTo);
    }

    public OpenClosedLoansTO retrieveAllOpenClosedLoansDelegate(UserTO inputTo) {
        return budgetTrackerDataRetrieveSo.retrieveAllOpenClosedLoansService(inputTo);
    }

    public List<AllYearsForCustomerTO> retrieveAllYearsForCustomerDelegate(UserTO inputTo) {
        return budgetTrackerDataRetrieveSo.retrieveAllYearsForCustomerService(inputTo);
    }

    public RawDataByInputAndDateResponseTO retrieveRawDataByInputAndDateDelegate(RetrieveRawDataByInputAndDateTO retrieveRawDataByInputAndDateTO) {
        return budgetTrackerDataRetrieveSo.retrieveRawDataByInputAndDateService(retrieveRawDataByInputAndDateTO);
    }

    public List<AllAlarmsResponseTO> retrieveAllAlarmsDelegate(UserTO inputTo) {
        return budgetTrackerDataRetrieveSo.retrieveAllAlarmsService(inputTo);
    }

    public void initiateAlarmsDelegate(List<InitiateAlarmInputTO> initiateAlarmInputTO) {
        budgetTrackerDataRetrieveSo.initiateAlarmsService(initiateAlarmInputTO);
    }
}
