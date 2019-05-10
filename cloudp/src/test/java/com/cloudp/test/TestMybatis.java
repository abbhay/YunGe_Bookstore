package com.cloudp.test;

import com.cloudp.dao.Dao;
import com.cloudp.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        //1、读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("./conf/sqlMapConfig.xml");
        //2、使用SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //3、使用工厂生产SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4、使用SqlSession创建Dao接口的代理对象
        Dao dao = session.getMapper(Dao.class);
        //5、使用代理对象执行方法
//        int i = dao.insertUser("z","123");
        int i = dao.insertUser("z","123","");
        System.out.println(i);
        //6、释放资源
        session.close();
        inputStream.close();
    }
}
