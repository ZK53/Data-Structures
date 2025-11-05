public class MyLinkedQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @SuppressWarnings("hiding")
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T t) {
            this.data = t;
            this.next = null;
        }
    }

    public MyLinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(T t) {
        Node<T> newNode = new Node<T>(t);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        } else {
            T t = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return t;
        }
    }

    public T peek() {
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int length() {
        return size;
    }

    public boolean contains(T t) {
        Node<T> curretNode = head;
        while (curretNode != null) {
            if (curretNode.data.equals(t)) {
                return true;
            }
            curretNode = curretNode.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder queue = new StringBuilder("{");
        Node<T> currentNode = head;
        while (currentNode != null) {
            queue.append(currentNode.data);
            currentNode = currentNode.next;
            if (currentNode != null) {
                queue.append(", ");
            }
        }
        queue.append("}");
        return queue.toString();
    }
}
