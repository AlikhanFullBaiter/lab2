
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
