package com.benqio.push.framework.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ValidateCode {
    
    /** 验证码中允许出现的字符串 */
    private static final String DEFAULT_ALLOW_VALIDATE_STRING = "0123456789abcdefghijklmnopqrstuvwxyz";
    
    /** 验证码类型为仅数字 0~9 */
    public static final int NUM_ONLY = 0;
    
    /** 验证码类型为仅字母，即大写、小写字母混合 */
    public static final int LETTER_ONLY = 1;
    
    /** 验证码类型为数字、大写字母、小写字母混合 */
    public static final int ALL_MIXED = 2;
    
    /** 验证码类型为数字、大写字母混合 */
    public static final int NUM_UPPER = 3;
    
    /** 验证码类型为数字、小写字母混合 */
    public static final int NUM_LOWER = 4;
    
    /** 验证码类型为仅大写字母 */
    public static final int UPPER_ONLY = 5;
    
    /** 验证码类型为仅小写字母 */
    public static final int LOWER_ONLY = 6;
    
    public static BufferedImage generateImageCode(String textCode, int width, int height, int interLine) {
        return generateImageCode(textCode, width, height, interLine, getRandColor(200, 500), getRandColor(160, 200));
    }
    
    public static BufferedImage generateImageCode(String textCode, int width, int height, int interLine,
            Color backColor, Color lineColor) {
        BufferedImage im = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // 缓冲区Image
        // 获取图形上下文
        Graphics2D g = im.createGraphics(); // 获得在缓冲区Image中负责绘画的对象(画笔)他是Graphics的字类型
        // 创建一个随机数生成器类。
        Random random = new Random();
        
        // g.setColor(Color.decode("#ffffff")); // 白色背景色
        g.setColor(backColor);
        g.fillRect(0, 0, width, height); // 画一个填充的矩形背景颜色
        
        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Times New Roman", Font.PLAIN, 22);
        g.setFont(font); // 设置字体。
        
        // 画边框。
        // g.setColor(Color.blue);
        // g.drawRect(0, 0, width - 1, height - 1);
        
        // 扰线颜色
        // g.setColor(Color.GRAY);
        g.setColor(lineColor);
        // 随机产生interLine条干扰线，使图象中的认证码不易被其它程序探测到。
        for (int i = 0; i < interLine; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        
        for (int i = 0; i < textCode.length(); i++) {
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            g.setColor(getColor(20, 110));
            // 用随机产生的颜色将验证码绘制到图像中。
            g.drawString(textCode.substring(i, i + 1), 13 * i + 6, 16);
        }
        // 图象生效
        g.dispose();
        return im;
    }
    
    /**
     * 生成验证码字符串
     * 
     * @param type 验证码类型，参见本类的静态属性
     * @param length 验证码长度，大于0的整数
     * @param exChars 需排除的特殊字符（仅对数字、字母混合型验证码有效，无需排除则为null）
     * @return 验证码字符串
     */
    public static String generateTextCode(int type, int length, String exChars) {
        // 创建一个随机数生成器类。
        Random random = new Random();
        StringBuffer code = new StringBuffer();
        // 随机产生验证码。
        for (int i = 0; i < length; i++) {
            // 得到随机产生的验证码数字。
            int t = random.nextInt(DEFAULT_ALLOW_VALIDATE_STRING.length());
            if (t == 0)
                t = 1;
            String c = DEFAULT_ALLOW_VALIDATE_STRING.substring(t - 1, t);
            // 将产生的四个随机数组合在一起。
            code.append(c);
        }
        return code.toString();
    }
    
    private static Color getColor(int base, int n) {
        Random random = new Random();
        return new Color(base + random.nextInt(n), base + random.nextInt(n), base + random.nextInt(n));
    }
    
    /**
     * @description 给定范围获得随机颜色
     * @param fc 颜色取值取值范围
     * @param bc 颜色取值取值范围
     * @return 返回颜色
     */
    private static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        fc = fc & 0xFF;
        bc = bc & 0xFF;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}