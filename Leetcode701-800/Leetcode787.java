// class State{
//     int id;
//     int costFromSource;
//     int nodesFromSource;

//     State(int id, int costFromSource, int nodesFromSource){
//         this.id = id;
//         this.costFromSource = costFromSource;
//         this.nodesFromSource = nodesFromSource;
//     }
// }
class Solution {

    //bellman-ford
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<=k;i++){
            int[] temp = Arrays.copyOf(dist,n);
            for(int[] flight:flights){
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                if(dist[from]!=Integer.MAX_VALUE){
                    temp[to]=Math.min(temp[to],dist[from]+cost);
                }
            }
            dist=temp;
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }

    //dijkstra:
    // public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    //     // k++;
    //     // return dijkstra(n,flights,src,dst,k);
    // }

    // public int dijkstra(int n, int[][] flights, int src, int dst, int k){

    //     int[] distTo = new int[n];
    //     int[] nodeNumTo = new int[n];
    //     Arrays.fill(distTo,Integer.MAX_VALUE);
    //     Arrays.fill(nodeNumTo,Integer.MAX_VALUE);
    //     distTo[src]=0;
    //     nodeNumTo[src]=0;
    //     PriorityQueue<State> pq = new PriorityQueue<>((a,b)->{
    //         return a.costFromSource-b.costFromSource;
    //     });
    //     pq.add(new State(src,0,0));

    //     while(!pq.isEmpty()){
    //         State cur = pq.poll();
    //         int curId = cur.id;
    //         int curCostFromSource = cur.costFromSource;
    //         int curNodesFromSource = cur.nodesFromSource;
            
    //         if(curId==dst) return curCostFromSource;
    //         if(curNodesFromSource==k) continue;

    //         for(int[] flight:flights){
                
    //             if(flight[0]==curId){
    //                 int from = flight[0];
    //                 int to = flight[1];
    //                 int cost = flight[2];
    //                 int nextCostFromSource = cost+curCostFromSource;
    //                 int nextNodesFromSource = curNodesFromSource+1;
                    
    //                 if(nextCostFromSource<distTo[to]){
    //                     distTo[to]=nextCostFromSource;
    //                     nodeNumTo[to]=nextNodesFromSource;
    //                 }

    //                 if(nextCostFromSource>distTo[to]){
    //                     continue;
    //                 }
    //                 pq.offer(new State(to,nextCostFromSource,nextNodesFromSource));
    //             }
    //         }
    //     }
    //     return -1;

    // }
}
