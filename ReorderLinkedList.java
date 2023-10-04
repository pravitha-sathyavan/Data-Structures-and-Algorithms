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

    public ListNode reverseList(ListNode head) {
         ListNode prev = null;
         ListNode temp = head;
         ListNode nxt;
         while(temp!=null){
            nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
         }
         return prev;
    }

    public ListNode merge(ListNode first, ListNode second){
        ListNode result = first;
        ListNode tempFirst, tempSecond;
        while(first!=null && second!=null){
            tempFirst = first.next;
            tempSecond = second.next; 
            first.next = second;
            second.next = tempFirst;
            first = tempFirst;
            second = tempSecond;
        }
        return result;
    }

    public ListNode reorderList(ListNode head) {
          ListNode slow = head, fast = head;
          while(fast!=null && fast.next!=null){
              slow = slow.next;
              fast = fast.next.next;
          }
          ListNode mid = slow.next;
          slow.next =null;
          ListNode endNode = reverseList(mid);
          ListNode result = merge(head, endNode);
          return result;
    }
}
