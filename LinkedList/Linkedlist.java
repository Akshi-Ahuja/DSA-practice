package LinkedList;

public class Linkedlist {

    // blue print of node objects so we make a class for it.
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

    public Node findMid(Node head) { // helper
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome() {
        // corner case
        if (head == null && head.next == null) {
            return true;
        }

        // 1. find mid
        Node midNode = findMid(head);

        // 2. reverse 2nd falf
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // right half's head
        Node left = head;

        // 3. check left half and right half
        while (right != null) {
            if (left.data != right.data)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // cycle exists
            }
        }

        return false; // cycle doesn't exist
    }

    public static void removeCycle() {
        // 1. detect cycle
        Node slow = head;
        Node fast = head;
        boolean detected = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                detected = true;
                break; // we want slow to become head but fast should continue from here only so BREAK
                       // here
            }
        }
        if (detected == false)
            return;

        // 2. find last node
        slow = head;
        Node prev = null;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        // 3. remove cycle -> last.next = null
        prev.next = null;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) { // O(n log n)
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // find mid
        Node mid = getMid(head);

        // left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge left and right half
        return merge(newLeft, newRight);
    }

    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse the 2nd half
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alternate merging - zigzag merge
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public void printMSkipN(int n, int m) {
        Node temp = head;
        while (temp != null) {
            for (int i = 1; i <= m; i++) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            for (int i = 1; i <= n; i++) {
                temp = temp.next;
            }
        }
    }

    public void deleteMafterN(int m, int n) {
        Node temp = head;
        while (temp != null) {
            // skip m nodes
            for (int i = 1; i < m && temp != null; i++) {
                temp = temp.next;
            }

            // check if temp is null return
            if (temp == null)
                return;

            // skip n nodes
            Node t = temp.next;
            for (int i = 1; i <= n && temp != null; i++) {
                t = t.next;
            }

            // connect
            temp.next = t;
            temp = t;
        }
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

        // Linkedlist ll2 = new Linkedlist();
        // ll2.addFirst(2);
        // ll2.addFirst(1);
        // ll2.addLast(4);
        // ll2.addLast(5);
        // // ll2.printLL();

        // ll2.add(2, 3);
        // ll2.printLL();
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

        // ll2.deleteFromEnd(3);
        // ll2.printLL();

        // Linkedlist ll = new Linkedlist();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(1);
        // // ll.addLast(1);
        // ll.printLL();

        // System.out.println(ll.checkPalindrome());

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = temp;
        // // 1->2->3->4->2
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        Linkedlist ll = new Linkedlist();
        // ll.addFirst(9);
        // ll.addFirst(1);
        // ll.addFirst(6);
        // ll.addFirst(4);
        // // ll.addFirst(8);
        // // 5>4>3>2>1>null
        // ll.printLL();

        // head = ll.mergeSort(head);
        // ll.printLL();

        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);
        // // 1>2>3>4>5>null
        // ll.printLL();

        // ll.zigZag();
        // ll.printLL();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(10);
        ll.printLL();

        // ll.printMSkipN(2, 3);
        ll.deleteMafterN(3, 2);
        ll.printLL();
    }
}
