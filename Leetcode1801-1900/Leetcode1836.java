class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode curr = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(curr != null){
            map.put(curr.val, map.getOrDefault(curr.val,0)+1);
            curr = curr.next;
        }
        curr = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = curr;
        ListNode pre = dummy;
        while(curr != null){
            if(map.get(curr.val) > 1) pre.next = curr.next;
            else pre = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
