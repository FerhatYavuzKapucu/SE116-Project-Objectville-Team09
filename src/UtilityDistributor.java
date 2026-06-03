import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

public class UtilityDistributor {

    private static ArrayList<Cell> getNeighbors(Cell cell, GameGrid grid) {
       ArrayList<Cell> neighbors = new ArrayList<>();
       int row = cell.getRow();
       int column = cell.getColumn();

       //Upper neighbor
       if (grid.isValid(row -1, column)) {
           neighbors.add(grid.getCell(row - 1, column));
       }
       //Lower neighbor
        if(grid.isValid(row + 1, column)){
            neighbors.add(grid.getCell(row + 1, column));
        }
        //Left Neighbor
        if(grid.isValid(row , column - 1)){
            neighbors.add(grid.getCell(row, column - 1));
        }
        //Right neighbor
        if(grid.isValid(row, column + 1)){
            neighbors.add(grid.getCell(row, column + 1));
        }

        return neighbors;
    }

    public static void distributeUtility(UtilityProvider provider, GameGrid grid) {
        Queue<Cell> queue = new ArrayDeque<>();
        Set<Cell> visited = new HashSet<>();

        queue.add(provider);
        visited.add(provider);

        //Loop should stop until the queue is empty(Ferhat).
        while(!queue.isEmpty()) {
            Cell current = queue.poll();
            //If the cell is  empty we should not do anything and continue the loop(Ferhat).
            if(current instanceof EmptyCell) {
                continue;
            }

            if(current instanceof Zone) {
                Zone zone = (Zone) current; // current is a Cell type, I checked it as Zone but Java still assumes it is Cell type, so by using "(Zone)" I can now reach the methods of Zone(Ferhat).
                int given = provider.distribute(zone.getCurrentDemand());
                if (provider.getUtilityType().equals("electricity")) {
                    zone.setReceivedElectricity(given);
                }
                if (provider.getUtilityType().equals("water")) {
                    zone.setReceivedWater(given);
                }
                if (provider.getUtilityType().equals("internet")) {
                    zone.setReceivedInternet(given);
                }
            }

            ArrayList<Cell> neighbors = getNeighbors(current, grid);
            //For all neighbors, if it is not visited we are adding it on queue and on visited(Ferhat).
            for (Cell neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}
