package leetcode;

public class Flatten_Binary_Tree_to_Linked_List extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		flatten(root);
		return;
	}
	
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode lRight;
        if(root.left!=null){ 
        	lRight=root.left;       	
		    while (lRight.right != null)
				lRight = lRight.right;
			lRight.right = root.right;
            root.right=root.left;
            root.left=null;
        }
    }

}
