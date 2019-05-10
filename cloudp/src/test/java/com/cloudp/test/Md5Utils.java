package com.cloudp.test;


import org.apache.commons.codec.digest.DigestUtils;

public class Md5Utils {

    public static String getMd5(String password){

        return DigestUtils.md5Hex(password);
    }
}
