import java.util.ArrayList;
import java.util.List;

/**
 * Week 11 Practice 8 - Spiral Order Traversal (works for non-square grids)
 *
 * Complexity: O(m * n) time; the output list holds m * n elements (O(m * n) space), O(1) besides that.
 */
public class P08_SpiralOrderTraversal {

    static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<Integer>();
        if (grid.length == 0) return result;
        int top = 0, bottom = grid.length - 1, left = 0, right = grid[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) result.add(grid[top][c]);       // left -> right
            top++;
            for (int r = top; r <= bottom; r++) result.add(grid[r][right]);     // top -> bottom
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) result.add(grid[bottom][c]); // right -> left
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) result.add(grid[r][left]);   // bottom -> top
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(grid));
        int[][] rectangle = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println("3x4 grid: " + spiralOrder(rectangle));
    }
}
