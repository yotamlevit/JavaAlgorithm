public class Ex11{

    /**
    *This function finds the biggest multiplication of 3 numbers from an array of integers.
    * <br><br>
    * Time complexity: O(n), where n is the length of the input array.
    *                 The function iterates through each element of the array once in a single for-loop.
    *                 In the for-loop the function preforms a constant number of comparisons and assignments.
    * <br><br>
    * Space complexity: O(1), the function uses a fixed number of integers variable.
                      These variables don't depend on the size of the input array
    * <br><br>
    * @param arr: An array of integers
    * @return int: Return the biggest multiplication of 3 numbers in the array.
    *             If the array had less then 3 numbers the function returns the minimum vaLur of int
     **/
    public static int maxMult3(int [] arr) {
        // Initialize variables to store the two smallest and three largest numbers
        int nimNum = Integer.MAX_VALUE,
                nimNum2 = Integer.MAX_VALUE,
                maxNum = Integer.MIN_VALUE,
                maxNum2 = Integer.MIN_VALUE,
                maxNum3 = Integer.MIN_VALUE,
                minNumbersMult, maxNumbersMult;

        //Function Condition
        if (arr.length < 3)
            return Integer.MIN_VALUE;

        //Finds the 3 biggest and 2 smallest numbers from the array
        for (int num: arr) {
            if (num < nimNum){
                nimNum2 = nimNum;
                nimNum = num;
            } else if (num < nimNum2) {
                nimNum2 = num;
            }

            if (num > maxNum){
                maxNum2 = maxNum;
                maxNum = num;
            } else if (num > maxNum2) {
                maxNum3 = maxNum2;
                maxNum2 = num;
            } else if (num > maxNum3) {
                maxNum3 = num;
            }
        }

        minNumbersMult = nimNum2 * nimNum;
        maxNumbersMult = maxNum2 * maxNum2;

        //Checks if the multiplication of the smallest numbers is bigger then the multiplication 2 biggest numbers
        if (minNumbersMult > maxNumbersMult)
            return minNumbersMult * maxNum;
        else
            return maxNumbersMult * maxNum3;
    }


    // *************************** EX 2 *******************************


    /**
     * This function finds the upper bound index for a specified key in a sorted array.
     * The upper bound is the index of the first element in the array that is bigger then the key.
     * <br><br>
     *
     * Time complexity: O(log n), where n is the length of the input array.
     *                  The function uses binary search to find the upper bound of a given key in a sorted array.
     *                  In each iteration the function halves the search space in the array,
     *                  therefore leading to a logarithmic time.
     * <br><br>
     * Space Complexity: O(1), the function uses a fixed number of integers variable.
     *                       These variables don't depend on the size of the input array
     * <br><br>
     * @param arr: A sorted array of integers.
     * @param key: The key for which the upper bound index is to be found
     * @return int: The upper bound index of the key in the array.
     *              If all elements are less then or equal to the ket, the function returns the array length.
     */
    public static int findUpperBound(int[] arr, int key)
    {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + ((high - low) >> 1);

            if (arr[mid] <= key)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    /**
    * This function finds the median element in a merged, sorted form of two sorted arrays.
    * The function assumes that both arrays are sorted in an increasing order, and have the same length.
    * <br><br>
    * Time complexity: O(log n), where n is the length of the arrays.
     *                 The function preforms a binary search over the arrays. Then calls the upperBound functions
     *                 That has a complexity of O(log n). During each iteration of the loop the function calls
     *                 the upperBound function twice thus O(2 log n) = O(log n).
     *                 The loop binary search is logarithmic with respect to the range of numbers.
     *                 The total number of iterations in the binary search is proportional to the logarithm of the range.
     *                 Therefore, the overall complexity is O(log n * log range) = O(log n)
    * <br><br>
    * Auxiliary Space : O(1), the function uses a fixed number of integers variable.
    *                   These variables don't depend on the size of the input array.
    *
    * <br><br>
    * @param arr1: The first sorted array of integers
    * @param arr2 : The second sorted array of integers
    * @return int: Returns the median of the combined sorted arrays
     **/
    public static int findMedian(int[] arr1, int[] arr2){
        int low = Math.min(arr1[0], arr2[0]) , high = Math.max(arr1[arr1.length -1], arr2[arr2.length -1]);
        int pos = arr1.length;
        int answer = 0;
        int mid;

        //Binary search to find the element witch will be at pos = mergedArray.length/2
        while (low <= high) {
            mid = low + ((high - low) >> 1);

            // the number of elements in the arrays witch are less than mid
            int upperBound = findUpperBound(arr1, mid) + findUpperBound(arr2, mid);

            if (upperBound <= pos)
                low = mid + 1;
            else
                high = mid - 1;
        }

        answer = low;

        // Because there are even number of elements, there is a need to find the element at pos = mergedArrary/2 -1
        pos--;
        low = Math.min(arr1[0], arr2[0]);
        high = Math.max(arr1[arr1.length -1], arr2[arr2.length -1]);;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            int ub = findUpperBound(arr1, mid)
                    + findUpperBound(arr2, mid);

            if (ub <= pos)
                low = mid + 1;
            else
                high = mid - 1;
        }

        answer = (answer + low) / 2;

        return answer;
    }
}
