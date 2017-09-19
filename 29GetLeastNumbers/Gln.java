package GetLeastNumbers29;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/9/19.
 */
public class Gln {
    //使用Arrays先排序 O(nlogn)
    /*public ArrayList<Integer> GetLeastNumbers_Solution(int[] input,int k){
        Arrays.sort(input);
        ArrayList<Integer> res=new ArrayList<Integer>();
        if (k<=input.length){
            for(int i=0;i<k;i++){
                res.add(input[i]);
            }
        }
        return res;
    }*/
    //使用冒泡法排序,O(N*K)
    /*public ArrayList<Integer> GetLeastNumbers_Solution(int[] input,int k){
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(k>input.length)
            return res;
        for(int i=0;i<k;i++){
            for(int j=0;j<input.length-i-1;j++){
                if(input[j]<input[j+1]){
                    int temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
            res.add(input[input.length-i-1]);
        }
        return res;
    }*/
    //使用堆排序O(nlogn)
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input,int k){
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(input==null||input.length==0||input.length<k){
            return res;
        }
        for(int i=k/2-1;i>=0;i--){
            adjustHeap(input,i,k-1);
        }
        for(int i=k;i<input.length;i++){
            if(input[i]<input[0]){
                int temp=input[i];
                input[i]=input[0];
                input[0]=temp;
                adjustHeap(input,0,k-1);
            }
        }
        for(int i=0;i<k;i++){
            res.add(input[i]);
        }
        return res;
    }
    //构建大顶堆
    public void adjustHeap(int[] input,int i,int k){
        int temp=input[i];
        for(int j=i*2+1;j<=k;j=j*2+1){
            if(j<k&&input[j]<input[j+1]){
                j++;
            }
            if(temp>input[j]){
                break;
            }
            input[i]=input[j];
            i=j;
        }
        input[i]=temp;
    }
    public static void main(String[] args){
        int[] num={4,5,1,6,2,7,3,8};
        ArrayList<Integer> res=new Gln().GetLeastNumbers_Solution(num,4);
        System.out.print(res);
    }
}
