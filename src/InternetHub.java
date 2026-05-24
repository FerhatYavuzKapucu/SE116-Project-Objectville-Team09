public class InternetHub extends UtilityProvider{

    public InternetHub(int row, int column, char symbol) {
        super(row, column, symbol);
    }

    public String getUtilityType() {
        return "Internet";
    }

    public String getSymbol() {
        return "T";
    }
}
