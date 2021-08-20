public class Oil extends BaseElement {
    public static void step(int[][] grid, int a, int b) {
        if (grid[a+1][b] == SandLab.EMPTY || grid[a+1][b] == SandLab.CLOUD)
            swap(grid, a, b, a+1, b);
        else
            horiShift(grid, a, b);
    }
}