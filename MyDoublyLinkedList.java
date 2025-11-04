public class MyDoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @SuppressWarnings("hiding")
    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> previous;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public MyDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public T firstElement() {
        return head.data;
    }

    public T lastElement() {
        return tail.data;
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void linkFirst(T t) {
        Node<T> newNode = new Node<T>(t);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public void unlinkFirst() {
        if (head == null)
            return;
        if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        size--;
    }

    public void add(T t, int index) {
        if (index == 0) {
            linkFirst(t);
        } else if (index == size) {
            linkLast(t);
        } else {
            Node<T> newNode = new Node<T>(t);
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            newNode.previous = currentNode.previous;
            newNode.next = currentNode;
            currentNode.previous.next = newNode;
            currentNode.previous = newNode;
            size++;
        }
    }

    public void add(T t) {
        linkLast(t);
    }

    public void linkLast(T t) {
        Node<T> newNode = new Node<T>(t);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;

        }
        size++;
    }

    public void unlinkLast() {
        if (tail == null)
            return;
        if (tail.previous == null) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
    }

    public void delete(int index) {
        if (index == 0) {
            unlinkFirst();
            return;
        }
        if (index == size - 1) {
            unlinkLast();
            return;
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next.next.previous = currentNode;
        currentNode.next = currentNode.next.next;
        size--;
    }

    public T getElement(int index) {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public void set(T t, int index) {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = t;
    }

    public int indexOf(T t) {
        Node<T> currentNode = head;
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
