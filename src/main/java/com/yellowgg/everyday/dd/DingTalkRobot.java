package com.yellowgg.everyday.dd;

import cn.hutool.core.util.StrUtil;
import com.yellowgg.everyday.entity.LinuxCommand;
import com.yellowgg.everyday.service.JavaPrimaryService;
import com.yellowgg.everyday.service.LinuxCommandService;
import com.yellowgg.everyday.utils.DingTalkUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
@PropertySource(value = {"classpath:dingding.properties"})
public class DingTalkRobot {

    //region 每日一道java面试题
    @Value("${dd.javainterview.webHookUrl}")
    String javainterviewWebHookUrl;
    @Value("${dd.javainterview.key}")
    String javainterviewKey;
    //endregion

    //region 每日一条Linux命令
    @Value("${dd.linuxcommand.webHookUrl}")
    String linuxcommandWebHookUrl;
    @Value("${dd.linuxcommand.key}")
    String linuxcommandKey;
    //endregion

    @Autowired
    JavaPrimaryService javaPrimaryService;
    @Autowired
    LinuxCommandService linuxCommandService;

    /**
     * 每日一道面试题
     * 每天中午12点更新
     */
    @Scheduled(cron = "0 0 12 * * ?")
    // @Scheduled(cron = "0/2 * * * * ?")
    public void everyDayInterviewQuestions() throws Exception {
        DingTalkUtil.sendTextMsg(javainterviewWebHookUrl, javainterviewKey, javaPrimaryService.selectRandOne().getContent());
    }

    /**
     * 每日一条Linux命令
     * 每天中午11点更新
     */
    @Scheduled(cron = "0 0 11 * * ?")
    public void everyDayLinuxCommand() throws Exception {
        LinuxCommand linuxCommand = linuxCommandService.selectRandOne();
        String content = StrUtil.format("{}命令：{}", linuxCommand.getName(), linuxCommand.getUrl());
        DingTalkUtil.sendTextMsg(linuxcommandWebHookUrl, linuxcommandKey, content);
    }

}
