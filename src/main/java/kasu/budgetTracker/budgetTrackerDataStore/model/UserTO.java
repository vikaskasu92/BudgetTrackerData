package kasu.budgetTracker.budgetTrackerDataStore.model;

import org.springframework.stereotype.Component;

@Component
public class UserTO {

    private String username;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserTO [username=" + username + "]";
    }

}
