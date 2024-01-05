/*
Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

 

Example 1:

Input:
LinkList1 = 3->6->9->common
LinkList2 = 10->common
common = 15->30->NULL
Output: 15
Explanation:
Y ShapedLinked List
Example 2:

Input: 
Linked List 1 = 4->1->common
Linked List 2 = 5->6->1->common
common = 8->4->5->NULL
Output: 8
Explanation: 

4              5
|              |
1              6
 \             /
  8   -----  1 
   |
   4
   |
  5
  |
  NULL       
Your Task:
You don't need to read input or print anything. The task is to complete the function intersetPoint() which takes the pointer to the head of linklist1(head1) and linklist2(head2) as input parameters and returns data value of a node where two linked lists intersect. If linked list do not merge at any point, then it should return -1.
Challenge : Try to solve the problem without using any extra space.

 

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)

 

Constraints:
Length of Both linkedList before intersection(if any) is greater than 0.
1 ≤ N + M ≤ 2*105
-1000 ≤ value ≤ 1000

*/
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
        int l1 = 0, l2 = 0;
        Node temp1 = head1, temp2 = head2;
        while(temp1!=null){
            //System.out.println(temp1.data);
            l1++;
            temp1 = temp1.next;
        }
        //System.out.println("---------");
         while(temp2!=null){
            //System.out.println(temp2.data);
            l2++;
            temp2 = temp2.next;
        }
        if(l1>l2){
            temp1 = head1;
            while(l1>l2){
                temp1 = temp1.next;
                l1--;
            }
            head1 = temp1;
        }
        if(l2>l1){
            temp2 = head2;
            while(l2>l1){
                temp2 = temp2.next;
                l2--;
            }
            head2 = temp2;
        }
        while(head1!=null  && head2!=null){
            if(head1 == head2)
                return head1.data;
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
	}
}

