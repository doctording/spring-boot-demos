package com.example.demo.api.utils;

/**
 * @Author mubi
 * @Date 2019/7/13 8:12 PM
 */
public class CheckAuthUtil {
    public static boolean isAuth(String token){
        // logic deal, here just check is null
        return token != null;
    }
}
