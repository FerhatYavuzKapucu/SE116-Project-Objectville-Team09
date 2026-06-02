import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapLoader {

    public static GameGrid load(String filename) throws IOException {
        List<String> lines = new ArrayList<>(); // Bütün satırlar okunur ve satırlar halinde burada tutulur(Ahmet)

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line.trim());
                }
            }
        }

        if (lines.isEmpty()) {
            throw new IllegalArgumentException("Harita dosyası boş veya okunamadı.");
        }
        // Burada harita okunduktan sonra uzunluğu ve eni belirlenir.
        int rows = lines.size();
        int cols = lines.get(0).length();
        Cell[][] grid = new Cell[rows][cols];

        // Aşağıda bulunan createCell ile tek tek harita oluşturuluyor
        for (int r = 0; r < rows; r++) {
            String currentLine = lines.get(r);
            for (int c = 0; c < cols; c++) {
                char symbol = currentLine.charAt(c);
                grid[r][c] = createCell(symbol, r, c);
            }
        }

        return new GameGrid(grid, rows, cols);
    }

    private static Cell createCell(char c, int row, int col) {
        switch (c) {
            case 'H': return new Housing();     // Bu sınıfların constructure'ları no-arg
            case 'I': return new Industrial();
            case 'C': return new Commercial();
            case 'P': return new PowerPlant(row, col, 'P');
            case 'W': return new WaterPump(row, col, 'W');
            case 'T': return new InternetHub(row, col, 'T');
            case 'F': return new PoliceStation(row, col, 'F');
            case 'D': return new Hospital(row, col, 'D');
            case 'S': return new School(row, col, 'S');
            case 'R': return new Road(row, col);
            default:  return new EmptyCell(row,col,'E');
        }
    }
}