package PrintListFromTailtoHead03;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/8/20.
 */
class ListNode{
    int val;
    ListNode next=null;
    ListNode(int val){
        this.val=val;
    }
}
public class plftth {
    //方法1,递归调用
    /*public ArrayList<Integer> printListFromTailtoHead(ListNode listNode){
        ArrayList<Integer> list=new ArrayList<Integer>();
        ListNode pNode=listNode;
        if(pNode!=null){
            if(pNode.next!=null){
                list=printListFromTailtoHead(pNode.next);
            }
            list.add(pNode.val);
        }
        return list;
    }*/
    //方法2，借助堆栈先进后出
    public ArrayList<Integer> printListFromTailtoHead(ListNode listNode){
        Stack<Integer> stack=new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
