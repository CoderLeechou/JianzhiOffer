package FindKthToTail14;

import java.util.Stack;

/**
 * Created by Administrator on 2017/8/27.
 */
class ListNode{
    int val;
    ListNode next=null;
    ListNode(int val){
        this.val=val;
    }
}
public class Fktt {
    //方法1,定义两个指针指向头结点，第一个先移动到k-1,然后第二个
    //和第一个一起继续移动，当第一个移动到末尾时，第二个指向的
    //就是倒数第k个结点
    /*public ListNode findKthToTail(ListNode head,int k){
        if(head==null||k<=0)
            return null;
        ListNode pre=head;
        ListNode last=head;
        for(int i=1;i<k;i++){
            if(pre.next!=null){
                pre=pre.next;
            }else{
                return null;
            }
        }
        while(pre.next!=null){
            pre=pre.next;
            last=last.next;
        }
        return last;
    }*/
    //方法2，先求出结点个数count，倒数第k个，就是正数第count-k+1,下标为count-k
    /*public ListNode findKthToTail(ListNode head,int k){
        if(head==null||k<=0)
            return null;
        int count=0;
        ListNode temp=head;
        for(int i=0;temp!=null;temp=temp.next){
            count++;
        }
        if(k>count)
            return null;
        for(int i=0;i<count-k;i++){
            head=head.next;
        }
        return head;
    }*/
    //将结点压入栈中
    public ListNode findKthToTail(ListNode head,int k){
        if(head==null||k<=0)
            return null;
        Stack<ListNode> stack=new Stack<ListNode>();
        int count=0;
        while(head!=null){
            stack.push(head);
            head=head.next;
            count++;
        }
        if(count<k){
            return null;
        }
        ListNode knode=null;
        for(int i=0;i<k;i++){
            knode=stack.pop();
        }
        return knode;
    }

}
