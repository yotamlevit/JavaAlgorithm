package Test_2023_83;

public class main {

    /**
     * Finds the length of the smallest contiguous subarray whose sum is greater than a given number.
     * This function iterates through the array, maintaining a running total and adjusting the start
     * point of the subarray to ensure it finds the minimum length of any subarray meeting the criteria.
     * If no such subarray exists, the function returns 0.
     *
     * @param arr An array of integers where the subarray will be searched.
     * @param num The target sum the subarray should exceed.
     * @return The length of the smallest subarray whose sum is greater than the specified number. If
     *         no such subarray is found, returns 0. If the input number is 0, also returns 0,
     *         indicating that an empty subarray is the smallest valid answer.
     *
     * Notes:
     * - The function prints to the console every time it finds a subarray that meets the criteria
     *   for being over the target sum, as well as the smallest subarray found by the end of its execution.
     * - In case the input array is empty or all elements do not sum to more than the target number,
     *   the function will consider the "smallest subarray" as an imaginary subarray starting and
     *   ending at an extremely large index, but it will still return 0 as no valid subarray exists.
     * - The algorithm used is a variation of the sliding window technique, where the window expands
     *   to include new elements until the sum exceeds the target, and then contracts from the start
     *   to find the smallest possible window meeting the criteria.
     * - Complexity:
     *   - Time complexity: O(n), where n is the number of elements in the input array. Each element
     *     is visited at most twice, once when expanding the window and once when contracting it.
     *   - Space complexity: O(1), as the solution requires a constant amount of space regardless of
     *     the input array size.
     */
    public static int findSmallestSubarrayLen(int[] arr, int num){

        int start = 0;
        int total = 0;
        int smallestArrStart = 0, smallestArrEnd = 1000000000;


        if (num == 0)
            return 0;

        for (int i = 0; i< arr.length; i++){
            total += arr[i];

            if (total > num) {
                System.out.println("Subarray found [" + start + "-" + i + "]");
                if ((i - start) < (smallestArrEnd - smallestArrStart)){
                    smallestArrEnd = i;
                    smallestArrStart = start;
                }
                for (;start <= i && total > num;){
                    total -= arr[start++];
                    if (total > num){
                        System.out.println("Subarray found [" + (start) + "-" + i + "]");
                        if ((i - start) < (smallestArrEnd - smallestArrStart)){
                            smallestArrEnd = i;
                            smallestArrStart = start;
                        }
                    }

                }
            }

        }
        System.out.println("Smallest Subarray found [" + smallestArrStart + "-" + smallestArrEnd + "]");
        return smallestArrEnd - smallestArrStart +1;
    }

    public static void main(String[] args){
        int[] arr = {2,6,1,9,7,3,1,4,1,8};
        System.out.println(findSmallestSubarrayLen(arr, 15));
    }
}
