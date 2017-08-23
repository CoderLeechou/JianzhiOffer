package Number0fOne11;

/**
 * Created by Administrator on 2017/8/23.
 */
public class Noo {
    //方法1,用1(00..001-->00..010)依次左移和n的每位进行位与，判断1的个数
    /*public int numberOfOne(int n){
        int count=0;
        int flag=1;
        while(flag!=0){
            if((n&flag)!=0){
                count++;
            }
            flag=flag<<1;
        }
        return count;
    }*/
    //方法2
    public int numberOfOne(int n){
        int count=0;
        while(n!=0){
            ++count;
            n=(n-1)&n;
        }
        return count;
    }
    public static void main(String[] args){
        int n=-10;
        int r=new Noo().numberOfOne(n);
        System.out.print(r);
    }
}
