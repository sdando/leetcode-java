package leetcode;

public class Path_Sum {
	
	private int sum;
	private int partSum;
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		this.sum = sum;
		this.partSum = root.val;
		return search(root);
	}

    private boolean search(TreeNode root){
		if (root.left == null && root.right == null) {
			if (partSum == sum)
				return true;
			else
				return false;
		}
		if (root.left != null) {
			partSum += root.left.val;
			boolean ret = search(root.left);
			if (ret == true)
				return true;
			partSum -= root.left.val;
		}
		if (root.right != null) {
			partSum += root.right.val;
			boolean ret = search(root.right);
			if (ret == true)
				return true;
			partSum -= root.right.val;
		}
		return false;
    }
}