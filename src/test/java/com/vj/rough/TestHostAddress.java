package com.vj.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.vj.Utilities.MonitoringMail;
import com.vj.Utilities.TestConfig;

public class TestHostAddress {
	
	public void host() throws UnknownHostException, AddressException, MessagingException {
		
		String messageBody = "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/DataDrivenFrameworkProjectfromPOM/HTML_20Report/";
		System.out.println(messageBody);
		
		MonitoringMail mail = new MonitoringMail();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		
	}
	
	public static void main(String[] args) throws UnknownHostException, AddressException, MessagingException {
	
	}

}
