# MyArrayList 🧩
This is a Java implementation of a generic ***ArrayList*** data structure. It implements the *MyList* interface, which defines a set of methods that can be used to manipulate a list of elements.


# Functionality 👨‍💻
The class has two instance variables: ***arr***, which is an array of generic type T that holds the elements of the list, and ***size***, which keeps track of the number of elements currently in the list.

The ***constructor*** initializes arr to a new array of length 5 and sets size to 0.

The ***size()*** method returns the current size of the list, which is equal to size.

The ***contains(Object o)*** method searches the list for the first occurrence of the specified element and returns true if it is found, or false otherwise.

The ***add(T item)*** method appends the specified element to the end of the list. If the list is full, the method calls the private ***increaseBuffer()*** method, which creates a new array with twice the capacity of the current one, copies the existing elements to the new array, and replaces the old array with the new one.

The ***add(T item, int index)*** method inserts the specified element at the specified position in the list. If the index is out of range, the method throws an IndexOutOfBoundsException. If the list is full, the method calls the ***increaseBuffer()*** method to increase the capacity of the list. The method shifts all elements from the specified index to the end of the list one position to the right, inserts the new element at the specified index, and increments size.

The ***remove(T item)*** method removes the first occurrence of the specified element from the list, if it is present. The method searches the list for the element, removes it by shifting all elements after it one position to the left, and decrements size. If the element is not found, the method returns false.

The ***remove(int index)*** method removes the element at the specified position in the list. If the index is out of range, the method throws an IndexOutOfBoundsException. The method removes the element by shifting all elements after it one position to the left, sets the last element to null, decrements size, and returns the removed element.

The ***clear()*** method removes all elements from the list by creating a new array of length 5 and setting size to 0.

The ***get(int index)*** method returns the element at the specified position in the list. If the index is out of range, the method throws an IndexOutOfBoundsException.

The ***indexOf(Object o)*** method returns the index of the first occurrence of the specified element in the list, or -1 if the element is not found.

The ***lastIndexOf(Object o)*** method returns the index of the last occurrence of the specified element in the list, or -1 if the element is not found.

The ***increaseBuffer()*** method is used to increase the size of the internal array buffer when it is full. The new buffer size is twice the size of the current buffer, and the existing elements in the buffer are copied to the new buffer. This is done by creating a new array of size arr.length * 2 and then using a for loop to copy the elements from the old array to the new array. Finally, the reference to the old array is updated to point to the new array.

The ***checkIndex(int index)*** method is used to check whether the given index is in the range of valid indices for this list. If the index is less than 0 or greater than or equal to the size of the list, an IndexOutOfBoundsException is thrown. This is used to ensure that only valid indices are used to access elements in the list.
```bash
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
```

# MyLinkedList 🧩
This is an implementation of a doubly linked list in Java that implements the *MyList* interface. A doubly linked list is a type of data structure in which each node in the list contains a reference to the next and previous node in the list.

# Functionality 👨‍💻
The class has a private inner class called ***Node*** that represents a node in the linked list. The Node class contains three fields: ***element*** which stores the data element for the node,*** next*** which stores a reference to the next node in the list, and ***prev*** which stores a reference to the previous node in the list.

The ***MyLinkedList*** class has three instance variables: ***head*** which stores a reference to the first node in the list, ***tail*** which stores a reference to the last node in the list, and ***size*** which stores the number of nodes in the list.

The class provides the following methods to interact with the linked list:

***checkIndex(int index)***: checks if the given index is within the bounds of the list and throws an IndexOutOfBoundsException if it is out of bounds.

***size()***: returns the number of elements in the list.

***contains(Object o)***: checks if the list contains the given element and returns true if it is in the list, false otherwise.

***add(Object item)***: adds the given element to the end of the list.

***add(Object item, int index)***: adds the given element at the given index in the list.

***remove(Object item)***: removes the first occurrence of the specified element from the list and returns true if it was removed, false otherwise.

***remove(int index)***: removes the element at the specified position in the list and returns the element that was removed.
Overall, this implementation provides a basic implementation of a doubly linked list with the most commonly used operations.

