public class Road extends Cell{

    public Road(int row, int col){
        super(row,col,'R');
    }
    @Override
    public String getSymbol(){ //Return type in cell class is different from document type.
        return "R";
    }
    // There is not any abstract getType method in cell class


}
