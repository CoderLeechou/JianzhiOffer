package BtJumpFloor09;

/**
 * Created by Administrator on 2017/8/23.
 * f(0)=1
 * f(1)=1
 * f(2)=f(1)+f(0)=2
 * f(3)=f(2)+f(1)+f(0)=4
 * ...
 * f(n)=f(n-1)+f(n-2)+...+f(1)+f(0)=2*f(n-1)
 * f(n)=1,(n=0,1)
 *     =2*f(n-1),(n>=2)
 */
public class Bjf {
    public int btJumpFloor(int target){
        if(target<=0){
            return -1;
        }else if(target==1){
            return 1;
        }else{
            return 2*btJumpFloor(target-1);
        }
    }
    public static void main(String[] args){
        int tar=4;
        int re=new Bjf().btJumpFloor(tar);
        System.out.print(re);
    }
}
