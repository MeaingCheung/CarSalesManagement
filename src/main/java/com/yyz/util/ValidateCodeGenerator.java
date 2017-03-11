/**
 *  Copyright (c) 2015, 杭州转乾网络. All rights reserved.
 */
package com.yyz.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yyz.util.VerificationCodeUtil;

/**
 * 图片验证码生成器
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version ValidateCodeGenerator.java, v 0.1 2017年3月11日 上午9:31:30
 */
public class ValidateCodeGenerator {

	/** 字体 */
	private static final String	TIMES_NEW_ROMAN			= "Times New Roman";

	/** 图片随机数key */
	public static final String	PICTURE_RANDOM_CODE_KEY	= "RANDOMVALIDATECODEKEY";	// 放到session中的key

	/** 随机数 */
	private Random				random					= new Random();

	/** 宽 */
	private static final int	width					= 150;						// 图片宽

	/** 高 */
	private static final int	height					= 35;						// 图片高

	/** 干扰线条数 */
	private static final int	lineSize				= 30;						// 干扰线数量

	/** 验证码 */
	private static final int	stringNum				= 6;						// 随机产生字符数量

	/**
	 * 生成随机图片
	 */
	public void getPicRandcode(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
		Graphics graphics = generateGraphics(image);
		// 绘制干扰线
		for (int i = 0; i <= lineSize; i++) {
			drawLine(graphics);
		}
		// 绘制随机字符
		String randomString = "";
		for (int i = 1; i <= stringNum; i++) {
			randomString = drawString(graphics, randomString, i);
		}
		session.removeAttribute(PICTURE_RANDOM_CODE_KEY);
		session.setAttribute(PICTURE_RANDOM_CODE_KEY, randomString);
		graphics.dispose();
		try {
			// 将内存中的图片通过流动形式输出到客户端
			ImageIO.write(image, "JPEG", response.getOutputStream());
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成一个图片
	 * 
	 * @param image
	 * @return
	 */
	private Graphics generateGraphics(BufferedImage image) {
		Graphics graphics = image.getGraphics();
		graphics.fillRect(0, 0, width, height);
		graphics.setFont(new Font(TIMES_NEW_ROMAN, Font.ROMAN_BASELINE, 18));
		int r = 110 + random.nextInt(7);
		int g = 110 + random.nextInt(9);
		int b = 110 + random.nextInt(5);
		graphics.setColor(new Color(r, g, b));
		return graphics;
	}

	/*
	 * 绘制字符串
	 */
	private String drawString(Graphics g, String randomString, int i) {
		g.setFont(new Font("Fixedsys", Font.CENTER_BASELINE, 20));
		g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
		String rand = VerificationCodeUtil.getRandomString();
		randomString += rand;
		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(rand, 18 * i, 20);
		return randomString;
	}

	/*
	 * 绘制干扰线
	 */
	private void drawLine(Graphics g) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int xl = random.nextInt(13);
		int yl = random.nextInt(15);
		g.drawLine(x, y, x + xl, y + yl);
	}

}
