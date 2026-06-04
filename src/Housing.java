public class Housing extends Zone {
    public Housing(int row, int column, char symbol, int level) {
        super(row, column, symbol, level);
    }

    @Override
    public void updateLevel(){
        //Deciding the level with logic operations(and,or) (Yigit)
        if(getReceivedWater()==0 || getReceivedElectricity() == 0 || getReceivedInternet() == 0){
            setLevel(0);
        } else if (getLevel()==0 && getReceivedInternet() !=0 && getReceivedElectricity() != 0 && getReceivedWater() != 0) {
            setLevel(1);
        } else if (getLevel() == 1 && isHasSecurity() && isHasHealth() && isHasEducation()) {
            setLevel(2);
        } else if (getLevel() == 2 && getReceivedLifestyle() > 0 && isHasHealth() && isHasEducation() && isHasSecurity()) {
            setLevel(3);
        }
        else if (getLevel() == 3 && (!isHasHealth() || !isHasSecurity() || !isHasEducation() || getReceivedLifestyle() ==0)){
            setLevel(2);
        }  else if (getLevel() == 2 && (!isHasEducation() || !isHasSecurity() || !isHasHealth())) {
            setLevel(1);
        }
    }



    @Override
    public void calculateOutput(){
        //Finding the minimum m with the variables for calculating output (Yigit)
        int m = Math.min(getReceivedElectricity(),Math.min(getReceivedWater(),getReceivedInternet()));
       // Calculating the output depending on m and level (Yigit)
        if(getLevel() == 0){
            setOutput(0);
        } else if ( getLevel() == 1) {
            setOutput(m);
        } else if (getLevel() == 2) {
            setOutput(2*m);
        } else if (getLevel() == 3) {
            setOutput((2 * m) + getReceivedLifestyle() );
        }
     calculateDemand();
    }

    @Override
    public String getSymbol(){return "H" ; }
}