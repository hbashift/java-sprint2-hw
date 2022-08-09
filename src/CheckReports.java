import java.util.ArrayList;

public class CheckReports {

    public static void checkExpenses(ArrayList<MonthlyReport> monthlyReportList, YearlyReport yearlyReport) {
        int check = 0;
        for (int i = 0; i < monthlyReportList.size(); i++) {
            if (!(monthlyReportList.get(i).sumOfExpenses() == yearlyReport.getExpense(i+1))) {
                System.out.println("Отчеты по расходам в " + (i+1) + " месяц не сходятся");
                check = 1;
            }
        }

        if (check == 0) {
            System.out.println("Все расходы сошлись");
        }
    }

    public static void checkIncomes(ArrayList<MonthlyReport> monthlyReportList, YearlyReport yearlyReport) {
        int check = 0;
        for (int i = 0; i < monthlyReportList.size(); i++) {
            if (!(monthlyReportList.get(i).sumOfIncomes() == yearlyReport.getIncomes(i+1))) {
                System.out.println("Отчеты по доходам в " + (i+1) + " месяц не сходятся");
                check = 1;
            }
        }

        if (check == 0) {
            System.out.println("Все доходы сошлись");
        }
    }
}
