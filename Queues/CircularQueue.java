package Queues;

public class CircularQueue {

    static class QueueC {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        QueueC(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // add
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full!");
                return;
            }

            // element is the first one in the queue, we got to update front as well
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }

            int result = arr[front];
            if (front == rear) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

    }

    public static void main(String[] args) {
        QueueC qc = new QueueC(3);
        qc.add(1);
        qc.add(2);
        qc.add(3);
        System.out.println(qc.remove());
        qc.add(4);
        System.out.println(qc.remove());
        qc.add(5);

        while (!qc.isEmpty()) {
            System.out.println(qc.remove());
        }
    }
}
