public class MyQueue<T> {
    private Object[] elements;
    private int size;
    private int capacity;
    private int front;
    private int back;

    public MyQueue(int capacity) {
        elements = new Object[capacity];
        this.capacity = capacity;
        size = 0;
        back = 0;
        front = 0;
    }

    public void enqueue(T t) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        elements[back] = t;
        back = (back + 1) % capacity;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T t = (T) elements[front];
        elements[front] = null;
        front = (front + 1) % capacity;
        size--;
        return t;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) elements[front];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            if (elements[index].equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder queue = new StringBuilder("{");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            queue.append(elements[index]);
            if (i != size - 1) {
                queue.append(", ");
            }
        }
        queue.append("}");
        return queue.toString();
    }
}
