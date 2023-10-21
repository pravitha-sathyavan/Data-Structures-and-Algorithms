/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
     class Node{
        TreeNode node;
        long min;
        long max;
        Node(TreeNode node,long min,long max){
            this.node = node;
            this.min = min;
            this.max = max;
        }
     }
    Node n = new Node(root,Long.MIN_VALUE,Long.MAX_VALUE);
    Queue<Node> q = new LinkedList<Node>();
    q.add(n);
    Node temp;
    while(!q.isEmpty()){
        temp = q.poll();
        if(temp.node!=null){
            if(temp.node.val<= temp.min || temp.node.val>= temp.max)
               return false;
        q.add(new Node(temp.node.left,temp.min,temp.node.val));
        q.add(new Node(temp.node.right,temp.node.val,temp.max));
        }
    }
    return true;
    }
}


//The below approach wont work in all cases. 
// Eg 5,null,6,4,null
// Here 5.right = 6 and 6.left = 4 But 4 should comes in left side of 5.

//   public boolean isValidBST(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<TreeNode>();
//         q.add(root);
//         TreeNode temp;
//         while(!q.isEmpty()){
//             temp = q.poll();
//             if(temp!=null){
//             if(temp.left!=null){
//                 if(temp.val <= temp.left.val)
//                    return false;
//                 q.add(temp.left);
//             }
//             if(temp.right!=null){
//                 if(temp.val >= temp.right.val)
//                    return false;
//                 q.add(temp.right);
//             }
//             }
//         }
//         return true;
//     }



