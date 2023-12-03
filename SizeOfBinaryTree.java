class Tree
{
	public static int getSize(Node root)
	{
        int result = 0;
        int left = 0;
        int right = 0;
        if(root == null)
            return 0;
        if(root.left != null)
            left = getSize(root.left);
        if(root.right != null)
            right = getSize(root.right);
        result += left;
        result += right;
        result++;
        return result;
 
