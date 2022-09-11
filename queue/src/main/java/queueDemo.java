import java.util.Scanner;

public class queueDemo{
    public static void main(String[] args) {
        //write a test sample
        Queue queue1 = new Queue(5);
        Scanner scanner = new Scanner(System.in);
        char key;
        boolean control = true;
        while (control) {
            System.out.println("g(get): get a number from queue");
            System.out.println("a(add): add a number into queue");
            System.out.println("s(show): show all numbers in queue");
            System.out.println("e(exit): exit from the queue");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("please enter a integer");
                    int value = scanner.nextInt();
                    queue1.add(value);
                    break;
                case 'g':
                    System.out.println(queue1.get());
                    break;
                case 's':
                    queue1.show();
                    break;
                case 'e':
                    control = false;
                    scanner.close();
                    break;
                default:
                    break;
            }

        }
    }
}

class Queue {
    //maxSize define the max size of this Queue;
    //front is the front point, use for get the data from the front of the queue;
    // rear is the end point, use for add the data from end of the queue;
    // arr is the array, mock the queue.
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public Queue(int maxQueueSize) {
        maxSize = maxQueueSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public void add(int inputNumber) {
        if (!isFull()) {
            rear++;
            arr[rear] = inputNumber;
        } else {
            throw new RuntimeException("This queue is full");
        }
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("This queue is empty");
        } else {
            front++;
            return arr[front];
        }
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("This queue is empty");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("the " + i + " number in the queue is" + arr[i]);
            }
        }
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

}

