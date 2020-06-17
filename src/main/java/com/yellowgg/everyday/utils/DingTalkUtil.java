package com.yellowgg.everyday.utils;

import cn.hutool.core.util.StrUtil;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import org.springframework.util.Base64Utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;

/**
 * @Description: 钉钉的工具类
 * @Author: yellowgg
 * @Date: Created in 2020/6/17 11:47
 */
public class DingTalkUtil {

    /**
     * 编码
     */
    private static final String CODE = "UTF-8";

    /**
     * 加签方式：获取机器人的webhookUrl
     *
     * @param webHookUrl 初始化的url，既钉钉那边复制的
     * @param key        密钥，机器人安全设置页面，加签一栏下面显示的SEC开头的字符串
     * @return 拼接好的完整的webhookUrl
     */
    private static String getHookUrl(String webHookUrl, String key) throws Exception {
        Long timestamp = System.currentTimeMillis();
        String sign = null;
        if (StrUtil.isNotBlank(key)) {
            sign = getSign(timestamp, key);
        }
        return String.format("%s&timestamp=%s&sign=%s", webHookUrl, timestamp, sign);
    }

    /**
     * 获取签名
     *
     * @param timestamp 当前时间戳
     * @param key       密钥，机器人安全设置页面，加签一栏下面显示的SEC开头的字符串
     * @return 签名值
     */
    private static String getSign(Long timestamp, String key) throws Exception {
        String stringToSign = timestamp + "\n" + key;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(key.getBytes(CODE), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes(CODE));
        return URLEncoder.encode(new String(Base64Utils.encode(signData)), CODE);
    }

    /**
     * 发送text类型消息
     *
     * @param webHookUrl 初始化的url，既钉钉那边复制的
     * @param content    要发送的内容
     * @param key        密钥，机器人安全设置页面，加签一栏下面显示的SEC开头的字符串
     */
    public static void sendTextMsg(String webHookUrl, String key, String content) throws Exception {
        webHookUrl = getHookUrl(webHookUrl, key);
        DingTalkClient client = new DefaultDingTalkClient(webHookUrl);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(content);
        request.setText(text);
        client.execute(request);
    }
}
