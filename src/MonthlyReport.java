import java.util.ArrayList;

public class MonthlyReport {
    private ArrayList<MonthData> monthData;
    private String monthName;
    public MonthlyReport() {
        this.monthData = new ArrayList<>();
    }

    public ArrayList<MonthData> getMonthData() {
        return monthData;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthData(ArrayList<MonthData> monthData) {
        this.monthData = monthData;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public void printInfo() {
        /*maximumExpense();
        minimumExpense();*/
    }

    /*private String maximumExpense() {
        return "Максимальное значение траты";
    }

    private String minimumExpense() {
        return "Минимальное значение траты";
    }*/
}
