public class ServiceDistributor {
    // Distributes service to zones inside provider range. (Gizem)
    public static void distributeService(ServiceProvider serviceProvider, GameGrid grid) {

        for(Zone zone : grid.getZones()) {
            if(serviceProvider.covers(zone.getRow(), zone.getColumn())) {
                switch(serviceProvider.getServiceType()) {
                    case "Security":
                        zone.setHasSecurity(true);
                        break;
                    case "Health":
                        zone.setHasHealth(true);
                        break;
                    case "Education":
                        zone.setHasEducation(true);
                        break;
                }
            }
        }
    }
}