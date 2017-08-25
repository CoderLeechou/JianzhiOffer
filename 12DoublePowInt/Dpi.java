package DoublePowInt12;

/**
 * Created by Administrator on 2017/8/23.
 * 1.全面考察指数的正负、底数是否为零等情况。
 */
public class Dpi {
    //方法1.快速幂
    //写出指数的二进制表达，例如13表达为二进制1101。
    //举例:10^1101 = 10^0001*10^0100*10^1000。
    // 通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
    /*public double Power(double base,int exponent){
        double res=1,curr=base;
        int n;
        if(exponent>0){
            n=exponent;
        }else if(exponent<0){
            if(base==0)
                throw new RuntimeException("分母不能为0");
            n=-exponent;
        }else{
            return 1;
        }
        while(n!=0){
            if((n&1)==1)
                res*=curr;
            curr*=curr;
            n>>=1;
        }
        return exponent>=0?res:(1/res);
    }*/
    //方法2,传统方法，依次乘
    /*public double Power(double base,int exponent){
        double result=1;
        for(int i=0;i<Math.abs(exponent);i++){
            result*=base;
        }
        if(exponent<0){
            result=1/result;
        }
        return result;
    }*/
    //方法3,按奇偶递归n为偶数，a^n=a^n/2*a^n/2;n为奇数，a^n=（a^（n-1）/2）*（a^（n-1/2））*a
    public double Power(double base,int exponent){
        int n=Math.abs(exponent);
        if(n==0)
            return 1;
        if(n==1)
            return base;
        double result=Power(base,n>>1);
        result*=result;
        if((n&1)==1)
            result*=base;
        if(exponent<0)
            result=1/result;
        return result;
    }
    public static void main(String[] args){
        double base=0.1;
        int exp=2;
        double res=new Dpi().Power(base,exp);
        System.out.print(res);
    }
}
