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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode head1 = list1;
         ListNode head2 = list2;
         ListNode tmp = null;
         ListNode result = tmp;
         ListNode ans = tmp;
         while(head1!=null && head2!= null){
             if(head1.val<head2.val){
                    tmp =  new ListNode();
                    tmp.val = head1.val;
                    head1 = head1.next;
             }else{
                    tmp =  new ListNode();
                    tmp.val = head2.val;
                    head2 = head2.next;
             }
             if(result == null){
                    result = tmp;
                    ans = result;
             }
             else{
                 result.next = tmp;
                 result = tmp;
             }
         }
         if(head1!=null){  
              if(ans==null)
                 ans = head1;
              else    
                 result.next = head1;
         } 
         if(head2!=null){
               if(ans==null)
                 ans = head2;
              else    
                 result.next = head2;
         }
         return ans;
        
    }
}
