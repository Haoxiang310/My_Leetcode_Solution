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
        ListNode beforeList = new ListNode(-1), beforeP = beforeList;
        ListNode afterList = new ListNode(-1), afterP = afterList;
        ListNode p = head;
        while(p != null){
            if(p.val < x){
                beforeP.next = p;
                beforeP = beforeP.next;
            }
            else{
                afterP.next = p;
                afterP = afterP.next;
            }
            p = p.next;
        }
        //since beforeP or afterP will carry all the elements fall befind the final element that meet the requirement, we need to set next to null to prevent cycle([1,4,3,2,5,2],beforeList is [1,2,2], beforeP is [2]; afterList is [4,3,5,2], afterP is [5,2], we need to set afterP.next = null, otherwise after we connect beforeP.next to afterList, it happens that 2->4, 4->3->5->2, which generate cycle)
        beforeP.next = null;
        afterP.next = null;
        if(beforeP != null) {
            beforeP.next = afterList.next;
            head = beforeList.next;
        }
        else head = afterList.next;
        return head;
    }
}
