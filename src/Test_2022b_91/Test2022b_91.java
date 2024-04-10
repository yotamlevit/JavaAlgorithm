package Test_2022b_91;

public class Test2022b_91 {

    public static int cheapRt(int[] stations, int step1, int step2, int limit, int currentIndex, int currentCost, String trackOutput) {
        int step1Result = Integer.MAX_VALUE, step2Result = Integer.MAX_VALUE;

        if (currentIndex == stations.length-1) {
            currentCost += stations[currentIndex];
            System.out.println(trackOutput + " " + currentIndex + " = " + currentCost);
            return currentCost;
        }

        if (currentIndex > stations.length-1)
            return Integer.MAX_VALUE;

        step1Result = cheapRt(stations, step1, step2, limit, currentIndex+step1, currentCost+stations[currentIndex], trackOutput + " " + currentIndex);

        if (limit > 0)
            step2Result = cheapRt(stations, step1, step2, limit-1, currentIndex+step2, currentCost+stations[currentIndex], trackOutput + " " + currentIndex);

        return Math.min(step1Result, step2Result);

    }

    public static int cheapRt(int[] stations, int step1, int step2, int limit) {
        return cheapRt(stations, step1, step2, limit, 0, 0, "");
    }

    public static int findTriplet(int[] arr){
        int maxPos1 = 0, maxPos2 = 0, maxPos3 = 0;
        int minNeg1 = 0, minNeg2 = 0, minNeg3 = 0;

        for (int i = 0; i < arr.length; i++){

            if (arr[i] > maxPos3){
                if (arr[i] > maxPos2){
                    if (arr[i] > maxPos1) {
                        maxPos3 = maxPos2;
                        maxPos2 = maxPos1;
                        maxPos1 = arr[i];
                    }
                    else{
                        maxPos3 = maxPos2;
                        maxPos2 = arr[i];
                    }
                }
                else
                    maxPos3 = arr[i];
            }

            if (arr[i] < minNeg3){
                if (arr[i] < minNeg2){
                    if (arr[i] < minNeg3) {
                        minNeg3 = minNeg2;
                        minNeg2 = minNeg1;
                        minNeg1 = arr[i];
                    }
                    else{
                        minNeg3 = minNeg2;
                        minNeg2 = arr[i];
                    }
                }
                else
                    minNeg3 = arr[i];
            }


        }

        return Math.max(minNeg1 * minNeg2 * maxPos1, maxPos1 * maxPos2 * maxPos3);
    }

    public static void main(String[] args) {
        int[] stations = {2,4,8,3,10,1,12,3,2};
        System.out.println(cheapRt(stations, 3, 2, 4));
        System.out.println("--------------------------------------------");
        System.out.println(cheapRt(stations, 3, 6, 4) + " Integer.Max_value");

        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");

        //int[] arr = {-4,1,-8,9,6};
        int[] arr = {-4,-3,-8};
        System.out.println(findTriplet(arr));
    }
}
