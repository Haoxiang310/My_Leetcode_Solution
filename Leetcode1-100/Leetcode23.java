class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode dummy = new ListNode(-1), p=dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });

        for(ListNode list:lists){
            if(list!=null)
                pq.add(list);
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            p=p.next;
            if(node.next!=null){
                // ListNode temp = node.next;
                // node.next=null;
                // node = temp;
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}
