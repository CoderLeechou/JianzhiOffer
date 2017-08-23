package JumpFloor08;

/**
 * Created by Administrator on 2017/8/23.
 */
public class Jf {
    public int jumpFloor(int target){
        int fn1=1;
        int fn2=2;
        int sum=0;
        if(target<=0)
            return 0;
        if(target<=2){
            if(target==1){
                return fn1;
            }
            else {
                return fn2;
            }
        }
        while(target-->2){
            sum=fn1+fn2;
            fn1=fn2;
            fn2=sum;
        }
        return sum;
    }
    public static void main(String[] args){
        int tar=3;
        int jf=new Jf().jumpFloor(tar);
        System.out.print(jf);
    }
}
