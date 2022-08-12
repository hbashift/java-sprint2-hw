import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<MonthlyReport> monthlyReportList = new ArrayList<>();

        YearlyData yearlyData = new YearlyData();
        YearlyReport yearlyReport = new YearlyReport();

        Reader reader = new Reader();

        Menu.printMenu();
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        while (true) {

            switch (command) {
                case 1:
                    Menu.readMonthlyReports(reader, monthlyReportList);
                    break;
                case 2:
                    Menu.readYearlyReports(reader, yearlyData, yearlyReport);
                    break;
                case 3:
                    CheckReports.checkExpenses(monthlyReportList, yearlyReport);
                    CheckReports.checkIncomes(monthlyReportList, yearlyReport);
                    break;
                case 4:
                    Menu.printMonthlyReport(monthlyReportList);
                    break;
                case 5:
                    yearlyReport.printReport();
                    break;
                case 777:
                    System.exit(0);
                default:
                    System.out.println("Такой команды не существует. Ввод некорректен.");
                    break;
            }

            Menu.printMenu();
            command = scanner.nextInt();
        }
    }
}

