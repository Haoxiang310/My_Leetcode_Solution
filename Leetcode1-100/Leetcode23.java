//pq Solution
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

//divide and conquer solution
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return divide(lists, 0, lists.length - 1);
    }

    public ListNode divide(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        int mid = start + (end - start)/2;
        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid+1, end);
        return conquer(left, right);
    }

    public ListNode conquer(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode s1 = left, s2 = right;
        while(s1 != null && s2 != null){
            if(s1.val < s2.val) {
                p.next = s1;
                s1 = s1.next;
            }
            else{
                p.next = s2;
                s2 = s2.next;
            }
            p = p.next;
        }
        if(s1 == null) p.next = s2;
        else if(s2 == null) p.next = s1;
        return dummy.next;
    }
}
