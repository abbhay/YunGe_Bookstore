package com.cloudp.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016093000633562";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCgZeH9AolnHDGy2PNQTSIdBkoBJtcw9kO8MoWafRnhwkkVMCDP56Keux75knftpDmf6p+59c40rLCouPins+dLdhiMCHk1O6Q0VX48Kyc4Un7ax0KP/amQjK/7TgCqNiwLDn8/j3/RAUxwO5RpSaE98D7d9KdyWimpQ7BT4G4t/GTv06Ti+14U776cUI61y2NlHCjLvvFV/3/DUtoiMDmI0d3NuBmA/6g/Y1+xmfYQQzRObXtuvmwTArGwZmQIrtUPyHyWREXynQprg6+bCnfTTr/OVo/SoXUL+KzHNV3gI8dbDnDTyCd7rtSDdJFD6jU+Efx3v6lyzaUcrJ6JEgHBAgMBAAECggEACl6r3pykX3suJ17pVB64fuHiNPLa5Lp3JJqrkpJV8weJjAohhO93zwVP+lii0kVUyGb1zqL6ouMrRK04vjbeVD2dVqhRlcR2WD/SuncbwQNsWh6Zyg9fQA4obnnbhyWbcVeNmIFhhRStaXAgpzHwb72xgs4HaVg061GJ+9I9rVFSNLVAvt0YvbOPfKp+CezyukFJPvVsC6XWAwkz1xUwTXtJ+8ZkTi4zb8r2KBgodkdAavN7PvnF+NV9+xlYr2RUv7fCN0GJRYf8juBdbnY36HgijYIx1xxVKrlBt6U6GMTjfysYD7H30baXm4lEVP6jh69W4sKk4iWQcvK8Ztf7tQKBgQD6xsK8AbrQ4/LnudiUTES9HL5+Kxhas3ZZFWrcM7o7AIzQXZDpJXWdkMROavyo4AJNI0fZdfE9FmNyvdSsz+siYqWgOTD5N90beNBAeBjDSxDkfqbdI6OaTf5C1WXoQcLw+lB681sQoB6Oy0IhF0fzcVBKsMisJ0rm+Ve9eZojnwKBgQCjvTA9hXvJgLlWuEvzIvTBhRZXLC5Krr9tzTDdtdh0rGz2SxfG49D/gTjHf9+rauDad9OChps4IkvRIORDOx6uoA4FFfnUuyg2jd1JYmgLvL59YSm5u/iztRIh3oosVE3ZdLSU2s4nQDLX7a0ozWnadj4vkNtWqz/h0LnhY07enwKBgQD0+60La4ksPjNy6txIa4WPVYBG0yTUnpMUDdc5zRK2RyBJAc7p5J1U0zLjBKNU+plk7/1l1FFaAwAd/JLCS9AB5Gq27ogIPumyx8Bx6qEOT8vt3Eh4qjNOL7kfY0dNsMiXD4IFyq0Avdt8VdaBazPv/5eXj8JKY4xJvfZX9G5/MwKBgFEC5KA7r9A1kP1395PXIrOwjioZINowdWP1Fo1LUEoBmXOOGbh8tMYFgDssaFSeb5uHl61Hvfpa9ZoFpQoicP7DD8yyX8ZBxxaev/Jz7riH7NOJxCQx/U2kc9EwErr2BwJk/Id9bmv7FmzBGmBKqWm+AOx1xh+uYM/v/lemU7pPAoGBANiYZrkpb/gUbhjlh2H4l3lS52hzg4efdhQsAyD1mAjJKA2QPn79d4rmQCR2drduBNVgvrMJil4Kr3cuFbGM2s93BZpSrgk+FIPqM2w/ZPh2M1RmW+FzCGKuZG5Et5rHfWt8cmNXRpfu6B0E0rKRJz164pWW7lzTaBRIdk4UQC49";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgA7EtTGwG4LUDf2xJbK9JXsDUSyOHKk/snLZpD3fyYckdTYLFPF1Eq17nV9RYro1W97knKufdkG/LVeRPhYZGzqhZ0wdcYSCDHumvXKDC09kDmgm1J95NPjI9AwSWLiF6M9jneYSVXE1E8OdTMy8BbvbBAzSpOErLa0uW8CNbNdbVdKIY2mLhOp54mazz9qN7Llqs1rV1+pvp7zCJtpSkb7O+zaWeMhik7PhFKrx2d7xoz4OUFHQTRpxKIhOzdw6LJSHNO8GkZtUR/JMmf9UQensG/EFlQbCYc6oqNYRyhomc3p8scXcrEHIHfSHh0JavBkLAYr+2/86kXdevuSB0wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://zhangjiahao.imwork.net/returnAlipay.do";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/returnAlipay.do";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

