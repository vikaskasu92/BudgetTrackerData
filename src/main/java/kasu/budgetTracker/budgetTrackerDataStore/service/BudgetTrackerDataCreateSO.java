package kasu.budgetTracker.budgetTrackerDataStore.service;

import kasu.budgetTracker.budgetTrackerDataStore.dao.BudgetTrackerDataCreateDAO;
import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetTrackerDataCreateSO implements BudgetTrackerDataCreateService {

    @Autowired
    BudgetTrackerDataCreateDAO budgetTrackerDataCreateDAO;

    @Override
    public void savePurchaseDataService(NewPurchaseInputTO newPurchaseInputTo) {
        budgetTrackerDataCreateDAO.savePurchaseDataToDB(newPurchaseInputTo);
    }

    @Override
    public void saveIncomeDataService(NewIncomeAndTaxesInputTO newIncomeAndTaxesInputTo){
        budgetTrackerDataCreateDAO.saveIncomeDataToDB(newIncomeAndTaxesInputTo);
    }

    @Override
    public void saveInsuranceDataService(NewInsuranceInputTO newInsuranceInputTo){
        budgetTrackerDataCreateDAO.saveInsuranceDataToDB(newInsuranceInputTo);
    }

    @Override
    public void saveLoansDataService(NewLoanInputTO newLoanInputTo){
        budgetTrackerDataCreateDAO.saveInsuranceDataToDB(newLoanInputTo);
    }

    @Override
    public void saveAlarmsDataService(NewAlarmInputTO newAlarmInputTo){
        budgetTrackerDataCreateDAO.saveAlarmsDataToDB(newAlarmInputTo);
    }


}
