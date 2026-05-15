public class Hospital extends ServiceProvider{
    public Hospital(int row,int column,char symbol){
        super(row,column,'D',2);
    }

    @Override
    public String getServiceType(){
        return "Health";
    }

    @Override
    public String getSymbol(){
        return "D";
    }
}
