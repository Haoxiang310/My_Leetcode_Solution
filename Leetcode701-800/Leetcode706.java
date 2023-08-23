class MyHashMap {

    List<Integer> map;
    List<Integer> cor;
    public MyHashMap() {
        this.map = new ArrayList<>(); //index -> value;
        this.cor = new ArrayList<>(); //index -> key;
    }
    
    public void put(int key, int value) {
        int i=0;
        for(;i<cor.size();i++){
            if(cor.get(i) == key) break;
        }
        if(i < cor.size()){
            map.set(i,value);
            return ;
        }
        map.add(value);
        cor.add(key);
    }
    
    public int get(int key) {
        int i=0;
        for(;i<cor.size();i++){
            if(cor.get(i)==key) break;
        }
        if(i == cor.size()) return -1;
        int j=0;
        for(;j<map.size();j++){
            if(cor.get(j) == key) break;
        }
        return map.get(j);
    }
    
    public void remove(int key) {
        int i=0;
        for(;i<cor.size();i++){
            if(cor.get(i)==key) break;
        }
        if(i == cor.size()) return;
        map.set(i, -1);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
