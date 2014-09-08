package leetcode;

public class Recover_Binary_Search_Tree extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    recoverTree(root);
    return;
	}
	// 保存位置错误的两个节点
	TreeNode broken_prev;
	TreeNode broken_cur;
  public void recoverTree(TreeNode root) {
    if(root == null || (root.left == null && root.right == null))
    	return;
    TreeNode prev = null;
    TreeNode cur = root;
    while(cur != null){
    	if(cur.left == null){
    		detect(prev, cur);
    		prev = cur;
    		cur = cur.right;
    	}
    	else{
    		TreeNode node = cur.left;
    		while(node.right != null && node.right != cur)
    			node = node.right;
        if(node.right == null){
        	node.right = cur;
        	cur = cur.left;
        }
        else{
        	detect(prev, cur);
        	node.right = null;
        	prev = cur;
        	cur = cur.right;
        }
    	}
    }
    if(broken_cur != null && broken_prev != null){
      int t = broken_prev.val;
      broken_prev.val = broken_cur.val; 
      broken_cur.val = t;
    }
    return;
  }

  private void detect(TreeNode prev, TreeNode cur){
  	if(prev != null && prev.val > cur.val){
  		if(broken_prev == null){
  			broken_prev = prev;
  		}
  		broken_cur = cur;
  	}
  } 
}
