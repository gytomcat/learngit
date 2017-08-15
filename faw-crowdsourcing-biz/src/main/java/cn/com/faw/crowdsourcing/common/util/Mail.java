package cn.com.faw.crowdsourcing.common.util;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Authenticator;
import javax.mail.Transport;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.*;




public class Mail {
	
	private static Log log = LogFactory.getLog(Mail.class);
	/**
	 * 邮箱host对象
	 */
	//public static final String MAIL_HOST = "smtp.163.com";
	public static final String MAIL_HOST = "smtp.qq.com";
	/**
	 * 发送邮件账号
	 */
	//public static final String MAIL_FROM_ACCOUNT = "18604400136@163.com";
	public static final String MAIL_FROM_ACCOUNT = "413548423@qq.com";
	/**
	 * 发送邮件密码
	 */
	//public static final String MAIL_FROM_PASSWORD = "88661113zjy";
	public static final String MAIL_FROM_PASSWORD = "trzdirmujjqfbihe";
	/**
	 * 发送邮件标题
	 */
	public static final String MAIL_TITLE = "重置密码验证";

	/**
	 * 发送邮件
	 * 
	 * @param mail
	 *            收件邮箱
	 * @param title
	 *            标题
	 * @param text
	 *            正文
	 * @throws MessagingException
	 */
	public int sendMail(String mail, String title, String text)
			throws Exception {
		Transport transport = null;
		try {
			Properties props = new Properties();
			// 开启debug调试
			props.setProperty("mail.debug", "true");
			// 发送服务器需要身份验证
			props.setProperty("mail.smtp.auth", "true");
			// 设置邮件服务器主机名
			props.setProperty("mail.host", "smtp.qq.com");
			// 发送邮件协议名称
			props.setProperty("mail.transport.protocol", "smtp");
			// 开启SSL加密，否则会失败
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.socketFactory", sf);
			// 创建session
			Session session = Session.getInstance(props);
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			// 通过session得到transport对象
			transport = session.getTransport();
			transport.connect(MAIL_HOST, MAIL_FROM_ACCOUNT, MAIL_FROM_PASSWORD);
			Message msg = new MimeMessage(session);
			msg.setSubject(title);
			msg.setText(text);
			msg.setFrom(new InternetAddress(MAIL_FROM_ACCOUNT));
			transport.sendMessage(msg,new Address[] { new InternetAddress(mail) });
			transport.close();
			return 0;
		} catch (Exception e) {	
			log.error(e);
			return 1;
		} finally {
			if (null != transport) {
				transport.close();
			}
		}
	}
}
