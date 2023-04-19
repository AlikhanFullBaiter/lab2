package src;

public class MyLinkedList<E> implements MyList<E> {
    private class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }


    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
    @Override
    public int size() {
        return size;
    }

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

    @Override
    public void add(E item) {
        Node node = new Node(item, tail, null);
        if (tail != null) {
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
        size++;
    }

    @Override
    public void add(Object item, int index) {
        checkIndex(index);
        Node<E> newNode = new Node<E>((E) item, null, null);
        if (index == 0) {
            add((E) item);
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

    @Override
    public boolean remove(E item) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }


}
