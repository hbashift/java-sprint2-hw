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

    public int getProfit(int month) {
        return incomeByMonth.get(month) - expensesByMonth.get(month);
    }

    public int getIncomes(int month) {
        return incomeByMonth.get(month);
    }

    public int getExpense(int month) {
        return expensesByMonth.get(month);
    }

    public int sumOfExpenses() {
        int expSum = 0;
        for (int i = 0; i < expensesByMonth.size(); i++) {
            if (expensesByMonth.containsKey(i+1)) {
                expSum += expensesByMonth.get(i+1);
            }
        }

        return expSum;
    }

    public int sumOfIncome() {
        int incomeSum = 0;
        for (int i = 0; i < incomeByMonth.size(); i++) {
            if (incomeByMonth.containsKey(i+1)) {
                incomeSum += incomeByMonth.get(i+1);
            }
        }

        return incomeSum;
    }

    public void printReport() {
        System.out.println(yearNumber);
        for (int i = 0; i < incomeByMonth.size(); i++) {
            System.out.println("Прибыль за " + (i+1) + " месяц года: " + getProfit(i+1));
        }

        System.out.println("Средний расход за все месяцы в году: " + sumOfExpenses()/expensesByMonth.size());
        System.out.println("Средний доход за все месяцы в году: " + sumOfIncome()/incomeByMonth.size());
    }
}
