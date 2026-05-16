public class Industrial extends Zone {
    public Industrial(){
        super();
    }

    @Override
    public void updateLevel() {
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
        int m = Math.min(getReceivedPopulation(),(Math.min(getReceivedWater(),getReceivedElectricity())));
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
    public char getSymbol(){return  'I';}
}
