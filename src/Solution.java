import java.util.ArrayDeque;

class MinStack {

    ArrayDeque<Integer> stack;
    ArrayDeque<Integer> min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        min.push(Math.min(val, min.isEmpty() ? val : min.getFirst()));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}