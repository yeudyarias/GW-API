package com.gw.api.Util;

import com.gw.api.models.entity.Usuario;
import com.sun.mail.smtp.SMTPTransport;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

public class EmailUtil {

	// for example, smtp.mailgun.org
	private static final String SMTP_SERVER = "smtp server ";
	private static final String USERNAME = "ygarialfa@gmail.com";
	private static final String PASSWORD = "gerardito10";

	private static final String EMAIL_FROM = "ygarialfa@gmail.com";
	private static final String EMAIL_TO = "ygarialfa@gmail.com";
	private static final String EMAIL_TO_CC = "";

	private static final String EMAIL_SUBJECT = "GWT - Restablecer Contraseña";
	private static final String EMAIL_TEXT = "<h1>Hola Mi amor te amo</h1>";

	public static String recuperarContrasenna(String newPassword, Usuario usuario) {
		Properties prop = System.getProperties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop, new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(USERNAME,PASSWORD);
		}
		});
		Message msg = new MimeMessage(session);

		try {

			msg.setFrom(new InternetAddress(EMAIL_FROM));

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usuario.getEmail(), false));

			msg.setSubject(EMAIL_SUBJECT);

			// TEXT email
			// msg.setText(EMAIL_TEXT);

			// HTML email
			msg.setDataHandler(new DataHandler(new HTMLDataSource("Hola "+usuario.getNombre() + " "+usuario.getApellido()+" su nueva contraseña es: "+newPassword)));
			
			Transport.send(msg);

//			SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
//
//			// connect
//			t.connect(SMTP_SERVER, USERNAME, PASSWORD);
//
//			// send
//			t.sendMessage(msg, msg.getAllRecipients());
//
//			System.out.println("Response: " + t.getLastServerResponse());
//
//			t.close();

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return "";
	}

	static class HTMLDataSource implements DataSource {

		private String html;

		public HTMLDataSource(String htmlString) {
			html = htmlString;
		}

		@Override
		public InputStream getInputStream() throws IOException {
			if (html == null)
				throw new IOException("html message is null!");
			return new ByteArrayInputStream(html.getBytes());
		}

		@Override
		public OutputStream getOutputStream() throws IOException {
			throw new IOException("This DataHandler cannot write HTML");
		}

		@Override
		public String getContentType() {
			return "text/html";
		}

		@Override
		public String getName() {
			return "HTMLDataSource";
		}
	}
}
