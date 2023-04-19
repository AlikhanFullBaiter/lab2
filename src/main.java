package src;

public class main {
    public static void main(String[] args) {
        MyLinkedList array = new MyLinkedList();
        array.add("Alikhan");
        array.add("Nurbol");
        array.add("football");
        array.add("barcelona");
        array.add("Real Vadrid");
        array.add("Harry MAguire");
        array.add("se-2217" , 1);
        array.remove(1);
        array.printList();
        System.out.println(array.indexOf("barcelona"));
        array.clear();
        System.out.println(array.size());
    }
}
