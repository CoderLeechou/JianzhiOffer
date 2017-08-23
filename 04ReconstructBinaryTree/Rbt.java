package ReconstructBinaryTree04;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/21.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class rbt {
    //根据题目给出的前序遍历、后序遍历数组，
    //首先找出根节点，然后再根据中序遍历找到左子树和右子树的长度，
    //分别构造出左右子树的前序遍历和中序遍历序列，
    //最后分别对左右子树采取递归，递归跳出的条件是序列长度为1.
    public TreeNode reConstructBinaryTree(int[] pre,int[] in){
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
            root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
            root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
        }
        return root;
    }
}
