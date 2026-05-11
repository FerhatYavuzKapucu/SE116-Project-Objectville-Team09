public abstract class UtilityProvider extends Cell {

    private int capaciy = 100;
    private int remaining;


    public UtilityProvider(int row, int column, String symbol) {
        super(row, column, symbol);
    }

    public int getRemaining() {
        return remaining;
    }

    public void resetCapacity() {
        remaining = 100; //After the capacity is renewed we can now set the remaining to 100 again to use it (Ferhat).
    }

    public int distribute(int demand) {
        if(demand <= remaining){
            remaining -= demand;
            System.out.println(remaining); //Just a  simple print to see how much remained after the distribution (Ferhat).
            return demand; //Since the method exists to distribute the Utilities, we must print the demanded amount (Ferhat).
        }
        else {
            int toDistribute = remaining;
            remaining = 0; //If the demand is larger than the remaining then we have to give all what remains and remaining has to be "0" (Ferhat).
            return toDistribute;
        }
    }

    public abstract String getUtilityType(); //"Electricity", "Water" and "Internet" (Ferhat).

}

