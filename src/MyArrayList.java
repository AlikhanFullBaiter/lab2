package src;

public class MyArrayList<T> implements MyList<T> {
    private T[] arr;
    private int size;

    public MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public void add(T item) {
        if (size == arr.length) {
            increaseBuffer();
        }
        arr[size++] = item;
    }

    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == arr.length) {
            increaseBuffer();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;
    }

    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                for (int j = i + 1; j < size; j++) {
                    arr[j - 1] = arr[j];
                }
                arr[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }


    public T remove(int index) {
        checkIndex(index);
        T item = arr[index];
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        arr[size-1] = null;
        return item;
    }

    public void clear() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {

    }


    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
