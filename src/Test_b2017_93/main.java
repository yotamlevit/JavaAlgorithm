package Test_b2017_93;

public class main {
    public static boolean isBoundary(int i, int j, boolean[][]mat){
        return (i > 0 && i == mat.length && j == mat[0].length && j > 0);
    }

    public static void disable(boolean[][] mat, int i, int j){
        if (isBoundary(i, j, mat) || !mat[i][j])
            return;

        mat[i][j] = false;
        disable(mat, i ,j-1);
        disable(mat, i ,j+1);
        disable(mat, i-1 ,j);
        disable(mat, i+1 ,j);

    }

    public static int cntTrueReg(boolean[][] mat, int i, int j, int count){

        if (i == mat.length)
            return count;

        if (j == mat.length)
            return cntTrueReg(mat, i+1, 0, count);

        if (mat[i][j]){
            count++;
            disable(mat, i, j);
        }

        return cntTrueReg(mat, i, j+1, count);
    }

    public static int cntTrueReg(boolean[][] mat){
        return cntTrueReg(mat, 0, 0, 0);
    }


    public static int findNum(Range rangeA[], int num){
        int low = 0, high = rangeA.length-1, mid;

        while (low <= high)
        {
            mid = (low + high) /2;
            if (rangeA[mid].getCenter() - rangeA[mid].getRadius() <= num || num <= rangeA[mid].getCenter() + rangeA[mid].getRadius())
                return mid;
            if (rangeA[mid].getCenter() + rangeA[mid].getRadius() < num)
                low = mid + 1;
            else
                high = mid -1;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println("Hello");
    }
}
