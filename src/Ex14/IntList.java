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
     * Time complexity: O(n^2), where n is the length of the list.
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

    /**
     * This function finds the node in the linked list that maximizes the absolute difference
     * between the averages of the numbers in the two parts of the list divided by this node.
     * The left part includes all nodes up to and including the current node,
     * and the right part includes all nodes after the current node.
     * Meaning -
     * The function find the node that the difference between
     * the average value of the node to its "left"
     * and the average value of the nodes to its "right" is the biggest
     *
     * <br><br>
     * Time complexity: O(n), where n is the length of the list.
     *                  The function traverses the list three times - once for calculating the total length of the list,
     *                  and again for populating the prefix sums.
     *                  The final iteration for finding the maximum difference also takes linear time.
     * <br><br>
     Space Complexity: O(n), due to the additional array used to store prefix sums.
     *                 The space required for this array scales linearly with the number of nodes in the list.
     * <br><br>
     *
     *
     * @return IntNode: The node that maximizes the absolute difference of averages.
     *                  If the list is empty or has only one node the function returns null.
     */
    public IntNode averageNode(){
        IntNode current = _head;
        IntNode maxDiffNode = _head;
        double prefixAvg = 0, postfixAvg = 0, currentDiff = 0, maxDiff = 0;
        int length = 0, sum = 0, index = 0;

        // Checks if list is empty
        if (_head == null || _head.getNext() == null) {
            return null;
        }

        //Finds the list length
        while (current != null) {
            length++;
            current = current.getNext();
        }

        // An array that will contain the prefix sum for each node
        int[] prefixSums = new int[length];

        // Calculate the prefixf sums
        for (current = _head; current != null; current = current.getNext()) {
            sum += current.getValue();
            prefixSums[index++] = sum;
        }

        index = 0;

        // Finds the node will the biggest difference between his prefix average and postfix average
        for (current = _head; current.getNext() != null; current = current.getNext()) {
            prefixAvg = (double) prefixSums[index] / (index + 1);
            postfixAvg = (double) (prefixSums[length-1] - prefixSums[index]) / (length - index -1);
            currentDiff = Math.abs(prefixAvg - postfixAvg);
            if (currentDiff >= maxDiff) {
                maxDiff = currentDiff;
                maxDiffNode = current;
            }

            index++;
        }

        return maxDiffNode;
    }
}
