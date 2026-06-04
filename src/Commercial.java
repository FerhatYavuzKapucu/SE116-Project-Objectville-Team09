public class Commercial extends  Zone{

    public Commercial(int row, int column, char symbol, int level){
        super(row, column, symbol, level);
    }

    @Override
    public void updateLevel(){
        //Deciding the level with logic operations(and,or) (Yigit)
        if(getReceivedWater() == 0 && getReceivedInternet() == 0 && getReceivedElectricity() == 0
        && getReceivedGoods() ==0 && getReceivedPopulation() == 0){
            setLevel(0);
        } else if (getLevel() == 0 && getReceivedWater() != 0 && getReceivedInternet() != 0 && getReceivedElectricity() != 0
                && getReceivedGoods() !=0 && getReceivedPopulation() != 0 ) {
            setLevel(1);
        } else if (getLevel() == 1 && isHasSecurity()) {
            setLevel(2);
        } else if (getLevel() == 2 && isHasSecurity() && getReceivedPopulation() != 0 && getReceivedGoods() != 0) {
            setLevel(3);
        } else if (getLevel() == 3 && (!isHasSecurity() || getReceivedPopulation() == 0 || getReceivedGoods() == 0)) {
            setLevel(2);
        } else if (getLevel() == 2 && !isHasSecurity()) {
            setLevel(1);
        }
    }


    @Override
    public void calculateOutput(){
        //Finding the minimum m with the variables for calculating output (Yigit)
        int a = Math.min(getReceivedWater(),(Math.min(getReceivedElectricity(),getReceivedInternet())));
        int b = Math.min(getReceivedGoods(),getReceivedPopulation());
        int m = Math.min(a,b);
        // Calculating the output depending on m and level (Yigit)
        if (getLevel() == 0){
            setOutput(0);
        } else if (getLevel() == 1) {
            setOutput(m);
        } else if (getLevel() == 2) {
            setOutput(2*m);
        } else if (getLevel() == 3) {
            setOutput((2*m)+(Math.min(getReceivedPopulation(),getReceivedGoods())));
        }
        calculateDemand();
    }

    @Override
    public String getSymbol() {return "C";}
}
