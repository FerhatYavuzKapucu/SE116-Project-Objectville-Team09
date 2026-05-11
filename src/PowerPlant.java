public class PowerPlant extends UtilityProvider{

    public PowerPlant(int row, int column, char symbol) {
        super(row, column, symbol);
    }


    public String getType() {
        return "Power Plant";
    }
    public String getUtilityType() {
        return "Electricity";
    }

}
