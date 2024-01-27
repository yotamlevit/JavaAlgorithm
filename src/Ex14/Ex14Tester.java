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
        System.out.println("Test case {" + list.toString() + "} " +
                (result == expected ? "PASS" : "FAIL") +
                " (Expected: \"" + expected + "\", Got: \"" + result + "\")");
    }

    private static IntList[] ex2ArrangeIntLists() {
        IntList[] lists = new IntList[2];
        IntList intList = new IntList();

        intList.addToEnd(5);
        intList.addToEnd(7);
        intList.addToEnd(-2);
        intList.addToEnd(10);

        lists[0] = intList;

        intList = new IntList();

        intList.addToEnd(1);
        intList.addToEnd(0);
        intList.addToEnd(0);
        intList.addToEnd(0);
        intList.addToEnd(1);

        lists[1] = intList;

        return lists;
    }

    private static void testAverageNode() {
        boolean result, expected;
        System.out.println("- Arrage Lists For Ex2 - ");
        IntList[] ex2Lists = ex2ArrangeIntLists();
        System.out.println("- Test subListSum Ex1 - ");

        testAverageNode(ex2Lists[0], -2);
        testAverageNode(ex2Lists[1], 0);

    }

    private static void testAverageNode(IntList list, int expectedNodeValue) {
        IntNode result = list.averageNode();
        System.out.println("Test case {" + list.toString() + "} " +
                (result.getValue() == expectedNodeValue ? "PASS" : "FAIL") +
                " (Expected: \"" + expectedNodeValue + "\", Got: \"" + result.getValue() + "\")");
    }

    public static void main(String[] args) {
        System.out.println("------------------ Start Ex1 ------------------------ ");


        testSubListSum();

        System.out.println("------------------ Finish Ex1 ------------------------ \n");
        System.out.println("------------------ Start Ex2 ------------------------ ");

        testAverageNode();

        System.out.println("------------------ Finish Ex2 ------------------------ ");
    }
}
