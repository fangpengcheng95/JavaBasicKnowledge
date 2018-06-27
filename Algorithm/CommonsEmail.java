package com.fpc.Test;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class CommonsEmail {
	public static void sendEmail() {
		MultiPartEmail email = new MultiPartEmail();
//		email.setTLS(true);
		//email.setSSL(true);
		email.setDebug(true);
		email.setHostName("smtp.163.com");
		email.setAuthenticator(new DefaultAuthenticator("15755502569@163.com","aa892475"));
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("C:\\Users\\Administrator\\Desktop\\test.xml");
		attachment.setDescription(EmailAttachment.ATTACHMENT);
		attachment.setDescription("test xml file");
		attachment.setName("test xml");
		try {
			email.setFrom("15755502569@163.com");
			email.addTo("18500408772@163.com");
			email.addCc("1448433741@qq.com");
			email.setCharset("GB2312");
			email.setSubject("2017/11/29");
			email.setMsg("看到邮件速度到会议室来开会！");
//			email.attach(attachment);
			email.attach(attachment);//添加附件
			email.send();
			System.out.println("邮件发送成功");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		CommonsEmail.sendEmail();
	}
}
