package PrintMatrix19;



import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/30.
 */
public class Pm {
    public ArrayList<Integer> printMatrix(int [][] matrix){
       ArrayList<Integer> result=new ArrayList<Integer>();
       int row=matrix.length;
       int col=matrix[0].length;
       if(row==0||col==0)
           return result;
       //圈圈的层数由最小的行、列数决定。因为可能出现0.5，所以-1再加1。
       int layers=(Math.min(row,col)-1)/2+1;
       for(int i=0;i<layers;i++){
           //从左到右
           for(int j=i;j<col-i;j++){
               result.add(matrix[i][j]);
           }
           //从右上至右下
           for(int k=i+1;k<row-i;k++){
               result.add(matrix[k][col-i-1]);
           }
           //从右至左
           for(int m=col-i-2;(m>=i)&&(row-i-1!=i);m--){
               result.add(matrix[row-i-1][m]);
           }
           //从左下至左上
           for(int n=row-i-2;(n>i)&&(col-i-1!=i);n--){
               result.add(matrix[n][i]);
           }
       }
       return result;
    }
    public static void main(String[] args){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> res=new Pm().printMatrix(matrix);
        System.out.print(res);
    }
}
