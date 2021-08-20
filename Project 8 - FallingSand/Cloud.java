public class Cloud extends BaseElement {
    public static void step(int[][] grid, int a, int b) {
        if (a > 0) {
            if (grid[a - 1][b] != SandLab.METAL)
                swap(grid, a, b, a - 1, b);
            else
                grid[a][b] = SandLab.WATER;
        } else if (a == 0)
            grid[a][b] = SandLab.WATER;
    }
}