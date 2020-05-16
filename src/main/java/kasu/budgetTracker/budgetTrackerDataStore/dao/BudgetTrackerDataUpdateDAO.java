package kasu.budgetTracker.budgetTrackerDataStore.dao;

import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BudgetTrackerDataUpdateDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${store.updateCustomerLoan}")
    private String updateCustomerLoan;
    @Value("${store.updateInsurance}")
    private String updateInsuranceDataQuery;
    @Value("${store.updateIncomeData}")
    private String updateIncomeDataQuery;
    @Value("${store.updatePurchases}")
    private String updatePurchasesDataQuery;
    @Value("${store.closeCustomerLoan}")
    private String closeCustomerLoan;
    @Value("${store.reOpenCustomerLoan}")
    private String reOpenCustomerLoan;

    public void updateCustomerLoanInDB(UpdateCustomerLoanInputTO updateCustomerLoanInputTo){
        try {
            jdbcTemplate.update(updateCustomerLoan,updateCustomerLoanInputTo.getLoanName(),updateCustomerLoanInputTo.getLoanType(),updateCustomerLoanInputTo.getLoanBalance(),updateCustomerLoanInputTo.getLoanAPR(),updateCustomerLoanInputTo.getLoanEMI(),updateCustomerLoanInputTo.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updateInsuranceInDB(UpdateInsuranceInputTO updateInsuranceInputTo){
        try {
            jdbcTemplate.update(updateInsuranceDataQuery,updateInsuranceInputTo.getInsuranceType(),updateInsuranceInputTo.getInsurnacePaidAmount(), updateInsuranceInputTo.getInsurancePaidDate(),updateInsuranceInputTo.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updateIncomeInDB(UpdateIncomeAndTaxesInputTO updateIncomeAndTaxesInputTo){
        try {
            jdbcTemplate.update(updateIncomeDataQuery,updateIncomeAndTaxesInputTo.getDateRecieved(), updateIncomeAndTaxesInputTo.getFederalTax(),updateIncomeAndTaxesInputTo.getStateTax(),updateIncomeAndTaxesInputTo.getMedicareTax(),updateIncomeAndTaxesInputTo.getSocialSecurityTax(),updateIncomeAndTaxesInputTo.getSalaryRecieved(),updateIncomeAndTaxesInputTo.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updatePurchaseInDB(UpdatePurchaseInputTO updatePurchaseInputTo){
        try {
            jdbcTemplate.update(updatePurchasesDataQuery,updatePurchaseInputTo.getMainCategory(),updatePurchaseInputTo.getSubCategory(),updatePurchaseInputTo.getItem(),updatePurchaseInputTo.getDate(),updatePurchaseInputTo.getCost(),updatePurchaseInputTo.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updateLoanToClosedInDB(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
        try {
            jdbcTemplate.update(closeCustomerLoan,changeCustomerLoanStatusInputTo.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updateLoanToOpenInDB(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
        try {
            jdbcTemplate.update(reOpenCustomerLoan,changeCustomerLoanStatusInputTo.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

}
