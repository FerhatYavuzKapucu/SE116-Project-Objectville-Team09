public class Industrial extends Zone {
    public Industrial(int row, int column, char symbol, int level){
        super(row, column, symbol, level);
    }

    @Override
    public void updateLevel() {
        //Deciding the level with logic operations(and,or) (Yigit)
        if(getReceivedPopulation() == 0 || getReceivedElectricity() == 0 || getReceivedWater() == 0 ){
            setLevel(0);
        } else if (getReceivedWater() != 0 && getReceivedElectricity() != 0
                && getReceivedPopulation() != 0) {setLevel(1);
        } else if (getLevel() == 1 &&  isHasSecurity()) {setLevel(2);
        } else if (getLevel() == 2 && getReceivedPopulation() != 0 && isHasSecurity()) {
            setLevel(3);
        } else if (getLevel() == 3 && (!isHasSecurity() || getReceivedPopulation() == 0)) {
            setLevel(2);
        } else if (getLevel() == 2 && (!isHasSecurity() || getReceivedPopulation() == 0)) {
            setLevel(1);
        }
    }


    @Override
    public void calculateOutput(){
        //Finding the minimum m with the variables for calculating output (Yigit)
        int m = Math.min(getReceivedPopulation(),(Math.min(getReceivedWater(),getReceivedElectricity())));
        // Calculating the output depending on m and level (Yigit)
        if( getLevel() == 0){
            setOutput(0);
        } else if (getLevel() == 1) {
            setOutput(m);
        } else if (getLevel() == 2) {
            setOutput(2*m);
        } else if (getLevel() == 3) {
            setOutput((2*m)+getReceivedPopulation());
        }
    calculateDemand();
    }

    @Override
    public String getSymbol(){return  "I";}
}
