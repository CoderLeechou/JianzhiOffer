package MinumumNumberofRotationArray06;

/**
 * Created by Administrator on 2017/8/23.
 * 找出旋转数组中的最小数
 */
public class Mnora {
    //方法1，遍历整个数组，太笨不考虑
    //方法2，稍微优化,速度还是慢。
    //如果某个数比它后面的数大，那么后面那个数即为最小数
    /*public int minNumberInRotateArray(int[] array){
        if(array.length==0)
            return 0;
        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1])
                return array[i+1];
        }
        return array[0];
    }*/
    //方法3，二分查找
    public int minNumberInRotate(int[] array){
        int low=0;
        int high=array.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(array[mid]>array[high]){
                low=mid+1;
            }
            else if(array[mid]==array[high]){
                high=high-1;
            }
            else{
                high=mid;
            }
        }
        return array[low];
    }
    public static void main(String[] args){
        int[] array={3,4,5,1,2};
        int r=new Mnora().minNumberInRotate(array);
        System.out.print(r);
    }
}
