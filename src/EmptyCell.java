public class EmptyCell extends Cell{
    public EmptyCell(int row, int column, char symbol) {
        super(row, column, symbol);
    }

    @Override
    public String getSymbol() {//Return type in cell class is different from the return type in the document.
        return "E";
    }
    // There is not any abstract getType method in cell class.
}
