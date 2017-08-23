package TwoStacktoQueue05;

import java.util.Stack;

/**
 * Created by Administrator on 2017/8/23.
 */
public class tstq {
    //1.push,将数据直接压入stack1
    //2.pop,将stack1中的数据弹出压入到stack2中，
    //则数据顺序相反，为保证最先进入的数据一直在栈顶，
    //只有将stack2中的数据全部pop后，才能继续将
    //stack1中的数据压入到stack2中，继续pop

    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();
    public void push(int node){
        stack1.push(node);
    }
    public int pop(){
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
