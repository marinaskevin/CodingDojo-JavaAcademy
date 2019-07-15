import java.util.ArrayList;

public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    public void add(int value) {
        Node newNode = new Node(value);
        if(this.head == null) {
            this.head = newNode;
        } else {
            Node runner = this.head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public Integer remove() {
        Integer lastInt;
        if(this.head == null) {
            return null;
        }
        Node runner = this.head;
        if(runner.next == null) {
            lastInt = runner.value;
            this.head = null;
            return lastInt;
        }
        while(runner.next.next != null) {
            runner = runner.next;
        }
        lastInt = runner.next.value;
        runner.next = null;
        return lastInt;
    }
    public void printValues() {
        Node runner = this.head;
        ArrayList<String> printArray = new ArrayList<String>();
        while(runner != null){
            printArray.add(runner.value+"");
            runner = runner.next;
        }
        System.out.println(printArray);
    }
    public Node find(int value) {
        Node runner = this.head;
        while(runner != null) {
           if(runner.value == value) {
                return runner;
           }
           runner = runner.next;
        }
        return null;
    }
    public Integer removeAt(int index) {
        if(this.head == null || index < 0) {
            return null;
        }
        Integer value;
        Node runner = this.head;
        if(index == 0) {
            value = runner.value;
            this.head = runner.next;
            return value;
        }
        while(runner.next != null && index > 1) {
            runner = runner.next;
            index--;
        }
        if(runner.next == null) {
            return null;
        }
        value = runner.next.value;
        runner.next = runner.next.next;
        return value;
    }
}
