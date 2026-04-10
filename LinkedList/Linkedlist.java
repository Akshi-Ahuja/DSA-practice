package LinkedList;

public class Linkedlist {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // head and tail defined as properties of LinkedList class
    public static Node head;
    public static Node tail;

    public void addFirst(int data) { // O(1)
        // step1 - create new node
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        }

        // step2 - newNode's next = head
        newNode.next = head; // link

        // step3 - head = newNode
        head = newNode;
    }

    public void addLast(int data) { // O(1)
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLL() {
        if (head == null) {

        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);

        // Instead we create some methods directly in LinkedList class for reuse.

        // Methods:

        // 1. addFirst
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
    }
}
