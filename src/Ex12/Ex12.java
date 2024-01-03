// Author: Yotam Levit

package Ex12;

public class Ex12 {

    // ****************** EX1 ********************
    /**
     *A recursive function that finds the longest streak of digits in a given number
     * <br><br>
     * @param num: The remaining part of the number to process.
     * @param countSequence: The current streak of repeated digits.
     * @param longestSequence: The longest streak of digits found so far.
     * @param checkDigit: The current digit to check for sequence.
     * @return int: Return the longest streak of repeated digits found in the number.
     **/
    public static int equalDigits(int num, int countSequence, int longestSequence, int checkDigit){
        int currentDigit;

        //Brake condition
        if (num == 0)
            return longestSequence;

        currentDigit = num % 10;

        //Checks if the streak continues
        if (currentDigit == checkDigit)
            countSequence++;
        else
            countSequence = 1;

        if (countSequence > longestSequence)
            longestSequence = countSequence;

        return equalDigits(num/10, countSequence, longestSequence, currentDigit);
    }

    /**
     * Finds the length of the longest sequence of repeated digits in a number.
     *
     * @param num: The number to find the sequence in.
     * @return int: Return the longest streak of repeated digits found in the number.
     **/
    public static int equalDigits (int num){
        return equalDigits(num, 0, 0, 0);
    }


    // ****************** EX2 ********************

    /**
     *A recursive function that finds all the digits in a number that divides by a given digit
     * And returns it as a number
     *<br><br>
     * For example: digit = 3, num = 387960 the number will find the numbers 3,9,6,0 and will return 3960
     * <br><br>
     * @param num: A number to find the sub number in.
     * @param digit: The digits that all the sub number digits divides in.
     * @return int: Return the sub number that all of its digits are digits that divides by the given digit
     **/
    public static int subNumber(int num, int digit) {
        int currentDigit;

        //Brake condition
        if (num == 0)
            return 0;

        currentDigit = num % 10;

        //If the current digit divides by the digit.
        // then add the digit to the subNumber
        if (currentDigit % digit == 0){
            return currentDigit + subNumber(num/10, digit) * 10;
        }

        return subNumber(num/10, digit);
    }


    // ****************** EX3 ********************

    /**
     *A help recursive function that checks if a number is a special number.
     <br><br>
     * A special number is a number that is explained by the next example:
     *<br><br>
     * The group of Natural numbers - 1,2,3,4,5,6,7,8,9,10,11,12..... <br><br>
     * For the first round we will remove any 2 number - 1,3,5,7,9,11....<br><br>
     * For the second round we will remove any 3 number - 1,3,7,9,13....<br><br>
     * And so on and so on.... Every number that is not remove is a special number
     *<br><br>
     *
     * @param n: The number to check if it`s a special number.
     * @param eliminationHops: The revolutions of numbers to eliminate
     * @return boolean: Return True if the number is special, False if not.
     **/
    public static boolean isSpecial(int n, int eliminationHops){
        int numbersToEliminate = n / eliminationHops;

        //Brake condition 1 - The elimination revolution removed the given number thus the number is not special
        if (n % eliminationHops == 0)
            return false;

        //Brake condition 2 - The elimination revolution passed the given number thus the number will never be eliminated
        // and the number is special
        if (numbersToEliminate == 0)
            return true;

        n -= numbersToEliminate;
        return isSpecial(n, ++eliminationHops);
    }

    /**
     * This function get a number and tells if the number is a special number.
     * <br><br>
     * A special number is a number that is explained by the next example:
     *<br><br>
     * The group of Natural numbers - 1,2,3,4,5,6,7,8,9,10,11,12..... <br><br>
     * For the first round we will remove any 2 number - 1,3,5,7,9,11....<br><br>
     * For the second round we will remove any 3 number - 1,3,7,9,13....<br><br>
     * And so on and so on.... Every number that is not remove is a special number
     *<br><br>
     *
     * @param n: The number to check if it`s a special number.
     * @return boolean: Return True if the number is special, False if not.
     **/
    public static boolean isSpecial (int n) {
        return isSpecial(n, 2);
    }
}
