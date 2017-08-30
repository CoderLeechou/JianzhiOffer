package ReverseList15;


/**
 * Created by Administrator on 2017/8/30.
 */
class ListNode{
    int val;
    ListNode next=null;
    ListNode(int val){
        this.val=val;
    }
}

public class ReverseList(ListNode head){
    ListNode pre=null;
    ListNode next=null;
    while(head!=null){
        next=head.next;
        head.next=pre;
        pre=head;
        head=head.next;
    }
    return pre;
}
