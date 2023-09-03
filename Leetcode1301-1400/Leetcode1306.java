class Solution {
    public boolean canReach(int[] arr, int start) {
        int N = arr.length;
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int curr = q.poll();
            visited[curr] = true;
            if(arr[curr] == 0) return true;
            if(curr - arr[curr] >= 0 && curr - arr[curr] < N && !visited[curr-arr[curr]]) q.offer(curr-arr[curr]);
            if(curr + arr[curr] >= 0 && curr + arr[curr] < N && !visited[curr+arr[curr]]) q.offer(curr+arr[curr]);
        }
        return false;
    }
}
