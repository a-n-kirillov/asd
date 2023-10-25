import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    private Deque<Integer> orderMemoryStack;
    private Deque<Integer> minimumMemoryStack;

    public MinStack() {
        this.orderMemoryStack = new ArrayDeque<>();
        this.minimumMemoryStack = new ArrayDeque<>();
    }

    public void push(int val) {
        orderMemoryStack.addLast(val);

        Integer currentMinimum = minimumMemoryStack.peekLast();
        if (currentMinimum == null || val < currentMinimum) {
            minimumMemoryStack.addLast(val);
        } else {
            minimumMemoryStack.addLast(currentMinimum);
        }
    }

    public void pop() {
        orderMemoryStack.removeLast();
        minimumMemoryStack.removeLast();
    }

    public int top() {
        return orderMemoryStack.peekLast();
    }

    public int getMin() {
        return minimumMemoryStack.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */