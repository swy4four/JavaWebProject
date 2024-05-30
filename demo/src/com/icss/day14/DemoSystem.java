package com.icss.day14;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;


public class DemoSystem {
    public static void main(String[] args) {
        /*
            src-源数组
            srcPos-源数组中的起始位置。
            dest-目标数组，
            destPos在目标数据的起始位置
            length-数组元素的数目被复制*/
        //BigInteger 大数
        /*
        BigInteger bi1=new BigInteger("10000000");
        BigInteger bi2=new BigInteger("10000000");
        System.out.println(bi1.add(bi2));//加
        System.out.println(bi1.subtract(bi2));//减
        System.out.println(bi1.divide(bi2));//除
        System.out.println(bi1.multiply(bi2));//乘

         */


        //BigDecimal
       /* BigDecimal bi1=new BigDecimal("10000000.2");
        BigDecimal bi2=new BigDecimal("10000000");
        System.out.println(bi1.add(bi2));//加
        System.out.println(bi1.subtract(bi2));//减
        System.out.println(bi1.divide(bi2));//除
        System.out.println(bi1.multiply(bi2));//乘

        //公约数
        BigInteger bi1=new BigInteger("78");
        BigInteger bi2=new BigInteger("44");
        System.out.println(bi1.gcd(bi2));
        */


        /*
        随机数 1-35
         */

         /*
        Random random =new Random();
        int randomNumber =random.nextInt(35)+1;
        System.out.println(randomNumber);
          */

        for (int i = 0; i < 6; i++) {
            //System.out.println((int)(Math.random()*35 +1));
            //(数值类型)(最小值+Math.random()*(最大值-最小值+1))

            System.out.println((int)(2+Math.random()*(32-2+1)));
        }
    }
}
