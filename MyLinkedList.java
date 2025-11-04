public class MyLinkedList<T> {
    private Node<T> first;
    private int size = 0;

    @SuppressWarnings("hiding")
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public MyLinkedList() {
        first = null;
        size = 0;
    }

    T firstElement() {
        return first.data;
    }

    T lastElement() {
        return getElement(size - 1);
    }

    int length() {
        return size;
    }

    boolean isEmpty() {
        return first == null;
    }

    public void linkfirst(T t) {
        final Node<T> newNode = new Node<T>(t);
        if (first == null) {
            first = newNode;
        } else {
            final Node<T> f = first;
            newNode.next = f;
            first = newNode;
        }

        size++;
    }

    public void unlinkFirst() {
        if (first == null)
            return;
        first = first.next;
        size--;
    }

    public void add(T t, int index) {
        Node<T> newNode = new Node<T>(t);
        Node<T> predNode = first;
        if (index == 0) {
            linkfirst(t);
        } else {
            for (int i = 0; i < index - 1; i++) {
                predNode = predNode.next;
            }
            newNode.next = predNode.next;
            predNode.next = newNode;
            size++;
        }
    }

    public void add(T t) {
        linkLast(t);
    }

    public void linkLast(T t) {
        Node<T> newNode = new Node<T>(t);
        if (first == null) {
            first = newNode;
        } else {
            Node<T> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void unlinkLast() {
        if (first == null) {
            return;
        } else if (first.next == null) {
            first = null;
        } else {
            Node<T> node = getNode(size - 2);
            node.next = null;
        }
        size--;
    }

    public void delete(int index) {
        if (index == 0) {
            unlinkFirst();
            return;
        }
        Node<T> predNode = first;
        for (int i = 0; i < index - 1; i++) {
            predNode = predNode.next;
        }
        predNode.next = predNode.next.next;
        size--;
    }

    public T getElement(int index) {
        Node<T> predNode = first;
        for (int i = 0; i < index; i++) {
            predNode = predNode.next;
        }
        return predNode.data;
    }

    private Node<T> getNode(int index) {
        Node<T> predNode = first;
        for (int i = 0; i < index; i++) {
            predNode = predNode.next;
        }
        return predNode;
    }

    public void printList() {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            System.out.print(current + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void set(T t, int index) {
        getNode(index).data = t;
    }

    public int indexOf(T t) {
        Node<T> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.data.equals(t)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public boolean contains(T t) {
        return indexOf(t) != -1;
    }
}
