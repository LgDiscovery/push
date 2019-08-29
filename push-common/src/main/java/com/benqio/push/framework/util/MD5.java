package com.benqio.push.framework.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    
    /**
     * MD5 加密
     */
    public static String getMD5Str(String str) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        byte[] byteArray = digest.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                sb.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                sb.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return sb.toString();
    }
}
