//package com.yudainxx.springBootDemo.Utils;
//
//
//import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;
//
//import java.net.PasswordAuthentication;
//
//public  class SendMailUtil  {
//   public static  void  sendMail(){
//       Properties props = new Properties();
//       props.put("mail.smtp.auth", "true");
//       props.put("mail.smtp.starttls.enable", "true");
//       props.put("mail.smtp.host", "smtp.gmail.com");
//       props.put("mail.smtp.port", "587");
//
//       Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//           protected PasswordAuthentication getPasswordAuthentication() {
//               return new PasswordAuthentication("yiibai@gmail.com", "<your password>");
//           }
//       });
//       Message msg = new MimeMessage(session);
//       msg.setFrom(new InternetAddress("yiibai@gmail.com", false));
//
//       msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("yiibai@gmail.com"));
//       msg.setSubject("Spring Boot Yiibai email");
//       msg.setContent("Spring Boot Yiibai email", "text/html");
//       msg.setSentDate(new Date());
//
//       MimeBodyPart messageBodyPart = new MimeBodyPart();
//       messageBodyPart.setContent("Spring Boot Yiibai email", "text/html");
//
//       Multipart multipart = new MimeMultipart();
//       multipart.addBodyPart(messageBodyPart);
//       MimeBodyPart attachPart = new MimeBodyPart();
//
//       attachPart.attachFile("/var/tmp/image19.png");
//       multipart.addBodyPart(attachPart);
//       msg.setContent(multipart);
//   }
//}
