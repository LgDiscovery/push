package com.benqio.push.framework.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 
 * @author jinyifeng5969@163.com QQ:361612388
 * @since 2013-5-29
 * @description image tool
 * @TODO
 */
public class ImageUtils {
    
    /**
     * 给定范围获得随机颜色
     */
    private static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
    
    /**
     * 生成随机验证码
     * 
     * @param output 输出流
     * @param allowValidateString 允许验证码中出现的字符串
     * @return
     */
    public static String validateCode(OutputStream output, String allowValidateString) {
        int width = 60, height = 24;
        
        BufferedImage im = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // 缓冲区Image
        // 获取图形上下文
        Graphics2D g = im.createGraphics(); // 获得在缓冲区Image中负责绘画的对象(画笔)他是Graphics的字类型
        
        // 创建一个随机数生成器类。
        Random random = new Random();
        
        // g.setColor(Color.decode("#ffffff"));
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height); // 画一个填充的矩形背景颜色为白色
        
        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Times New Roman", Font.PLAIN, 18);
        // 设置字体。
        g.setFont(font);
        
        // 画边框。
        // g.setColor(Color.blue);
        // g.drawRect(0, 0, width - 1, height - 1);
        
        // 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。
        // g.setColor(Color.GRAY);
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 160; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer code = new StringBuffer();
        int red = 0, green = 0, blue = 0;
        // 随机产生验证码。
        for (int i = 0; i < 4; i++) {
            // 得到随机产生的验证码数字。
            int randomIndex = random.nextInt(allowValidateString.length());
            if (randomIndex == 0)
                randomIndex = 1;
            String strRand = allowValidateString.substring(randomIndex - 1, randomIndex);
            // 将产生的四个随机数组合在一起。
            code.append(strRand);
            
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = 20 + random.nextInt(110);
            green = 20 + random.nextInt(110);
            blue = 20 + random.nextInt(110);
            // 用随机产生的颜色将验证码绘制到图像中。
            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, 13 * i + 6, 16);
        }
        // 图象生效
        g.dispose();
        try {
            ImageIO.write(im, "jpeg", output);
            output.flush();
            output.close();
            output = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code.toString();
    }
}
