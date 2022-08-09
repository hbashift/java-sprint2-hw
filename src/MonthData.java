public class MonthData {
    Integer quantity;
    Integer sumOfOne;
    String itemName;
    Boolean isExpense;

    public void convert(String[] line) {
        this.itemName = line[0].toString();
        this.isExpense = Boolean.parseBoolean(line[1]);
        this.quantity = Integer.parseInt(line[2]);
        this.sumOfOne = Integer.parseInt(line[3]);
    }
}
