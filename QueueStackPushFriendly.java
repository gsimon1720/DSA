
package dsa;
import java.util.Queue;
import java.util.LinkedList;

public class QueueStackPushFriendly {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // DISPLAY stack elements
    void display() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack (top → bottom): " + q1);
    }

    // PUSH operation (O(1))
    void push(int x) {
        q1.add(x);
        System.out.println("push(" + x + ")");
    }

    // POP operation (O(n))
    void pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        System.out.println("pop() -> " + q1.remove());

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
  
    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        // Display at beginning
        stack.display();

        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.pop();
        stack.push(9);
        stack.pop();
        stack.pop();

        // Display at end
        stack.display();
    }
    
}
