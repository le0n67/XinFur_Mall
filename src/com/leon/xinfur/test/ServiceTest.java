package com.leon.xinfur.test;

import com.leon.xinfur.entity.Furn;
import com.leon.xinfur.service.FurnService;
import com.leon.xinfur.service.MemberService;
import com.leon.xinfur.service.impl.FurnServiceImpl;
import com.leon.xinfur.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

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

    @Test
    void getFurnById(){
        System.out.println(furnService.queryFurnById(1));
    }

    @Test
    void update(){
        Furn furn = new Furn(11,"板砖", "猩猩大王", new BigDecimal(1000), 100, 100, "assets/images/product-image/default.jpg");
        System.out.println(furnService.updateFurn(furn));
        System.out.println(furnService.queryFurnById(11));
    }

    @Test
    void page(){
        System.out.println(furnService.Page(2, 5));
    }


    @Test
    void pageByName(){
        System.out.println(furnService.PageByName(1, 5, "沙发"));
    }

}
