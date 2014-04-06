package leetcode;

public class Binary_Tree_Maximum_Path_Sum extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}
	int max;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode root){
    	if(root==null) return 0;
    	int l=dfs(root.left);
    	int r=dfs(root.right);
    	int sum=root.val;
    	if(l>0) sum+=l;
    	if(r>0) sum+=r;
    	max=Math.max(max, sum);
    	return Math.max(l, r)>0? root.val+Math.max(l, r):root.val;
    }
}
