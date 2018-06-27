package com.fpc.Test;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.json.JSONObject;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class regexTest {
	public void captureScreen(String fileName) throws IOException, AWTException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(fileName));
	}
	public void a () {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("current method Name: " + methodName);
	}
	public static void fileCopy(File in ,File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		//magic number for windows,64MB -32Kb
		int maxCount = (64*1024*1024) - (32*1024);
		long size = inChannel.size();
		int position = 0;
		while ( position < size ) {
			position += inChannel.transferTo(position, maxCount, outChannel);
		}
		if ( inChannel != null ) {
			inChannel.close();
		}
		if ( outChannel != null ) {
			outChannel.close();
		}
	}
	public static void main(String[] args) throws IOException, DocumentException, AWTException{
//		OutputStream file = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\test.pdf"));
//		Document document = new Document();
//		PdfWriter.getInstance(document, file);
//		document.open();
//		document.add(new Paragraph("Hello Fpc"));
//		document.add(new Paragraph(new Date().toString()));
//		document.close();
//		file.close();
		String fileName = "C:\\\\Users\\\\Administrator\\\\Desktop\\1.png";
		regexTest r = new regexTest();
		r.captureScreen(fileName);
	}
}
