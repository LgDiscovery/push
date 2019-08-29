package com.benqio.push.framework.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomGUID {
    
    private static Random myRand;
    
    private static SecureRandom mySecureRand = new SecureRandom();
    
    private static String s_id;
    
    static {
        long secureInitializer = mySecureRand.nextLong();// 生成一个伪随机数
        myRand = new Random(secureInitializer);
        try {
            s_id = InetAddress.getLocalHost().toString();// 以字符串的形式返回本地主机的IP
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; ++i)
            System.out.println(randomNumberString(10));
    }
    
    public static String randomNumberString(int bits) {
        StringBuffer sb = new StringBuffer(0);
        for (int i = 0; i < bits; ++i) {
            sb.append((char) Math.random());
        }
        for (; sb.charAt(0) == '0';) {
            sb.substring(1);
        }
        return sb.substring(0, bits);
    }
    
    public String valueAfterMD5 = "";
    
    public String valueBeforeMD5 = "";
    
    public RandomGUID() {
        getRandomGUID(false);
    }
    
    public RandomGUID(boolean secure) {
        getRandomGUID(secure);
    }
    
    private void getRandomGUID(boolean secure) {
        MessageDigest md5 = null;
        StringBuffer sbValueBeforeMD5 = new StringBuffer();
        try {
            md5 = MessageDigest.getInstance("MD5");// 返回md5的ＭＤ对象
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            long time = System.currentTimeMillis();
            long rand = 0L;
            
            if (secure)
                rand = mySecureRand.nextLong();
            else {
                rand = myRand.nextLong();
            }
            
            sbValueBeforeMD5.append(s_id);
            sbValueBeforeMD5.append(":");
            sbValueBeforeMD5.append(Long.toString(time));
            sbValueBeforeMD5.append(":");
            sbValueBeforeMD5.append(Long.toString(rand));
            
            this.valueBeforeMD5 = sbValueBeforeMD5.toString();
            md5.update(this.valueBeforeMD5.getBytes());
            
            byte[] array = md5.digest();// 将哈希值以数组的方式存储
            StringBuffer sb = new StringBuffer();
            for (byte by : array) {
                int b = by & 0xFF;
                if (b < 16)
                    sb.append('0');
                sb.append(Integer.toHexString(b));
            }
            this.valueAfterMD5 = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
     *是为了获得大写的（IP:Time:MD） 
     */
    public static String uuid() {
        return new RandomGUID().toString();
    }
    
    public String toString() {
        String raw = this.valueAfterMD5.toUpperCase();
        return raw;
    }
}