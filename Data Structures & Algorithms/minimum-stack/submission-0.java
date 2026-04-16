class MinStack {

    Deque<Integer> mStack;
    Deque<Integer> stack;

    public MinStack() {
        stack = new LinkedList<>();
        mStack = new LinkedList<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (mStack.isEmpty() || val <= mStack.peek()) {
            mStack.push(val);
        } else {
            mStack.push(mStack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        mStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mStack.peek();
    }
}
