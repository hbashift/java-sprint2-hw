public class MonthData {
    String itemName;
    Boolean isExpense;
    Integer quantity;
    Integer sumOfOne;

    public MonthData() {
        this.itemName = "";
        this.isExpense = false;
        this.quantity = 0;
        this.sumOfOne = 0;
    }

    public void setMonthData(String[] line) {
        this.itemName = line[0];
        this.isExpense = Boolean.parseBoolean(line[1]);
        this.quantity = Integer.parseInt(line[2]);
        this.sumOfOne = Integer.parseInt(line[3]);
    }
}
