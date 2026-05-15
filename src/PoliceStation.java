public class PoliceStation extends ServiceProvider{
    public PoliceStation(int row,int column, char symbol){
        super(row,column, 'F', 2);
    }

    @Override
    public String getServiceType(){
        return "Security";
    }

    @Override
    public String getSymbol(){
        return "F";
    }
}
