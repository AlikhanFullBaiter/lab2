package src;

public class MyLinkedList<E> implements MyList<E> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private E element;
        private Node next;
        private Node prev;

        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    MyLinkedList () {
        this.head = null;
        this.tail = null;
        size = 0;
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

    }

    @Override
    public void add(E item, int index) {

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
