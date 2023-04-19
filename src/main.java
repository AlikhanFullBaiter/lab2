package src;

public class main {
    public static void main(String[] args) {
        MyLinkedList array = new MyLinkedList();
        array.add("Alikhan");
        array.add("Nurbol");
        array.add("se-2217" , 1);
        array.remove(1);
        array.printList();
    }
}
