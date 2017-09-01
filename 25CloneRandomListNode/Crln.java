package CloneRandomListNode25;

/**
 * Created by Administrator on 2017/9/1.
 * A->B->C,A->A'->B->B'->C->C',再拆分
 */
class RandomListNode{
    int label;
    RandomListNode next=null;
    RandomListNode random=null;
    RandomListNode(int label){
        this.label=label;
    }
}
public class Crln {
    //方法1，三步法
    /*public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null)
            return null;
        RandomListNode pCur=pHead;
        //1. 复制单链表 如原来是A->B->C 变成A->A'->B->B'->C->C'
        //1.1. p指向头结点，只要p不为空，就一直循环；
        //1.2. 创建新节点，值和p相同；
        //1.3. 将新节点插入p节点之后；
        while(pCur!=null){
            RandomListNode node=new RandomListNode(pCur.label);
            node.next=pCur.next;
            pCur.next=node;
            pCur=node.next;
        }
        pCur=pHead;
        //2. 连接random域 pCur是原来链表的结点 pCur.next是复制pCur的结点
        //2.1. p指向头结点，只要p不为空，就一直循环；
        //2.2. 将含有random的p节点的后继节点添加random域；
        //PS：有些节点本身就没有random，再访问random的后继就会出现空指针！
        while(pCur!=null){
            if(pCur.random!=null)
                pCur.next.random=pCur.random.next;
            pCur=pCur.next.next;
        }
        RandomListNode head=pHead.next;
        RandomListNode cur=head;
        pCur=pHead;
        //3.拆分链表
        //3.1. p指向头结点，依次向后移动；
        //3.2. 将p指向后继的后继；
        //3.3. p的后继指向p的后继的后继的后继；
        //PS：若p已经为最后一个元素，则p的后继直接为null，否则出现空指针
        while(pCur!=null){
            pCur.next=pCur.next.next;
            if(cur.next!=null)
                cur.next=cur.next.next;
            cur=cur.next;
            pCur=pCur.next;
        }
        return head;
    }*/
    //方法2，递归
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null) return null;
        RandomListNode root = new RandomListNode(pHead.label);
        root.random = pHead.random;
        root.next = Clone(pHead.next);
        return root;
    }
}
