package com.cloudp.service;

import com.cloudp.entity.Book;
import com.cloudp.entity.Cart;
import com.cloudp.entity.User;

import java.io.IOException;
import java.util.List;

public interface Service {
     String login(User user) throws IOException;
     String regist(User user)throws IOException;
     Book getBooksInfo(String bookid) throws IOException;
     List<Cart> getcart(String username) throws  IOException;
     void addToCart(String bookid,String username) throws IOException;
     int deleteCart(String carid,String username) throws IOException;
     int deleteCart(String username) throws IOException;
}
