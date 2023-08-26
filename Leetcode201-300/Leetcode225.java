//O(1) PUSH, O(N) POP
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
        this.top = 0;
    }
    
    public void push(int x) {
        q1.offer(x);
        top = x;
    }
    
    public int pop() {
        while(q1.size() > 1){
            top = q1.poll();
            q2.offer(top);
        }
        int res = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

//O(1) POP, O(N) PUSH
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }
    public void push(int x) {
        if(q1.isEmpty()) q1.offer(x);
        else{
            q2.offer(x);
            while(!q1.isEmpty()) q2.offer(q1.poll());
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
