package TreeConvertList26;


import java.util.Stack;

/**
 * Created by Administrator on 2017/9/9.
 */
class TreeNode{
    int val=0;
    TreeNode left=null;
    TreeNode right=null;
    public TreeNode(int val){
        this.val=val;
    }
}
public class Tcl {
    //方法1,核心是中序遍历的非递归算法。
    //修改当前遍历节点与前一遍历节点的指针指向。
    /*public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree==null)
            return null;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode p=pRootOfTree;
        TreeNode pre=null;  //用于保存中序遍历序列的上一个节点
        boolean isFirst=true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            if(isFirst){
                //中序遍历序列中的第一个结点记为root
                pRootOfTree=p;
                pre=pRootOfTree;
                isFirst=false;
            }else{
                pre.right=p;
                p.left=pre;
                pre=p;
            }
            p=p.right;
        }
        return pRootOfTree;
    }*/
    //方法2，递归
    TreeNode head=null;
    TreeNode tail=null;
    //head是每个子树排序后的第一个结点,tail是排序后的最后一个结点
    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree==null)
            return null;
        Convert(pRootOfTree.left);
        if(tail==null){
            head=tail=pRootOfTree;
        }else{
            tail.right=pRootOfTree;
            pRootOfTree.left=tail;
            tail=pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return head;
    }
}
