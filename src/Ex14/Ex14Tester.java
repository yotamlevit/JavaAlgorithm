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
        System.out.println("- Test AverageNode Ex1 - ");

        testAverageNode(ex2Lists[0], -2);
        testAverageNode(ex2Lists[1], 0);

    }

    private static void testAverageNode(IntList list, int expectedNodeValue) {
        IntNode result = list.averageNode();
        System.out.println("Test case {" + list.toString() + "} " +
                (result.getValue() == expectedNodeValue ? "PASS" : "FAIL") +
                " (Expected: \"" + expectedNodeValue + "\", Got: \"" + result.getValue() + "\")");
    }

    private static IntListTwo[] ex3ArrangeIntLists() {
        IntListTwo[] lists = new IntListTwo[2];
        IntListTwo intList = new IntListTwo();

        intList.addToEnd(1);
        intList.addToEnd(2);
        intList.addToEnd(3);
        intList.addToEnd(4);


        lists[0] = intList;

        intList = new IntListTwo();

        intList.addToEnd(1);
        intList.addToEnd(9);
        intList.addToEnd(3);
        intList.addToEnd(4);

        lists[1] = intList;

        return lists;
    }

    private static void testEx3() {
        boolean result, expected;
        System.out.println("- Arrage Lists For Ex3 - ");
        IntListTwo[] ex3Lists = ex3ArrangeIntLists();
        System.out.println("- Test Add To end Ex3 - ");

        testAddToEnd(ex3Lists[0], -2000000, "{1, 2, 3, 4, -2000000}");
        System.out.println("- Test Add To String Ex3 - ");
        testToString(ex3Lists[1], "{1, 9, 3, 4}");
        System.out.println("- Test Add To String reverse Ex3 - ");
        testToStringReverse(ex3Lists[1], "{4, 3, 9, 1}");
    }

    private static void testAddToEnd(IntListTwo list, int lastValue, String expectedResult) {
        String before = list.toString();
        list.addToEnd(lastValue);
        String result = list.toString();
        System.out.println("Test case {" + before + "} " +
                (result.equals(expectedResult) ? "PASS" : "FAIL") +
                " (Expected: \"" + expectedResult + "\", Got: \"" + result + "\")");
    }

    private static void testToString(IntListTwo list, String expectedOutput) {
        String result = list.toString();
        System.out.println("Test case {" + list.toString() + "} " +
                (result.equals(expectedOutput) ? "PASS" : "FAIL") +
                " (Expected: \"" + expectedOutput + "\", Got: \"" + result + "\")");
    }

    private static void testToStringReverse(IntListTwo list, String expectedOutput) {
        String result = list.toStringReverse();
        System.out.println("Test case {" + list.toString() + "} " +
                (result.equals(expectedOutput) ? "PASS" : "FAIL") +
                " (Expected: \"" + expectedOutput + "\", Got: \"" + result + "\")");
    }

    private static IntListTwo[] ex4ArrangeIntLists() {
        IntListTwo[] lists = new IntListTwo[2];
        IntListTwo intList = new IntListTwo();

        intList.addToEnd(2);
        intList.addToEnd(4);
        intList.addToEnd(1);
        intList.addToEnd(6);
        intList.addToEnd(4);
        intList.addToEnd(2);
        intList.addToEnd(4);
        intList.addToEnd(3);
        intList.addToEnd(5);


        lists[0] = intList;

        intList = new IntListTwo();

        intList.addToEnd(1);
        intList.addToEnd(4);
        intList.addToEnd(3);
        intList.addToEnd(1);
        intList.addToEnd(2);
        intList.addToEnd(4);
        intList.addToEnd(3);

        lists[1] = intList;

        return lists;
    }

    private static void testIsWay() {
        boolean result, expected;
        System.out.println("- Arrage IntList Ex4 - ");
        IntListTwo[] ex3Lists = ex4ArrangeIntLists();
        System.out.println("- Test isWay Ex4 - ");

        testIsWay(ex3Lists[0], true);
        testIsWay(ex3Lists[1], false);

    }

    private static void testIsWay(IntListTwo list, boolean expected) {
        boolean result = list.isWay();
        System.out.println("Test case {" + list.toString() + "} " +
                (result == expected ? "PASS" : "FAIL") +
                " (Expected: \"" + expected + "\", Got: \"" + result + "\")");
    }

    public static void main(String[] args) {
        System.out.println("------------------ Start Ex1 ------------------------ ");


        testSubListSum();

        System.out.println("------------------ Finish Ex1 ------------------------ \n");
        System.out.println("------------------ Start Ex2 ------------------------ ");

        testAverageNode();

        System.out.println("------------------ Finish Ex2 ------------------------ ");
        System.out.println("------------------ Start Ex3 ------------------------ ");

        testEx3();

        System.out.println("------------------ Finish Ex3 ------------------------ ");
        System.out.println("------------------ Start Ex4 ------------------------ ");

        testIsWay();

        System.out.println("------------------ Finish Ex4 ------------------------ ");
    }
}
