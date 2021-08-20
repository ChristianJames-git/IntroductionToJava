public class Fire extends BaseElement {
    public static void step(int[][] grid, int a, int b) {
        if (grid[a+1][b] == SandLab.OIL)
            grid[a+1][b] = SandLab.FIRE;
        if (grid[a+1][b] == SandLab.WATER)
            grid[a+1][b] = SandLab.CLOUD;
        if (b > 0) {
            if (grid[a][b - 1] == SandLab.OIL)
                grid[a][b - 1] = SandLab.FIRE;
            if (grid[a][b - 1] == SandLab.WATER)
                grid[a][b - 1] = SandLab.CLOUD;
        }
        if (b < 79) {
            if (grid[a][b + 1] == SandLab.OIL)
                grid[a][b + 1] = SandLab.FIRE;
            if (grid[a][b + 1] == SandLab.WATER)
                grid[a][b + 1] = SandLab.CLOUD;
        }
        grid[a][b] = SandLab.EMPTY;
    }
}