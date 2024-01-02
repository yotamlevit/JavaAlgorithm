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

        if (num == 0)
            return longestSequence;

        currentDigit = num % 10;

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

    public static int subNumber(int num, int digit) {
        int currentDigit;

        if (num == 0)
            return 0;

        currentDigit = num % 10;

        if (currentDigit % digit == 0){
            return currentDigit + subNumber(num/10, digit) * 10;
        }

        return subNumber(num/10, digit);
    }
}
