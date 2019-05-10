package com.cloudp.utils;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 使用邮箱发送，相关信息
 */
public class SmsUtils {
    private static Properties properties = new Properties();
    private static final String GS = "text/html;charset=UTF-8";


    private static MimeMessage init_Mail() throws MessagingException {
        properties.setProperty("mail.smtp.host", "smtp.exmail.qq.com");//发送邮箱服务器
        properties.setProperty("mail.smtp.port", "465");//发送端口
        properties.setProperty("mail.smtp.auth", "true");//是否开启权限控制
        properties.put("mail.debug", "true");//是否打印信息到控制台
        properties.put("mail.transport.proptocol", "smtp");//发送协议是简单邮箱协议
        properties.put("mail.smtp.ssl.enable", "true"); //开启ssl
        properties.put("mail.user", "zhangjiahao@zjhwork.xyz");
        properties.put("mail.password", "Abcd35873");

        //使用授权信息，构建邮箱会话
        Session session = Session.getInstance(properties,
                new Authenticator() {    //构建授权信息
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(properties.get("mail.user").toString(),
                                properties.get("mail.password").toString());
                    }
                });

        return new MimeMessage(session);
    }

    public void sendMail(String eMail, String code) throws MessagingException {


        MimeMessage mimeMessage = init_Mail();
        //设置发件人
        mimeMessage.setFrom(new InternetAddress(properties.getProperty("mail.user")));
        //设置收件人
        mimeMessage.setRecipient(RecipientType.TO, new InternetAddress(eMail));

        //设置邮箱标题
        mimeMessage.setSubject("验证码");

        //设置正文
        mimeMessage.setContent("<h1>欢迎加入云鸽</h1>" +
                "<p style='" +
                "background:black;" +
                "color:white;" +
                "padding:15px;" +
                "font-size:40px;" +
                "border-radius:20px;" +
                "text-aglin:center;" +
                "out-line:100%;'>您的验证码为："+code+"</p><br>"+"注：验证码有效时常5分钟", GS);

        //发送邮箱
        Transport.send(mimeMessage);

    }

    public  String verificationCode(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 6 ; i++){
            sb.append((int)(Math.random()*10));
        }
        return sb.toString();
    }

}
