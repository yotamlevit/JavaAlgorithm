// Author: Yotam Levit

package Ex13;

public class Ex13 {

     /**
     *A recursive function that calculates the shortest common super-sequence of two strings.
     * The shortest common super-sequence is the shortest string
     * that contains both input strings as subsequences.
     <br><br>
     *<br><br>
     * For example: <br><br>
     * If st1 = AGGTAB, st2 = GXTXAYB then the shortest common super-sequence will be AGGXTXAYB <br><br>
     * If st1 = CAT, st2 = DOT then the shortest common super-sequence will be CATDOD<br><br>
     *<br><br>
     *
     * @param st1: The first input string.
     * @param st2: The second input string.
     * @return String: Returns the shortest common super-sequence string of st1 and st2.
     **/
    public static String minimalSt(String st1, String st2) {

        //Brake condition 1
        if (st1.length() == 0)
            return st2;

        //Brake condition 2
        if (st2.length() == 0)
            return st1;

        if (st1.charAt(0) == st2.charAt(0)) {
            return st1.charAt(0) + minimalSt(st1.substring(1), st2.substring(1));
        } else {
            String option1 = st1.charAt(0) + minimalSt(st1.substring(1), st2);
            String option2 = st2.charAt(0) + minimalSt(st1, st2.substring(1));

            // Returns the sorter string between the 2 options
            return option1.length() > option2.length() ? option2 : option1;
        }
    }


    /**
     *This function check if a given indexes are at the border of a matrix
     <br><br>
     *
     * @param mat: The matrix
     * @param i: The x (axis) index.
     * @param j: The y (axis) index.
     * @return boolean: Returns true if the indexes are border false if not
     **/
    public static boolean isBorder(int[][] mat, int i, int j) {
        return i == -1 || j == -1 || mat.length == i || mat[0].length == j;
    }


    /**
     *A recursive function that calculates and explores possible snake path and returns
     *  the length of the longest snake path.
     <br><br>
     *<br><br>
     * A snake path is defined by:
     * *<br><br>
     *   1. the path starts on the first cell of the matrix (0,0)
     *   *<br><br>
     *   2. The last cell is the bottom right.
     *   *<br><br>
     *   3.The next cell can only be one from above, below, right, left. not diagnose
     *   *<br><br>
     *   4.The next cell can only be a cell where the difference of the values is max 1
     *   *<br><br>
     *   5. The math cannot return to the previous cell
     *    *<br><br>
     *<br><br>
     *
     * @param mat: The matrix
     * @param i: The x (axis) index.
     * @param j: The y (axis) index.
     * @param prevVal: The previous value
     * @param visited: A boolean matrix indicating which cells have been visited.
     * @return int: Returns the maximum length of the snake-path from the current cell.
     *              If no valid path is found the method returns Integer.MIN_VALUE.
     **/
    public static int maxSnake(int[][] mat, int i, int j, int prevVal, boolean[][] visited) {
        int moveUp, moveDown, moveRight, moveLeft, maxMove;

        // Brake condition - the indexes are border
        if (isBorder(mat, i, j))
            return 0;

        // Brake condition - the difference between the cells values is less than 1
        //                   or the cell is the origin
        if (Math.abs(mat[i][j] - prevVal) > 1 || visited[i][j])
            return 0;

        //Brake condition - got to then bottom-right corner
        if (mat.length - 1 == i && mat[0].length -1 == j)
            return 1;

        // Mark the current cell as visited- to not loop back and forth of the same cells
        visited[i][j] = true;

        moveUp = maxSnake(mat, i-1, j, mat[i][j], visited);
        moveDown = maxSnake(mat, i+1, j, mat[i][j], visited);
        moveRight = maxSnake(mat, i, j+1, mat[i][j], visited);
        moveLeft = maxSnake(mat, i, j-1, mat[i][j], visited);

        // Mark the current cell as unvisited before returning to allow other paths to use it
        visited[i][j] = false;

        maxMove = Math.max(Math.max(moveLeft, moveRight), Math.max(moveUp, moveDown));

        if (maxMove == 0)
            return Integer.MIN_VALUE;

        return 1 + maxMove;
    }

    /**
     * This function calculates the maximum length of a "snake-path" in a given 2D matrix.
     * A "snake-path" is defined as a path from the top left corner to the
     * bottom right corner of the matrix, moving only to adjacent cells (not diagonally),
     * where the difference in values between adjacent cells is at most 1.
     * The path cannot visit a cell more than once. The method uses a recursive function to
     * search and find the longest such path.
     <br><br>
     *
     * @param mat: The 2D integer matrix in which to find the snake-path.
     * @return The length of the longest snake-path. If no valid path is found,
     *  *         the method returns Integer.MIN_VALUE.
     **/
    public static int maxSnake(int[][] mat) {
        // Initialize a boolean matrix to keep track of visited cells
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        return maxSnake(mat, 0, 0, mat[0][0]+1, visited);
    }
}
