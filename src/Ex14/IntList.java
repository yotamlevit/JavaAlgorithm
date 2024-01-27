package Ex14;

import java.util.HashMap;
import java.util.Map;

public class IntList {
    private IntNode _head;
    public IntList( ) {
        _head = null;
    }

    public void addToEnd(int num) {
        // adds num at the end of the list
        IntNode node = new IntNode(num);
        if (_head == null)
            _head = node;
        else {
            IntNode ptr = _head;
            while (ptr.getNext( ) != null)
                ptr = ptr.getNext( );
            ptr.setNext(node);
        }
    }

    public String toString()
    {
        String s = "";
        IntNode temp = _head;
        while (temp != null)
        {
            s = s+ temp.getValue() + " --> ";
            temp = temp.getNext();
        }
        s+= " null";
        return s;
    }


    /**
     * This function searches for a sequence of nodes in the list that their sum is num
     <br><br>
     * Time complexity: O(n^2), where n is the length of the list. ------------------------------------
     *                 The function iterates through each element of the array once in a single for-loop.
     *                 In the for-loop the function preforms a constant number of comparisons and assignments.
     * <br><br>
     * Space complexity: O(1), the function uses a fixed number of integers variable (1).
     *                         These variables don't depend on the size of the input array
     * <br><br>
     *
     * @param num: The number that is the wanted sum.
     * @return boolean: True if there is streak of nodes that their sum is num false if not.
     **/
    public boolean subListSum(int num) {
        int sum = 0;

        for (IntNode originNode = _head; originNode != null; originNode = originNode.getNext()) {
            sum = 0;

            for (IntNode currentNode = originNode; currentNode != null && sum < num; currentNode = currentNode.getNext()) {
                sum += currentNode.getValue();
            }

            if (sum == num)
                return true;
        }
        return false;
    }


    private IntList calculatePrefixSum() {
        IntList prefixSum = new IntList();
        IntNode current = _head;
        int sum = 0;

        while (current != null) {
            sum += current.getValue();
            prefixSum.addToEnd(sum);
            current = current.getNext();
        }

        return prefixSum;
    }

    /*
    private IntNode averageNode(int sum, int count, IntNode current){
        if (current.getNext().getNext() == null)
            sum += current.getValue();
            return sum/++count > current.getNext().getValue()
    }
    */

    public IntNode averageNode(){
        IntNode current = _head;
        IntNode maxDiffNode = _head;
        double prefixAvg = 0, postfixAvg = 0, currentDiff = 0, maxDiff = 0;
        int length = 0, sum = 0, index = 0;

        if (_head == null || _head.getNext() == null) {
            return null;
        }


        while (current != null) {
            length++;
            current = current.getNext();
        }

        int[] cumulativeSums = new int[length];

        for (current = _head; current != null; current = current.getNext()) {
            sum += current.getValue();
            cumulativeSums[index++] = sum;
        }

        index = 0;

        for (current = _head; current.getNext() != null; current = current.getNext()) {
            prefixAvg = (double) cumulativeSums[index] / (index + 1);
            postfixAvg = (double) (cumulativeSums[length-1] - cumulativeSums[index]) / (length - index -1);
            currentDiff = Math.abs(prefixAvg - postfixAvg);
            System.out.println("Prefix: " + prefixAvg + "|    Postfix: " + postfixAvg + "|      currentdiff: "+ currentDiff + "|   maxDiffValue: " + maxDiffNode.getValue());
            if (currentDiff >= maxDiff) {
                maxDiff = currentDiff;
                maxDiffNode = current;
            }

            index++;
        }

        System.out.println("---------------");
        return maxDiffNode;
    }
}
