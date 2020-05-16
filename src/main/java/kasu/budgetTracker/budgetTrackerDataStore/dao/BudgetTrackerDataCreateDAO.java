package kasu.budgetTracker.budgetTrackerDataStore.dao;

import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:DataStoreSQL.properties")
public class BudgetTrackerDataCreateDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${store.purchaseData}")
    private String storePurchaseDataQuery;
    @Value("${store.incomeData}")
    private String storeIncomeDataQuery;
    @Value("${store.insuranceData}")
    private String storeInsuranceDataQuery;
    @Value("${store.loanData}")
    private String storeLoanDataQuery;
    @Value("${store.BudgetAlarmData}")
    private String storeBudgetAlarmDataQuery;

    public void savePurchaseDataToDB(NewPurchaseInputTO newPurchaseInputTo){
        try {
            jdbcTemplate.update(storePurchaseDataQuery,newPurchaseInputTo.getUsername(),newPurchaseInputTo.getMainCategory(), newPurchaseInputTo.getSubCategory(), newPurchaseInputTo.getDate(),newPurchaseInputTo.getCost(),newPurchaseInputTo.getItem());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void saveIncomeDataToDB(NewIncomeAndTaxesInputTO newIncomeAndTaxesInputTo){
        try {
            jdbcTemplate.update(storeIncomeDataQuery, newIncomeAndTaxesInputTo.getUsername(), newIncomeAndTaxesInputTo.getDateRecieved(), newIncomeAndTaxesInputTo.getFederalTax(), newIncomeAndTaxesInputTo.getStateTax(), newIncomeAndTaxesInputTo.getMedicareTax(), newIncomeAndTaxesInputTo.getSocialSecurityTax(), newIncomeAndTaxesInputTo.getSalaryRecieved());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void saveInsuranceDataToDB(NewInsuranceInputTO newInsuranceInputTo){
        try {
            jdbcTemplate.update(storeInsuranceDataQuery,newInsuranceInputTo.getUsername(),newInsuranceInputTo.getInsuranceType(),newInsuranceInputTo.getInsurnacePaidAmount(), newInsuranceInputTo.getInsurancePaidDate());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void saveInsuranceDataToDB(NewLoanInputTO newLoanInputTo){
        try {
            jdbcTemplate.update(storeLoanDataQuery,newLoanInputTo.getUsername(),newLoanInputTo.getLoanType(),newLoanInputTo.getLoanName(),newLoanInputTo.getLoanBalance(),newLoanInputTo.getLoanEMI(),newLoanInputTo.getLoanAPR());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void saveAlarmsDataToDB(NewAlarmInputTO newAlarmInputTo){
        try {
            jdbcTemplate.update(storeBudgetAlarmDataQuery,newAlarmInputTo.getUsername(),newAlarmInputTo.getAlarmBy(),newAlarmInputTo.getBudgetEmail(),newAlarmInputTo.getBudgetAmount());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

}
