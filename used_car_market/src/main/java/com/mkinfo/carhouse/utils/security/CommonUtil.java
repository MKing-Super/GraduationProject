/**
 * projectName: used_car_market
 * fileName: CommonUtil.java
 * packageName: com.mkinfo.carhouse.utils.security
 * date: 2021-01-25 21:57
 * copyright(c) 2020- xxx公司
 */
package com.mkinfo.carhouse.utils.security;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version: V1.0
 * @author: MK
 * @className: CommonUtil
 * @packageName: com.mkinfo.carhouse.utils.security
 * @description: 通用工具
 * @date: 2021-01-25 21:57
 **/
@Component
public class CommonUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * @title: sendSimpleMail
     * @path:
     * @description: 发送验证码邮件
     * @author: MK
     * @date: 2021-04-08 20:40
     * @param: [receiveAddress, verificationCode]
     * @return: void
     * @throws:
     * @modefied: 2021-04-08 20:40 MK 修改
     */
    public void sendSimpleMail(String receiveAddress,String verificationCode) {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("二手车交易平台验证码");
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("1216578277@qq.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        message.setTo(receiveAddress);
        // 设置邮件抄送人，可以有多个抄送人
        //message.setCc("1799324403@qq.com");
        // 设置隐秘抄送人，可以有多个
        //message.setBcc("1799324403@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        String context = "【二手车线上交易平台】" +
                "您的验证码为： " +
                verificationCode +
                " ,请勿告知他人。若您未进行注册，请忽略此条消息。";
        message.setText(context);
        // 发送邮件
        javaMailSender.send(message);
    }

    /**
     * @title: getNowTime
     * @path:
     * @description: 获取当前的时间（年月日时分秒）
     * @author: MK
     * @date: 2021-01-23 20:52
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-23 20:52 MK 修改
     */
    public static String getNowTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }


}
