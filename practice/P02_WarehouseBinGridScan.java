/**
 * Week 11 Practice 2 - Warehouse Bin Grid Scan
 * Total items and the (row, col) of the fullest bin; ties keep the first one found (row by row).
 *
 * Complexity: O(m * n) time, O(1) additional space.
 */
public class P02_WarehouseBinGridScan {

    // Returns {total, maxRow, maxCol}
    static int[] warehouseSummary(int[][] grid) {
        int total = 0, maxValue = -1, maxRow = -1, maxCol = -1;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > maxValue) {   // strictly greater keeps the first maximum
                    maxValue = grid[r][c];
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return new int[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 9, 2}, {7, 1, 6}, {3, 12, 5}};
        int[] s = warehouseSummary(grid);
        System.out.println("total = " + s[0] + ", maxCoordinate = (" + s[1] + ", " + s[2] + ")");
    }
}
