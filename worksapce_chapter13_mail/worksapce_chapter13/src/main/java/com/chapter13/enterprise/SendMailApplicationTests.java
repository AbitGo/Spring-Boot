package com.chapter13.enterprise;

import com.chapter13.EnterpriseApplication;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import javax.security.auth.login.AppConfigurationEntry;
import java.io.File;
import java.io.StringWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMailApplicationTests {
    @Autowired
    MailService mailService;
    @Test
    public void sendHtmlMail()
    {
        try{
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
            ClassLoader loader = EnterpriseApplication.class.getClassLoader();
            configuration.setClassLoaderForTemplateLoading(loader,"ftl");
            Template template = configuration.getTemplate("maitemplate.ftl");
            StringWriter mail = new StringWriter();
            User user = new User();
            user.setGender("男");
            user.setUsername("abc");
            template.process(user,mail);
            mailService.sendHtmlMail("15695203200@163.com","1947145891@qq.com","测试邮箱主题",
                    mail.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    public void sendMailWithImg()
//    {
//        mailService.sendMailWithImg("15695203200@163.com","zy199864@163.com","zhou199864@live.com",
//                "测试邮件主题(图片)","<div>hello,这是一封带图片资源的邮件:"+
//                "这是图片1:<div><img src='cid:p1'/></div>"+
//                        "这是图片2:<div><img src='cid:p2'/></div>"+
//                "</div>",
//                new String[]{"F:\\p1.png","F:\\p2.png"},new String[]{"p1","p2"});
//    }
//    public void sendSimpleMail(){
//        for(int i=0;i<10;i++)
//        {
//            mailService.sendAttachFileMail("15695203200@163.com","zy199864@163.com","zhou199864@live.com",
//                    "测试邮件主题","测试油价内容",new File("F:\\测试附件.txt"));
//        }
//
//    }
}
