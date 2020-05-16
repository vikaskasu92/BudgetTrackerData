package kasu.budgetTracker.budgetTrackerDataStore.dao;

import kasu.budgetTracker.budgetTrackerDataStore.model.YearlyExpenseSummaryRowMapperTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveYearlyExpenseRowMapper implements RowMapper<YearlyExpenseSummaryRowMapperTO> {

    @Override
    public YearlyExpenseSummaryRowMapperTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        YearlyExpenseSummaryRowMapperTO yearlySummary = new YearlyExpenseSummaryRowMapperTO();
        yearlySummary.setYearlyExpenseSummaryPrice(rs.getDouble("price"));
        yearlySummary.setYearlyExpenseSummaryDate(rs.getDate("date"));
        return yearlySummary;
    }
}
