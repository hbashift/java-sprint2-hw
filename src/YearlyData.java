public class YearlyData {
    Integer month;
    Integer amount;
    Boolean isExpense;
    public YearlyData() {
        this.month = 0;
        this.amount = 0;
        this.isExpense = false;
    }

    public void setYearlyData(String[] line) {
        this.month = Integer.parseInt(line[0]);
        this.amount = Integer.parseInt(line[1]);
        this.isExpense = Boolean.parseBoolean(line[2]);
    }
}
