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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode oddHead = new ListNode(-1),oddP = oddHead;
        ListNode evenHead = new ListNode(-1),evenP = evenHead;
        ListNode curr = head;
        int cnt = 1;
        while(curr != null){
            if(cnt % 2 == 0){
                evenP.next = curr;
                evenP = evenP.next;
            }
            else{
                oddP.next = curr;
                oddP = oddP.next;
            }
            curr = curr.next;
            cnt++;
        }
        oddP.next = null;
        evenP.next = null;
        if(oddHead.next == null) return evenHead.next;
        if(evenHead.next == null) return oddHead.next;
        oddP.next = evenHead.next;
        head = oddHead.next;
        
        return head;
    }
}
