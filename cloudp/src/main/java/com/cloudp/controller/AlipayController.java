package com.cloudp.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

import com.alipay.api.request.AlipayTradePagePayRequest;
import com.cloudp.config.AlipayConfig;
import com.cloudp.entity.User;
import com.cloudp.service.Service;
import com.cloudp.service.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class AlipayController {

    @ResponseBody
    @GetMapping("/pay")
    public String pay(HttpSession session,@Param("name")String name,@Param("price")String price,@Param("desc")String desc) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new Random().nextInt()*1000000+1+"";
        //付款金额，必填
        String total_amount = price;
        //订单名称，必填
        String subject = name;
        //商品描述，可空
        String body = desc;

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        return result;
    }


    @GetMapping("/returnAlipay.do")
    public String toreturn_url(HttpSession session){
        //清空购物车
        Service service = new ServiceImpl();
        User loginUser = (User)session.getAttribute("loginUser");
        try {
            service.deleteCart(loginUser.getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "return_url";
    }


}
