public class ListTester {
    public static void main(String[] args) {

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.printValues();

        System.out.println("Removed "+sll.remove()+" at the end of the list");
        System.out.println("Removed "+sll.remove()+" at the end of the list");
        sll.printValues();

        int findValue = 3;
        int removeIndex = -1;
        System.out.println("Found value "+findValue+" in Node "+sll.find(findValue));
        System.out.println("Removed value "+sll.removeAt(removeIndex)+" at index "+removeIndex);
        sll.printValues();

        findValue = 30;
        removeIndex = 2;
        System.out.println("Found value "+findValue+" in Node "+sll.find(findValue));
        System.out.println("Removed value "+sll.removeAt(removeIndex)+" at index "+removeIndex);
        sll.printValues();

        removeIndex = 3;
        System.out.println("Removed value "+sll.removeAt(removeIndex)+" at index "+removeIndex);
        sll.printValues();
    }
}
