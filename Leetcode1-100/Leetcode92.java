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

    //Reverse N elements from start
    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n){
        
        if(n==1){
            successor=head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next=head;
        head.next=successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        
    //     Recursion:
    if(left==1) return reverseN(head,right-left+1);
    head.next = reverseBetween(head.next,--left,--right);
    return head;

    //     Iteration：
    //     if(left==right) return head;
    //     if(head==null) return null;
    //     ListNode new_head = new ListNode(0);
    //     new_head.next = head;
    //     ListNode cur = new_head;
    //     ListNode before = null;
    //     ListNode after = null;
    //     for(int i=1;i<left;i++){
    //         cur=cur.next;
    //     }
    //     before = cur;
    //     ListNode new_cur = cur.next;
        

    //     ListNode pre = null;
    //     ListNode tmp = null;
    //     for(int i=left;i<=right;i++){
    //         if(new_cur==null) break;
    //         if(i==right){
    //             after=new_cur.next;
    //         }
    //         tmp = new_cur.next;
    //         new_cur.next = pre;
    //         pre = new_cur;
    //         new_cur = tmp;
    //     }

    //     before.next = pre;
    //     while(pre.next!=null){
    //         pre=pre.next;
    //     }
    //     pre.next = after;
    //     return new_head.next;
    }
    
}
