class CustomStack {

    Deque<Integer> stack;

    int[] inc;

    int n;

    public CustomStack(int maxSize) {
        this.n = maxSize;
        inc = new int[n];
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if(stack.size() < n) stack.push(x);
    }
    
    public int pop() {
        int i = stack.size() - 1;
        if(i == -1) return -1;
        int res = stack.pop();
        res += inc[i];
        //inc[i]指从栈底到i（栈顶）位置的增量是inc[i]；inc[i-1]指从栈底到i-1位置（新的栈顶）的增量是inc[i-1]。由于我们只对栈顶元素记录增量，因此栈顶元素出栈后，应该把栈顶元素的增量propagate给新栈顶。
        if(i>0) inc[i-1] += inc[i];
        inc[i] = 0;
        return res;
    }
    
    public void increment(int k, int val) {
        int i = Math.min(k, stack.size()) - 1;
        if(i >= 0) inc[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
