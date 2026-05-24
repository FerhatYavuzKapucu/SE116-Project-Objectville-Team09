public class PowerPlant extends UtilityProvider{

    public PowerPlant(int row, int column, char symbol) {
        super(row, column, symbol);
    }

    public String getUtilityType() {
        return "Electricity";
    }
    public String getSymbol() {
        return "P";
    }
}
