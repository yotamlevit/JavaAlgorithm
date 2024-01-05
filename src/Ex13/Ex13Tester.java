package Ex13;

public class Ex13Tester {

    public static void main(String[] args) {
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
}
