package Ex14;

public class IntListTwo {
    private IntNodeTwo _head, _tail;

    public IntListTwo() {
        _head = null;
        _tail = null;
    }

    /**
     * This function adds a new node with the specified value to the end of the list.
     * If the list is empty, the new node becomes the head of the list.
     * If there is only one node in the list, the new node is set as the tail and linked to the head.
     * Otherwise, the new node is appended to the end and becomes the new tail.
     *
     * @param num: The integer value of the new node to be added to the list.
     */
    public void addToEnd(int num) {
        IntNodeTwo newNode = new IntNodeTwo(num);
        //Checks is the list is empty
        if (_head == null) {
            _head = newNode;
        }
        // If there is only one node in the list
        else if (_tail == null) {
            newNode.setPrev(_head);
            _head.setNext(newNode);
            _tail = newNode;
        }
        else {
            newNode.setPrev(_tail);
            _tail.setNext(newNode);
            _tail = newNode;
        }
    }

    /**
     * A To String function - THe function returns a string representation of the list.
     * The format is a comma-separated list of values enclosed in braces.
     * If the list is empty, returns "{}".
     *
     * @return String: A string representing the list.
     */
    public String toString() {
        String str = "{";

        if (_head == null)
            return str + "}";

        if (_tail == null)
            return str + _head.getNum() + "}";

        for (IntNodeTwo current = _head; current.getNext() != null && current != _tail; current = current.getNext()) {
            str += current.getNum() + ", ";
        }

        str += _tail.getNum() + "}";;

        return str;
    }

    /**
     * A recursive helper method for generating the string representation of the list in reverse order.
     * This method is called internally by the public `toStringReverse()` method.
     * It starts from a given node and recursively traverses to the previous node until it reaches the head.
     * The method constructs a comma-separated string of the node values in reverse order.
     *
     * @param currentNode The current node being processed in the recursion.
     * @return String: A string representing a portion of the list in reverse order,
     *         starting from `currentNode` and ending at the head of the list.
     */
    private String toStringReverse(IntNodeTwo currentNode) {
        //Brake condition
        if (currentNode == null || currentNode == _head)
            return _head.getNum() + "}";

        return currentNode.getNum() + ", " +  toStringReverse(currentNode.getPrev());
    }


    /**
     * A To String Reverse function - the function returns a string representation of the list in reverse order.
     * This method is using an overloading recursive function and is initially called with the tail of the list.
     * The format is a comma-separated list of values enclosed in braces.
     * If the list is empty, returns "{}".
     *
     * @return String: A string representing the list in reverse order.
     */
    public String toStringReverse() {
        if (_head == null)
            return "{}";

        return "{" + toStringReverse(_tail);
    }

    /**
     * Helper method for isWay. It recursively checks whether a valid path exists from a given node,
     * considering a specific direction (right or left) and steps to move.
     * The method avoids infinite loops by tracking the left boundary and ensuring
     * that moves don't go beyond the list boundaries.
     *
     * @param currentNode: The current node from which to check the path.
     * @param leftBoundaryNode: The node that acts as a left boundary to avoid revisiting the same node.
     * @param steps: The number of steps to move in the current direction.
     * @param goRight: A boolean indicating the direction of movement (true for right, false for left).
     * @return boolean: True if a valid path is found from the current node to the tail, false otherwise.
     */
    private boolean isWay(IntNodeTwo currentNode, IntNodeTwo leftBoundaryNode,int steps, boolean goRight) {
        // Brake condition - there is a way in the list
        if (currentNode == null || currentNode.getNum() == 0)
            return false;

        //Move Right/Left on the list
        if (steps > 0)
            return isWay(goRight ? currentNode.getNext() : currentNode.getPrev(), leftBoundaryNode, --steps, goRight);


        // Brake condition - Got to tail, there is a way in the list
        if (currentNode == _tail)
            return true;

        //Brake condition - The current node got to the left boundary - meaning that the current node returned to a
        // visited node
        if (currentNode == leftBoundaryNode)
            return false;

        //Set the left boundary
        if (!goRight){
            leftBoundaryNode = currentNode;
        }

        //Explores the left and right "ways" of the node
        return isWay(currentNode, leftBoundaryNode, currentNode.getNum(), true) || isWay(currentNode, leftBoundaryNode, currentNode.getNum(), false);
    }

    /**
     * A Function to determines whether there is a valid path through the list starting from the head.
     * A valid path is defined as a sequence of moves starting from the head of the list,
     * where each move is either to the right (next) or left (previous) by a number of steps
     * equal to the value of the current node. The path is considered valid if it ends at the
     * tail of the list.
     *
     * @return boolean: True if a valid path exists from head to tail, false otherwise.
     */
    public boolean isWay() {
        return isWay(_head, null, 0, false);
    }
}
