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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        if(root == null)
            return result;
        pq.add(root);
        int level = 1;
        while(!pq.isEmpty()){
            int index = pq.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < index; i++) {
                TreeNode node = pq.poll();
                subList.add(node.val);  
                if(node.left!=null)
                    pq.add(node.left);
                if(node.right!=null)
                    pq.add(node.right);
            }
            if(level%2==0){
                Collections.reverse(subList);
            }
            result.add(subList);
            level++;
        }
        return result;
    }
}
