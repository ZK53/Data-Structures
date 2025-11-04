import java.util.EmptyStackException;

public class MyStack<T> {
    private Object[] elements;
    private int size = 0;
    private int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return (T) elements[size - 1];
    }

    public void push(T t) {
        if (isFull())
            resize();
        elements[size++] = t;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T t = (T) elements[--size];
        elements[size] = null;
        return t;
    }

    public void resize() {
        capacity *= 2;
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    public boolean contains(T t) {
        for (int i = 0; i < length(); i++) {
            if (elements[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stack = new StringBuilder("{");
        for (int i = size; i >= 0; i--) {
            stack.append(elements[i]);
            if (i != size - 1) {
                stack.append(", ");
            }
        }
        stack.append("}");
        return stack.toString();
    }
}
