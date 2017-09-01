package FindPath24;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/31.
 */
class TreeNode{
    int val=0;
    TreeNode left=null;
    TreeNode right=null;
    public TreeNode(int val){
        this.val=val;
    }
}
public class Fp {
    //方法1，先序遍历，递归，DFS深度优先遍历
    ArrayList<ArrayList<Integer>> listAll=new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list=new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target){
        if(root==null)
            return listAll;
        list.add(root.val);
        target-=root.val;
        //可能会出现多条路径，所以需要new一个ArrayList
        if(target==0&&root.left==null&&root.right==null)
            listAll.add(new ArrayList<Integer>(list));
        findPath(root.left,target);
        findPath(root.right,target);
        //递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
        list.remove(list.size()-1);
        return listAll;
    }
}
