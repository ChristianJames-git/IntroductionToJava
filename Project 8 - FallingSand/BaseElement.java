import java.util.Random;
public abstract class BaseElement {
    /**
     * Randomly chooses left or right and the chance to move sand, then move the water or oil the chosen direction
     * @param grid
     * @param a
     * @param b
     */
    public static void horiShift(int[][] grid, int a, int b) {
        Random rand = new Random();
        int leftOrRight = rand.nextInt(2);
        int randSandMove = rand.nextInt(10);
        if (leftOrRight == 0 && b > 0 && grid[a][b-1] != SandLab.METAL && (grid[a][b-1] != SandLab.SAND || randSandMove == 0))
            swap(grid, a, b, a, b-1);
        if (leftOrRight == 1 && b < 79 && grid[a][b+1] != SandLab.METAL && (grid[a][b+1] != SandLab.SAND || randSandMove == 0))
            swap(grid, a, b, a, b+1);
    }

    /**
     * Swaps two values of a 2D array
     * @param arr
     * @param index1
     * @param index2
     * @param index3
     * @param index4
     */
    @SuppressWarnings("unchecked")
    public static void swap(int[][] arr, int index1, int index2, int index3, int index4) {
        // Need to add null check and index checks
        int temp = arr[index1][index2];
        arr[index1][index2] = arr[index3][index4];
        arr[index3][index4] = temp;
    }
}
