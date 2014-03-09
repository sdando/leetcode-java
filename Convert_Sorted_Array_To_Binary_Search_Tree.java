package leetcode;

import junit.framework.Assert;

public class Convert_Sorted_Array_To_Binary_Search_Tree extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        TreeNode t=sortedArrayToBST(new int[]{1,2,3});
        Assert.assertEquals(2, t.val);
        Assert.assertEquals(3, t.right.val);
        Assert.assertEquals(1, t.left.val);
	}
	
    public TreeNode sortedArrayToBST(int[] num) {
    	if(num==null || num.length==0)
    		return null;
    	return sortedArrayToBST(0,num.length-1,num);
    }
    
    public TreeNode sortedArrayToBST(int begin,int end,int[] num){
    	if(begin>end) return null;
    	int mid=(begin+end)/2;
    	TreeNode root=new TreeNode(num[mid]);
    	root.left=sortedArrayToBST(begin,mid-1,num);
    	root.right=sortedArrayToBST(mid+1,end,num);
    	return root;
    }
}
