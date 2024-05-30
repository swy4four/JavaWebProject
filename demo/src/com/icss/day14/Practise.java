package com.icss.day14;

/**
 * 1  隐藏身份证中的出生日期的六位
 * 2 隐藏IP 后几位
 * 192.168.13.256 ——————>192.168.13.***
 **/
public class Practise {
    public static void main(String[] args) {

        //String id=new Practise().personId("210281200401230123");
        //System.out.println(id);

       String ip= new Practise().hiddenIp("169.254.177.85");
        System.out.println(ip);
    }

    public String personId(String id) {
        //1 拼接+repalce

        return id.replace(id.substring(6,14),"******");
        //return id.substring(0,6)+"******"+id.substring(14);

    }

    public String hiddenIp(String ip){
        int index =ip.lastIndexOf(".");
        String ip1 =ip.substring(0,index +1);
        String s="";

        for (int i =index;i<ip.length();i++) {
            s+="*";
        }
        return ip1.concat(s);

    }
}
