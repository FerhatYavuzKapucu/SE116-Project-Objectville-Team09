public abstract class Cell {
    private int row;
    private int column;
    private char symbol; //I specifically choose the "char" because we are only using "one" character for symbols (Ferhat).

    public Cell(int row, int column, String symbol) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

    public abstract String getType(); //I have implemented this because we need an abstract class which returns the type of building such as Housing or Road (Ferhat).

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
