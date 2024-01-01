package Ex12;

public class Mmn12StudentTester {

    public static void main(String[] args) {
        boolean errorFound;
        System.out.println("\n=============================== Start equalDigits test===============================");
        errorFound = false;
        
        int expected1 = 3;
        int num1 = 57779227;
        int actual1 = Ex12.equalDigits(num1);
        
        if (actual1 != expected1) {
            errorFound = true;
            System.out.println("Incorrect result when executing with number " + num1);
            System.out.println("Should be: " + expected1 + " but got: " + actual1 + "\n");
        }

        if (!errorFound) {
            System.out.println("Testing equalDigits Successfully passed.");
        }
        
        System.out.println("\n=============================== End equalDigits test===============================");
/*
        System.out.println("\n=============================== Start subNumber test===============================");
        errorFound = false;

        int expected2 = 3960;
        int num2=387960, digit=3;
        int actual2 = Ex12.subNumber(num2, digit);
        
        if (actual2 != expected2) {
            errorFound = true;
            System.out.println("Incorrect result when executing with number " + num2 + " and digit "+digit);
            System.out.println("Should be: " + expected2 + " but got: " + actual2 + "\n");
        }

        if (!errorFound) {
            System.out.println("Testing subNumber Successfully passed.");
        }

        System.out.println("\n=============================== End subNumber test===============================");

        System.out.println("\n=============================== Start isSpecial test===============================");
        errorFound = false;
        
        boolean expected3=true;
        int num3=7;
        boolean actual3 = Ex12.isSpecial(num3);
        
        if (actual3 != expected3) {
            errorFound = true;
            System.out.println("Incorrect result when executing with number " + num3);
            System.out.println("Should be: " + expected3 + " but got: " + actual3 + "\n");
        }

        if (!errorFound) {
            System.out.println("Testing isSpecial Successfully passed.");
        }
*/
        System.out.println("\n=============================== End isSpecial test===============================");
    }
}

