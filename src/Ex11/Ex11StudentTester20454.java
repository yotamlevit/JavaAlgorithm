
public class Ex11StudentTester20454
{
    public static void main(String[] args) {

        System.out.println("----------------------------------------");
        System.out.println("***         Q1  - maxMult3           ***");
        System.out.println("----------------------------------------");
        System.out.println("arr:[-8,1,-4,11,9,-15,10,8,-3]");
        int[] arr={-8,1,-4,11,9,-15,10,8,-3};
        int result1=Ex11.maxMult3(arr);
        if (result1==1320)
            System.out.println("Passed, result is 1320");
        else
            System.out.println("Failed,  expected: 1320   student's result: "+result1);
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("***      Q2  - findMedian            ***");
        System.out.println("----------------------------------------");
        {
            int []arr1 = {1,12,15,26,38};
            int []arr2 = {12,13,18,30,45};
            System.out.println("arr1: [1,12,15,26,38]");
            System.out.println("arr1: [12,13,18,30,45]");
            int result2=Ex11.findMedian(arr1,arr2);
            if (result2==16)
                System.out.println("Passed, result is 16");
            else
                System.out.println("Failed,  expected: 16  student's result: "+result2);
        }
    }
}
