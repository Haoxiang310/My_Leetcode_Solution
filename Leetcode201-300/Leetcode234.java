class Solution {

    //Recursion:
    ListNode left;
    boolean traverse(ListNode right){
        if(right==null) return true;
        boolean res = traverse(right.next);
        res=res && (left.val==right.val);
        left=left.next;
        return res;

    }
    public boolean isPalindrome(ListNode head) {
        left=head;
        return traverse(head);
    }

    //Iteration:
    // public boolean isPalindrome(ListNode head) {
    //     ListNode firstHalfEnd  = getFirstHalfEnd(head);
    //     ListNode secondHalfStart = reverseLinkedList(firstHalfEnd.next);
    //     ListNode p1 = head;
    //     ListNode p2 = secondHalfStart;
    //     while(p1!=p2 && p1!=null && p2!=null){
    //         if(p1.val!=p2.val) return false;
    //         p1=p1.next;
    //         p2=p2.next;
    //     }
        
    //     firstHalfEnd.next = reverseLinkedList(secondHalfStart);
    //     return true;
    // }

    // public ListNode getFirstHalfEnd(ListNode head){
    //     ListNode slow = head;
    //     ListNode fast = head;
    //     while(fast.next!=null && fast.next.next!=null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return slow;
    // }
    // public ListNode reverseLinkedList(ListNode head){
    //     ListNode prev = null;
    //     ListNode curr = head;
    //     while(curr!=null){
    //         ListNode nextTmp = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = nextTmp;
    //     }
    //     return prev;
    // }
    
}
