
package dsa;
import java.util.LinkedList;
import java.util.Queue;
public class QueueStackPopFriendly {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push operation is costly
    public void push(int x) {
        // Step 1: enqueue to empty queue2
        queue2.add(x);

        // Step 2: move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Step 3: swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop operation is friendly / fast (O(1))
    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.remove();
    }

    // Peek top element
    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.peek();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        QueueStackPopFriendly stack = new QueueStackPopFriendly();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
        stack.push(40);
        System.out.println(stack.top()); // 40
        System.out.println(stack.pop()); // 40
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.pop()); // 10
        System.out.println(stack.isEmpty()); // true
    }
}
