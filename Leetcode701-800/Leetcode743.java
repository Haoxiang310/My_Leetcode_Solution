class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge:times){
            graph.computeIfAbsent(edge[0], x->new ArrayList<>()).add(new int[]{edge[1],edge[2]});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> {
                return a[1]-b[1];
            }
        );
        pq.offer(new int[]{k,dist[k]});
        int res = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            res = Math.max(res, dist[curr[0]]);
            for(int[] nei:graph.getOrDefault(curr[0],new ArrayList<>())){
                int to = nei[0], w = nei[1];
                int alt = dist[curr[0]] + w;
                if(alt < dist[to]){
                    pq.offer(new int[]{to,alt});
                    dist[to] = alt;
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<dist.length;i++){
            if(dist[i] != Integer.MAX_VALUE) cnt++;
        }
        return cnt != n ? -1 : res;
    }
}
