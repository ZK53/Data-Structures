import java.util.EmptyStackException;

public class MyLinkedStack<T> {
    private Node<T> top;
    private int size = 0;

    @SuppressWarnings("hiding")
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedStack() {
        top = null;
        size = 0;
    }

    public void push(T t) {
        Node<T> newNode = new Node<T>(t);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public T pop() {
        if (!isEmpty()) {
            T t = top.data;
            top = top.next;
            size--;
            return t;
        } else {
            throw new EmptyStackException();
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return top.data;
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int length() {
        return size;
    }

    public boolean contains(T t) {
        Node<T> currentNode = top;
        while (currentNode != null) {
            if (currentNode.data.equals(t)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public String toString() {
        Node<T> currentNode = top;
        StringBuilder stack = new StringBuilder("{");
        while (currentNode != null) {
            stack.append(currentNode.data.toString());
            if (currentNode != null) {
                stack.append(", ");
            }
            currentNode = currentNode.next;
        }
        stack.append("}");
        return stack.toString();
    }
}
