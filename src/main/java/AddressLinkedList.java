public class AddressLinkedList implements AddressList {
    private Node first;
    private Node last;
    private int size;

    @Override
    public Address get(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(Address address) {
        if (size == 0) {
            Node node = new Node(null, address, null);
            first = node;
            last = node;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, address, null);
            secondLast.next = last;
        }
        size++;
    }

    @Override
    public void add(Address address, int index) {
        if (index < 0 || index > size) {
            new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(address);
            return;
        }

        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, address, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;

    }

    @Override
    public boolean remove(Address address) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(address)) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;

        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private static class Node {
        private Node previous;
        private Address value;
        private Node next;

        public Node(Node previous, Address value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    private Node getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

}
