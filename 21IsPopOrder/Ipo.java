package IsPopOrder21;

import java.util.Stack;

/**
 * Created by Administrator on 2017/8/31.
 */
 public calss Ipo{
    public boolean isPopOrder(int[] pushA,int[] popA){
        if(pushA.length==0||popA.length==0)
            return false;
        Stack<Integer> s=new Stack<Integer>();
        int popIndex=0;
        for(int i=0;i<pushA.length;i++){
            s.push(pushA[i]);
            while(!s.empty()&&s.peek()==popA[popIndex]){
                s.pop();
                popIndex++;
            }
        }
        return s.empty();
    }
 }
