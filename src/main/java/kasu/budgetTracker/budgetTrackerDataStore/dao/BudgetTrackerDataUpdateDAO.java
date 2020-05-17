package kasu.budgetTracker.budgetTrackerDataStore.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import kasu.budgetTracker.budgetTrackerDataStore.helper.BudgetTrackerDataHelper;
import kasu.budgetTracker.budgetTrackerDataStore.model.ChangeCustomerLoanStatusInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.InitiateAlarmInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdateCustomerLoanInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdateIncomeAndTaxesInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdateInsuranceInputTO;
import kasu.budgetTracker.budgetTrackerDataStore.model.UpdatePurchaseInputTO;

@Repository
public class BudgetTrackerDataUpdateDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(BudgetTrackerDataUpdateDAO.class);
	
	
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    BudgetTrackerDataHelper budgetTrackerDataHelper;

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
    @Value("${store.deleteAlarmTriggered}")
    private String deleteAlarmTriggered;

    public void updateCustomerLoanInDB(UpdateCustomerLoanInputTO updateCustomerLoanInputTo){
        try {
            jdbcTemplate.update(updateCustomerLoan,updateCustomerLoanInputTo.getLoanName(),updateCustomerLoanInputTo.getLoanType(),updateCustomerLoanInputTo.getLoanBalance(),updateCustomerLoanInputTo.getLoanAPR(),updateCustomerLoanInputTo.getLoanEMI(),updateCustomerLoanInputTo.getIdToDB());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updateInsuranceInDB(UpdateInsuranceInputTO updateInsuranceInputTo){
        try {
            jdbcTemplate.update(updateInsuranceDataQuery,updateInsuranceInputTo.getInsuranceType(),updateInsuranceInputTo.getInsurnacePaidAmount(), updateInsuranceInputTo.getInsurancePaidDateToDB(),updateInsuranceInputTo.getIdToDB());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updateIncomeInDB(UpdateIncomeAndTaxesInputTO updateIncomeAndTaxesInputTo){
        try {
            jdbcTemplate.update(updateIncomeDataQuery,updateIncomeAndTaxesInputTo.getDateRecievedToDB(), updateIncomeAndTaxesInputTo.getFederalTax(),updateIncomeAndTaxesInputTo.getStateTax(),updateIncomeAndTaxesInputTo.getMedicareTax(),updateIncomeAndTaxesInputTo.getSocialSecurityTax(),updateIncomeAndTaxesInputTo.getSalaryRecieved(),updateIncomeAndTaxesInputTo.getIdToDB());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updatePurchaseInDB(UpdatePurchaseInputTO updatePurchaseInputTo){
        try {
            jdbcTemplate.update(updatePurchasesDataQuery,updatePurchaseInputTo.getMainCategory(),updatePurchaseInputTo.getSubCategory(),updatePurchaseInputTo.getItem(),updatePurchaseInputTo.getDateToDB(),updatePurchaseInputTo.getCost(),updatePurchaseInputTo.getIdToDB());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updateLoanToClosedInDB(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
        try {
            jdbcTemplate.update(closeCustomerLoan,changeCustomerLoanStatusInputTo.getIdToDB());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updateLoanToOpenInDB(ChangeCustomerLoanStatusInputTO changeCustomerLoanStatusInputTo){
        try {
            jdbcTemplate.update(reOpenCustomerLoan,changeCustomerLoanStatusInputTo.getIdToDB());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    
    public Map<String,Object> initiateAlarmsCheck(InitiateAlarmInputTO initiateAlarmInputTO) {
        budgetTrackerDataHelper.updateInitiateAlarmInputTOWithDates(initiateAlarmInputTO);
        SimpleJdbcCall callSP = budgetTrackerDataHelper.callSPDR1(jdbcTemplate);
        SqlParameterSource sqlParameter = budgetTrackerDataHelper.generateStoredProcedureValues(initiateAlarmInputTO.getUser(),initiateAlarmInputTO.getFromDate(), initiateAlarmInputTO.getToDate());
        Map<String,Object> result = new HashMap<>();
        try {
            result = budgetTrackerDataHelper.retrieveFromDB(callSP,sqlParameter);
        }catch(DataAccessException e) {
            LOGGER.error("exception is "+e);
        }
        return result;
    }

    public void deleteAlarmTriggered(InitiateAlarmInputTO initiateAlarmInputTO) {
        try {
            jdbcTemplate.update(deleteAlarmTriggered, new Object[]{initiateAlarmInputTO.getId()});
        }catch(DataAccessException e) {
            LOGGER.error("exception is "+e);
        }
    }

}
