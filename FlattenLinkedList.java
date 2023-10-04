/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node mergeLinkedLists(Node head1, Node head2) {
          Node dummy = new Node();
          Node resut = dummy, temp = dummy;
          while(head1!=null && head2!= null){
              if(head1.val<head2.val){
                 dummy.next = head1;
                 head1 = head1.next;
              }else{
                 dummy.next = head2;
                 head2 = head2.next;
              }
                dummy = dummy.next;
          }
          dummy.next = head1==null?head2:head1;
    }

    public Node flatten(Node head) {
         if(head == null || head.right == null)
            return head;
         else
           return mergeLinkedLists(head, flatten(head.next));
        return head;
    }
}
