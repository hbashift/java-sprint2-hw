import java.util.ArrayList;

public class MonthlyReport {
    private ArrayList<MonthData> monthData;
    private int monthName;
    public MonthlyReport() {
        this.monthData = new ArrayList<>();
    }

    public ArrayList<MonthData> getMonthData() {
        return monthData;
    }

    public int getMonthName() {
        // TODO присвоение полю monthName названия по номеру
        return monthName;
    }

    public void setMonthData(ArrayList<MonthData> monthData) {
        this.monthData = monthData;
    }

    public void setMonthName(int monthName) {
        this.monthName = monthName;
    }

    public int sumOfExpenses() {
        int sum = 0;
        for (MonthData transaction : monthData) {
            if (transaction.isExpense) {
                sum += transaction.sumOfOne * transaction.quantity;
            }
        }

        return sum;
    }

    public int sumOfIncomes() {
        int sum = 0;
        for (MonthData transaction : monthData) {
            if (!transaction.isExpense) {
                sum += transaction.sumOfOne * transaction.quantity;
            }
        }

        return sum;
    }

    private void maximumExpense() {
        int maxExpense = 0;
        String maxItemName = "";
        for (MonthData month : monthData) {
            if (month.isExpense && month.sumOfOne * month.quantity > maxExpense) {
                maxExpense = month.sumOfOne;
                maxItemName = month.itemName;
            }
        }
        System.out.println("Самая большая трата в этом месяце: " + maxItemName + "-" + maxExpense);
    }

    private void maximumIncome() {
        int maxIncome = 0;
        String maxItemName = "";
        for (MonthData line : monthData) {
            if (!line.isExpense && line.sumOfOne * line.quantity > maxIncome) {
                maxIncome = line.sumOfOne;
                maxItemName = line.itemName;
            }
        }
        System.out.println("Самая большая прибыль в этом месяце: " + maxItemName + "-" + maxIncome);
    }

    public void printReport() {
        System.out.println(getMonthName());
        maximumExpense();
        maximumIncome();
    }
}
