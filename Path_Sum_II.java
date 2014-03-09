package leetcode;

import java.util.ArrayList;

public class Path_Sum_II extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}
	
	ArrayList<Integer> one;
	ArrayList<ArrayList<Integer>> ret;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ret=new ArrayList<ArrayList<Integer>>();
    	if(root==null)
        	return ret;
        one=new ArrayList<Integer>();
        one.add(root.val);
        doSearch(root, root.val, sum);
        return ret;
    }
    
    public void doSearch(TreeNode node, int part, int sum){
    	if(node.left==null&&node.right==null){
    		if(part==sum){
    			ret.add(new ArrayList<Integer>(one));
    			return;
    		}
    	}
    	if(node.left!=null){
    		part+=node.left.val;
    		one.add(node.left.val);
    		doSearch(node.left, part, sum);
    		one.remove(one.size()-1);
    		part-=node.left.val;
    	}
    	if(node.right!=null){
    		part+=node.right.val;
    		one.add(node.right.val);
    		doSearch(node.right, part, sum);
    		one.remove(one.size()-1);
    		part-=node.right.val;
    	}
    }
}