```bash

package src;

public class MyLinkedList<E> implements MyList<E> {

    private class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        /**

         Constructor for creating a new node.
         @param element the element to be stored in the node
         @param next a reference to the next node in the list
         @param prev a reference to the previous node in the list
         */
        Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**

     Constructor for creating an empty linked list.
     */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }


    /**

     Checks if the given index is within the bounds of the list.
     @param index the index to check
     @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
    /**

     Returns the number of elements in the list.
     @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }


    /**

     Checks if the list contains the given element.
     @param o the element to check for
     @return true if the element is in the list, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        if (head.element == o) {
            return true;
        }
        Node node = head.next;
        while (node != null) {
            if (node.element == o) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**

     Adds the given element to the end of the list.
     @param item the element to add
     */
    @Override
    public void add(Object item) {
        Node<E> newNode = new Node<E>((E) item, null, null);
        if (head == null) {
            head = newNode;
            tail = head;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**

     Adds the given element at the given index in the list.
     @param item the element to add
     @param index the index at which to add the element
     */
    @Override
    public void add(Object item, int index) {
        checkIndex(index);
        Node<E> newNode = new Node<E>((E) item, null, null);
        if (index == 0) {
            add(item);
            return;
        }
        Node<E> node = head;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                Node<E> temp = node.next;
                node.next = newNode;
                newNode.prev = node;
                newNode.next = temp;
                temp.prev = newNode;
            }
            node = node.next;
        }
        size++;
    }

    /**
     * Removes the first occurrence of the specified element from this list.
     *
     * @param item the element to be removed from the list
     * @return true if the list contains the specified element and it was removed, false otherwise
     */
    @Override
    public boolean remove(Object item) {
        Node<E> newNode = new Node<E>((E) item, null, null);
        if (head.element == newNode.element) {
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }
        Node<E> node = head.next;
        while (node != null) {
            if (node.element == newNode.element) {
                Node<E> temp = node.prev;
                temp.next = node.next;
                Node<E> temp2 = node.next;
                temp2.prev = temp;
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }


    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E remove(int index) {
        checkIndex(index);
        if (index == 0) {
            E delete;
            delete  = head.element;
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
                return delete;
            }
            head = head.next;
            head.prev = null;
            size--;
            return delete;
        }
        if (index == size-1) {
            E delete = tail.element;
            tail = tail.prev;
            tail.next = null;
            size--;
            return delete;
        }
        Node<E> node = head.next;
        for (int i = 1; i <= size; i++) {
            if (index == i) {
                Node<E> p = node.prev;
                Node<E> n = node.next;
                E delete = node.element;

                p.next = n;
                n.prev = p;
                size--;
                return delete;
            }
            node = node.next;
        }
        return null;
    }


    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to be returned
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        if (index == 0) {
            return head.element;
        }

        Node<E> newNode = head.next;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                return newNode.element;
            }
            newNode = newNode.next;
        }

        return null;
    }

    /**

     Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     @param o the element to search for
     @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     @throws ClassCastException if the type of the specified element is incompatible with this list (optional)
     @throws NullPointerException if the specified element is null and this list does not permit null elements (optional)
     */
    @Override
    public int indexOf(Object o) {
        Node<E> newNode = new Node<E>((E) o, null, null);
        if (head.element == newNode.element) {
            return 0;
        }
        Node<E> node = head.next;
        for (int i = 1; i <= size; i++) {
            if (node.element == newNode.element) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }


    /**

     Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
     @param o the element to search for
     @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     @throws ClassCastException if the type of the specified element is incompatible with this list (optional)
     @throws NullPointerException if the specified element is null and this list does not permit null elements (optional)
     */
    @Override
    public int lastIndexOf(Object o) {
        Node<E> newNode = new Node<E>((E) o, null, null);
        if (tail.element == newNode.element) {
            return size-1;
        }
        Node<E> node = tail.prev;
        for (int i = size-1; i >= 1; i--) {
            if (node.element == newNode.element) {
                return i;
            }
            node = node.prev;
        }
        return -1;
    }

    @Override
    public void sort() {

    }

    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

}
```
