package leetcode;

import java.util.ArrayList;

public class Unique_Binary_Search_Trees_II extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        ArrayList<TreeNode> retArrayList=generateTrees(3);
        return;
	}

    public ArrayList<TreeNode> generateTrees(int n) {
    	if(n<=0){
    		ArrayList<TreeNode> ret=new ArrayList<TreeNode>();
    		ret.add(null);
    		return ret;
    	}
    	else{
            return generateTrees(1,n);
    	}
    }
    
    private ArrayList<TreeNode> generateTrees(int start, int end){
    	ArrayList<TreeNode> ret=new ArrayList<TreeNode>();
    	TreeNode root;
    	if(start>end) return ret;
    	if(start==end) {ret.add(new TreeNode(start));return ret;} 
    	for(int i=start;i<=end;i++){
    		ArrayList<TreeNode> left=generateTrees(start,i-1);
    		ArrayList<TreeNode> right=generateTrees(i+1,end);
    		if(left.size()==0){
    			for(TreeNode r:right){
    				root=new TreeNode(i);
    				root.left=null;
    				root.right=r;
    				ret.add(root);
    			}    			
    		}
    		else if(right.size()==0){
        		for(TreeNode l:left){
        				root=new TreeNode(i);
        				root.left=l;
        				root.right=null;
        				ret.add(root);
        		}
    		}
    		else{
				for (TreeNode l : left) {
					for (TreeNode r : right) {
						root = new TreeNode(i);
						root.left = l;
						root.right = r;
						ret.add(root);
					}
				}
    		}
    	}
    	return ret;
    }

}
