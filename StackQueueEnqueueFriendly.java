package dsa;
import java.util.Stack;

public class StackQueueEnqueueFriendly<T> {
     private Stack<T> stack1 = new Stack<>(); // main stack for enqueue
    private Stack<T> stack2 = new Stack<>(); // auxiliary stack for dequeue

    // Enqueue operation (fast)
    public void enqueue(T item) {
        stack1.push(item);
    }

    // Dequeue operation (may be costly)
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // If stack2 is empty, transfer all elements from stack1
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Peek the front element
    public T front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Display queue elements
    public void display() {
        Stack<T> tempStack = new Stack<>();
        // Print stack2 elements first
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }
        // Print stack1 elements in order
        for (int i = 0; i < stack1.size(); i++) {
            tempStack.push(stack1.get(i));
        }
        while (!tempStack.isEmpty()) {
            System.out.print(tempStack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly<Integer> queue = new StackQueueEnqueueFriendly<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display(); // 10 20 30

        System.out.println("Dequeued: " + queue.dequeue()); // 10
        queue.display(); // 20 30

        queue.enqueue(40);
        queue.display(); // 20 30 40

        System.out.println("Front: " + queue.front()); // 20
    }
}
