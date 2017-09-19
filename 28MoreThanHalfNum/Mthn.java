package MoreThanHalfNum28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/19.
 */
public class Mthn {
    //采用阵地攻守的思想：第一个数字作为第一个士兵，守阵地；count = 1；
    //遇到相同元素，count++;遇到不相同元素，即为敌人，同归于尽,count--；
    //当遇到count为0的情况，又以新的i值作为守阵地的士兵，
    //继续下去，到最后还留在阵地上的士兵，有可能是主元素。
    //再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
    /*public int MoreThanHalfNum_Solution(int[] array){
        int length=array.length;
        if(array==null||length<=0){
            return 0;
        }
        int result=array[0];
        int times=1;
        for(int i=1;i<length;i++){
            if(times==0){
                result=array[i];
                times=1;
            }else{
                if(array[i]==result){
                    times++;
                }else{
                    times--;
                }
            }
        }
        times=0;
        for(int i=0;i<length;i++){
            if(result==array[i]){
                times++;
            }
        }
        if(times*2<=length){
            result=0;
        }
        return result;
    }*/
    //数组排序后，如果符合条件的数存在，则一定是数组中间那个数。
    /*public int MoreThanHalfNum_Solution(int[] array){
        Arrays.sort(array);
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==array[array.length/2]){
                count++;
            }
        }
        if(count>array.length/2){
            return array[array.length/2];
        }else{
            return 0;
        }
    }*/
    //用HashMap
    public int MoreThanHalfNum_Solution(int[] array){
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                int count=map.get(array[i]);
                map.put(array[i],++count);
            }
        }
        Iterator iter=map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry=(Map.Entry)iter.next();
            Integer key=(Integer)entry.getKey();
            Integer val=(Integer)entry.getValue();
            if(val>array.length/2){
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        int[] array={4,2,4,1,4,2};
        int res=new Mthn().MoreThanHalfNum_Solution(array);
        System.out.print(res);
    }
}
