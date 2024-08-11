//  public class ListNode {
//     int val;  
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
 
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = null;
        while(head != null){
            cur = head.next;
            head.next = prev;
            prev = head;
            head = cur;
        }

        return prev;
    }
}