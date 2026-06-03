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

// Constructor method (Oyuna baslarken binlarda ve haritada bir sey olmadigi varsayilarak 0 girildi)


    public Zone(int row, int column, char symbol, int level) {
        super(row, column, symbol);

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

    // Getter ve setterlar.
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

    //Override yapilacak methodlar.
    abstract public void updateLevel();
    abstract public void calculateOutput();
    abstract public char getSymbol();


    // Sub classlarda ayni olan talep hesaplama metodu.
    //Bir sonraki turum demandi output kadar olmak zorunda ve en az 1 olabilir. Bu yuzden karsilastirip fazlayi alir.
    public void calculateDemand(){
        this.currentDemand = Math.max(1,this.output);
    }
}
