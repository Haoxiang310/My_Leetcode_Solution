class Solution {

    //Reverse a whole linkedlist
    public ListNode reverse(ListNode a){
        ListNode prev=null, curr=a, temp=a;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    //Reverse the list in interval [a,b)
    public ListNode reverseFromAtoB(ListNode a, ListNode b){
        ListNode prev=null, curr=a, temp=a;
        while(curr!=b){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    //Reverse first k elements, then recursively call reverseKGroup starting from (k+1)th node
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head;
        ListNode b = head;
        for(int i=0;i<k;i++){
            if(b==null) return head;
            b=b.next;
        }
        ListNode newHead = reverseFromAtoB(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }
}
