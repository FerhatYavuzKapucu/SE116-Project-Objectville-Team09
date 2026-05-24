public class WaterPump extends UtilityProvider{

    public WaterPump(int row, int column, char symbol) {
        super(row, column, symbol);
    }

    public String getUtilityType() {
        return "Water";
    }

    public String getSymbol() {
        return "W";
    }
}
