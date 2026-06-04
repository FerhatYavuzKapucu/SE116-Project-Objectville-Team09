public abstract class Zone extends Cell{
    private int level;
    private int currentDemand;
    private int  output;
    private int receivedElectricity;
    private int receivedWater;
    private int receivedInternet;
    private boolean  hasSecurity;
    private boolean hasEducation;
    private boolean hasHealth;
    private int receivedGoods;
    private int receivedLifestyle;
    private int receivedPopulation;


    public Zone(int row, int column, char symbol, int level) {
        super(row, column, symbol);
    //When the game starts everything should be 0 or false (Yigit)
        this.level = 0;
        this.receivedElectricity = 0;
        this.receivedWater = 0;
        this.receivedInternet = 0;
        this.hasSecurity = false;
        this.hasEducation =false;
        this.hasHealth = false;
        this.currentDemand =1;
        this.output = 0;
        this.receivedGoods = 0;
        this.receivedLifestyle = 0;
        this.receivedPopulation = 0;
    }

    // Getters and setters for updating. (Yigit)
    public int getCurrentDemand() {
        return currentDemand;
    }

    public void setCurrentDemand(int currentDemand) {
        this.currentDemand = currentDemand;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public int getReceivedElectricity() {
        return receivedElectricity;
    }

    public void setReceivedElectricity(int receivedElectricity) {
        this.receivedElectricity = receivedElectricity;
    }

    public int getReceivedWater() {
        return receivedWater;
    }

    public void setReceivedWater(int receivedWater) {
        this.receivedWater = receivedWater;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isHasSecurity() {
        return hasSecurity;
    }

    public void setHasSecurity(boolean hasSecurity) {
        this.hasSecurity = hasSecurity;
    }

    public int getReceivedInternet() {
        return receivedInternet;
    }

    public void setReceivedInternet(int receivedInternet) {
        this.receivedInternet = receivedInternet;
    }

    public boolean isHasEducation() {
        return hasEducation;
    }

    public void setHasEducation(boolean hasEducation) {
        this.hasEducation = hasEducation;
    }

    public boolean isHasHealth() {
        return hasHealth;
    }

    public void setHasHealth(boolean hasHealth) {
        this.hasHealth = hasHealth;
    }

    public int getReceivedLifestyle() {
        return receivedLifestyle;
    }

    public void setReceivedLifestyle(int receivedLifestyle) {
        this.receivedLifestyle = receivedLifestyle;
    }

    public int getReceivedGoods() {
        return receivedGoods;
    }

    public void setReceivedGoods(int receivedGoods) {
        this.receivedGoods = receivedGoods;
    }

    public int getReceivedPopulation() {
        return receivedPopulation;
    }

    public void setReceivedPopulation(int receivedPopulation) {
        this.receivedPopulation = receivedPopulation;
    }

    //Abstract methods for overriding (Yigit)
    abstract public void updateLevel();
    abstract public void calculateOutput();
    abstract public String getSymbol();


    // Calculating demand which same for every subclass. (Yigit)
    //Deciding the demand depending on output.When there is not a output demand will be 1. (Yigit)
    public void calculateDemand(){
        this.currentDemand = Math.max(1,this.output);
    }
}
