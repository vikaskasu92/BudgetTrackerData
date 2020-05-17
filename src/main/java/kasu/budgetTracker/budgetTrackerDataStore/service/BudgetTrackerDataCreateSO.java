package kasu.budgetTracker.budgetTrackerDataStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kasu.budgetTracker.budgetTrackerDataStore.dao.BudgetTrackerDataCreateDAO;
import kasu.budgetTracker.budgetTrackerDataStore.helper.BudgetTrackerDataHelper;
import kasu.budgetTracker.budgetTrackerDataStore.model.NewAlarmInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.NewIncomeAndTaxesInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.NewInsuranceInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.NewLoanInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.NewPurchaseInputTO;

@Service
public class BudgetTrackerDataCreateSO implements BudgetTrackerDataCreateService {

    @Autowired
    BudgetTrackerDataCreateDAO budgetTrackerDataCreateDAO;
    @Autowired
    BudgetTrackerDataHelper budgetTrackerDataHelper;

    @Override
    public void savePurchaseDataService(NewPurchaseInputTO newPurchaseInputTo) {
    	newPurchaseInputTo.setDateToDB(budgetTrackerDataHelper.formatedDate(newPurchaseInputTo.getDate()));
        budgetTrackerDataCreateDAO.savePurchaseDataToDB(newPurchaseInputTo);
    }

    @Override
    public void saveIncomeDataService(NewIncomeAndTaxesInputTO newIncomeAndTaxesInputTo){
    	newIncomeAndTaxesInputTo.setDateRecievedToDB(budgetTrackerDataHelper.formatedDate(newIncomeAndTaxesInputTo.getDateRecieved()));
        budgetTrackerDataCreateDAO.saveIncomeDataToDB(newIncomeAndTaxesInputTo);
    }

    @Override
    public void saveInsuranceDataService(NewInsuranceInputTO newInsuranceInputTo){
    	newInsuranceInputTo.setInsurancePaidDateToDB(budgetTrackerDataHelper.formatedDate(newInsuranceInputTo.getInsurancePaidDate()));
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
