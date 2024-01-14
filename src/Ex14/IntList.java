package Ex14;

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
}
