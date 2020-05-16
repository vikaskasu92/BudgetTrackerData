package kasu.budgetTracker.budgetTrackerDataStore.dao;

import kasu.budgetTracker.budgetTrackerDataStore.model.DeleteByID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BudgetTrackerDataDeleteDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${store.deletePurchases}")
    private String deletePurchasesDataQuery;
    @Value("${store.deleteIncomeData}")
    private String deleteIncomeDataQuery;
    @Value("${store.deleteInsuranceData}")
    private String deleteInsuranceDataQuery;
    @Value("${store.deleteCustomerLoan}")
    private String deleteCustomerLoan;
    @Value("${store.deleteAlarmFromDB}")
    private String deleteAlarmFromDB;

    public void deletePurchaseDataFromDB(DeleteByID deleteById){
        try {
            jdbcTemplate.update(deletePurchasesDataQuery,deleteById.getDeleteById());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteIncomeDataFromDB(DeleteByID deleteById){
        try {
            jdbcTemplate.update(deleteIncomeDataQuery,deleteById.getDeleteById());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteInsuranceDataFroDB(DeleteByID deleteById){
        try {
            jdbcTemplate.update(deleteInsuranceDataQuery,deleteById.getDeleteById());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomerLoanDataFroDB(DeleteByID deleteById){
        try {
            jdbcTemplate.update(deleteCustomerLoan,deleteById.getDeleteById());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteAlarmsFromDB(DeleteByID deleteById){
        try {
            jdbcTemplate.update(deleteAlarmFromDB,deleteById.getDeleteById());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
