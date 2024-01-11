package Ex13;

public class Ex13Tester {

    public static void main(String[] args) {
        System.out.println("------------------ Start Ex1 ------------------------ ");

        testMinimalSt();

        System.out.println("------------------ Finish Ex1 ------------------------ \n");
        System.out.println("------------------ Start Ex2 ------------------------ ");

        testMaxSnake();

        System.out.println("------------------ Finish Ex2 ------------------------ ");
    }

    private static void testMinimalSt() {
        testMinimalSt("AGGTAB", "GXTXAYB", "AGGXTXAYB");
        testMinimalSt("B", "A", "BA");
        testMinimalSt("AA", "A", "AA");
        testMinimalSt("", "ABC", "ABC");
        testMinimalSt("ABC", "", "ABC");
        testMinimalSt("CAT", "DOG", "CATDOG");
    }

    private static void testMinimalSt(String st1, String st2, String expected) {
        String result = Ex13.minimalSt(st1, st2);
        System.out.println("Test with st1 = \"" + st1 + "\", st2 = \"" + st2 + "\": " +
                (result.equals(expected) ? "PASS" : "FAIL") +
                " (Expected: \"" + expected + "\", Got: \"" + result + "\")");
    }

    private static void testMaxSnake() {
        int[][] mat = {
                {1,2,3,4,5,6},
                {1,2,3,4,5,6},
                {1,2,3,4,5,6},
                {1,2,3,4,5,6},
                {1,2,3,4,5,6},
                {1,2,3,4,5,6}
        };
        testMaxSnake(mat, Integer.MIN_VALUE);

        int[][] mat1 = {
                {1,2},
                {3,4},
        };
        testMaxSnake(mat1, Integer.MIN_VALUE);

        int[][] mat2 = {
                {4,5,2,3,1},
                {3,4,1,4,4},
                {1,5,6,7,8},
                {3,4,5,8,9},
                {3,2,2,7,6},
        };
        testMaxSnake(mat2, 13);
    }

    private static void testMaxSnake(int[][] mat, int expected) {
        int result = Ex13.maxSnake(mat);
        System.out.println("Test case " + mat + " " +
                (result == expected ? "PASS" : "FAIL") +
                " (Expected: \"" + expected + "\", Got: \"" + result + "\")");
    }
}
