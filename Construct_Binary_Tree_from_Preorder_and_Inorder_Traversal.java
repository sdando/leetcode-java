package leetcode;

import org.junit.Test;


public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	
	@Test
	public void test(){
		TreeNode root=buildTree(new int[]{1,2}, new int[]{2,1});
		return;
	}
	//借助inheritor确定右子树根节点
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder==null||inorder==null||(preorder.length==0)){
    		return null;
    	}
        TreeNode root=doBuild(preorder,0,inorder,0,preorder.length);
        return root;
    }
    
    private TreeNode doBuild(int[] preorder,int start1,int[] inorder,int start2,
    		int length){
    	if(length==0)
    		return null;
    	TreeNode node=new TreeNode(preorder[start1]);
    	if(length==1){
    		node.left=null;
    		node.right=null;
    		return node;
    	}
    	int leftLength=0;
    	for(int i=start2;i<start2+length;i++){
    		if(inorder[i]==preorder[start1])
    			break;
    		leftLength++;
    	}
    	node.left=doBuild(preorder, start1+1, inorder, start2, leftLength);
    	node.right=doBuild(preorder, start1+1+leftLength, inorder, start2+leftLength+1, 
    			length-leftLength-1);
    	return node;
    }
}
