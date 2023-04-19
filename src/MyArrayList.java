package src;

public class MyArrayList<T> implements MyList<T> {
    private T[] arr;
    private int size;

    public MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param o the element to be searched for
     * @return true if this list contains the specified element
     */
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item the element to be added to this list
     */
    public void add(T item) {
        if (size == arr.length) {
            increaseBuffer();
        }
        arr[size++] = item;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param item the element to be inserted into this list
     * @param index the index at which the specified element is to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
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

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param item the element to be removed from this list, if present
     * @return true if this list contained the specified element, false otherwise
     */
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

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T remove(int index) {
        checkIndex(index);
        T item = arr[index];
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        arr[size-1] = null;
        size--;
        return item;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */

    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    /**
            * Returns the index of the first occurrence of the specified element in this list,
            * or -1 if this list does not contain the element.
            *
            * @param o the element to search for
            * @return the index of the first occurrence of the specified element in this list,
            * or -1 if this list does not contain the element
    */
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
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



    /**
     Increases the size of the internal array buffer when it is full.
     The new buffer size is twice the size of the current buffer.
     The existing elements in the buffer are copied to the new buffer.
     */
    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }


    /**
     * Checks whether the given index is in the range of valid indices for this list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
