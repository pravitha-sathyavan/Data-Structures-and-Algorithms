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

    class Data{
        int value;
        int listIndex;
        Data(int value,int listIndex){
            this.value = value;
            this.listIndex = listIndex;
        }
    }

    class OurCustomComparator implements Comparator<Data>{
        public int compare(Data s1, Data s2){
            if (s1.value < s2.value)
                return -1;
            else
                return 1;
            }
    }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode result = null;
        ListNode temp = result;
        PriorityQueue<Data> pq = new PriorityQueue<Data>(new OurCustomComparator());
        

        for(int i=0;i<len;i++){
            if(lists[i]!=null){
                pq.add(new Data(lists[i].val,i));
                lists[i] = lists[i].next;
            }
        }
        while(pq.size()!=0){
            Data data = pq.poll();
            if(temp==null){
                temp = new ListNode(data.value,null);
                result = temp;
            }
            else{
                temp.next = new ListNode(data.value,null);
                temp = temp.next;
            }
            int listIndex = data.listIndex;
            if(lists[listIndex]!=null){
                pq.add(new Data(lists[listIndex].val,listIndex));
                lists[listIndex] = lists[listIndex].next;
            }
       }
       return result;
    }
    
}
