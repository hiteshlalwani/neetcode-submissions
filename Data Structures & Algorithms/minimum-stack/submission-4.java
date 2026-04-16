class MinStack {
    long min;
    Deque<Long> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        }
        else {
            stack.push(x - min);
            if (x < min) {
                min = x;
            }
        }
    }
    
    public void pop() {
        long p = stack.pop();
        
        if (p < 0) {
            // if (p < 0), the popped value is the min
            // Recall p is added by this statement: stack.push(x - min);
            // So, p = x - old_min
            // old_min = x - p
            // again, if (p < 0), x is the min so:
            // old_min = min - p
            min = min - p;
        }
    }
    
    public int top() {
        long p = stack.peek();
        
        if (p < 0) {
            return (int) min;
        }
        else {
            // p = x - min
            // x = p + min
            return (int) (p + min);
        }
        
        
    }
    
    public int getMin() {
        return (int) min;    
    }
}