package com.fpc.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InetAddress1 {
	public String isIPv6Address(String addr) {
		try {
			InetAddress ip = InetAddress.getByName(addr);
			return "合法";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "不合法";
		}
		
	}
	
	public void Ipv6Address(String addr) {
		String regex = "^([\\da-fA-F]{1,4}:){7}([\\da-fA-F]{1,4})$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(addr);
		while ( m.find() ) {
			System.out.println(m.group());
		}
//		return "a";
	}
	public static void main(String[] args) throws UnknownHostException {
		Scanner in = new Scanner(System.in);
//		String ipAddr = in.nextLine();
//		System.out.println(new InetAddress1().isIPv6Address(ipAddr));
		new InetAddress1().Ipv6Address("1:1:1:1:1:1:1:1");
	}
}
