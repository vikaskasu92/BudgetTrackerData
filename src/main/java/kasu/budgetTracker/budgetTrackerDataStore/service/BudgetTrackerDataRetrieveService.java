package kasu.budgetTracker.budgetTrackerDataStore.service;

import kasu.budgetTracker.budgetTrackerDataStore.model.*;

import java.util.List;
import java.util.Map;

public interface BudgetTrackerDataRetrieveService {

    public Map<String,Object> retrieveIncomeExpenseSummaryService(ExpenseIncomeSummaryInputTO inputTo);

    public YearlyExpenseSummaryTO retrieveYearlyExpenseSummaryService(YearlyExpenseSummaryInputTO inputTo);

    public List<OverallPendingLoansTO> retrieveAllPendingLoansSummaryService(UserTO inputTo);

    public List<ExpenseByCategoryTO> retrieveExpenseByCategorySummaryService(ExpenseByCategorySummaryInputTO inputTo);

    public List<YearByYearExpenseCategoryTO> retrieveYearByYearExpenseCategoryService(YearByYearExpenseCategoryInputTO inputTo);

    public OpenClosedLoansTO retrieveAllOpenClosedLoansService(UserTO inputTo);

    public List<AllYearsForCustomerTO> retrieveAllYearsForCustomerService(UserTO inputTo);

    public RawDataByInputAndDateResponseTO retrieveRawDataByInputAndDateService(RetrieveRawDataByInputAndDateTO retrieveRawDataByInputAndDateTO);

    public List<AllAlarmsResponseTO> retrieveAllAlarmsService(UserTO inputTo);

    public void initiateAlarmsService(List<InitiateAlarmInputTO> initiateAlarmInputTO);

}
