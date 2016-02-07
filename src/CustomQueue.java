
import java.util.NoSuchElementException;

/**
 * Custom Queue implementation in Java
 */
public class CustomQueue {

    //Internal Array to hold the data
    private int[] dataArray;
    //Max queue size
    private int maxSize;
    //Front Position pointer
    private int front;
    //Rear Position pointer
    private int rear;
    //Current Size of the queue
    private int queueSize;

    public CustomQueue(int maxSize) {
        this.maxSize = maxSize;
        dataArray = new int[this.maxSize];
    }

    public boolean add(int data) {
        if (isFull()) {
            System.out.println("Queue is full. so can't add the data :" + data);
            return false;
        }
        queueSize++;
        dataArray[rear++] = data;
        return true;
    }

    /**
     * Remove the top element, throw NoSuchElementException if the queue is empty
     * @return int
     * @throws NoSuchElementException
     */
    public int remove() throws NoSuchElementException {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            throw new NoSuchElementException("Queue is Empty");
        } else {
            queueSize--;
            return dataArray[front++];
        }
    }

    /**
     * Fetch the top element, throw NoSuchElementException if the queue is empty
     * @return int
     * @throws NoSuchElementException
     */
    public int element() throws NoSuchElementException {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            throw new NoSuchElementException("Queue is Empty");
        } else {
            return dataArray[front];
        }
    }


    public void printAllElements() {
        for (int i = front; i < dataArray.length; i++) {
            System.out.println(dataArray[i]);
        }
    }

    public boolean isEmpty() {
        return (queueSize == 0);
    }

    public boolean isFull() {
        return (queueSize == maxSize);
    }

    public static void main(String[] args) {
        final int MAX_SIZE = 5;
        CustomQueue customQueue = new CustomQueue(MAX_SIZE);
        for (int i = 1; i <= MAX_SIZE; i++) {
            System.out.println("Inserting data " + i * 100);
            customQueue.add(i * 100);
        }
        System.out.println("==========================");
        System.out.println("Printing Queue Contents");
        customQueue.printAllElements();
        System.out.println("==========================");
        System.out.println("Removing Element:" + customQueue.remove());
        System.out.println("==========================");
        System.out.println("Top element in the Queue is:" + customQueue.element());
        System.out.println("Printing Queue Contents:");
        customQueue.printAllElements();
    }

}
