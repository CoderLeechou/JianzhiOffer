package FibonacciFind07;

/**
 * Created by Administrator on 2017/8/23.
 */
public class Ff {
    public int Fibonacci(int n){
        int fn1=1;
        int fn2=1;
        if(n<=0)
            return 0;
        if(n==1||n==2)
            return 1;
        while(n-->2){
            fn1+=fn2;
            fn2=fn1-fn2;
        }
        return fn1;
    }
    public static void main(String[] args){
        int n=6;
        int f=new Ff().Fibonacci(n);
        System.out.print(f);
    }
}
