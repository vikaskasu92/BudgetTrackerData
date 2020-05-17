package kasu.budgetTracker.budgetTrackerDataStore.helper;

import kasu.budgetTracker.budgetTrackerDataStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class BudgetTrackerDataHelper {

    @Autowired
    ExpenseIncomeSummaryInputTO expenseSummaryInputTo;
    @Autowired
    YearlyExpenseSummaryInputTO yearlyExpenseSummaryInputTo;
    @Autowired
    ExpenseByCategorySummaryInputTO expenseByCategorySummaryInputTO;
    @Autowired
    YearByYearExpenseCategoryInputTO yearByYearExpenseCategoryInputTO;
    @Autowired
    UserTO userTO;
    @Autowired
    RetrieveRawDataByInputAndDateTO retrieveRawDataByInputAndDateTO;
    @Autowired
    InitiateAlarmInputTO initiateAlarmInputTO;

    public NewPurchaseInputTO createSavePurchasesInput(NewPurchaseInputTO newPurchaseInputTo, String username){
        newPurchaseInputTo.setUsername(username);
        return newPurchaseInputTo;
    }

    public NewIncomeAndTaxesInputTO createNewIncomeDataInput(NewIncomeAndTaxesInputTO newIncomeAndTaxesInputTo, String username){
        newIncomeAndTaxesInputTo.setUsername(username);
        return newIncomeAndTaxesInputTo;
    }

    public NewInsuranceInputTO createNewInsuranceDataInput(NewInsuranceInputTO newInsuranceInputTo,String username){
        newInsuranceInputTo.setUsername(username);
        return newInsuranceInputTo;
    }

    public NewLoanInputTO createNewLoanInput(NewLoanInputTO newLoanInputTo,String username){
        newLoanInputTo.setUsername(username);
        return newLoanInputTo;
    }

    public NewAlarmInputTO createNewAlarmInput(NewAlarmInputTO newAlarmInputTo, String username){
        newAlarmInputTo.setUsername(username);
        return newAlarmInputTo;
    }

    public ExpenseIncomeSummaryInputTO buildIncomeExpenseSummaryInputTo(String username,String fromDate,String toDate) {
        expenseSummaryInputTo.setUsername(username);
        expenseSummaryInputTo.setFromDate(formatedDate(fromDate));
        expenseSummaryInputTo.setToDate(formatedDate(toDate));
        return expenseSummaryInputTo;
    }

    public YearlyExpenseSummaryInputTO yearlyExpenseInput(String username,String fromDate, String toDate) {
        yearlyExpenseSummaryInputTo.setUsername(username);
        yearlyExpenseSummaryInputTo.setStartYear(formatedDate(fromDate));
        yearlyExpenseSummaryInputTo.setEndYear(formatedDate(toDate));
        return yearlyExpenseSummaryInputTo;
    }

    public UserTO  pendingLoansInput(String username) {
        userTO.setUsername(username);
        return userTO;
    }

    public ExpenseByCategorySummaryInputTO categoryByExpense(String username, String category, String subCategory) {
        expenseByCategorySummaryInputTO.setUsername(username);
        expenseByCategorySummaryInputTO.setCategory(category);
        expenseByCategorySummaryInputTO.setSubCategory(subCategory);
        return expenseByCategorySummaryInputTO;
    }

    public YearByYearExpenseCategoryInputTO yearByYearExpenseCategory(String username, String fromDate, String toDate, String category) {
        yearByYearExpenseCategoryInputTO.setUsername(username);
        yearByYearExpenseCategoryInputTO.setFromDate(formatedDate(fromDate));
        yearByYearExpenseCategoryInputTO.setToDate(formatedDate(toDate));
        yearByYearExpenseCategoryInputTO.setCategory(category);
        return yearByYearExpenseCategoryInputTO;
    }

    public UserTO allOpenClosedLoans(String username) {
        userTO.setUsername(username);
        return userTO;
    }

    public UserTO allYearsForCustomer(String username) {
        userTO.setUsername(username);
        return userTO;
    }

    public RetrieveRawDataByInputAndDateTO retrieveRawDataByInputAndDate(String username, String inputType,String fromDate, String toDate,String minPage) {
        retrieveRawDataByInputAndDateTO.setUsername(username);
        retrieveRawDataByInputAndDateTO.setInputType(inputType);
        retrieveRawDataByInputAndDateTO.setFromDate(formatedDate(fromDate));
        retrieveRawDataByInputAndDateTO.setToDate(formatedDate(toDate));
        retrieveRawDataByInputAndDateTO.setMinPage(Integer.parseInt(minPage));
        return retrieveRawDataByInputAndDateTO;
    }

    public UserTO retrieveAllAlarms(String username){
        userTO.setUsername(username);
        return userTO;
    }

    public InitiateAlarmInputTO initiateAlarm(String username,float budgetAmount,String fromDate,String toDate) {
        initiateAlarmInputTO.setUsername(username);
        initiateAlarmInputTO.setBudgetAmount(budgetAmount);
        initiateAlarmInputTO.setFromDate(formatedDate(fromDate));
        initiateAlarmInputTO.setToDate(formatedDate(toDate));
        return initiateAlarmInputTO;
    }

    public Map<String,Object> retrieveFromDB(SimpleJdbcCall callSP, SqlParameterSource sqlParameter){
        return callSP.execute(sqlParameter);
    }

    public SqlParameterSource generateStoredProcedureValues(String username,LocalDate fromDate,LocalDate toDate) {
        SqlParameterSource sqlParameter = new MapSqlParameterSource().addValue("username",username).addValue("fromdate",fromDate ).addValue("todate",toDate);
        return sqlParameter;
    }

    public SimpleJdbcCall callSPDR1(JdbcTemplate jdbcTemplate) {
        SimpleJdbcCall callSP = getSimpleJdbcCallFactory(jdbcTemplate).withProcedureName("SPRD1").withoutProcedureColumnMetaDataAccess()
                .declareParameters(new SqlParameter("username", Types.CHAR),
                        new SqlParameter("fromdate",Types.DATE),
                        new SqlParameter("todate",Types.DATE),
                        new SqlOutParameter("salary", Types.REAL),
                        new SqlOutParameter("expenses",Types.REAL),
                        new SqlOutParameter("taxes",Types.REAL));
        return callSP;
    }

    public SimpleJdbcCall getSimpleJdbcCallFactory(JdbcTemplate jdbcTemplate) {
        return new SimpleJdbcCall(jdbcTemplate);
    }

    public void updateInitiateAlarmInputTOWithDates(InitiateAlarmInputTO initiateAlarmInputTO) {
        if(initiateAlarmInputTO.getAlarmBy().equals("currentMonth")) {
            formStartAndEndDateMonthly(initiateAlarmInputTO);
        }else {
            formStartAndEndDateYearly(initiateAlarmInputTO);
        }
    }
    
    public LocalDate formatedDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }

    private void formStartAndEndDateYearly(InitiateAlarmInputTO initiateAlarmInputTO) {
        LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();
        initiateAlarmInputTO.setFromDate(LocalDate.parse(Integer.toString(currentYear)+"-01-01"));
        initiateAlarmInputTO.setToDate(LocalDate.parse(Integer.toString(currentYear)+"-12-31"));
    }

    private void formStartAndEndDateMonthly(InitiateAlarmInputTO initiateAlarmInputTO) {
        LocalDate currentdate = LocalDate.now();
        String currentMonthUpdated = "";
        YearMonth yearMonthObject = YearMonth.of(currentdate.getYear(), currentdate.getMonthValue());
        currentMonthUpdated = updatedMonthValue(currentdate.getMonthValue());
        int daysInMonth = yearMonthObject.lengthOfMonth();
        initiateAlarmInputTO.setFromDate(LocalDate.parse(Integer.toString(currentdate.getYear())+"-"+currentMonthUpdated+"-01"));
        initiateAlarmInputTO.setToDate(LocalDate.parse(Integer.toString(currentdate.getYear())+"-"+currentMonthUpdated+"-"+Integer.toString(daysInMonth)));
    }

    private String updatedMonthValue(int currentMonth) {
        String currentMonthUpdated;
        if(currentMonth <10) {
            currentMonthUpdated = "0"+Integer.toString(currentMonth);
        }else {
            currentMonthUpdated = Integer.toString(currentMonth);
        }
        return currentMonthUpdated;
    }

}
