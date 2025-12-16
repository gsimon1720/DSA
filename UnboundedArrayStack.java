package dsa;
import java.util.Arrays;

public class UnboundedArrayStack<T> {
    private T[] stack;
    private int top; // points to the next insertion index
    private int capacity;

    @SuppressWarnings("unchecked")
    public UnboundedArrayStack() {
        capacity = 4; // initial capacity
        stack = (T[]) new Object[capacity];
        top = 0;
    }

    // Push operation
    public void push(T item) {
        if (top == capacity) {
            resize(capacity * 2); // double the size
        }
        stack[top++] = item;
    }

    // Pop operation
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T item = stack[--top];
        stack[top] = null; // avoid memory leak

        // shrink array if less than 1/4 full
        if (top > 0 && top == capacity / 4) {
            resize(capacity / 2);
        }

        return item;
    }

    // Peek the top element
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top - 1];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == 0;
    }

    // Resize internal array
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        capacity = newCapacity;
        stack = Arrays.copyOf(stack, capacity);
    }

    // Display elements (for debugging)
    public void display() {
        System.out.print("Stack: ");
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        UnboundedArrayStack<Integer> stack = new UnboundedArrayStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display(); // Stack: 40 30 20 10

        System.out.println("Popped: " + stack.pop()); // 40
        stack.display(); // Stack: 30 20 10

        stack.push(50);
        stack.push(60);
        stack.display(); // Stack: 60 50 30 20 10

        System.out.println("Peek: " + stack.peek()); // 60
    }
}
