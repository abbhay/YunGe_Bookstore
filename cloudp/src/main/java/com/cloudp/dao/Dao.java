package com.cloudp.dao;

import com.cloudp.entity.Book;
import com.cloudp.entity.Cart;
import com.cloudp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Dao {
    User findUser(@Param("username") String username);
    int insertUser(@Param("username") String username,@Param("password") String password,@Param("email") String email);
    Book findBook(@Param("bookid") String bookid);
    List<Cart> findCart(@Param("username") String username);
    int addTOCart(@Param("bookid") String bookid,@Param("username") String username);
    int deleteCart(@Param("carid") String carid,@Param("username")String username);
    int clearCart(@Param("username")String username);
}
