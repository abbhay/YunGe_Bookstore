package com.cloudp.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.cloudp.entity.Book;
import com.cloudp.entity.Cart;
import com.cloudp.entity.User;
import com.cloudp.service.Service;
import com.cloudp.service.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class JumpController {
    @GetMapping("/user/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/";
    }


    @GetMapping("/goods/info")
    public String toBookPage(@RequestParam String bookid, Map<String,Object> map) throws IOException {
        ServiceImpl service = new ServiceImpl();
        Book booksInfo = service.getBooksInfo(bookid);
        map.put("book",booksInfo);
        return "product-details";
    }
    @GetMapping("/goods/cart")
    public String getCart(HttpSession session, Model model) throws IOException {
        Service service = new ServiceImpl();
        User loginUser = (User)session.getAttribute("loginUser");

        List<Cart> carts = service.getcart(loginUser.getUsername());
        List<Book> books = new ArrayList();

       for (Cart c:carts){
           Book book=service.getBooksInfo(c.getGoods_id());
           books.add(book);
       }
        double sum =0;
        String name = "";
        for (Book b:books) {
            sum+=Double.parseDouble(b.getBook_price());
            name += b.getBook_name()+"-";
        }
        System.out.println((int)sum);
        name = name.replace(" ||  ","");
        model.addAttribute("name",name);
        model.addAttribute("unitsum",(int)sum);
        model.addAttribute("totalprice",(int)(sum)+20);
        model.addAttribute("books",books);
        model.addAttribute("carts",carts);
        return "cart";
    }


    @GetMapping("/user/addToCart")
    public String addToCart(HttpSession session,@Param("bookid")String bookid,Map<String,Object> map) throws IOException {
        Service service = new ServiceImpl();
        User loginUser = (User)session.getAttribute("loginUser");
        service.addToCart(bookid,loginUser.getUsername());
        Book booksInfo = service.getBooksInfo(bookid);
        map.put("book",booksInfo);
        return "product-details";
    }
    @GetMapping("/cart/delete")
    public String cartDelete(@Param("carid") String carid,HttpSession session,Model model) throws IOException {
        Service service = new ServiceImpl();
        User loginUser = (User)session.getAttribute("loginUser");
        service.deleteCart(carid,loginUser.getUsername());
        List<Cart> carts = service.getcart(loginUser.getUsername());
        List<Book> books = new ArrayList();
        for (Cart c:carts){
            Book book=service.getBooksInfo(c.getGoods_id());
            books.add(book);
        }
        model.addAttribute("books",books);
        model.addAttribute("carts",carts);
        return "cart";
    }



    @RequestMapping("/su")
    public ModelAndView success(String out_trade_no, Double total_amount){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("money",total_amount);
        modelAndView.addObject("no",out_trade_no);
        return modelAndView;
    }

}