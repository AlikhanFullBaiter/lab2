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


    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

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
