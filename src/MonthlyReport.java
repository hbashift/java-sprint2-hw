import java.util.ArrayList;

public class MonthlyReport {
    private ArrayList<MonthData> monthData;
    private int monthNumber;
    public MonthlyReport() {
        this.monthData = new ArrayList<>();
    }

    public String getMonthNumber() {
        String monthName = "";

            if (monthNumber == 0) {
                monthName = "Январь";
                return monthName;
            } else if (monthNumber == 1) {
                monthName = "Февраль";
                return monthName;
            } else if (monthNumber == 2) {
                monthName = "Март";
                return monthName;
            } else if (monthNumber == 3) {
                monthName = "Апрель";
                return monthName;
            } else if (monthNumber == 4){
                monthName = "Май";
                return monthName;
            } else if (monthNumber == 5) {
                monthName = "Июнь";
                return monthName;
            } else if (monthNumber == 6) {
                monthName = "Июль";
                return monthName;
            } else if (monthNumber == 7) {
                monthName = "Август";
                return monthName;
            } else if (monthNumber == 8) {
                monthName = "Сентябрь";
                return monthName;
            } else if (monthNumber == 9) {
                monthName = "Октябрь";
                return monthName;
            } else if (monthNumber == 10) {
                monthName = "Ноябрь";
                return monthName;
            } else if (monthNumber == 11) {
                monthName = "Декабрь";
                return monthName;
            } else {
                return monthName;
            }
    }

    public void setMonthData(ArrayList<MonthData> monthData) {
        this.monthData = monthData;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
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
                maxExpense = month.sumOfOne * month.quantity;
                maxItemName = month.itemName;
            }
        }
        System.out.println("Самая большая трата в этом месяце: " + maxItemName + " - " + maxExpense);
    }

    private void maximumIncome() {
        int maxIncome = 0;
        String maxItemName = "";
        for (MonthData line : monthData) {
            if (!line.isExpense && line.sumOfOne * line.quantity > maxIncome) {
                maxIncome = line.sumOfOne * line.quantity;
                maxItemName = line.itemName;
            }
        }
        System.out.println("Самая большая прибыль в этом месяце: " + maxItemName + " - " + maxIncome + "\n");
    }

    public void printReport() {
        System.out.println(getMonthNumber() + "\n");
        maximumExpense();
        maximumIncome();
    }
}
