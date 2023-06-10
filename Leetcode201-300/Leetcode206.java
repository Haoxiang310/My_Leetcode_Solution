class Solution {
    public ListNode reverseList(ListNode head) {
        //Recursion:
        //Definition of reverseList function:
        //Given a head pointer, reverse the list, return the last node of the reversed list starting from the head pointer
        if(head==null || head.next==null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;


        //Iteration:
        // ListNode prev = null;
        // ListNode curr = head;
        // ListNode temp = head;
        // while(curr!=null){
        //     temp=curr.next;
        //     curr.next=prev;
        //     prev=curr;
        //     curr=temp;
        // }
        // return prev;
        
    }
}
