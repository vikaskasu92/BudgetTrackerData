package kasu.budgetTracker.budgetTrackerDataStore.service;

import kasu.budgetTracker.budgetTrackerDataStore.dao.BudgetTrackerDataDeleteDAO;
import kasu.budgetTracker.budgetTrackerDataStore.model.DeleteByID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetTrackerDataDeleteSO implements BudgetTrackerDataDeleteService{

    @Autowired
    BudgetTrackerDataDeleteDAO budgetTrackerDataDeleteDAO;

    @Override
    public void deletePurchaseDataService(DeleteByID deleteById){
        budgetTrackerDataDeleteDAO.deletePurchaseDataFromDB(deleteById);
    }

    @Override
    public void deleteIncomeAndTaxesService(DeleteByID deleteById){
        budgetTrackerDataDeleteDAO.deleteIncomeDataFromDB(deleteById);
    }

    @Override
    public void deleteInsuranceDataService(DeleteByID deleteById){
        budgetTrackerDataDeleteDAO.deleteInsuranceDataFroDB(deleteById);
    }

    @Override
    public void deleteCustomerLoanService(DeleteByID deleteById){
        budgetTrackerDataDeleteDAO.deleteCustomerLoanDataFroDB(deleteById);
    }

    @Override
    public void deleteAlarmService(DeleteByID deleteById){
        budgetTrackerDataDeleteDAO.deleteAlarmsFromDB(deleteById);
    }

}
