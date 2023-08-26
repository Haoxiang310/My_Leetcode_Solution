class MyCircularDeque {

    int[] q;
    int front = 0, rear = -1, size = 0, capacity;
    public MyCircularDeque(int k) {
        q = new int[k];
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(!isFull()){
            if(--front < 0) front += capacity;
            q[front] = value;
            size++;
            //因为deque insert front用front作为pointer，但queue用rear作为pointer。queue中rear会先加1变成0，然后insert操作不会有问题，但deque中如果先通过insert front只改变了front的值，rear没变还是-1，因此再insert last时rear的值是0，就覆盖了之前front位置的值。
            if(size == 1) rear = front;
            return true;
        }
        else return false;
    }
    
    public boolean insertLast(int value) {
        if(!isFull()){
            rear = (rear + 1) % capacity;
            q[rear] = value;
            size++;
            return true;
        }
        else return false;
    }
    
    public boolean deleteFront() {
        if(!isEmpty()){
            front = (front + 1)%q.length;
            size--;
            return true;
        }
        else return false;
    }
    
    public boolean deleteLast() {
        if(!isEmpty()){
            if(--rear<0) rear += q.length;
            size--;
            return true;
        }
        else return false;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : q[front];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : q[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == q.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
