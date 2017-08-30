package ReOrderArray13;

/**
 * Created by Administrator on 2017/8/25.
 */
public class Roa {
    //方法1，要想保证原有次序，则只能顺次移动或相邻交换。
    // i从左向右遍历，找到第一个偶数。
    // j从i+1开始向后找，直到找到第一个奇数。
    // 将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
    // 終止條件：j向後遍歷查找失敗。
    /*public void reOrderArray(int[] array){
        if(array==null||array.length==0)
            return;
        int i=0;
        int j;
        while(i<array.length){
            while(i<array.length&&array[i]%2!=0)
                i++;
            j=i+1;
            while(j<array.length&&array[j]%2==0)
                j++;
            if(j<array.length){
                int tmp=array[j];
                for(int k=j-1;k>=i;k--){
                    array[k+1]=array[k];
                }
                array[i++]=tmp;
            }else{
                break;
            }
        }
    }*/
    //方法2,新建一个等长数组，设置两个指针
    public void reOrderArray(int[] array){
        if(array==null||array.length==0)
            return;
        int count=0;
        int begin=0;
        int[] newArray=new int[array.length];
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1)
                count++;
        }
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1)
                newArray[begin++]=array[i];
            else
                newArray[count++]=array[i];
        }
        for(int i=0;i<array.length;i++){
            array[i]=newArray[i];
        }
    }

    public static void main(String[] args){
        int[] arr={2,1,4,6,3};
        Roa roa=new Roa();
        roa.reOrderArray(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}
