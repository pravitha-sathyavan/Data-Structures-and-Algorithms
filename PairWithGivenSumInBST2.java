/*
The inorder traversal of a BST gives us the keys in sorted order.
Hence, you can generate a sorted array of keys and the question then reduces to 
finding the pair sum in a sorted array.
The O(N) solution for this is pretty straightforward using 2-pointers.

But, storing all the keys in an array requires O(N) extra space. 
Can you use the same idea of the 2-pointers without actually storing the node values in 
an array? What about doing an iterative in-order traversal of the tree,
one normal and the other reverse?

*/


//Back-end complete function Template for Java

class Solution
{
    HashSet<Integer> nodeValues = new HashSet<>();
    
    public int isPairPresent(Node root,int target)
    {
        Stack<Node > it1 = new Stack<Node>(), it2 = new Stack<Node>();
 
    Node c = root;
    while (c != null)
    {
        it1.push(c);
        c = c.left;
    }
 
    c = root;
    while (c != null)
    {
        it2.push(c);
        c = c.right;
    }
         
    while (it1.peek() != it2.peek()) 
    {
 
        int v1 = it1.peek().data, v2 = it2.peek().data;
 
        if (v1 + v2 == target)
            return 1;
 
        if (v1 + v2 < target) 
        {
            c = it1.peek().right;
            it1.pop();
            while (c != null)
            {
                it1.push(c); 
                c = c.left;
            }
        }
 
        else
        {
            c = it2.peek().left;
            it2.pop();
            while (c != null)
            {
                it2.push(c);
                c = c.right;
            }
        }
    }
     
    return 0;
    }
}
