package kasu.budgetTracker.budgetTrackerDataStore.dao;

import kasu.budgetTracker.budgetTrackerDataStore.helper.BudgetTrackerDataHelper;
import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BudgetTrackerDataRetrieveDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(BudgetTrackerDataRetrieveDAO.class);

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    BudgetTrackerDataHelper budgetTrackerDataHelper;
    @Autowired
    OpenClosedLoansTO openClosedLoansTO;

    @Value("${retrieve.yearlyExpensesSummary}")
    private String retrieveYearlyExpensesSummary;
    @Value("${retrieve.allPendingLoansSummary}")
    private String retrieveAllPendingLoansSummary;
    @Value("${retrieve.expensesByCategorySummary}")
    private String retrieveExpensesByCategorySummary;
    @Value("${retrieve.yearByYearCategory}")
    private String retrieveYearByYearExpenseCategory;
    @Value("${retrieve.allOpenLoans}")
    private String retrieveAllOpenLoans;
    @Value("${retrieve.allClosedLoans}")
    private String retrieveAllClosedLoans;
    @Value("${retrieve.allYearsForCustomer}")
    private String retrieveAllYearsForCustomer;
    @Value("${retrieve.rawDataByPurchaseByDate}")
    private String retrieveRawDataByPurchaseAndDate;
    @Value("${retrieve.rawDataByPurchaseByDateCount}")
    private String retrieveRawDataByPurchaseAndDateCount;
    @Value("${retrieve.rawDataByIncomeByDate}")
    private String retrieveRawDataByIncomeAndDate;
    @Value("${retrieve.rawDataByIncomeByDateCount}")
    private String retrieveRawDataByIncomeAndDateCount;
    @Value("${retrieve.rawDataByInsuranceByDate}")
    private String retrieveRawDataByInsuranceAndDate;
    @Value("${retrieve.rawDataByInsuranceByDateCount}")
    private String retrieveRawDataByInsuranceAndDateCount;
    @Value("${retrieve.retrieveAllAlarms}")
    private String retrieveAllAlarms;


    public Map<String,Object> retrieveIncomeExpenseSummaryFromDB(ExpenseIncomeSummaryInputTO inputTo) {
        SimpleJdbcCall callSP = budgetTrackerDataHelper.callSPDR1(jdbcTemplate);
        SqlParameterSource sqlParameter = budgetTrackerDataHelper.generateStoredProcedureValues(inputTo.getUsername(),inputTo.getFromDate(), inputTo.getToDate());
        Map<String,Object> result = new HashMap<>();
        try {
            result = budgetTrackerDataHelper.retrieveFromDB(callSP,sqlParameter);
        }catch(DataAccessException e) {
            LOGGER.error("exception is "+e);
        }
        return result;
    }

    public YearlyExpenseSummaryTO retrieveYearlyExpenseSummary(YearlyExpenseSummaryInputTO inputTo) {
        YearlyExpenseSummaryTO yearlyExpenseSummaryTO = new YearlyExpenseSummaryTO();
        try {
            yearlyExpenseSummaryTO.setYearlyExpenseSummary(jdbcTemplate.query(retrieveYearlyExpensesSummary, new Object[]{inputTo.getStartYear(),inputTo.getEndYear(),inputTo.getUsername()}, new RetrieveYearlyExpenseRowMapper()));
        }catch(DataAccessException e) {
            LOGGER.error("exception is "+e);
        }
        yearlyExpenseSummaryTO.setStartYear(inputTo.getStartYear());
        yearlyExpenseSummaryTO.setEndYear(inputTo.getEndYear());
        return yearlyExpenseSummaryTO;
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public List<OverallPendingLoansTO> retrievePendingLoansSummary(UserTO inputTo) {
        List<OverallPendingLoansTO> overallPendingLoansTO = new ArrayList<OverallPendingLoansTO>();
        try {
            overallPendingLoansTO = jdbcTemplate.query(retrieveAllPendingLoansSummary, new Object[]{inputTo.getUsername()}, new BeanPropertyRowMapper(OverallPendingLoansTO.class));
        }catch(DataAccessException e) {
            LOGGER.error("exception is "+e);
        }
        return overallPendingLoansTO;
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public List<ExpenseByCategoryTO> retrieveExpenseByCategorySummary(ExpenseByCategorySummaryInputTO inputTo) {
        List<ExpenseByCategoryTO> expenseByCategoryTO = new ArrayList<ExpenseByCategoryTO>();
        try {
            expenseByCategoryTO = jdbcTemplate.query(retrieveExpensesByCategorySummary, new Object[]{inputTo.getUsername(),inputTo.getCategory(),inputTo.getSubCategory()}, new BeanPropertyRowMapper(ExpenseByCategoryTO.class));
        }catch(DataAccessException e) {
            LOGGER.error("exception is "+e);
        }
        return expenseByCategoryTO;
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public List<YearByYearExpenseCategoryTO> retrieveYearByYearExpenseCategory(YearByYearExpenseCategoryInputTO inputTo) {
        List<YearByYearExpenseCategoryTO> yearByYearExpenseCategoryTO = new ArrayList<YearByYearExpenseCategoryTO>();
        try {
            yearByYearExpenseCategoryTO = jdbcTemplate.query(retrieveYearByYearExpenseCategory, new Object[]{inputTo.getUsername(),inputTo.getFromDate(),inputTo.getToDate(),inputTo.getCategory()}, new BeanPropertyRowMapper(YearByYearExpenseCategoryTO.class));
        }catch(DataAccessException e) {
            LOGGER.error("exception is "+e);
        }
        return yearByYearExpenseCategoryTO;
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public OpenClosedLoansTO retrieveAllOpenClosedLoans(UserTO inputTo) {
        List<OpenLoansTO> openLoansTO = new ArrayList<OpenLoansTO>();
        List<ClosedLoansTO> closedLoansTO = new ArrayList<ClosedLoansTO>();
        try {
            openLoansTO = jdbcTemplate.query(retrieveAllOpenLoans, new Object[]{inputTo.getUsername()}, new BeanPropertyRowMapper(OpenLoansTO.class));
            closedLoansTO = jdbcTemplate.query(retrieveAllClosedLoans, new Object[]{inputTo.getUsername()}, new BeanPropertyRowMapper(ClosedLoansTO.class));
        }catch(DataAccessException e) {
            LOGGER.error("exception is "+e);
        }
        openClosedLoansTO.setOpenLoans(openLoansTO);
        openClosedLoansTO.setClosedLoans(closedLoansTO);
        return openClosedLoansTO;
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public List<AllYearsForCustomerTO> retrieveAllYearsForCustomer(UserTO inputTo) {
        List<AllYearsForCustomerTO> allYearsForCustomerTO = new ArrayList<>();
        try {
            allYearsForCustomerTO = jdbcTemplate.query(retrieveAllYearsForCustomer, new Object[]{inputTo.getUsername()}, new BeanPropertyRowMapper(AllYearsForCustomerTO.class));
        }catch(DataAccessException e) {
            LOGGER.error("exception is "+e);
        }
        return allYearsForCustomerTO;
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public RawDataByInputAndDateResponseTO retrieveRawDataByInputAndDate(RetrieveRawDataByInputAndDateTO retrieveRawDataByInputAndDateTO) {
        RawDataByInputAndDateResponseTO rawDataByInputAndDateResponseTO = new RawDataByInputAndDateResponseTO();
        switch(retrieveRawDataByInputAndDateTO.getInputType()) {
            case "purchases": {
                try {
                    rawDataByInputAndDateResponseTO.setRawData(jdbcTemplate.query(retrieveRawDataByPurchaseAndDate, new Object[]{retrieveRawDataByInputAndDateTO.getUsername(),retrieveRawDataByInputAndDateTO.getFromDate(),retrieveRawDataByInputAndDateTO.getToDate(),retrieveRawDataByInputAndDateTO.getMinPage()}, new BeanPropertyRowMapper(RawDataPurchaseTO.class)));
                    rawDataByInputAndDateResponseTO.setCount(jdbcTemplate.query(retrieveRawDataByPurchaseAndDateCount, new Object[]{retrieveRawDataByInputAndDateTO.getUsername(),retrieveRawDataByInputAndDateTO.getFromDate(),retrieveRawDataByInputAndDateTO.getToDate()}, new BeanPropertyRowMapper(CountTO.class)));
                }catch(DataAccessException e) {
                    LOGGER.error("exception is "+e);
                }
                break;
            }
            case "income": {
                try {
                    rawDataByInputAndDateResponseTO.setRawData(jdbcTemplate.query(retrieveRawDataByIncomeAndDate, new Object[]{retrieveRawDataByInputAndDateTO.getUsername(),retrieveRawDataByInputAndDateTO.getFromDate(),retrieveRawDataByInputAndDateTO.getToDate(),retrieveRawDataByInputAndDateTO.getMinPage()}, new BeanPropertyRowMapper(RawDataIncomeTO.class)));
                    rawDataByInputAndDateResponseTO.setCount(jdbcTemplate.query(retrieveRawDataByIncomeAndDateCount, new Object[]{retrieveRawDataByInputAndDateTO.getUsername(),retrieveRawDataByInputAndDateTO.getFromDate(),retrieveRawDataByInputAndDateTO.getToDate()}, new BeanPropertyRowMapper(CountTO.class)));
                }catch(DataAccessException e) {
                    LOGGER.error("exception is "+e);
                }
                break;
            }
            case "insurance": {
                try {
                    rawDataByInputAndDateResponseTO.setRawData(jdbcTemplate.query(retrieveRawDataByInsuranceAndDate, new Object[]{retrieveRawDataByInputAndDateTO.getUsername(),retrieveRawDataByInputAndDateTO.getFromDate(),retrieveRawDataByInputAndDateTO.getToDate(),retrieveRawDataByInputAndDateTO.getMinPage()}, new BeanPropertyRowMapper(RawDataInsuranceTO.class)));
                    rawDataByInputAndDateResponseTO.setCount(jdbcTemplate.query(retrieveRawDataByInsuranceAndDateCount, new Object[]{retrieveRawDataByInputAndDateTO.getUsername(),retrieveRawDataByInputAndDateTO.getFromDate(),retrieveRawDataByInputAndDateTO.getToDate()}, new BeanPropertyRowMapper(CountTO.class)));
                }catch(DataAccessException e) {
                    LOGGER.error("exception is "+e);
                }
                break;
            }
            default:{}
        }
        return rawDataByInputAndDateResponseTO;
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public List<AllAlarmsResponseTO> retrieveAllAlarmsFromDB(UserTO inputTo) {
        List<AllAlarmsResponseTO> allAlarmsResponseTO = new ArrayList<>();
        try {
            allAlarmsResponseTO = jdbcTemplate.query(retrieveAllAlarms, new Object[]{inputTo.getUsername()}, new BeanPropertyRowMapper(AllAlarmsResponseTO.class));
        }catch(DataAccessException e) {
            LOGGER.error("exception is "+e);
        }
        return allAlarmsResponseTO;
    }

}
