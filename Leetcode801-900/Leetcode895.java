//O(logN) pq solution
class FreqStack {

    Map<Integer, Integer> freq;
    int cnt = 0;
    //{element, frequency, insertSequence}
    PriorityQueue<int[]> pq;

    public FreqStack() {
        this.pq = new PriorityQueue<>(
        (a,b) -> {
            return a[1] == b[1] ? b[2] - a[2] : b[1] - a[1];
        }
        );
        this.freq = new HashMap<>();
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0)+1);
        pq.offer(new int[]{val, freq.get(val),cnt++});
    }
    
    public int pop() {
        int res = pq.peek()[0];
        freq.put(res, freq.get(res)-1);
        return pq.poll()[0];
    }
}

//O(N) Stack solution
class FreqStack {

    Map<Integer, Integer> eleToFreq;
    Map<Integer, Stack<Integer>> freqToEle;
    int maxFreq;
    public FreqStack() {
        eleToFreq = new HashMap<>();
        freqToEle = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        eleToFreq.put(val,eleToFreq.getOrDefault(val,0)+1);
        int freq = eleToFreq.get(val);
        freqToEle.computeIfAbsent(freq, x -> new Stack<>()).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        int x = freqToEle.get(maxFreq).pop();
        eleToFreq.put(x, eleToFreq.get(x)-1);
        if(freqToEle.get(maxFreq).size() == 0) maxFreq--;
        return x;
    }
}
