package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.util.List;

public class RawDataByInputAndDateResponseTO {

    private List<Object> rawData;
    private List<CountTO> count;

    public List<CountTO> getCount() {
        return count;
    }
    public void setCount(List<CountTO> count) {
        this.count = count;
    }
    public List<Object> getRawData() {
        return rawData;
    }
    public void setRawData(List<Object> rawData) {
        this.rawData = rawData;
    }

    @Override
    public String toString() {
        return "RawDataByInputAndDateResponseTO [rawData=" + rawData + ", count=" + count + "]";
    }

}
