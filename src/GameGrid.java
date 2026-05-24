import java.util.ArrayList;

public class GameGrid {
    private Cell[][] grid;
    private int rows;
    private int columns;
    // I used ArrayList because the number of zones, utility and service providers changes depending on the map size. (Gizem)
    private ArrayList<Zone> zones = new ArrayList<>();
    private ArrayList<UtilityProvider> utilityProviders = new ArrayList<>();
    private ArrayList<ServiceProvider> serviceProviders = new ArrayList<>();

    public GameGrid(Cell[][] grid, int rows, int columns) {

        this.grid = grid;
        this.rows = rows;
        this.columns = columns;

        fillLists();
    }

    // I created this method to fill list by checking all cells. (Gizem)
    private void fillLists() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(grid[i][j] instanceof Zone) {
                    zones.add((Zone) grid[i][j]);
                }
                if(grid[i][j] instanceof UtilityProvider) {
                    utilityProviders.add((UtilityProvider) grid[i][j]);
                }
                if(grid[i][j] instanceof ServiceProvider) {
                    serviceProviders.add((ServiceProvider) grid[i][j]);
                }
            }
        }
    }

    public Cell getCell(int row, int column) {
        return grid[row][column];
    }

    // Used before neighbour checks in BFS. (Gizem)
    public boolean isValid(int row, int column) {
        if(row < 0 || row >= rows) {
            return false;
        }
        if(column < 0 || column >= columns) {
            return false;
        }
        return true;
    }

    public ArrayList<Zone> getZones() {
        return zones;
    }

    public ArrayList<UtilityProvider> getUtilityProviders() {
        return utilityProviders;
    }

    public ArrayList<ServiceProvider> getServiceProviders() {
        return serviceProviders;
    }

    // Prints symbols row by row. (Gizem)
    public void printGrid() {
        for(int i = 0; i < rows; i++) {
            String line = "";
            for(int j = 0; j < columns; j++) {
                line += grid[i][j].getSymbol();
            }
            System.out.println(line);
        }
    }
}








