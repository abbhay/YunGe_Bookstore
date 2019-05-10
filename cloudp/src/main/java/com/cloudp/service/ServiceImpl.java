package com.cloudp.service;

import com.cloudp.dao.Dao;
import com.cloudp.entity.Book;
import com.cloudp.entity.Cart;
import com.cloudp.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceImpl implements Service{

    public SqlSession getSqlSession() throws IOException {
        //1、读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("./conf/sqlMapConfig.xml");
        //2、使用SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //3、使用工厂生产SqlSession对象
        return sqlSessionFactory.openSession();
    }

    @Override
    public int deleteCart(String carid, String username) throws IOException {
        SqlSession session = getSqlSession();
        Dao dao  =  session.getMapper(Dao.class);
        dao.deleteCart(carid,username);
        session.commit();
        session.close();
        return 0;
    }

    @Override
    public int deleteCart(String username) throws IOException {
        SqlSession session = getSqlSession();
        Dao dao  =  session.getMapper(Dao.class);
        dao.clearCart(username);
        session.commit();
        session.close();
        return 0;
    }

    public String login(User user) throws IOException {
//        //1、读取配置文件
//        InputStream inputStream = Resources.getResourceAsStream("./conf/sqlMapConfig.xml");
//        //2、使用SqlSessionFactory工厂
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
//        //3、使用工厂生产SqlSession对象
//        SqlSession session = sqlSessionFactory.openSession();
        //3、获得SqlSession对象

        SqlSession session = getSqlSession();
        //4、使用SqlSession创建Dao接口的代理对象
        Dao dao = session.getMapper(Dao.class);
        //5、使用代理对象执行方法
        try{
        User userFromMysql = dao.findUser(user.getUsername());
        if(userFromMysql==null ){
            //未找到该用户名，或者密码错误
            return "fail";
        }else if(!userFromMysql.getPassword().equals(user.getPassword())){
            return "fail";
        }else
        {
            return "success";
        }}finally {
            session.close();
        }
    }

    @Override
    public void addToCart(String bookid, String username) throws IOException {
        SqlSession session = getSqlSession();
        Dao dao = session.getMapper(Dao.class);
        int i = dao.addTOCart(bookid, username);
        session.commit();
        session.close();
    }

    @Override
    public Book getBooksInfo(String bookid) throws IOException {
        SqlSession session = getSqlSession();
        Dao dao = session.getMapper(Dao.class);
        Book res_book = dao.findBook(bookid);
        session.close();
        return res_book;
    }

    @Override
    public List<Cart> getcart(String username) throws IOException {
        SqlSession session = getSqlSession();
        Dao dao = session.getMapper(Dao.class);
        List<Cart> cart = dao.findCart(username);
        session.close();
        return cart;
    }

    @Override
    public String regist(User user) throws IOException {
        SqlSession session = getSqlSession();
        Dao dao = session.getMapper(Dao.class);
        User userFromMysql = dao.findUser(user.getUsername());
        if( userFromMysql != null){
            //用户名已存在
            if(userFromMysql.getEmail().equals(user.getEmail())){
                return "email is exist";
            }
            else{
                session.close();
            return "username is exist";
            }
        }
        else{
            //用户名可以注册
            int i = dao.insertUser(user.getUsername(), user.getPassword(),user.getEmail());
            session.commit();
            session.close();
            return "success";
        }

    }

}
