package com.yudianxx.tool;

import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PictureAddText {
    public static void main(String[] args) throws IOException {
        Font font = new Font("04b_08", Font.BOLD, 60);//字体
        String sourceImg = "D:\\test\\123.jpg"; //源图片地址
        String targetImg = "T:\\wangzhe\\skinAddText"; //新存储的地址
        String watermark = "图片出处:www.baidu.com";//水印内容
        String watermarkUrl = "D:\\test\\zy.png";
//        Color color = new Color(255, 255, 255, 128);
        Color color = Color.WHITE;


        FileList(sourceImg, targetImg, watermark, color, font);
//        markImgMark(watermarkUrl,sourceImg,targetImg);
    }

    /**
     * 为图片添加图片水印
     *
     * @param watermarkUrl 原图
     * @param source       水印图片
     * @param output       制作完成的图片
     * @return
     * @throws IOException
     */
    public static String markImgMark(String watermarkUrl, String source, String output) throws IOException {
        String result = "添加图片水印出错";
        File file = new File(source);
        Image img = ImageIO.read(file);
        int width = img.getWidth(null);//水印宽度
        int height = img.getHeight(null);//水印高
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        ImageIcon imgIcon = new ImageIcon(watermarkUrl);
        Image con = imgIcon.getImage();
//        float clarity = 0.6f;//透明度
        float clarity = 2f;//透明度
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, clarity));
        g.drawImage(con, 100, 100, null);//水印的位置
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        g.dispose();
        File sf = new File(output);
        ImageIO.write(bi, "jpg", sf); // 保存图片
        System.out.println("添加图片水印成功");
        return result;
    }

    /**
     * 设置文字水印
     *
     * @param sourceImg 源图片路径
     * @param targetImg 保存的图片路径
     * @param watermark 水印内容
     * @param color     水印颜色
     * @param font      水印字体
     * @throws IOException
     */
    public static void addWatermark(String sourceImg, String targetImg, String watermark, Color color, Font font) throws IOException {
        File srcImgFile = new File(sourceImg);
        Image srcImg = ImageIO.read(srcImgFile);
        int srcImgWidth = srcImg.getWidth(null);
        int srcImgHeight = srcImg.getHeight(null);
        BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufImg.createGraphics();
        g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
        g.setColor(color);
        g.setFont(font);
        //设置水印的坐标
//        int x = srcImgWidth - (g.getFontMetrics(g.getFont()).charsWidth(watermark.toCharArray(), 0, watermark.length()) + 20);
////        int y = srcImgHeight - 25;
        int x = 0, y = 0;
        int width_biao = 0, height_biao = 0;
        String location = "left-top";
        if (StringUtils.equals(location, "left-top")) {
            x += 30;
            y += 80;
        } else if (StringUtils.equals(location, "right-top")) {
            x = srcImgWidth - width_biao - 30;
            y += 30;
        } else if (StringUtils.equals(location, "left-bottom")) {
            y = srcImgHeight - height_biao - 30;
            x += 30;
        } else if (StringUtils.equals(location, "right-bottom")) {
            x = srcImgWidth - width_biao - 30;
            y = srcImgHeight - height_biao - 30;
        } else {
            x = (srcImgWidth - width_biao) / 2;
            y = (srcImgHeight - height_biao) / 2;
        }
        g.drawString(watermark, x, y);  //加水印
        g.dispose();
        // 输出图片
        FileOutputStream outImgStream = new FileOutputStream(targetImg);
        ImageIO.write(bufImg, "jpg", outImgStream);
        System.out.println("添加水印完成");
        outImgStream.flush();
        outImgStream.close();
    }

    public static void FileList(String sourceImg, String targetImg, String watermark, Color color, Font font) throws IOException {
        String fileSrc = "T:\\wangzhe\\skin2";

        File f1 = new File(fileSrc);

        File[] fs1 = f1.listFiles();//列出所有文件和子目录

        for (File file : fs1) {
            String fileName = file.getName();
            sourceImg = file + "";
            targetImg = "T:\\wangzhe\\skinAddText\\";
            targetImg = targetImg + fileName;
            watermark = fileName.substring(0, fileName.lastIndexOf("."));
            addWatermark(sourceImg, targetImg, watermark, color, font);
        }
    }

}
