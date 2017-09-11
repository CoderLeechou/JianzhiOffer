package StringPermutation27;

import java.util.*;

/**
 * Created by Administrator on 2017/9/11.
 */
public class Sp {
    //1、递归算法
    //对于无重复值的情况
    //固定第一个字符，递归取得首位后面的各种字符串组合；
    //再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
    //递归的出口，就是只剩一个字符的时候，递归的循环过程，
    //就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
    //对于重复值的情况,只把重复值得第一个进行交换。abb,bab,没bba。然后bab,bba。
    /*public ArrayList<String> Permutation(String str){
        ArrayList<String> list=new ArrayList<String>();
        if(str!=null&&str.length()>0){
            PermutaionHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }
    private void PermutaionHelper(char[] chars,int i,ArrayList<String> list){
        if(i==chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            Set<Character> charSet=new HashSet<Character>();
            for(int j=i;j<chars.length;++j){
                if(j==i||!charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutaionHelper(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }
    }
    private void swap(char[] cs,int i,int j){
        char temp=cs[i];
        cs[i]=cs[j];
        cs[j]=temp;
    }*/
    //方法2，字典序排列算法一个全排列可看做一个字符串，字符串可有前缀、后缀。
    //生成给定全排列的下一个排列.所谓一个的下一个就是这一个与下一个之间没有其他的。
    //这就要求这一个与下一个有尽可能长的共同前缀，也即变化限制在尽可能短的后缀上。
    public ArrayList<String> Permutation(String str){
        ArrayList<String> list=new ArrayList<String>();
        if(str==null||str.length()==0)
            return list;
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        int len=chars.length;
        while(true){
            int lIndex=len-1;
            int rIndex;
            while(lIndex>=1&&chars[lIndex-1]>=chars[lIndex]){
                lIndex--;
            }
            if(lIndex==0)
                break;
            rIndex=lIndex;
            while(rIndex<len&&chars[rIndex]>chars[lIndex-1]){
                rIndex++;
            }
            swap(chars,lIndex-1,rIndex-1);
            reverse(chars,lIndex);
            list.add(String.valueOf(chars));
        }
        return list;
    }

    private void reverse(char[] chars, int k) {
        if(chars==null||chars.length<=k)
            return;
        int len=chars.length;
        for(int i=0;i<(len-k)/2;i++){
            int m=k+i;
            int n=len-1-i;
            if(m<n){
                swap(chars,m,n);
            }
        }
    }

    private void swap(char[] cs,int i,int j){
        char temp=cs[i];
        cs[i]=cs[j];
        cs[j]=temp;
    }
    
    public static void main(String[] args){
        String str="abb";
        ArrayList<String> res=new Sp().Permutation(str);
        System.out.print(res);
    }
}
