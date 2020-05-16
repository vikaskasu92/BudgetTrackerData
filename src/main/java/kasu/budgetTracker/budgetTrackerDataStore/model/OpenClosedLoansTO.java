package kasu.budgetTracker.budgetTrackerDataStore.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OpenClosedLoansTO {
    private List<OpenLoansTO> openLoans;
    private List<ClosedLoansTO> closedLoans;

    public List<OpenLoansTO> getOpenLoans() {
        return openLoans;
    }
    public void setOpenLoans(List<OpenLoansTO> openLoans) {
        this.openLoans = openLoans;
    }
    public List<ClosedLoansTO> getClosedLoans() {
        return closedLoans;
    }
    public void setClosedLoans(List<ClosedLoansTO> closedLoans) {
        this.closedLoans = closedLoans;
    }

    @Override
    public String toString() {
        return "OpenClosedLoansTO [openLoans=" + openLoans + ", closedLoans=" + closedLoans + "]";
    }
}
