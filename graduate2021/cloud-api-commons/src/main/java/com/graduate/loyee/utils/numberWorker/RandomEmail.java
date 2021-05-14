package com.graduate.loyee.utils.numberWorker;

import java.util.Random;

public class RandomEmail {
    //随机生成9-10位 QQ 邮箱
    public static String getRandomString(String acct){
        if(acct.equals("17820418132")){
            return "664827065@qq.com";
        }
        String str="0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<10;i++){
            int number=random.nextInt(10);
            if(i == 0 && number != 1 && number != 2){
                i++;
            }
            sb.append(str.charAt(number));
        }
        sb.append("@qq.com");
        return sb.toString();
    }

    public static void main(String[] args) {
        String randomString = RandomEmail.getRandomString("4456wddwf");
        System.out.println(randomString);
    }
}
