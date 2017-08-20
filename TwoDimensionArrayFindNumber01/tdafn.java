package TwoDemensionArrayFindNumber01;

/**
 * Created by Administrator on 2017/8/20.
 */
public class tdafn {
    //方法1，按行使用二分查找
    /*public boolean Find(int[][] array,int target){
        for(int i=0;i<array.length;i++){
            int low=0;
            int high=array[i].length-1;
            while(low<high){
                int mid=(low+high)/2;
                if(target>array[i][mid])
                    low=mid+1;
                else if(target<array[i][mid])
                    high=mid-1;
                else
                    return true;
            }
        }
        return false;
    }*/
    //方法2，与正对角线上的元素对比
    public boolean Find(int[][] array,int target){
        int row=0;
        int col=array[0].length-1;
        while(row<=array.length-1&&col>=0){
            if(target==array[row][col])
                return true;
            else if(target>array[row][col])
                row++;
            else
                col--;
        }
        return false;
    }



    public static void main(String[] args){
        int[][] array={{1,2,3},{4,5,6},{7,8,9}};
        int target=5;
        boolean f=new tdafn().Find(array,target);
        System.out.print(f);
    }
}
