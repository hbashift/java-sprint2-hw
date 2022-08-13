import java.util.ArrayList;

public class Menu {
    public static void printMenu() {
        System.out.println("1. Считать все месячные отчёты\n" +
                "2. Считать годовой отчёт\n" +
                "3. Сверить отчёты\n" +
                "4. Вывести информацию о всех месячных отчётах\n" +
                "5. Вывести информацию о годовом отчёте\n" +
                "Введите 777 для завершения программы. ");
    }

    public static void readMonthlyReports(Reader reader, ArrayList<MonthlyReport> monthlyReportList) {
        ArrayList<String[]> reports = reader.parseMonthlyReports();
        if (reports == null) {
            return;
        }
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
    }

    public static void readYearlyReports(Reader reader, YearlyData yearlyData, YearlyReport yearlyReport) {
        String[] reports = reader.parseYearlyReport();
        if (reports == null) {
            return;
        }
        for (int i = 1; i < reports.length; i++) {
            String[] reportContent = reports[i].split(",");
            yearlyData.setYearlyData(reportContent);
            yearlyReport.addRecord(yearlyData.month, yearlyData.amount, yearlyData.isExpense);
        }
    }

    public static void printMonthlyReport(ArrayList<MonthlyReport> monthlyReportList) {
        if (monthlyReportList.size() == 0) {
            System.out.println("Месячный отчет не был прочтён");
            return;
        }

        for (MonthlyReport report : monthlyReportList) {
            report.printReport();
        }
    }
}
