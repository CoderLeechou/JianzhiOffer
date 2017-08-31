package VerifySquenceOfBST23;

/**
 * Created by Administrator on 2017/8/31.
 */
public class Vsobst {
    //方法1，递归
    //BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根）
    //如果去掉最后一个元素的序列为T，那么T满足:
    //T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x
    //且这两段（子树）都是合法的后序序列
    /*public boolean verifySequenceOfBST(int[] sequence){
        if(sequence==null||sequence.length==0)
            return false;
        return isBST(sequence,0,sequence.length-1);
    }
    public boolean isBST(int[] a,int start,int root){
        if(start>=root)
            return true;
        int i=root;
        while(i>start&&a[i-1]>a[root]){
            i--;
        }
        for(int j=start;j<i-1;j++){
            if(a[j]>a[root])
                return false;
        }
        return isBST(a,start,i-1)&&isBST(a,i,root-1);
    }*/
    //方法2，非递归
    public boolean verifySequenceOfBST(int[] sequence){
        int len=sequence.length;
        if(sequence==null||len==0)
            return false;
        int i=0;
        while(--len>0){
            while(sequence[i]<sequence[len]){
                i++;
            }
            while(sequence[i]>sequence[len]){
                i++;
            }
            if (i<len)
                return false;
            i=0;
        }
        return true;
    }
}
