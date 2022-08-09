import java.util.HashMap;

public class YearlyReport {
    private HashMap<Integer, Integer> incomeByMonth;
    private HashMap<Integer, Integer> expensesByMonth;
    private int yearNumber;

    public YearlyReport() {
        incomeByMonth = new HashMap<>();
        expensesByMonth = new HashMap<>();
        yearNumber = 2021;
    }

    public void addRecord(int month, int amount, boolean isExpense) {
        if (isExpense) {
            if (expensesByMonth.containsKey(month)) {
                amount += expensesByMonth.get(month);
                expensesByMonth.put(month, amount);
            } else {
                expensesByMonth.put(month, amount);
            }
        } else {
            if (incomeByMonth.containsKey(month)) {
                amount += incomeByMonth.get(month);
                incomeByMonth.put(month, amount);
            } else {
                incomeByMonth.put(month, amount);
            }
        }
    }

    public Integer getProfit(int month) {
        return incomeByMonth.get(month) - expensesByMonth.get(month);
    }

    public Integer getExpense(int month) {
        return expensesByMonth.get(month);
    }

    public void printReport() {

    }
}
