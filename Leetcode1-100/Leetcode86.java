/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode(-1);
        ListNode dummyMore = new ListNode(-1);
        ListNode pLess = dummyLess;
        ListNode pMore = dummyMore;
        while(head!=null){
            if(head.val<x){
                pLess.next=head;
                head=head.next;
                pLess=pLess.next;
            }
            else{
                pMore.next=head;
                head=head.next;
                pMore=pMore.next;
            }
        }
        pMore.next=null;
        pLess.next=dummyMore.next;
        return dummyLess.next;
    }
}
