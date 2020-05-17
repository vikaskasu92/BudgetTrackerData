package kasu.budgetTracker.budgetTrackerDataStore.service;

import kasu.budgetTracker.budgetTrackerDataStore.dao.BudgetTrackerDataRetrieveDAO;
import kasu.budgetTracker.budgetTrackerDataStore.email.RetrieveBudgetTrackerInitiateEmail;
import kasu.budgetTracker.budgetTrackerDataStore.model.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BudgetTrackerDataRetrieveSO implements  BudgetTrackerDataRetrieveService {

    @Autowired
    BudgetTrackerDataRetrieveDAO retrieveBudgetTrackerDataDAO;

    @Override
    public Map<String,Object> retrieveIncomeExpenseSummaryService(ExpenseIncomeSummaryInputTO inputTo) {
        return retrieveBudgetTrackerDataDAO.retrieveIncomeExpenseSummaryFromDB(inputTo);
    }

    @Override
    public YearlyExpenseSummaryTO retrieveYearlyExpenseSummaryService(YearlyExpenseSummaryInputTO inputTo) {
        return retrieveBudgetTrackerDataDAO.retrieveYearlyExpenseSummary(inputTo);
    }

    @Override
    public List<OverallPendingLoansTO> retrieveAllPendingLoansSummaryService(UserTO inputTo) {
        return retrieveBudgetTrackerDataDAO.retrievePendingLoansSummary(inputTo);
    }

    @Override
    public List<ExpenseByCategoryTO> retrieveExpenseByCategorySummaryService(ExpenseByCategorySummaryInputTO inputTo){
        return retrieveBudgetTrackerDataDAO.retrieveExpenseByCategorySummary(inputTo);
    }

    @Override
    public List<YearByYearExpenseCategoryTO> retrieveYearByYearExpenseCategoryService(YearByYearExpenseCategoryInputTO inputTo) {
        return retrieveBudgetTrackerDataDAO.retrieveYearByYearExpenseCategory(inputTo);
    }

    @Override
    public OpenClosedLoansTO retrieveAllOpenClosedLoansService(UserTO inputTo) {
        return retrieveBudgetTrackerDataDAO.retrieveAllOpenClosedLoans(inputTo);
    }

    @Override
    public List<AllYearsForCustomerTO> retrieveAllYearsForCustomerService(UserTO inputTo) {
        return retrieveBudgetTrackerDataDAO.retrieveAllYearsForCustomer(inputTo);
    }

    @Override
    public RawDataByInputAndDateResponseTO retrieveRawDataByInputAndDateService(RetrieveRawDataByInputAndDateTO retrieveRawDataByInputAndDateTO) {
        return retrieveBudgetTrackerDataDAO.retrieveRawDataByInputAndDate(retrieveRawDataByInputAndDateTO);
    }

    @Override
    public List<AllAlarmsResponseTO> retrieveAllAlarmsService(UserTO inputTo) {
        return retrieveBudgetTrackerDataDAO.retrieveAllAlarmsFromDB(inputTo);
    }

}
