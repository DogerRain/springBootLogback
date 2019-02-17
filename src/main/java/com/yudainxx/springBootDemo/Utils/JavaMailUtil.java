package com.yudainxx.springBootDemo.Utils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

public class JavaMailUtil {
    private static final Logger log = Logger.getLogger(JavaMailUtil.class.getName());
  /**
   * @Author: Administrator
   * @Date: 2019/2/16  17:35 
   * @Description: 邮件发送公共类
   * @Param:
   * @return: 
   */
    public static void sendMail(String messages,String subject,String fileName,String receivers) throws Exception {
        Session session = null;
        MimeMessage msg = null;
        MimeMultipart multipart = null;
        try {
            //1、连接邮件服务器的参数配置
            Properties props = new Properties();
            //设置用户的认证方式
            props.setProperty("mail.smtp.auth", "true");
            //设置传输协议
            props.setProperty("mail.transport.protocol", "smtp");
            //设置发件人的SMTP服务器地址
            props.setProperty("mail.smtp.host", "smtp.163.com");
            //2、创建定义整个应用程序所需的环境信息的 Session 对象
            session = Session.getInstance(props);
            //设置调试信息在控制台打印出来
            session.setDebug(true);
            //3、创建邮件的实例对象
//        Message msg = getMimeMessage(session);

            //1.创建一封邮件的实例对象
            msg = new MimeMessage(session);
            //2.设置发件人地址
            msg.setFrom(new InternetAddress(PropertiesUtil.MAIL_USERNAME_163));
            /**
             * 3.设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
             * MimeMessage.RecipientType.TO:发送
             * MimeMessage.RecipientType.CC：抄送
             * MimeMessage.RecipientType.BCC：密送
             */
            String[] receiversMail = receivers.split(",");
            InternetAddress[] sendTo = new InternetAddress[receiversMail.length];
            for (int i = 0; i < receiversMail.length; i++) {
                log.info("发送到邮箱："+receiversMail[i]);
                sendTo[i]=new InternetAddress(receiversMail[i]);
            }
            msg.setRecipients(Message.RecipientType.TO, sendTo);
            //4.设置邮件主题
            msg.setSubject(subject,"UTF-8");
            //处理附件
            MimeBodyPart messageBodyPart1 = new MimeBodyPart();
            multipart = new MimeMultipart();
            messageBodyPart1.setContent(messages,"text/html;charset=UTF-8");
            multipart.addBodyPart(messageBodyPart1);
            if (fileName!=""||fileName!=null){
                String[] fileNames = fileName.split(",");
                for (String  files : fileNames) {
                    // 读取本地文件
                    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
    //                File attachments =new File(files);
                    log.info("附件路径："+files);
                    DataHandler dh = new DataHandler(new FileDataSource(files));
                    // 将附件数据添加到"节点"
                    messageBodyPart2.setDataHandler(dh);
                    // 设置附件的文件名（需要编码）
                    messageBodyPart2.setFileName(MimeUtility.encodeText(dh.getName()));
                    multipart.addBodyPart(messageBodyPart2);     // 如果有多个附件，可以创建多个多次添加
    //                mm.setSubType("mixed");         // 混合关系
                    // 11. 设置整个邮件的关系（将最终的混合"节点"作为邮件的内容添加到邮件对象）
    //                msg.setContent(mm);
                }
            }
            //设置邮件的发送时间,默认立即发送
            msg.setContent(multipart);
            msg.setSentDate(new Date());
            //4、根据session对象获取邮件传输对象Transport
            Transport transport = session.getTransport();
            //设置发件人的账户名和密码
            transport.connect(PropertiesUtil.MAIL_USERNAME_163, PropertiesUtil.MAIL_PASSWORD_163);
            //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(msg,msg.getAllRecipients());
            //5、关闭邮件连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            JavaMailUtil.sendMail("message","主题","C:\\Users\\Administrator\\Desktop\\1.png,C:\\Users\\Administrator\\Desktop\\settings.xml",PropertiesUtil.RECEIVER_MAIL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
