public class School extends ServiceProvider{
    public School(int row,int column,char symbol){
        super(row,column,'S',2);
    }

    @Override
    public String getServiceType(){
        return "Education";
    }
    
    @Override
    public String getSymbol(){
        return "S";
    }
}
