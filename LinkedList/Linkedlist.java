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
    public static int size;

    public void addFirst(int data) { // O(1)
        // step1 - create new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step2 - newNode's next = head
        newNode.next = head; // link

        // step3 - head = newNode
        head = newNode;
    }

    public void addLast(int data) { // O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLL() {
        if (head == null) {
            System.out.println("LinkedList is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // i == idx - 1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data; // head == tail here
            head = tail = null;
            size = 0;
            return val;
        }

        // Find prev node - prev = size - 2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i; // key found
            }
            temp = temp.next;
            i++;
        }

        return -1; // key not found!
    }

    public int helperRecSearch(Node head, int key) {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helperRecSearch(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recSearch(int key) {
        return helperRecSearch(head, key);
    }

    public void reverse() {
        // 3 variables
        Node prev = null;
        Node curr = tail = head;
        Node next;

        // 4 steps in loop
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void deleteFromEnd(int n) {
        // calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next;
            return;
        }

        // sz-n
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    public static void main(String[] args) {
        // Linkedlist ll = new Linkedlist();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);

        // Instead we create some methods directly in LinkedList class for reuse.

        // Methods:

        // // 1. addFirst
        // ll.addFirst(2);
        // ll.addFirst(1);

        // // 2. addLast
        // ll.addLast(3);
        // ll.addLast(4);

        Linkedlist ll2 = new Linkedlist();
        ll2.addFirst(2);
        ll2.addFirst(1);
        ll2.addLast(4);
        ll2.addLast(5);
        // ll2.printLL();

        ll2.add(2, 3);
        ll2.printLL();
        // System.out.println(ll2.size);

        // System.out.println("Removed first element: " + ll2.removeFirst());
        // ll2.printLL();
        // System.out.println(ll2.size);

        // System.out.println("Removed last element: " + ll2.removeLast());
        // ll2.printLL();
        // System.out.println(ll2.size);

        // System.out.println(ll2.iterativeSearch(3));
        // System.out.println(ll2.iterativeSearch(10));

        // System.out.println(ll2.recSearch(2));
        // System.out.println(ll2.recSearch(10));

        // ll2.reverse();
        // ll2.printLL();

        ll2.deleteFromEnd(3);
        ll2.printLL();
    }
}
