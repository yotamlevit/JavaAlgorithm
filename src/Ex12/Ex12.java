public class Ex12 {

    // ****************** EX1 ********************

    public static int equalDigits(int num, int countSequence, int longestSequence, int checkDigit){
        int currentNum;

        if (num == 0){
            if (countSequence > longestSequence)
                longestSequence = countSequence;

            return longestSequence;
        }

        currentNum = num % 10;

        if (currentNum == checkDigit)
            equalDigits(num/10, countSequence++, longestSequence, checkDigit);
        else{
            if (countSequence > longestSequence)
                longestSequence = countSequence;

            equalDigits(num/10, 0, longestSequence, currentNum);
        }

        return 0;
    }

    public static int equalDigits (int num){
        return equalDigits(num/10, 1, 0, num%10);
    }


    public static void main(String[] args) {
        System.out.println("EX1");
        int num = 57779227;

        System.out.println("The longest sequence is: " + equalDigits(num));

        System.out.println("EX2");

    }
}
