package leetcode;

import org.junit.Test;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	
	@Test
	public void test(){
		TreeNode root=buildTree(new int[]{1,2}, new int[]{2,1});
		return;
	}
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(postorder==null||inorder==null||(postorder.length==0)){
    		return null;
    	}
        TreeNode root=doBuild(inorder,0,postorder,0,postorder.length);
        return root;
    }
    
    private TreeNode doBuild(int[] inorder,int start1,int[] postorder,int start2,
    		int length){
    	if(length==0)
    		return null;
    	TreeNode node=new TreeNode(postorder[start2+length-1]);
    	if(length==1){
    		node.left=null;
    		node.right=null;
    		return node;
    	}
    	int leftLength=0;
    	for(int i=start1;i<start1+length;i++){
    		if(inorder[i]==postorder[start2+length-1])
    			break;
    		leftLength++;
    	}
    	node.left=doBuild(inorder, start1, postorder, start2, leftLength);
    	node.right=doBuild(inorder, start1+1+leftLength, postorder, start2+leftLength, 
    			length-leftLength-1);
    	return node;
    }
}
