public class Sand extends BaseElement {
    public static void step(int[][] grid, int a, int b) {
        if (grid[a+1][b] == SandLab.EMPTY || grid[a+1][b] == SandLab.WATER || grid[a+1][b] == SandLab.OIL || grid[a+1][b] == SandLab.CLOUD)
            swap(grid, a, b, a+1, b);
    }
}