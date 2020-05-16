package kasu.budgetTracker.budgetTrackerDataStore.service;

import kasu.budgetTracker.budgetTrackerDataStore.dao.BudgetTrackerDataRetrieveDAO;
import kasu.budgetTracker.budgetTrackerDataStore.email.RetrieveBudgetTrackerInitiateEmail;
import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BudgetTrackerDataRetrieveSO implements  BudgetTrackerDataRetrieveService {

    @Autowired
    BudgetTrackerDataRetrieveDAO retrieveBudgetTrackerDataDAO;
    @Autowired
    RetrieveBudgetTrackerInitiateEmail retrieveBudgetTrackerInitiateEmail;

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

    @Override
    public void initiateAlarmsService(List<InitiateAlarmInputTO> initiateAlarmInputTO) {
        List<Boolean> triggeredList = new ArrayList<>();
        for(InitiateAlarmInputTO inputTO:initiateAlarmInputTO) {
            if(!inputTO.isAlarmSent()) {
                checkForAlarmIntiation(retrieveBudgetTrackerDataDAO.initiateAlarmsCheck(inputTO),inputTO);
            }
        }
    }

    private void checkForAlarmIntiation(Map<String,Object> result,InitiateAlarmInputTO initiateAlarmInputTO) {
        float expenses = (float) result.get("expenses");
        if(initiateAlarmInputTO.getBudgetAmount() < expenses){
            buildSubjectAndMessageForOverBudget(initiateAlarmInputTO,expenses);
            if(retrieveBudgetTrackerInitiateEmail.triggerEmailToClient(initiateAlarmInputTO.getBudgetEmail(),initiateAlarmInputTO.getSubject(),initiateAlarmInputTO.getMessage())) {
                retrieveBudgetTrackerDataDAO.deleteAlarmTriggered(initiateAlarmInputTO);
            }
        }
    }

    private void buildSubjectAndMessageForOverBudget(InitiateAlarmInputTO initiateAlarmInputTO, float expenses) {
        initiateAlarmInputTO.setSubject(initiateAlarmInputTO.getAlarmBy()+" spending limit crossed!");
        StringBuilder message = new StringBuilder();
        message.append("Hello "+initiateAlarmInputTO.getUser()+", Hope you are having a great day! ");
        message.append("You are recieving this e-mail from the Budget Tracker (VikasPortfolio) application as you have crossed the Budget limit of $"+initiateAlarmInputTO.getBudgetAmount()+". Your total expenses add up to $"+expenses+" for the "+ initiateAlarmInputTO.getAlarmBy()+". ");
        message.append("This alarm will now be marked as complete will be removed from the Budget Tracker application, please setup a new alarm, if you choose to do so. ");
        initiateAlarmInputTO.setMessage(message.toString());
    }

}
