public class List {
    private String[] arr;
    int size;

    public List(int capacity) {
        arr = new String[capacity];
        size = 0;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    public void set(int index, String item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = item;
    }

    public void add(int index, String item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (isFull()) {
            throw new RuntimeException("List is full");
        }
        for (int i = size; i >= index + 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public String toString() {
        String string = "[";
        for (int i = 0; i < size; i++) {
            string += arr[i];
            if(i < size - 1) string += ", ";
        }
        string += "]";
        return string;
    }
}
