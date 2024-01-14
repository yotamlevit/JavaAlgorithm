package Ex14;

import Ex13.Ex13;

public class Ex14Tester {

    private static IntList ex1ArrangeIntList() {
        IntList intList = new IntList();

        intList.addToEnd(3);
        intList.addToEnd(6);
        intList.addToEnd(2);
        intList.addToEnd(7);
        intList.addToEnd(1);

        return intList;
    }

    private static void testSubListSum() {
        boolean result, expected;
        System.out.println("- Arrage IntList Ex1 - ");
        IntList ex1List = ex1ArrangeIntList();
        System.out.println("- Test subListSum Ex1 - ");

        testSubListSum(ex1List, true, 15);
        testSubListSum(ex1List, false, 14);

    }

    private static void testSubListSum(IntList list, boolean expected, int num) {
        boolean result = list.subListSum(num);
        expected = true;
        System.out.println("Test case {" + list.toString() + "} " +
                (result == expected ? "PASS" : "FAIL") +
                " (Expected: \"" + expected + "\", Got: \"" + result + "\")");
    }

    public static void main(String[] args) {
        System.out.println("------------------ Start Ex1 ------------------------ ");


        testSubListSum();

        System.out.println("------------------ Finish Ex1 ------------------------ \n");
        System.out.println("------------------ Start Ex2 ------------------------ ");

        //testMaxSnake();

        System.out.println("------------------ Finish Ex2 ------------------------ ");
    }
}
