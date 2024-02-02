package Ex14;

public class IntListTwo {
    private IntNodeTwo _head, _tail;

    public IntListTwo() {
        _head = null;
        _tail = null;
    }

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

    private String toStringReverse(IntNodeTwo currentNode) {
        //Brake condition
        if (currentNode == null || currentNode == _head)
            return _head.getNum() + "}";

        return currentNode.getNum() + ", " +  toStringReverse(currentNode.getPrev());
    }

    public String toStringReverse() {
        if (_head == null)
            return "{}";
        
        return "{" + toStringReverse(_tail);
    }

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

        if (currentNode == leftBoundaryNode)
            return false;

        if (!goRight){
            leftBoundaryNode = currentNode;
        }

        return isWay(currentNode, leftBoundaryNode, currentNode.getNum(), true) || isWay(currentNode, leftBoundaryNode, currentNode.getNum(), false);
    }

    public boolean isWay() {
        return isWay(_head, null, 0, false);
    }
}
