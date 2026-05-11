public abstract class ServiceProvider extends Cell {
    // I added range bacause every service affects nearby zones. (Gizem)
    private int range;
    // I used super because ServiceProvider inherits from Cell. (Gizem)
    public ServiceProvider(int row, int column, char symbol, int range){
        super(row,column,symbol);
        this.range=range;
    }

    public int getRange(){
        return range;
    }
    // I used Manhattan distance because it is easier to calculate in grid. (Gizem)
    public boolean covers(int targetRow, int targetColumn){
        int distance = Math.abs(getRow() - targetRow) + Math.abs(getColumn() - targetColumn);
        return distance <= range;
    }
    // "Police Station", "Hospital" and "School" (Gizem)
    public abstract String getServiceType();

    @Override
    public abstract String getSymbol();

}
