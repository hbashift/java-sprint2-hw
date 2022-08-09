import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Reader {

    public String[] readReport(String path)
    {
        try {
            return Files.readString(Path.of(path)).split(System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public ArrayList<String[]> readMonthlyReports() {
        ArrayList<String[]> reports = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            reports.add(readReport("resources/m.20210" + i + ".csv"));
        }
        return reports;
    }

    public String[] readYearlyReport() {
        return readReport("resources/y.2021.csv");
    }
}
