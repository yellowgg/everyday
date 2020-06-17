package com.yellowgg.everyday.dd;

import com.yellowgg.everyday.utils.DingTalkUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description: 你钉起来真好听
 * @Author: yellowgg
 * @Date: Created in 2020/6/17 12:03
 */
@Component
@PropertySource(value = {"classpath:signature.properties"})
public class DingTalk {

    /**
     * 机器人的WebHookUrl
     */
    @Value("${dd.webHookUrl}")
    private String webHookUrl;
    /**
     * 加签的密钥
     */
    @Value("${dd.key}")
    private String key;

    /**
     * 每日一道面试题
     * 每天中午12点更新
     */
    @Scheduled(cron = "0 45 12 * * ?")
    public void everyDayInterviewQuestions() throws Exception {
        DingTalkUtil.sendTextMsg(webHookUrl, key, "面试题1");
        System.out.println("完成发送");
    }

}
