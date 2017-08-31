package MinNumberStack20;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/8/31.
 * 实现带min函数的栈
 */
//方法1，使用ArrayList
/*public class Mns {
    ArrayList<Integer> list=new ArrayList<Integer>();
    public void push(int node){
        list.add(0,node);
    }
    public void pop(){
        list.get(0);
        list.remove(0);
    }
    public int top(){
        return list.get(0).intValue();
    }
    public int min(){
        int tmp=top();
        for(int i=0;i<list.size();i++){
            if(tmp>list.get(i).intValue()){
                tmp=list.get(i).intValue();
            }
        }
        return tmp;
    }
}*/
//方法2，使用两个Stack
public class Mns{
    Stack<Integer> dataStack=new Stack<Integer>();
    Stack<Integer> minStack=new Stack<Integer>();
    public void push(int node){
        dataStack.push(node);
        if(minStack.isEmpty()||node<minStack.peek()){
            minStack.push(node);
        }else{
            //这样pop时可以和dataStack一起
            minStack.push(minStack.peek());
        }
    }
    public void pop(){
        dataStack.pop();
        minStack.pop();
    }
    public int top(){
        return dataStack.peek();
    }
    public int min(){
        return minStack.peek();
    }
}
