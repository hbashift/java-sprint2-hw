import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Reader {

    public String[] parseReport(String path)
    {
        try {
            return Files.readString(Path.of(path)).split(System.lineSeparator());
        } catch (IOException e) {
            return null;
        }
    }

    public ArrayList<String[]> parseMonthlyReports() {
        ArrayList<String[]> reports = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            if (parseReport("resources/m.20210" + i + ".csv") == null) {
                System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл не находится в нужной директории.");
                System.exit(0);
            } else {
                reports.add(parseReport("resources/m.20210" + i + ".csv"));
            }
        }
        return reports;
    }

    public String[] parseYearlyReport() {
        if (parseReport("resources/y.2021.csv") == null) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл не находится в нужной директории.");
            System.exit(0);
            return null;
        } else {
            return parseReport("resources/y.2021.csv");
        }
    }
}
