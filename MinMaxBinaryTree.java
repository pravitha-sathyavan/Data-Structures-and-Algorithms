//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    public static int findMax(Node root){
        int max = Integer. MIN_VALUE;
        int left, right, maxChild;
        left = max;
        right = max;
        if(root == null)
            return max;
        if(root.left != null)
            left = findMax(root.left);
        if(root.right != null)
            right = findMax(root.right);
            
        if(left>right){
            maxChild = left;
        }
        else{
            maxChild = right;
        }
        if(root.data>maxChild){
            max = root.data;
        }
        else{
            max = maxChild;
        }
        return max;
    }
    public static int findMin(Node root){
        int min = Integer. MAX_VALUE;
        int left, right, minChild;
        left = min;
        right = min;
        if(root == null)
            return min;
        if(root.left != null)
            left = findMin(root.left);
        if(root.right != null)
            right = findMin(root.right);
        if(left<right){
            minChild = left;
        }
        else{
            minChild = right;
        }
        if(root.data<minChild){
            min = root.data;
        }
        else{
            min = minChild;
        }
        return min;
    }
}
