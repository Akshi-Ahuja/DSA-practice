package LinkedList;

public class Assignment {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node intersectionPoint(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Assignment list = new Assignment();
        Node head1, head2;

        head1 = new Node(4);
        head2 = new Node(1);

        Node newNode = new Node(2);
        head2.next = newNode;

        newNode = new Node(3);
        head2.next.next = newNode;

        newNode = new Node(5);
        head1.next = newNode;

        newNode = new Node(6);
        head1.next.next = newNode;
        head2.next.next.next = newNode;

        newNode = new Node(7);
        head1.next.next.next = newNode;

        head1.next.next.next.next = null;

        Node intersection = list.intersectionPoint(head1, head2);
        if (intersection == null) {
            System.out.println("No intersection!");
        } else {
            System.out.println("Intersection point: " + intersection.data);
        }
    }
}
