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
            if (command == 1) {
                ArrayList<String[]> reports = reader.readMonthlyReports();
                for (int i = 0; i < reports.size(); i++) {
                    MonthlyReport monthlyReport = new MonthlyReport();
                    ArrayList<MonthData> monthDataArrayList = new ArrayList<>();
                    String[] line = reports.get(i);
                    for (int j = 1; j < line.length; j++) {
                        MonthData monthData = new MonthData();
                        String[] lineContents = line[j].split(",");
                        monthData.setMonthData(lineContents);
                        monthDataArrayList.add(monthData);
                    }
                    monthlyReport.setMonthData(monthDataArrayList);
                    monthlyReport.setMonthNumber(i);
                    monthlyReportList.add(monthlyReport);
                }
            }else if (command == 2) {
                String[] reports = reader.readYearlyReport();
                for (int i = 1; i < reports.length; i++) {
                    String[] reportContent = reports[i].split(",");
                    yearlyData.setYearlyData(reportContent);
                    yearlyReport.addRecord(yearlyData.month, yearlyData.amount, yearlyData.isExpense);
                }
            } else if (command == 3) {
                CheckReports.checkExpenses(monthlyReportList, yearlyReport);
                CheckReports.checkIncomes(monthlyReportList, yearlyReport);
            } else if (command == 4) {
                for (MonthlyReport report : monthlyReportList) {
                    report.printReport();
                }
            } else if (command == 5) {
                yearlyReport.printReport();
            } else if (command == 777){
                break;
            }


            Menu.printMenu();
            command = scanner.nextInt();
        }
    }
}

