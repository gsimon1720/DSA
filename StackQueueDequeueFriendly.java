
package dsa;
import java.util.Stack;

public class StackQueueDequeueFriendly {

     private Stack<Integer> stack1; // main stack
    private Stack<Integer> stack2; // helper stack

    public StackQueueDequeueFriendly() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation (costly)
    public void enqueue(int data) {
        // Move all elements from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Push new element into stack1
        stack1.push(data);

        // Move everything back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        System.out.println("Enqueued: " + data);
    }

    // Dequeue operation (fast)
    public int dequeue() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return stack1.pop();
    }

    // Peek front element
    public int peek() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return stack1.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty();
    }


    public static void main(String[] args) {
        StackQueueDequeueFriendly queue = new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());

    }
    
}
