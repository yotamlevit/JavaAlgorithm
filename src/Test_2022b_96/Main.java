package Test_2022b_96;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int calc(int num, int calcResult, int result, int maxOp, String output){
        int add = 0, sub = 0, mul = 0, div = 0;
        if (calcResult == result) {
            System.out.println(output);
            return 1;
        }

        if (maxOp == 0)
            return 0;

        sub = calc(num, calcResult - num, result, maxOp - 1,output + "-" + num);
        add = calc(num, calcResult + num, result, maxOp - 1, output + "+" + num);
        div = calc(num, calcResult / num, result, maxOp - 1, output + "/" + num);
        mul = calc(num, calcResult * num, result, maxOp - 1, output + "*" + num);


        return add + sub + mul + div;
    }

    public static int calc(int num, int result, int maxOp) {
        return calc(num, num, result, maxOp, String.valueOf(num));
    }

    /**
     * makes a binary search in an almost sorted array.
     * An almost sorted array is an array that has 0-s in it.
     *
     * @param a: int array The number to use in the calculations.
     * @param num int target result to achieve.
     * @return - int the index that the number is in the array,
     *           -1 if the number is not found in the array
     */
    public static int kAlmostSearch(int[] a, int num){
        {
            int low = 0, high = a.length - 1;
            int mid;
            while (low <= high) {
                mid = low + (high - low) / 2;

                if (a[mid] == 0){
                    int temp = mid;
                    while (a[mid++] == 0 && mid < high);

                    if (mid == high){
                        mid = temp;
                        while (a[mid--] == 0 && mid > low);
                        if (mid == low)
                            return -1;
                    }


                }

                // Check if x is present at mid
                if (a[mid] == num)
                    return mid;

                // If x greater, ignore left half
                if (a[mid] < num)
                    low = mid + 1;
                    // If x is smaller, ignore right half
                else
                    high = mid - 1;
            }

            // If we reach here, then element was
            // not present
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(calc(3,36,4));
        System.out.println("---------------------------------");
        int[] a = {3,0,0,4,7,9,0,0,0,0,11,15,0,19,20,0,0,31,40,0};
        System.out.println(kAlmostSearch(a, 9));
        System.out.println(kAlmostSearch(a, 31));
        System.out.println(kAlmostSearch(a, 30));
    }
}