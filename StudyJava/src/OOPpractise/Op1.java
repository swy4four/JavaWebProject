package OOPpractise;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Op1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //stPrint();
        //test();
        stbyPrint();
    }

    public static void test(){
        Person person =Person.getInstance();
        System.out.println(person.getName());
    }

    public static void stPrint(){
        //将一个字符数组转换为字符串
        char[] helloArray={'h','e','l','l','o'};
        //String helloString=new String(helloArray);
        System.out.println(helloArray);
    }

    public static void stbyPrint() throws UnsupportedEncodingException {
        String str =new String("hhhabc银鞍照白马 飒沓如流星");
        byte[] arrs=str.getBytes("UTF-8");
        for(int i=0;i< arrs.length;i++){
            System.out.print(arrs[i]);
        }

        System.out.println();
        String str1=new String(arrs,"UTF-8");
        System.out.println(str1);


    }

}
