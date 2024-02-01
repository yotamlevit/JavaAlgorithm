package Ex14;

public class IntListTwo {
    private IntNodeTwo _head, _tail;

    public IntListTwo() {
        _head = null;
        _tail = null;
    }

    public void addToEnd(int num) {
        System.out.println(num);
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
        return "{" + toStringReverse(_tail);
    }
}
