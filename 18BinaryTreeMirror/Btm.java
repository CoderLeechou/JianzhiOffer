package BinaryTreeMirror18;


import java.util.Stack;

/**
 * Created by Administrator on 2017/8/30.
 */
class TreeNode{
    int val=0;
    TreeNode left=null;
    TreeNode right=null;
    public TreeNode(int val){
        this.val=val;
    }
}
public calss Btm{
    //递归
    public void binaryTreeMirror(TreeNode root){
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
            return;
        TreeNode pTemp=root.left;
        root.left=root.right;
        root.right=pTemo;
        if(root.left!=null){
            binaryTreeMirror(root.left);
        }
        if(root.right!=null){
            binaryTreeMirror(root.right);
        }
    }
    //使用栈
    public void binaryTreeMirror(TreeNode root){
        if(root==null)
        return;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.left!=null||node.right!=null){
                TreeNode temp=root.left;
                root.left=root.right;
                root.right=root.left;
            }
            if(root.left!=null){
                stack.push(root.left);
            }
            if(root.right!=null){
                stack.push(root.right);
            }
        }
    }
}
