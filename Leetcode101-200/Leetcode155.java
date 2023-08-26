//use 2 stack
class MinStack {

    Deque<Integer> mainStack;
    Deque<Integer> minStack;
    public MinStack() {
        this.mainStack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val ) minStack.push(val);
    }
    
    public void pop() {
        int temp = mainStack.pop();
        if(temp == minStack.peek()) minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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

//use one stack
class MinStack {

    Deque<int[]> stack;
    public MinStack() {
        this.stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) stack.push(new int[]{val,val});
        else {
            int min = stack.peek()[1];
            min = Math.min(min, val);
            stack.push(new int[]{val, min});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
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
