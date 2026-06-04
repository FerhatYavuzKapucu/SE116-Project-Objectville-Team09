
public class ResourcePool {
    private int populationPool;
    private int goodsPool;
    private int lifestylePool;

    //The pools are starting with 0 (Yigit)
    public ResourcePool(){
        this.populationPool = 0;
        this.goodsPool = 0;
        this.lifestylePool = 0;
    }

    //Pulling the output from Zone object (Yigit)
    public void collectingResources(Zone zone){
        int product = zone.getOutput();
        String type = zone.getSymbol();

        //Adding the product into the pool depending on their type (Yigit)
        switch (type) {
            case "H":
                 this.populationPool += product;
                 break;
            case "I" :
                this.goodsPool += product;
                break;
            case "C" :
                this.lifestylePool += product;
                break;
        }
    }

    //Distributing method (Yigit)
    public void distributingResources(GameGrid cityMap){
        int availableP = populationPool;
        int availableG = goodsPool;
        int availableL = lifestylePool;

        //Looping the map with the getZones method in GameGrid (Yigit)
        for(Zone zone: cityMap.getZones()){
            int demand = zone.getCurrentDemand();
            String type = zone.getSymbol();

            //Distributing resources depending on cells demand (Yigit)
            if ((type.equals("H"))){
                if(availableL >= demand){
                    zone.setReceivedLifestyle(demand);
                    availableL -= demand;
                }
                else {
                    zone.setReceivedLifestyle(availableL);
                    availableL = 0;
                }
            }
            if(type.equals("I")){
                if(availableP >= demand){
                    zone.setReceivedPopulation(demand);
                    availableP -= demand;
                }
                else{
                    zone.setReceivedPopulation(availableP);
                    availableP = 0;
                }
            }
            if(type.equals("C")){
                if(availableP >= demand){
                    zone.setReceivedPopulation(demand);
                    availableP -= demand;
                }
                else{
                    zone.setReceivedPopulation(availableP);
                    availableP = 0;
                }
                if(availableG >= demand){
                    zone.setReceivedGoods(demand);
                    availableG -= demand;
                }
                else {
                    zone.setReceivedGoods(availableG);
                    availableG = 0;
                }
            }
        }
        //When the loop is over i am updating the pools (Yigit)
        populationPool = availableP;
        goodsPool = availableG;
        lifestylePool = availableL;
    }
}
