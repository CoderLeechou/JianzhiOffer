package ReplaceSpace;

/**
 * Created by Administrator on 2017/8/20.
 */
public class rs {
    public String replaceSpace(StringBuffer str){
        String sti=str.toString();
        char[] strChar=sti.toCharArray();
        StringBuffer stb=new StringBuffer();
        for(int i=0;i<strChar.length;i++){
            if(strChar[i]==' '){
                stb.append("%20");
            }else{
                stb.append(strChar[i]);
            }
        }
        return stb.toString();
    }
    public static void main(String[] args){
        StringBuffer str=new StringBuffer("Hello LZW");
        String out=new rs().replaceSpace(str);
        System.out.print(out);
    }
}
