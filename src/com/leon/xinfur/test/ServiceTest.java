package com.leon.xinfur.test;

import com.leon.xinfur.service.FurnService;
import com.leon.xinfur.service.MemberService;
import com.leon.xinfur.service.impl.FurnServiceImpl;
import com.leon.xinfur.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * Date：2024/7/1  17:57
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

public class ServiceTest {
    MemberService memberService=new MemberServiceImpl();
    FurnService furnService=new FurnServiceImpl();
    @Test
    void isExistsUserName(){
        System.out.println(memberService.isExistsUserName("admin"));
    }

    @Test
    void login(){
        System.out.println(memberService.login("root","root"));
    }

    @Test
    void getAllFurn(){
        System.out.println(furnService.getAllFurn());
    }
}
